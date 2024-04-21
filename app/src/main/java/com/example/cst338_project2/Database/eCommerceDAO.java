package com.example.cst338_project2.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.cst338_project2.Database.entities.eCommerce;

import java.util.ArrayList;

@Dao
public interface eCommerceDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(eCommerce eCom);

    @Query("Select * from " + eCommerceDatabase.ECOMMERCE_TABLE)
    ArrayList<eCommerce> getAllRecords();
}
