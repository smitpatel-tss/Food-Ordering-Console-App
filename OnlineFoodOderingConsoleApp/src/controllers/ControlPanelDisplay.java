package controllers;

public class ControlPanelDisplay {
    public void displayMainMenu(){
        System.out.println("""
                \n------------------------------------------------------
                => MAIN MENU:
                ------------------------------------------------------
                1. Admin
                2. Customer
                3. Delivery Partner
                0. Exit""");
        System.out.println("\n======================================================");

    }

    public void displayAdminMenu(){
        System.out.println("""
                \n=> ADMIN MENU:
                ------------------------------------------------------
                1. Display Menu
                2. Add new Cuisine Type
                3. Add new Food Item
                4. Change Price
                5. Display Orders History
                6. Add New Delivery Partner
                7. Add Discount
                8. Display Delivery Partners
                9. Display All Customers
                10. Display Our Discounts
                11. Broadcast Notification to all Customers
                12. Broadcast Notification to all Delivery Partners
                13. Notification Inbox
                14. Sales Summary
                15. Update Phone Number
                16. Change Password
                0. LogOut""");
        System.out.println("\n======================================================");

    }
    public void displayUserFirstMenu(){
        System.out.println("""
                \n=> USER MENU:
                ------------------------------------------------------
                1. New Registration
                2. Existing Log In
                0. Back""");
        System.out.println("\n======================================================");

    }

    public void displayUserSecondMenu(){
        System.out.println("""
                \n=> USER - FOOD ORDERING MENU:
                ------------------------------------------------------
                1. Show History
                2. Add Item To Cart
                3. Remove Item From Cart
                4. Display Cart
                5. Display Available Discounts
                6. Place Order
                7. Notification Inbox
                8. Update Phone Number
                9. Change Password
                0. LogOut""");
        System.out.println("\n======================================================");

    }

    public void displayDeliveryPartnerMenu(){
        System.out.println("""
                \n=> Delivery Partner MENU:
                ------------------------------------------------------
                1. Delivery Confirmation
                2. Order History
                3. Notification Inbox
                4. Update Phone Number
                5. Change Password
                0. LogOut""");
        System.out.println("\n======================================================");

    }
}
