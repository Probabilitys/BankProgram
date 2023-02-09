package com.example.bank_window;

import java.util.Scanner;

public interface InputCommand {
    String execute(Scanner sc, InputController controller);
}