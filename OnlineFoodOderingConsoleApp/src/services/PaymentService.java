package services;

import payments.CashOnDelivery;
import payments.PaymentMode;
import payments.UPI;
import utils.Validate;


import static utils.GlobalConstants.scanner;

public class PaymentService {

    public PaymentMode choosePaymentMethod(double amount) {

        int choice;

        while (true) {
            System.out.println("1. UPI");
            System.out.println("2. Cash On Delivery");
            System.out.print("Choose Option From above: ");

            choice = Validate.validatePositiveIntNonZero();
            if (choice == 1 || choice == 2) {
                break;

            } else {
                scanner.nextLine();
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