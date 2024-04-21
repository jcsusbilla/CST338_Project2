package com.example.cst338_project2.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.cst338_project2.database.entities.User;

import java.util.List;

@Dao
public interface UserDAO {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(User... user);

  @Delete
  void delete(User user);

  @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " ORDER BY username")
  List<User> getAllUsers();

  @Query("DELETE from " + AppDatabase.USER_TABLE)
  void deleteAll();
}
