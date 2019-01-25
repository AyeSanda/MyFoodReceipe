package com.example.aaung.myfoodreceipe.constantdata;

import com.example.aaung.myfoodreceipe.model.HomeItem;

import java.util.ArrayList;
import java.util.List;

public class HomeItemConstant {
    public static List<HomeItem> homeItems;

    static{
        homeItems = new ArrayList<>();

        addItem(new HomeItem("Main Dish", "home_main_dishes"));
        addItem(new HomeItem("Soup", "home_soups"));
        addItem(new HomeItem("Salad", "home_salads"));
        addItem(new HomeItem("Dessert", "home_desserts"));
        addItem(new HomeItem("Drinks", "home_drinks"));
    }

    private static void addItem(HomeItem item){
        homeItems.add(item);
    }
}
