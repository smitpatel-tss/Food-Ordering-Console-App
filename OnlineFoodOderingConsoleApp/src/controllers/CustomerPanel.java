package controllers;

import exceptions.UserNotFoundException;
import model.users.Customer;
import services.AuthenticationService;
import services.CustomerService;
import utils.Validate;

public class CustomerPanel {

    private final AuthenticationService authService;

    public CustomerPanel() {
        this.authService = new AuthenticationService();
    }

    public void start() {

        while (true) {

            ControlPanelDisplay.displayUserFirstMenu();
            System.out.print("Choose Option From Menu: ");
            int choice = Validate.validateIntLimit(2);

            switch (choice) {

                case 1 -> {
                    CustomerService tempService = new CustomerService(null);
                    tempService.newCustomerRegister();
                }

                case 2 -> {
                    loginAndStartSession();
                }

                case 0 -> {
                    System.out.println("Back...");
                    return;
                }
            }
        }
    }

    private void loginAndStartSession() {

        try {
            Customer customer = authService.loginCustomer();

            CustomerService customerService =
                    new CustomerService(customer);

            customerService.welcomeDisplay();
            customerSecondMenu(customerService);

        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void customerSecondMenu(CustomerService customerService) {

        while (true) {

            ControlPanelDisplay.displayUserSecondMenu();
            System.out.print("Choose Option From Menu: ");
            int choice = Validate.validateIntLimit(11);

            switch (choice) {

                case 1 -> customerService.showHistory();

                case 2 -> {
                    try {
                        customerService.addItemToCart();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 3 -> {
                    try {
                        customerService.displayCart();
                        customerService.removeItemFromCart();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 4 -> customerService.displayCart();

                case 5 -> customerService.displayDiscounts();

                case 6 -> {
                    try {
                        customerService.placeOrder();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 7 -> customerService.displayNotifications();

                case 8 -> {
                    try{
                        customerService.changePhoneNumber();
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }

                case 9 -> {
                    try{
                        customerService.changePassword();
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }

                case 10 -> customerService.customerSupport();

                case 11 -> customerService.displayMenu();

                case 0 -> {
                    System.out.println("Logging out...");
                    return;
                }
            }
        }
    }
}