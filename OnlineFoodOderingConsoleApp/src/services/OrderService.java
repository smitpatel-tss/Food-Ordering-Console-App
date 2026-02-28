package services;

import model.*;
import payments.PaymentMode;
import repositories.OrderRepository;

public class OrderService {
    private DiscountService discountService;
    private NotificationService notificationService;

    public OrderService() {
        discountService = DiscountService.getInstance();
        notificationService = NotificationService.getInstance();
    }

    private static class InstanceContainer {
        static OrderService obj = new OrderService();
    }

    public static OrderService getInstance() {
        return InstanceContainer.obj;
    }

    public Order placeOrder(Cart cart, PaymentMode paymentMode, long customerId) {
        Order newOrder = new Order(cart, discountService.giveMaxPossibleDiscount(paymentMode.getAmount()), paymentMode, customerId);
        OrderRepository.getInstance().getAllOrders().add(newOrder);
        OrderManager.getOrderManagerInstance().addOrderToQueue(newOrder);

        notificationService.sendNotification(
                newOrder.getCustomerId(),
                "Your Order Is Accepted... Order id: " + newOrder.getOrderId(),
                "RESTAURANT"
        );
        return newOrder;
    }

}
