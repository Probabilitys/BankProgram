package com.example.bank_window;

import java.util.function.Consumer;

public interface Visitor<T,R> extends Consumer<T> {
    R result();
}