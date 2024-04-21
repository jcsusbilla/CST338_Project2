package com.example.cst338_project2.Database;

import android.app.Application;
import android.util.Log;

import com.example.cst338_project2.Database.entities.eCommerce;
import com.example.cst338_project2.MainActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class eCommerceRepository {
    private final eCommerceDAO eCommDAO;
    private ArrayList<eCommerce> allLogs;
    public eCommerceRepository(Application application){
        eCommerceDatabase db = eCommerceDatabase.getDatabase(application);
        this.eCommDAO = db.eCommDAO();
        this.allLogs = this.eCommDAO.getAllRecords();
    }


    public ArrayList<eCommerce> getAllLogs() {
        Future<ArrayList<eCommerce>> future = eCommerceDatabase.databaseWriteExecutor.submit(
                @Override
                new Callable<ArrayList<eCommerce>>() {
                    public ArrayList<eCommerce> call() throws Exception {
                        return eCommDAO.getAllRecords();
                    }
                }
        );
        try{
            return future.get();

        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
            Log.i(MainActivity.TAG, "Problem");
        }
        return null;
    }
    //vid3 48:49
}
