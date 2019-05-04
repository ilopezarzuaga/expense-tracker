package com.example.usuario.expensestracker.ui.users;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.usuario.expensestracker.db.AppDatabase;
import com.example.usuario.expensestracker.db.dao.UserDao;
import com.example.usuario.expensestracker.db.entitiy.UserEntity;

public class UserDetailViewModel extends ViewModel {
    private UserEntity userEntity;
    private UserDao userDao;

    public UserDetailViewModel(Application application) {
        userDao = AppDatabase.getInstance(application).userDao();
    }

    public UserEntity getUserEntity(Long id) {
         if (userEntity == null) {
             userEntity = userDao.getUserById(id).getValue();
         }
         return userEntity;
    }
}
