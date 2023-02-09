package com.example.bank_window;

public interface BankObserver {
    void update(BankEvent event, BankAccount ba, int depositamt);
}