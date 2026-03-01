package controllers;

import exceptions.OrderNotFoundException;
import exceptions.UserNotFoundException;
import model.users.DeliveryPartner;
import services.AuthenticationService;
import services.DeliveryPartnerService;
import utils.Validate;

public class DeliveryPartnerPanel {

    private final AuthenticationService authService;

    public DeliveryPartnerPanel() {
        this.authService = new AuthenticationService();
    }

    public void start() {

        try {
            DeliveryPartner deliveryPartner =
                    authService.loginDeliveryPartner();

            DeliveryPartnerService deliveryPartnerService =
                    new DeliveryPartnerService(deliveryPartner);

            deliveryPartnerService.welcomeDisplay();
            deliveryPartnerMenu(deliveryPartnerService);

        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deliveryPartnerMenu(DeliveryPartnerService deliveryPartnerService) {

        while (true) {

            ControlPanelDisplay.displayDeliveryPartnerMenu();
            System.out.print("Choose option : ");
            int choice = Validate.validateIntLimit(6);

            switch (choice) {

                case 1 -> {
                    try {
                        deliveryPartnerService.confirmDelivery();
                    } catch (OrderNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 2 -> deliveryPartnerService.printOrdersHistory();

                case 3 -> deliveryPartnerService.displayNotifications();

                case 4 -> {
                    try {
                        deliveryPartnerService.changePhoneNumber();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 5 -> {
                    try {
                        deliveryPartnerService.changePassword();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 6 -> deliveryPartnerService.reportIssue();

                case 0 -> {
                    System.out.println("Logging out...");
                    return;
                }
            }
        }
    }
}