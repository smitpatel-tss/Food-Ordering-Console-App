package services;

import authentication.AccountInfo;
import factory.UserFactory;
import model.users.DeliveryPartner;
import model.users.User;
import repositories.UserRepository;
import utils.Validate;

public class UserService {
    UserFactory userFactory;

    public UserService() {
        userFactory = new UserFactory();
    }

    public User makeUser(int choice) {
        System.out.print("Enter name: ");
        String name = Validate.validateCharOnlyString();

        System.out.print("Enter Phone number: ");
        String number = Validate.validatePhoneNumber();
        while (!UserRepository.getInstance().canAddNumber(number)) {
            System.out.println("Number Already Exists!");
            System.out.print("Enter Different Number: ");
            number = Validate.validatePhoneNumber();
        }

        System.out.print("Enter Password: ");
        String password = Validate.validatePassword();

        return userFactory.getUser(name, choice, new AccountInfo(number, password));
    }

    public User authenticateUser() {
        System.out.print("Enter Phone number: ");
        String number = Validate.validatePhoneNumber();
        System.out.print("Enter Password: ");
        String password = Validate.validatePassword();

        if (UserRepository.getInstance().passwordCheck(number, password)) {
            return UserRepository.getInstance().getUserFromNumber(number);
        }
        return null;
    }
}
