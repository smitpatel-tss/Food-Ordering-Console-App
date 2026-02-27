package services;

import model.Order;
import model.users.DeliveryPartner;
import repositories.UserRepository;

import java.util.LinkedList;
import java.util.Queue;

public class DeliveryPartnerManager {
    private Queue<DeliveryPartner> deliveryPartners;

    private DeliveryPartnerManager() {
        LinkedList<DeliveryPartner> tempLinkedlist = new LinkedList<>(UserRepository.
                getInstance().getDeliveryPartners());
        deliveryPartners = new LinkedList<>(tempLinkedlist);
    }

    private static class InstanceContainer {
        static DeliveryPartnerManager obj = new DeliveryPartnerManager();
    }

    public static DeliveryPartnerManager getInstance() {
        return InstanceContainer.obj;
    }

    public void pushDeliveryPartnerInQueue(DeliveryPartner deliveryPartner) {
        deliveryPartners.offer(deliveryPartner);
        OrderManager.getOrderManagerInstance().assignDeliveryPartner();
    }

    public void assignOrder(Order order) {
        if (deliveryPartners.isEmpty()) {
            return;
        }
        order.setDeliveryPartner(deliveryPartners.poll());
    }

    public boolean isDeliveryPartnerAvailable() {
        return !(deliveryPartners.isEmpty());
    }


}
