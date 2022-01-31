package com.example.bankingapplication;

public class Accounts {
    private String ACCOUNT_NAME;
    private String ACCOUNT_NUMBER;
    private String AMMOUNT;

    public Accounts(String ACCOUNT_NAME, String ACCOUNT_NUMBER, String AMMOUNT) {
        this.ACCOUNT_NAME = ACCOUNT_NAME;
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
        this.AMMOUNT = AMMOUNT;
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
}
