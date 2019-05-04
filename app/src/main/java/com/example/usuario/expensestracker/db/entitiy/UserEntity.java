package com.example.usuario.expensestracker.db.entitiy;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.usuario.expensestracker.model.IUser;

import java.util.Date;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "users")
public class UserEntity implements IUser {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Long id;

    @NonNull
    private Date createdAt;

    @NonNull
    private String name;
    private String description;

    public UserEntity(Date createdAt, String name, String description) {
        this.createdAt = createdAt;
        this.name = name;
        this.description = description;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
