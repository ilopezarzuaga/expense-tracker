package com.example.usuario.expensestracker.db.entitiy;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.usuario.expensestracker.model.IProduct;

@Entity(tableName = "products")
public class ProductEntity implements IProduct {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    @NonNull
    private String name;
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
