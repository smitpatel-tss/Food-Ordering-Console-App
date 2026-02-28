package test;

import authentication.AccountInfo;
import factory.UserFactory;
import controllers.ControlPanel;
import controllers.ControlPanelDisplay;
import model.users.*;
import repositories.UserRepository;
import services.AdminService;
import services.CustomerService;
import services.DeliveryPartnerService;
import utils.Validate;

public class MainApp {
    public static void main(String[] args) {
        UserFactory userFactory = new UserFactory();
        User admin = userFactory.getUser("Smit", UserType.ADMIN, new AccountInfo("0000000000", "00000000"));
        User customer = userFactory.getUser("Darshit", UserType.CUSTOMER, new AccountInfo("1111111111", "11111111"));
        User deliveryPartner = userFactory.getUser("Tanmay", UserType.DELIVERY_PARTNER, new AccountInfo("2222222222", "22222222"));
        UserRepository.getInstance().addUser(admin);
        UserRepository.getInstance().addUser(customer);
        UserRepository.getInstance().addUser(deliveryPartner);

        AdminService adminService = new AdminService(admin);
        CustomerService customerService = new CustomerService(customer);
        DeliveryPartnerService deliveryPartnerService = new DeliveryPartnerService(deliveryPartner);

        adminService.initializerMenu();
        ControlPanel controlPanel = new ControlPanel(adminService, customerService, deliveryPartnerService);
        ControlPanelDisplay controlPanelDisplay = new ControlPanelDisplay();


        System.out.println("WELCOME TO OUR APP:)");
        while (true) {
            controlPanelDisplay.displayMainMenu();
            System.out.print("Choose option: ");
            int choice = Validate.validateIntLimit(3);
            switch (choice) {
                case 1: {
                    controlPanel.adminPanel();
                    break;
                }
                case 2: {
                    controlPanel.customerFirstMenu();
                    break;
                }
                case 3: {
                    controlPanel.deliveryPartnerMenu();
                    break;
                }
                case 0: {
                    System.out.println("EXITING...");
                    return;
                }
            }
        }
    }
}
