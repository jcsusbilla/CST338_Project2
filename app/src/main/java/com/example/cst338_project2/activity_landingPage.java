//JC SUSBILLA
//CST338 PROJECT 2
//LANDING PAGE
package com.example.cst338_project2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cst338_project2.databinding.ActivityLandingPageBinding;

public class activity_landingPage extends AppCompatActivity {
    Button changePasswordButton;
    Button purchaseItemsButton;
    Button viewPurchasesButton;
    Button adminButton;
    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        ActivityLandingPageBinding binding;

        binding =ActivityLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //String name = getIntent().getStringExtra("name");
        String name = "JC";
        displayUsername(name);
        changePasswordButton = binding.changePasswordButton;
        purchaseItemsButton = binding.purchaseItemsButton;
        viewPurchasesButton = binding.viewPurchasesButton;
        adminButton = binding.adminButton;
        logoutButton = binding.logoutButton;

        boolean isAdmin = getIntent().getBooleanExtra("isAdmin", true);
        if(isAdmin){
            adminButton.setVisibility(View.VISIBLE);
        }
        if(!isAdmin){
            adminButton.setVisibility(View.INVISIBLE);
        } else {
            //insert error handling
        }

        //button functions
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        purchaseItemsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        viewPurchasesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        adminButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Name", name);
                intent.putExtra("isAdmin",isAdmin);
                startActivity(intent);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void displayUsername(String name){ //adjust to Miguel's Login.java
        runOnUiThread(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                TextView welcomeWithName= findViewById(R.id.welcome);
                welcomeWithName.setText("Welcome" + name);
                welcomeWithName.setVisibility(View.VISIBLE);
            }
        });
    }
}