package ru.example.todo;

import org.slf4j.Logger;

import java.util.Scanner;

public interface ClassnoVypolnil {

    void supports (String name);

    void vypolni(Scanner sc, ToDoList toDoList, Logger logger);
}
