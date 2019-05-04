package com.example.usuario.expensestracker.ui.users;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.usuario.expensestracker.R;
import com.example.usuario.expensestracker.db.AppDatabase;
import com.example.usuario.expensestracker.db.dao.UserDao;
import com.example.usuario.expensestracker.db.entitiy.UserEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersListActivity extends AppCompatActivity {

    private boolean mIsDualPanel;
    private UsersListViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        mIsDualPanel = findViewById(R.id.user_detail_content) != null;

        RecyclerView recyclerView = findViewById(R.id.users_list);
        assert recyclerView != null;
        setupRecyclerView(recyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        if (vm == null) {
            vm = new UsersListViewModel(getApplication());
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        vm.getUsersLiveData().observe(this, users -> {
            recyclerView.setAdapter(new UserListAdapter(users, mIsDualPanel, this));

            if (users==null || users.size()==0) {
                final UserDao store= AppDatabase.getInstance(this).userDao();

                new Thread() {
                    @Override
                    public void run() {
                        store.insert(new UserEntity(new Date(), "Juan Pedro", "Juanito"),
                                new UserEntity(new Date(), "Juan Pedro", "Juanito"));
                    }
                }.start();
            }
        });
    }
}
