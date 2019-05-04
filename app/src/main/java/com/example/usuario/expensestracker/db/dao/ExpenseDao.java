package com.example.usuario.expensestracker.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.usuario.expensestracker.db.entitiy.ExpenseEntity;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Query("SELECT * FROM expenses WHERE id = :id")
    LiveData<ExpenseEntity> getExpenseById(Long id);

    @Query("SELECT * FROM expenses WHERE registeredById = :userId")
    LiveData<List<ExpenseEntity>> getAllExpensesForUser(Long userId);

    @Query("SELECT * FROM expenses")
    LiveData<List<ExpenseEntity>> getAllExpenses();

    @Insert
    void insert(ExpenseEntity expense);

    @Update
    int update(ExpenseEntity expenseEntity);

    @Delete
    int delete(Long id);
}
