package com.example.usuario.expensestracker.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.usuario.expensestracker.db.entitiy.ProductEntity;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM products")
    LiveData<List<ProductEntity>> getAllProducts();

    @Query("SELECT * FROM products WHERE id = :id")
    LiveData<ProductEntity> getProductById(Long id);

    @Insert
    void insert(ProductEntity entity);

    @Update
    void update(ProductEntity entity);

    @Delete
    void delete(Long id);
}
