package com.example.bankingapplication;

import android.widget.ImageView;

public class Acc {

    private String ACCOUNT_NAME;
    private String ACCOUNT_NUMBER;
    private String AMMOUNT;
    private int iv;

    public Acc(String ACCOUNT_NAME, String ACCOUNT_NUMBER, String AMMOUNT, int iv) {
        this.ACCOUNT_NAME = ACCOUNT_NAME;
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
        this.AMMOUNT = AMMOUNT;
        this.iv = iv;
    }

    public String getACCOUNT_NAME() {
        return ACCOUNT_NAME;
    }

    public void setACCOUNT_NAME(String ACCOUNT_NAME) {
        this.ACCOUNT_NAME = ACCOUNT_NAME;
    }

    public String getACCOUNT_NUMBER() {
        return ACCOUNT_NUMBER;
    }

    public void setACCOUNT_NUMBER(String ACCOUNT_NUMBER) {
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
    }

    public String getAMMOUNT() {
        return AMMOUNT;
    }

    public void setAMMOUNT(String AMMOUNT) {
        this.AMMOUNT = AMMOUNT;
    }

    public int getIv() {
        return iv;
    }

    public void setIv(int iv) {
        this.iv = iv;
    }
}
