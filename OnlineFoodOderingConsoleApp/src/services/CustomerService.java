package services;

import exceptions.CartEmptyException;
import exceptions.ItemNotFoundException;
import exceptions.UserNotFoundException;
import factory.UserFactory;
import model.*;
import model.users.Customer;
import model.users.User;
import model.users.UserType;
import payments.PaymentMode;
import repositories.DiscountRepository;
import repositories.MenuRepository;
import repositories.OrderRepository;
import repositories.UserRepository;
import utils.Validate;

import java.util.List;

public class CustomerService {
    private Customer customer;
    private OrderService orderService;
    private OrderRepository orderRepository;
    private Cart cart;
    private MenuService menuService;
    private DiscountService discountService;
    private PaymentService paymentService;
    private InvoiceService invoiceService;
    private UserFactory userFactory;
    private UserRepository userRepository;
    private UserService userService;
    private NotificationService notificationService;

    public CustomerService(User customer) {
        this.customer =(Customer) customer;
        orderService = OrderService.getInstance();
        cart = new Cart();
        menuService = MenuService.getInstance();
        discountService = DiscountService.getInstance();
        paymentService = new PaymentService();
        invoiceService = new InvoiceService();
        userFactory = new UserFactory();
        userRepository = UserRepository.getInstance();
        orderRepository = OrderRepository.getInstance();
        userService = UserService.getInstance();
        notificationService = NotificationService.getInstance();
    }

    public void welcomeDisplay() {
        System.out.println("\nHii, " + customer.getName() + "\nWelcome!");
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void showHistory() {
        System.out.println("HISTORY:");
        orderRepository.displayOrders(orderRepository.ordersFromCustomerId(customer.getId()));
    }

    public void addItemToCart() {
        if (MenuRepository.isMenuEmpty()) {
            System.out.println("Menu is Empty!");
            return;
        }
        System.out.print("Enter Item id: ");
        long id = Validate.validatePositiveLong();

        FoodItem item = menuService.getItemFromId(id);

        if (item == null) {
            throw new ItemNotFoundException("No Such Item Exists!");
        }
        System.out.print("Enter Quantity: ");
        int quantity = Validate.validatePositiveIntNonZero();
        cart.addItemToCart(item, quantity);
        System.out.println(quantity + " x " + item.getName() + " added to cart...");
    }

    public void removeItemFromCart() {
        if (cart.getCart().isEmpty()) {
            throw new CartEmptyException();
        }
        System.out.print("Enter Item id: ");
        long id = Validate.validatePositiveLong();

        FoodItem item = menuService.getItemFromId(id);

        if (item == null) {
            System.out.println("No Item Found!");
            return;
        }
        if (!cart.getCart().containsKey(item)) {
            System.out.println("Item not in cart!");
            return;
        }
        System.out.print("Enter Quantity: ");
        int quantity = Validate.validatePositiveIntNonZero();
        while (quantity > cart.getCart().get(item)) {

            System.out.print("Enter Valid Quantity! " + cart.getCart().get(item) + " or Less: ");
            quantity = Validate.validatePositiveIntNonZero();
        }
        cart.removeItemFromCart(item, quantity);
        System.out.println(quantity + " x " + item.getName() + " removed from cart...");
    }

    public void displayCart() {
        cart.displayCart();
    }

    public void displayDiscounts() {
        System.out.println("AVAILABLE DISCOUNTS: ");
        discountService.displayDiscounts();
    }

    public void placeOrder() {
        if (cart.getCart().isEmpty()) {
            throw new CartEmptyException();
        }

        System.out.println("Do you want to place an Order?(y/n): ");
        if(!Validate.validateYesNo()){
            System.out.println("Back to menu...");
            return;
        }

        PaymentMode paymentMode = paymentService.choosePaymentMethod(cart.getTotalCartPrice());
        if (paymentMode == null) {
            throw new IllegalArgumentException("Payment failed!");
        }
        System.out.println("Order Placed...");
        Order myOrder = orderService.placeOrder(cart, paymentMode, customer.getId());
        invoiceService.printInvoice(myOrder);
        emptyTheCart();
    }

    public void newCustomerRegister() {

        User customer = userService.makeUser(UserType.CUSTOMER);

        UserRepository.getInstance().addUser(customer);

        System.out.println("✔ New Customer "
                + customer.getName()
                + " Registered, with Phone Number "
                + customer
                .getAccountInfo().getPhoneNumber());
    }

    public Customer customerLogIn() {
        User oldUser = userService.authenticateUser();
        if (!(oldUser instanceof Customer)) {
            throw new UserNotFoundException("No Customer Found!");
        }
        return (Customer) oldUser;
    }

    public void emptyTheCart() {
        cart.emptyTheCart();
    }

    public void displayNotifications() {
        userService.displayUserNotifications(customer);
    }

    public void changePassword(){
        userService.changePassword(customer);
    }

    public void changePhoneNumber(){
        userService.changeNumber(customer);
    }

//    Update profile
//Track real-time delivery status
//Repeat previous orders quickly
//    Wishlist for items not currently available
//Chat support for order issues
}
