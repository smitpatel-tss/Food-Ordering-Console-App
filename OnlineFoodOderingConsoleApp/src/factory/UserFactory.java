package factory;

import authentication.AccountInfo;
import model.users.Admin;
import model.users.Customer;
import model.users.DeliveryPartner;
import model.users.User;
import repositories.UserRepository;

import java.util.Random;

public class UserFactory {
    static Random random=new Random();

    public User getUser(String name, int choice, AccountInfo info){
        if(choice==1){
            return new Admin(getUniqueId(),name,info);
        }
        if(choice==2){
            return new DeliveryPartner(getUniqueId(),name,info);
        }
        if(choice==3){
            return new Customer(getUniqueId(),name,info);
        }
        return null;
    }

    public long getUniqueId(){
        UserRepository userRepo=UserRepository.getInstance();
        long newNumber;
        boolean flag;
        do {
            newNumber = random.nextLong(1_000_000_000L, 10_000_000_000L);
            flag = false;

            for (User user:userRepo.getUsers()) {
                if (user.getId() == newNumber) {
                    flag = true;
                    break;
                }
            }
        } while (flag);

        return newNumber;
    }
}
