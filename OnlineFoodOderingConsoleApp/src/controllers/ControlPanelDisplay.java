package controllers;

public class ControlPanelDisplay {
    public static void displayMainMenu() {
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

    public static void displayAdminMenu() {
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
                17. Display Pending Orders
                18. Remove item from menu
                19. Remove Cuisine type from menu
                0. LogOut""");
        System.out.println("\n======================================================");

    }

    public static void displayUserFirstMenuOld() {
        System.out.println("""
                \n=> USER MENU:
                ------------------------------------------------------
                1. New Registration
                2. Existing Log In
                0. Back""");
        System.out.println("\n======================================================");

    }

    public static void displayUserSecondMenu() {
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
                10. Customer Support
                11. Display Menu
                0. LogOut""");
        System.out.println("\n======================================================");

    }

    public static void displayDeliveryPartnerMenu() {
        System.out.println("""
                \n=> Delivery Partner MENU:
                ------------------------------------------------------
                1. Delivery Confirmation
                2. Order History
                3. Notification Inbox
                4. Update Phone Number
                5. Change Password
                6. Report Issue
                0. LogOut""");
        System.out.println("\n======================================================");

    }

    public static void displayMenuManagementMenu() {
        System.out.println("""
                \n=> MENU MANAGEMENT:
                ------------------------------------------------------
                1. Display Menu
                2. Add new Cuisine Type
                3. Add new Food Item
                4. Change Price
                5. Remove Item from Menu
                6. Remove Cuisine Type
                0. Back
                """);
        System.out.println("\n======================================================");
    }

    public static void displayUserManagementMenu() {
        System.out.println("""
                \n=> USER MANAGEMENT:
                ------------------------------------------------------
                1. Add New Delivery Partner
                2. Display Delivery Partners
                3. Display All Customers
                0. Back
                """);
        System.out.println("\n======================================================");
    }

    public static void displayOrderAndDiscountMenu() {
        System.out.println("""
                \n=> ORDER & DISCOUNT MANAGEMENT:
                ------------------------------------------------------
                1. Display Orders History
                2. Display Pending Orders
                3. Sales Summary
                4. Add Discount
                5. Display Our Discounts
                0. Back
                """);
        System.out.println("\n======================================================");
    }

    public static void displayNotificationManagementMenu() {
        System.out.println("""
                \n=> NOTIFICATION MANAGEMENT:
                ------------------------------------------------------
                1. Broadcast Notification to all Customers
                2. Broadcast Notification to all Delivery Partners
                3. Notification Inbox
                0. Back
                """);
        System.out.println("\n======================================================");
    }

    public static void displayCredentialManagementMenu() {
        System.out.println("""
                \n=> ACCOUNT SETTINGS:
                ------------------------------------------------------
                1. Update Phone Number
                2. Change Password
                0. Back
                """);
        System.out.println("\n======================================================");
    }

    public static void displayAdminMainMenuNew() {
        System.out.println("""
                \n=> ADMIN CONTROL PANEL:
                ------------------------------------------------------
                1. Menu Management
                2. Order & Discount Management
                3. User Management
                4. Notification Management
                5. Account Settings
                0. LogOut
                """);
        System.out.println("\n======================================================");
    }

    public static void displayCustomerMainMenu() {
        System.out.println("""
            \n=> CUSTOMER MAIN MENU:
            ------------------------------------------------------
            1. Orders Management
            2. History & Notifications
            3. Account & Support
            0. Logout""");
        System.out.println("\n======================================================");
    }

    public static void displayOrdersManagementMenu() {
        System.out.println("""
            \n=> ORDERS MANAGEMENT:
            ------------------------------------------------------
            1. Add Item to Cart
            2. Remove Item from Cart
            3. Display Cart
            4. Place Order
            5. Display Menu
            6. Display Available Discounts
            0. Back""");
        System.out.println("\n======================================================");
    }

    public static void displayHistoryNotificationsMenu() {
        System.out.println("""
            \n=> HISTORY & NOTIFICATIONS:
            ------------------------------------------------------
            1. Show Order History
            2. Display Notifications
            0. Back""");
        System.out.println("\n======================================================");
    }

    public static void displayAccountSupportMenu() {
        System.out.println("""
            \n=> ACCOUNT & SUPPORT:
            ------------------------------------------------------
            1. Change Phone Number
            2. Change Password
            3. Customer Support
            0. Back""");
        System.out.println("\n======================================================");
    }

    public static void displayUserFirstMenu() {
        System.out.println("""
            \n=> CUSTOMER MENU:
            ------------------------------------------------------
            1. Register New Customer
            2. Login
            0. Back""");
        System.out.println("\n======================================================");
    }
}

