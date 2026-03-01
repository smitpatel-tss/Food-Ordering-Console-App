package controllers;

import exceptions.ItemNotFoundException;
import exceptions.UserNotFoundException;
import model.users.Admin;
import services.AdminService;
import services.AuthenticationService;
import utils.Validate;

public class AdminPanel {

    private final AuthenticationService authService;

    public AdminPanel() {
        this.authService = new AuthenticationService();
    }

    public void start() {

        try {
            Admin admin = authService.loginAdmin();

            AdminService adminService =
                    new AdminService(admin);

            adminService.welcomeDisplay();
            adminMenu(adminService);

        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void adminMenu(AdminService adminService) {

        while (true) {

            ControlPanelDisplay.displayAdminMenu();
            System.out.print("Choose Option From Menu: ");
            int choice = Validate.validateIntLimit(19);

            switch (choice) {

                case 1 -> adminService.displayMenu();

                case 2 -> adminService.addCuisineType();

                case 3 -> adminService.addNewFoodItem();

                case 4 -> {
                    try {
                        adminService.changePrice();
                    } catch (ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 5 -> adminService.printAllOrders();

                case 6 -> adminService.addNewDeliveryPartner();

                case 7 -> adminService.addDiscount();

                case 8 -> adminService.showDeliveryPartners();

                case 9 -> adminService.displayAllCustomers();

                case 10 -> adminService.displayDiscounts();

                case 11 -> adminService.sendNotificationToCustomers();

                case 12 -> {
                    try {
                        adminService.sendNotificationToDeliveryPartners();
                    } catch (UserNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 13 -> {
                    try {
                        adminService.displayNotifications();
                    } catch (UserNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 14 -> adminService.revenueDetails();

                case 15 -> adminService.changePhoneNumber();

                case 16 -> adminService.changePassword();

                case 17 -> adminService.displayPendingOrders();

                case 18 -> adminService.removeItem();

                case 19 -> adminService.removeCuisine();

                case 0 -> {
                    System.out.println("Logging out...");
                    return;
                }
            }
        }
    }
}