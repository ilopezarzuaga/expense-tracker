package com.example.usuario.expensestracker.db.entitiy;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.usuario.expensestracker.model.IExpense;
import com.example.usuario.expensestracker.model.IProduct;
import com.example.usuario.expensestracker.model.IUser;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "expenses",
        foreignKeys = @ForeignKey(
                entity = UserEntity.class,
                parentColumns = "id",
                childColumns = "registeredById",
                onDelete = CASCADE
        ), indices = @Index("registeredById"))
public class ExpenseEntity implements IExpense {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Long id;
    private String description;
    private Date createdAt;
    @NonNull
    private double amount;
    private boolean active;
    private boolean expense;

    @NonNull
    private Long registeredById;
    private Long productId;

    @Ignore
    private IUser user;
    @Ignore
    private IProduct product;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean isExpense() {
        return expense;
    }

    public void setExpense(boolean expense) {
        this.expense = expense;
    }

    @Override
    public Long getRegisteredById() {
        return registeredById;
    }

    public void setRegisteredById(Long registeredById) {
        this.registeredById = registeredById;
    }

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public IProduct getProduct() {
        return product;
    }

    public void setProduct(IProduct product) {
        this.product = product;
    }

    @Override
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
