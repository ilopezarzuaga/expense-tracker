package com.example.usuario.expensestracker.db;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.usuario.expensestracker.db.dao.ExpenseDao;
import com.example.usuario.expensestracker.db.dao.ProductDao;
import com.example.usuario.expensestracker.db.dao.UserDao;
import com.example.usuario.expensestracker.db.entitiy.ExpenseEntity;
import com.example.usuario.expensestracker.db.entitiy.ProductEntity;
import com.example.usuario.expensestracker.db.entitiy.UserEntity;

import java.util.List;

public class Repository {

    private UserDao userDao;
    private ExpenseDao expenseDao;
    private ProductDao productDao;

    //User
    public LiveData<List<UserEntity>> getAllUsers() {
        return userDao.getAllUsers();
    }

    public LiveData<UserEntity> getUserById(Long userId) {
        return userDao.getUserById(userId);
    }

    public void insertUser(UserEntity entity) {
        userDao.insert(entity);
    }

    public void updateUser(UserEntity entity) {
        userDao.update(entity);
    }

    public void deleteUser(Long userId) {
        userDao.delete(userId);
    }

    //Expenses
    public LiveData<List<ExpenseEntity>> getAllExpenses() {
        return expenseDao.getAllExpenses();
    }

    public LiveData<List<ExpenseEntity>> getExpensesByUser(Long userId) {
        return expenseDao.getAllExpensesForUser(userId);
    }

    public LiveData<ExpenseEntity> getExpenseById(Long expenseId) {
        return expenseDao.getExpenseById(expenseId);
    }

    public void insertExpense(ExpenseEntity entity) {
        expenseDao.insert(entity);
    }

    public void updateExpense(ExpenseEntity entity) {
        expenseDao.update(entity);
    }

    public void deleteExpense(Long id) {
        expenseDao.delete(id);
    }

    //Product
    public LiveData<List<ProductEntity>> getAllProducts() {
        return productDao.getAllProducts();
    }

    public LiveData<ProductEntity> getProductById(Long id) {
        return productDao.getProductById(id);
    }

    public void insertProduct(ProductEntity entity) {
        productDao.insert(entity);
    }

    public void updateProduct(ProductEntity entity) {
        productDao.update(entity);
    }

    public void deleteProduct(Long id) {
        productDao.delete(id);
    }
}
