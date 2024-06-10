package ru.example.todo;

import org.slf4j.Logger;

import java.util.Scanner;
@CommandInterface(name = "quit")

public class Quit implements ClassnoVypolnil{
    @Override
    public void vypolni(Scanner sc, ToDoList toDoList, Logger logger) {
        System.exit(0);
    }
}
