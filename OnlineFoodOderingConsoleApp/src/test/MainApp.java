package test;

import authentication.AccountInfo;
import controllers.AdminPanel;
import controllers.ControlPanelDisplay;
import controllers.CustomerPanel;
import controllers.DeliveryPartnerPanel;
import factory.UserFactory;
import model.users.Admin;
import model.users.UserType;
import repositories.UserRepository;
import services.AdminService;
import utils.Validate;

public class MainApp {

    public static void main(String[] args) {

        UserFactory userFactory = new UserFactory();
        Admin admin = (Admin) userFactory.getUser(
                "Smit", UserType.ADMIN,
                new AccountInfo("0000000000", "00000000")
        );

        UserRepository.getInstance().addUser(admin);
        new AdminService(admin).initializerMenu();

        AdminPanel adminPanel = new AdminPanel();
        CustomerPanel customerPanel = new CustomerPanel();
        DeliveryPartnerPanel deliveryPartnerPanel = new DeliveryPartnerPanel();

        ControlPanelDisplay display = new ControlPanelDisplay();

        System.out.println("WELCOME TO OUR APP :)");

        while (true) {

            display.displayMainMenu();
            System.out.print("Choose option: ");
            int choice = Validate.validateIntLimit(3);

            switch (choice) {

                case 1 -> adminPanel.start();

                case 2 -> customerPanel.start();

                case 3 -> deliveryPartnerPanel.start();

                case 0 -> {
                    System.out.println("EXITING...");
                    return;
                }
            }
        }
    }
}