package com.example.usuario.expensestracker.model;

import java.util.Date;

public interface IUser {

    Long getId();
    String getName();
    Date getCreatedAt();
    String getDescription();
}
