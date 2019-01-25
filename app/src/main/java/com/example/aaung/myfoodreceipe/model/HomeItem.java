package com.example.aaung.myfoodreceipe.model;

public class HomeItem{


    private String categoryName;
    private String categoryImage;

    public HomeItem(String categoryName, String categoryImage){
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }
}
