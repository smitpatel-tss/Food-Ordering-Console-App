package core;

import authentication.AccountInfo;
import controllers.*;
import factory.UserFactory;
import model.users.Admin;
import model.users.DeliveryPartner;
import model.users.UserType;
import repositories.UserRepository;
import services.AdminService;
import utils.Validate;

public class App {

    public void start() {

        adminInitializer();

        AdminPanel adminPanel = new AdminPanel();
        CustomerPanel customerPanel = new CustomerPanel();
        DeliveryPartnerPanel deliveryPartnerPanel = new DeliveryPartnerPanel();

        System.out.println("WELCOME TO OUR APP");

        while (true) {

            try{
                ControlPanelDisplay.displayMainMenu();
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
            } catch (Exception e) {
                System.out.println("Something Went Wrong!");
            }
        }
    }

    private void adminInitializer() {

        UserFactory factory = new UserFactory();
        Admin admin = (Admin) factory.getUser(
                "Smit", UserType.ADMIN,
                new AccountInfo(7069209810L, "smit1234"));

        UserRepository.getInstance().addUser(admin);
        new AdminService(admin).initializerMenu();

    }
}