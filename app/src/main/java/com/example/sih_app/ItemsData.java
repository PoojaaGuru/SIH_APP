package com.example.sih_app;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;

public class ItemsData {

    String itemName;
    SpannableStringBuilder description;
    float price;
    String image;
    String category;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public SpannableStringBuilder getDescription() {
        return description;
    }

    public void setDescription(SpannableStringBuilder description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ItemsData(String itemName, SpannableStringBuilder description, float price, String image, String category) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }
}
