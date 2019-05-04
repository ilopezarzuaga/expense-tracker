package com.example.usuario.expensestracker.ui.users;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.expensestracker.R;
import com.example.usuario.expensestracker.db.entitiy.UserEntity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserDetailFragment#} factory method to
 * create an instance of this fragment.
 */
public class UserDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private UserDetailViewModel viewModel;

    public UserDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_user_detail, container, false);
        UserEntity userEntity;
        if (viewModel != null) {
            if (getArguments().containsKey(ARG_ITEM_ID)) {
                Long userId = getArguments().getLong(ARG_ITEM_ID);
                userEntity = viewModel.getUserEntity(userId);
                TextView textView = rootView.findViewById(R.id.user_name);
                textView.setText(userEntity.getName());
            }
        }
        return rootView;
    }

}
