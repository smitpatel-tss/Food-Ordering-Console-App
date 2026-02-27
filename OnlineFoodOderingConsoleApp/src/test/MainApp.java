package test;

import authentication.AccountInfo;
import factory.UserFactory;
import controllers.ControlPanel;
import controllers.ControlPanelDisplay;
import model.users.Admin;
import model.users.Customer;
import model.users.DeliveryPartner;
import model.users.User;
import repositories.UserRepository;
import services.AdminService;
import services.CustomerService;
import services.DeliveryPartnerService;
import utils.Validate;

public class MainApp {
    public static void main(String[] args) {
        UserFactory userFactory = new UserFactory();
        User admin = userFactory.getUser("Smit", 1,new AccountInfo("7069209810","smit1234"));
        User customer=userFactory.getUser("Darshit",3,new AccountInfo("9090909090","darshit1234"));
        User deliveryPartner=userFactory.getUser("Tanmay",2,new AccountInfo("1231231234","tanmay1234"));
        UserRepository.getInstance().addUser(admin);
        UserRepository.getInstance().addUser(customer);
        UserRepository.getInstance().addUser(deliveryPartner);

        AdminService adminService=new AdminService( admin);
         CustomerService customerService=new CustomerService( customer);
         DeliveryPartnerService deliveryPartnerService=new DeliveryPartnerService(deliveryPartner);

         adminService.initializerMenu();
        ControlPanel controlPanel=new ControlPanel(adminService,customerService,deliveryPartnerService);
        ControlPanelDisplay controlPanelDisplay=new ControlPanelDisplay();


        System.out.println("WELCOME TO OUR APP:)");
        while(true){
            controlPanelDisplay.displayMainMenu();
            System.out.print("Choose option: ");
            int choice= Validate.validateIntLimit(3);
            switch (choice){
                case 1:{
                    controlPanel.adminPanel();
                    break;
                }
                case 2:{
                    controlPanel.customerFirstMenu();
                    break;
                }
                case 3:{
                    controlPanel.deliveryPartnerMenu();
                    break;
                }
                case 0:{
                    System.out.println("EXITING...");
                    return;
                }
            }
        }
    }
}
