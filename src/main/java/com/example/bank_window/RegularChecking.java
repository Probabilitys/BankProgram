package com.example.bank_window;

public class RegularChecking extends CheckingAccount {

    public RegularChecking(int acctnum) {
        super(acctnum);
    }

    protected String accountType() {
        return "Regular checking";
    }

    protected double interestRate() {
        return 0.0;
    }
}