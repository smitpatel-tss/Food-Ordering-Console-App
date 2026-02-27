package repositories;

import model.Discount;
import model.PriceDiscount;

import java.util.ArrayList;
import java.util.List;

public class DiscountRepository {
    private List<Discount> discounts;

    private DiscountRepository() {
        discounts = new ArrayList<>();
    }

    private static class InstanceContainer {
        static DiscountRepository obj = new DiscountRepository();
    }

    public static DiscountRepository getInstance() {
        return DiscountRepository.InstanceContainer.obj;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

}
