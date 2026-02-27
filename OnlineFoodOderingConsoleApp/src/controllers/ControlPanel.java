package controllers;

import exceptions.CartEmptyException;
import exceptions.ItemNotFoundException;
import exceptions.OrderNotFoundException;
import exceptions.UserNotFoundException;
import model.users.Admin;
import model.users.Customer;
import model.users.DeliveryPartner;
import services.AdminService;
import services.CustomerService;
import services.DeliveryPartnerService;
import services.MenuService;
import utils.Validate;

public class ControlPanel {

    private AdminService adminService;
    private CustomerService customerService;
    private DeliveryPartnerService deliveryPartnerService;
    private ControlPanelDisplay controlPanelDisplay;
    private MenuService menuService;

    public ControlPanel(AdminService adminService, CustomerService customerService, DeliveryPartnerService deliveryPartnerService) {
        this.adminService = adminService;
        this.customerService = customerService;
        this.deliveryPartnerService = deliveryPartnerService;
        controlPanelDisplay=new ControlPanelDisplay();
        menuService=MenuService.getInstance();
    }

    public void adminPanel() {
        Admin admin;
        try{
            admin=adminService.adminLogIn();
        }catch (UserNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }
        adminService.setAdmin(admin);
        adminService.welcomeDisplay();
        while (true) {
            controlPanelDisplay.displayAdminMenu();
            System.out.print("Choose Option From Menu: ");
            int choice = Validate.validateIntLimit(14);

            switch (choice) {
                case 1: {
                    adminService.displayMenu();
                    break;
                }
                case 2: {
                    adminService.addCuisineType();
                    break;
                }
                case 3: {
                    adminService.addNewFoodItem();
                    break;
                }
                case 4: {
                    adminService.changePrice();
                    break;
                }
                case 5: {
                    adminService.printAllOrders();
                    break;
                }
                case 6: {
                    adminService.addNewDeliveryPartner();
                    break;
                }
                case 7: {
                    adminService.addDiscount();
                    break;
                }
                case 8:{
                    adminService.showDeliveryPartners();
                    break;
                }
                case 9:{
                    adminService.displayAllCustomers();
                    break;
                }
                case 10:{
                    adminService.displayDiscounts();
                    break;
                }
                case 11:{
                    adminService.sendNotificationToCustomers();
                    break;
                }
                case 12:{
                    try{
                        adminService.sendNotificationToDeliveryPartners();

                    }catch (UserNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 13:{
                    try{
                        adminService.displayNotifications();
                    }catch (UserNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 14:{
                    adminService.revenueDetails();
                    break;
                }
                case 0: {
                    System.out.println("Back...");
                    return;
                }
            }
        }
    }

    public void customerFirstMenu() {
        customerService.emptyTheCart();
        while (true) {
            controlPanelDisplay.displayUserFirstMenu();
            System.out.print("Choose Option From Menu: ");
            int choice = Validate.validateIntLimit(2);

            switch (choice) {
                case 1: {
                    customerService.newCustomerRegister();
                    break;
                }
                case 2: {
                    Customer customer;
                    try{
                        customer=customerService.customerLogIn();
                    }catch (UserNotFoundException e){
                        System.out.println(e.getMessage());
                        return;
                    }
                    customerService.setCustomer(customer);
                    customerSecondMenu();
                    break;
                }
                case 0: {
                    System.out.println("Back...");
                    return;
                }
            }
        }
    }


    public void customerSecondMenu(){
        customerService.welcomeDisplay();
        while (true) {

            controlPanelDisplay.displayUserSecondMenu();
            System.out.print("Choose Option From Menu: ");
            int choice = Validate.validateIntLimit(7);

            switch (choice) {
                case 1: {
                    customerService.showHistory();
                    break;
                }
                case 2: {

                    menuService.displayMenu();
                    try{
                        customerService.addItemToCart();
                    }catch (ItemNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    try{
                        customerService.displayCart();
                        customerService.removeItemFromCart();
                    }catch (CartEmptyException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    customerService.displayCart();
                    break;
                }
                case 5: {
                    customerService.displayDiscounts();
                    break;
                }
                case 6: {
                    try{
                        customerService.placeOrder();
                    }catch (CartEmptyException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 7:{
                    customerService.displayNotifications();
                    break;
                }
                case 0: {
                    System.out.println("Back...");
                    return;
                }
            }
        }
    }

    public void deliveryPartnerMenu(){

       DeliveryPartner deliveryPartner ;
        try{
            deliveryPartner =deliveryPartnerService.deliveryPartnerLogIn();
        }catch(UserNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }
        deliveryPartnerService.setDeliveryPartner(deliveryPartner);
        deliveryPartnerService.welcomeDisplay();
        while (true) {
            controlPanelDisplay.displayDeliveryPartnerMenu();
            System.out.print("Choose Option From Menu: ");
            int choice = Validate.validateIntLimit(3);

            switch (choice) {
                case 1: {
                    try{
                        deliveryPartnerService.confirmDelivery();
                    }catch (OrderNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    deliveryPartnerService.printOrdersHistory();
                    break;
                }
                case 3:{
                    deliveryPartnerService.displayNotifications();
                    break;
                }
                case 0: {
                    System.out.println("Back...");
                    return;
                }
            }
        }
    }
}
