package com.example.usuario.expensestracker.model;

import java.util.Date;

public interface IExpense {

    Long getId();
    String getDescription();
    Date getCreatedAt();
    double getAmount();
    boolean isActive();
    boolean isExpense();
    Long getRegisteredById();
    Long getProductId();
    IProduct getProduct();
    IUser getUser();

}
