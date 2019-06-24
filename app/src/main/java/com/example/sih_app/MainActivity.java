package com.example.sih_app;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Object> items = new ArrayList<>();
    RecyclerView recyclerView;
    ItemsAdapter itemsAdapter;
    ImageView search;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.items_list);
        search = findViewById(R.id.search);
        editText = findViewById(R.id.items_search);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] neededPermissions = {
                Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        ActivityCompat.requestPermissions( this, neededPermissions, 101);
        prefill();
        itemsAdapter = new ItemsAdapter(this);
        itemsAdapter.setList(items);
        recyclerView.setAdapter(itemsAdapter);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemsAdapter.setList(items);
                itemsAdapter.getFilter().filter(editText.getText().toString());
            }
        });
    }

    void prefill()
    {
        Spannable inStock = new SpannableString("In Stock");
        inStock.setSpan(new ForegroundColorSpan(Color.GREEN), 0, inStock.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Spannable outOfStock = new SpannableString("Out of Stock");
        inStock.setSpan(new ForegroundColorSpan(Color.RED), 0, inStock.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        items.add("Groceries");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("Madhur Sugar \n");
        spannableStringBuilder.append(inStock);
        items.add(new ItemsData("Sugar", spannableStringBuilder, 60.0f, "https://storage.googleapis.com/zopnow-static/images/products/320/madhur-pure-hygienic-sugar-v-1-kg-1.png", "Groceries"));
        spannableStringBuilder = new SpannableStringBuilder("Dawart Rosanna \n Original Basmati \n");
        spannableStringBuilder.append(inStock);
        items.add(new ItemsData("Rice", spannableStringBuilder, 65.0f, "http://www.daawat.com/sites/all/themes/ltfoods/images/niki.png", "Groceries"));
        items.add("Clothes");
        spannableStringBuilder = new SpannableStringBuilder("Lewis \n Cotton \n");
        spannableStringBuilder.append(inStock);
        items.add(new ItemsData("Shirt", spannableStringBuilder, 1950.0f, "https://ih1.redbubble.net/image.43781314.8469/ra,unisex_tshirt,x2200,fafafa:ca443f4786,front-c,392,146,750,1000-bg,f8f8f8.jpg", "Clothes"));
        spannableStringBuilder = new SpannableStringBuilder("AltoMado \n Cotton \n");
        spannableStringBuilder.append(outOfStock);
        items.add(new ItemsData("Kurti", spannableStringBuilder, 1190.0f, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVXV8gyLVpafORuFZLrTZw5mImZEWiaQqvkDzqkJlUUCV66P_j", "Clothes"));
        items.add("Gifts");
        spannableStringBuilder = new SpannableStringBuilder("Milton Steel \n 300ml \n");
        spannableStringBuilder.append(inStock);
        items.add(new ItemsData("Mugs", spannableStringBuilder, 699.0f, "https://res.sastasundar.com/incom/images/product/Milton-Melamine-Milk-Mug-Coffee-1510205620-10036934.jpg", "Gifts"));
        spannableStringBuilder = new SpannableStringBuilder("Archies cardboard \n 7x10 inch \n");
        spannableStringBuilder.append(inStock);
        items.add(new ItemsData("Greeting cards", spannableStringBuilder, 390.0f, "https://static6.cilory.com/71042-large_default/archies-greeting-card-for-friendship.jpg", "Gifts"));
        items.add("Stationery");
        spannableStringBuilder = new SpannableStringBuilder("Reynolds \n gel \n");
        spannableStringBuilder.append(inStock);
        items.add(new ItemsData("Pen", spannableStringBuilder, 50.0f, "https://images-na.ssl-images-amazon.com/images/I/51facmqWkAL._SX425_.jpg", "Stationery"));
        spannableStringBuilder = new SpannableStringBuilder("Classmate \n Long Ruled \n");
        spannableStringBuilder.append(inStock);
        items.add(new ItemsData("Greeting cards", spannableStringBuilder, 250.0f, "https://sc01.alicdn.com/kf/HTB1STnIXIrHK1JjSspcq6yzgpXa4/Classmate-Cute-Cat-Note-Book.jpg_350x350.jpg", "Stationery"));










//        items.add("Test2");
//        items.add(new ItemsData("Sugar", "Sweet sapda porom", 67.0f, "https://cdn.vox-cdn.com/thumbor/S4mRG9paCnXOp4jz56x8Z6iPxkQ=/0x0:2040x1360/1820x1213/filters:focal(808x472:1134x798):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/57697089/shutterstock_552061828_sized.0.jpg"));
//        items.add(new ItemsData("Sugar", "Sweet sapda porom", 67.0f, "https://cdn.vox-cdn.com/thumbor/S4mRG9paCnXOp4jz56x8Z6iPxkQ=/0x0:2040x1360/1820x1213/filters:focal(808x472:1134x798):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/57697089/shutterstock_552061828_sized.0.jpg"));
//        items.add(new ItemsData("Sugar", "Sweet sapda porom", 67.0f, "https://cdn.vox-cdn.com/thumbor/S4mRG9paCnXOp4jz56x8Z6iPxkQ=/0x0:2040x1360/1820x1213/filters:focal(808x472:1134x798):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/57697089/shutterstock_552061828_sized.0.jpg"));
//        items.add(new ItemsData("Sugar", "Sweet sapda porom", 67.0f, "https://cdn.vox-cdn.com/thumbor/S4mRG9paCnXOp4jz56x8Z6iPxkQ=/0x0:2040x1360/1820x1213/filters:focal(808x472:1134x798):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/57697089/shutterstock_552061828_sized.0.jpg"));
//        items.add(new ItemsData("Sugar", "Sweet sapda porom", 67.0f, "https://cdn.vox-cdn.com/thumbor/S4mRG9paCnXOp4jz56x8Z6iPxkQ=/0x0:2040x1360/1820x1213/filters:focal(808x472:1134x798):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/57697089/shutterstock_552061828_sized.0.jpg"));
//        items.add("Test3");
//        items.add(new ItemsData("Sugar", "Sweet sapda porom", 67.0f, "https://cdn.vox-cdn.com/thumbor/S4mRG9paCnXOp4jz56x8Z6iPxkQ=/0x0:2040x1360/1820x1213/filters:focal(808x472:1134x798):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/57697089/shutterstock_552061828_sized.0.jpg"));
//        items.add(new ItemsData("Sugar", "Sweet sapda porom", 67.0f, "https://cdn.vox-cdn.com/thumbor/S4mRG9paCnXOp4jz56x8Z6iPxkQ=/0x0:2040x1360/1820x1213/filters:focal(808x472:1134x798):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/57697089/shutterstock_552061828_sized.0.jpg"));
//        items.add(new ItemsData("Sugar", "Sweet sapda porom", 67.0f, "https://cdn.vox-cdn.com/thumbor/S4mRG9paCnXOp4jz56x8Z6iPxkQ=/0x0:2040x1360/1820x1213/filters:focal(808x472:1134x798):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/57697089/shutterstock_552061828_sized.0.jpg"));
//        items.add(new ItemsData("Sugar", "Sweet sapda porom", 67.0f, "https://cdn.vox-cdn.com/thumbor/S4mRG9paCnXOp4jz56x8Z6iPxkQ=/0x0:2040x1360/1820x1213/filters:focal(808x472:1134x798):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/57697089/shutterstock_552061828_sized.0.jpg"));
//        items.add("Test4");
//        items.add(new ItemsData("Sugar", "Sweet sapda porom", 67.0f, "https://cdn.vox-cdn.com/thumbor/S4mRG9paCnXOp4jz56x8Z6iPxkQ=/0x0:2040x1360/1820x1213/filters:focal(808x472:1134x798):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/57697089/shutterstock_552061828_sized.0.jpg"));
//        items.add(new ItemsData("Sugar", "Sweet sapda porom", 67.0f, "https://cdn.vox-cdn.com/thumbor/S4mRG9paCnXOp4jz56x8Z6iPxkQ=/0x0:2040x1360/1820x1213/filters:focal(808x472:1134x798):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/57697089/shutterstock_552061828_sized.0.jpg"));
    }





    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

//        Intent i = new Intent(MainActivity.this, WayFindingActivity.class);
//        startActivity(i);

        //Handle if any of the permissions are denied, in grantResults
    }

}
