package com.example.cst338_project2.database;

import android.app.Application;

import com.example.cst338_project2.database.entities.User;

import java.util.ArrayList;

public class AppRepository {
    private UserDAO userDAO;

    private static AppRepository repository;

    private AppRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        this.userDAO = db.userDAO();
    }

    public void insetUser(User...user){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDAO.insert(user);
        });
    }
}
