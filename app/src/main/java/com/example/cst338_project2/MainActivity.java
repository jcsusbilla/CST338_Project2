package com.example.cst338_project2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cst338_project2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "";
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}