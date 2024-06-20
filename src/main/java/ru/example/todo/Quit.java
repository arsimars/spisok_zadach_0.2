package ru.example.todo;

import org.slf4j.Logger;

import java.util.Scanner;


public class Quit implements ClassnoVypolnil {
    @Override
    public boolean supports(String name) {
        return "quit".equals(name);
    }

    @Override
    public void vypolni(Scanner sc, ToDoList toDoList, Logger logger) {
        System.exit(0);
    }
}
