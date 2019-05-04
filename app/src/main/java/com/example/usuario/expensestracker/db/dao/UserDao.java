package com.example.usuario.expensestracker.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.usuario.expensestracker.db.entitiy.UserEntity;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    LiveData<List<UserEntity>> getAllUsers();

    @Query("SELECT * FROM users WHERE id = :id")
    LiveData<UserEntity> getUserById(Long id);

    @Insert
    void insert(UserEntity... entity);

    @Update
    void update(UserEntity entity);

    @Delete
    void delete(Long id);
}
