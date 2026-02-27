package model;

public class FoodItem {
    private long id;
    private String name;
    private double price;
    private CuisineType cuisine;
    private boolean available;

    public FoodItem(long id, String name, double price, CuisineType cuisine) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cuisine = cuisine;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }


}
