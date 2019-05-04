package com.example.usuario.expensestracker.ui.users;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.usuario.expensestracker.db.AppDatabase;
import com.example.usuario.expensestracker.db.Repository;
import com.example.usuario.expensestracker.db.entitiy.UserEntity;

import java.util.List;

import javax.inject.Inject;

public class UsersListViewModel extends ViewModel {

    private Repository repository;
    private LiveData<List<UserEntity>> usersLiveData;

    public UsersListViewModel(Application application) {
        usersLiveData = AppDatabase.getInstance(application)
                .userDao().getAllUsers();
    }

    public LiveData<List<UserEntity>> getUsersLiveData() {
        return usersLiveData;
    }
}
