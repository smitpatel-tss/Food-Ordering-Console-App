package factory;

import model.CuisineType;
import model.FoodItem;

public class FoodItemFactory {
    static long count=1;

    public static FoodItem getFoodItemInstance(String name, Double price, CuisineType cuisine){
        return new FoodItem(count++,name,price,cuisine);
    }
}
