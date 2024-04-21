package com.example.cst338_project2.Database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.cst338_project2.Database.entities.eCommerce;
import com.example.cst338_project2.MainActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {eCommerce.class}, version = 1, exportSchema = false)
public abstract class eCommerceDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "eCommerce_database";
    public static final String ECOMMERCE_TABLE = "eCommerceTable";

    private static volatile eCommerceDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static eCommerceDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (eCommerceDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            eCommerceDatabase.class,
                            DATABASE_NAME)
                            .fallbackToDestructiveMigration()//erase everything & startover
                            .addCallback(addDefaultValues)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            Log.i(MainActivity.TAG, "DATABASE CREATED");
        }
    };

    public abstract eCommerceDAO eCommDAO();
}
