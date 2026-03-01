package services;

import payments.CashOnDelivery;
import payments.PaymentMode;
import payments.UPI;
import utils.Validate;


public class PaymentService {

    public PaymentMode choosePaymentMethod(double amount) {

        int choice;
        System.out.println("Available Payment Methods: ");
        while (true) {
            System.out.println("1. UPI");
            System.out.println("2. Cash On Delivery");
            System.out.print("Choose Option : ");

            choice = Validate.validatePositiveIntNonZero();
            if (choice == 1 || choice == 2) {
                break;

            }
            System.out.println("Invalid choice. Please enter Valid Option!\n");
        }

        switch (choice) {
            case 1:
                return new UPI(amount);

            case 2:
                return new CashOnDelivery(amount);

            default:
                System.out.println("UNEXPECTED VALUE!");
        }
        return null;
    }
}