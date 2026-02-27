package services;

import model.FoodItem;
import model.Menu;
import model.CuisineType;
import repositories.MenuRepository;

import java.util.List;

public class MenuService {
    private Menu menu;

    private MenuService() {
        menu = new Menu(MenuRepository.getMenuItemList());
    }

    private static class InstanceContainer {
        static MenuService obj = new MenuService();
    }

    public static MenuService getInstance() {
        return InstanceContainer.obj;
    }

    public void displayMenu() {

        System.out.println("\n======================== MENU ========================");

        for (CuisineType cuisine : menu.getMenu().keySet()) {

            List<FoodItem> foodItems = menu.getMenu().get(cuisine);
            if (foodItems == null || foodItems.isEmpty()) continue;

            System.out.println("\n[" + cuisine.getName().toUpperCase() + "]");
            System.out.println("------------------------------------------------------");

            System.out.printf("%-6s %-25s %-10s%n", "ID", "Name", "Price");
            System.out.println("------------------------------------------------------");

            for (FoodItem item : foodItems) {
                System.out.printf("%-6d %-25s ₹%-10.2f%n",
                        item.getId(),
                        item.getName(),
                        item.getPrice());
            }
        }

        System.out.println("\n======================================================\n");
    }

    public void changeName(int id, String newName) {
        getItemFromId(id).setName(newName);
    }

    public void changePrice(int id, double newPrice) {
        getItemFromId(id).setPrice(newPrice);
    }

    public FoodItem getItemFromId(long id) {
        for (CuisineType cuisine : menu.getMenu().keySet()) {
            List<FoodItem> foodItems = menu.getMenu().get(cuisine);

            for (FoodItem items : foodItems) {
                if (items.getId() == id) {
                    return items;
                }
            }
        }
        return null;
    }

}
