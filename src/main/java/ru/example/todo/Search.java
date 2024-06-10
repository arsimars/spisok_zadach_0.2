package ru.example.todo;

import java.util.Scanner;

import org.slf4j.Logger;

import static java.lang.System.out;
@CommandInterface(name = "search")

public class Search implements ClassnoVypolnil {
    public void vypolni (Scanner sc, ToDoList toDoList, Logger logger) {
        String slovo = sc.nextLine();
        logger.info("search {}", slovo);
        for (Zadanie u : toDoList.spisok) {
            if (u.zadacha.contains(slovo)) {
            out.println(u);
            logger.info(String.valueOf(u));
            }
        }
    }
}
