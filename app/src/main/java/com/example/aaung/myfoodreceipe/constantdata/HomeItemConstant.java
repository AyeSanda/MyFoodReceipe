package com.example.aaung.myfoodreceipe.constantdata;

import com.example.aaung.myfoodreceipe.model.HomeItem;

import java.util.ArrayList;
import java.util.List;

public class HomeItemConstant {
    public static List<HomeItem> homeItems;

    static{
        homeItems = new ArrayList<>();

        addItem(new HomeItem("cat_001","Main Dish", "home_main_dishes"));
        addItem(new HomeItem("cat_002","Soup", "home_soups"));
        addItem(new HomeItem("cat_003","Salad", "home_salads"));
        addItem(new HomeItem("cat_004","Dessert", "home_desserts"));
        addItem(new HomeItem("cat_005","Drinks", "home_drinks"));
        addItem(new HomeItem("cat_001","Main Dish", "home_main_dishes"));
        addItem(new HomeItem("cat_002","Soup", "home_soups"));
        addItem(new HomeItem("cat_003","Salad", "home_salads"));
        addItem(new HomeItem("cat_004","Dessert", "home_desserts"));
        addItem(new HomeItem("cat_005","Drinks", "home_drinks"));
        addItem(new HomeItem("cat_001","Main Dish", "home_main_dishes"));
        addItem(new HomeItem("cat_002","Soup", "home_soups"));
        addItem(new HomeItem("cat_003","Salad", "home_salads"));
        addItem(new HomeItem("cat_004","Dessert", "home_desserts"));
        addItem(new HomeItem("cat_005","Drinks", "home_drinks"));
    }

    private static void addItem(HomeItem item){
        homeItems.add(item);
    }
}
