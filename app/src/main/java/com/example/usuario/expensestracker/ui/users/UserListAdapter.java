package com.example.usuario.expensestracker.ui.users;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.expensestracker.R;
import com.example.usuario.expensestracker.db.entitiy.UserEntity;
import com.example.usuario.expensestracker.ui.test.ItemDetailActivity;
import com.example.usuario.expensestracker.ui.test.ItemDetailFragment;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder>{

    private boolean mDualPanel;
    private List<UserEntity> users;
    private UsersListActivity parent;

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            UserEntity selectedUser = (UserEntity) view.getTag();
            if (mDualPanel) {
                Bundle arguments = new Bundle();
                arguments.putLong(UserDetailFragment.ARG_ITEM_ID, selectedUser.getId());
                UserDetailFragment fragment = new UserDetailFragment();
                fragment.setArguments(arguments);
                parent.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.user_detail_content, fragment)
                            .commit();
            } else {
                Context context = view.getContext();
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, selectedUser.getId());

                context.startActivity(intent);
            }
        }
    };

    public UserListAdapter(List<UserEntity> users, boolean mDualPanel, UsersListActivity parent) {
        this.users = users;
        this.mDualPanel = mDualPanel;
        this.parent = parent;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewHolder = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_list_content, viewGroup, false);
        return new UserViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        UserEntity user = users != null ? users.get(i) : null;
        userViewHolder.bind(user);
        userViewHolder.itemView.setTag(i);
        userViewHolder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return users != null && !users.isEmpty() ? users.size() : 0;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        final TextView mUserName;
        final TextView mUserDescription;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            mUserDescription = (TextView) itemView.findViewById(R.id.user_content_description);
            mUserName = (TextView) itemView.findViewById(R.id.user_content_name);
        }

        public void bind(UserEntity user) {
            mUserName.setText(user.getName());
            mUserDescription.setText(user.getDescription());
        }
    }
}
