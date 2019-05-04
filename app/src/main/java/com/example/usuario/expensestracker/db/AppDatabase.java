package com.example.usuario.expensestracker.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.example.usuario.expensestracker.db.converter.DateConverter;
import com.example.usuario.expensestracker.db.dao.ExpenseDao;
import com.example.usuario.expensestracker.db.dao.ProductDao;
import com.example.usuario.expensestracker.db.dao.UserDao;
import com.example.usuario.expensestracker.db.entitiy.ExpenseEntity;
import com.example.usuario.expensestracker.db.entitiy.ProductEntity;
import com.example.usuario.expensestracker.db.entitiy.UserEntity;

@Database(entities = {ProductEntity.class, UserEntity.class, ExpenseEntity.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();

    private static AppDatabase sInstance;

    private static final Object LOCK = new Object();

    @VisibleForTesting
    private static final String DB_NAME = "expense-tracker-db";

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Building database.");
                sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                        .build();

            }
        }
        Log.d(LOG_TAG, "Getting database.");
        return sInstance;
    }

    public abstract ExpenseDao expenseDao();

    public abstract UserDao userDao();

    public abstract ProductDao productDao();
}