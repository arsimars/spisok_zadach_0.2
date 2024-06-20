package ru.example.todo;

import org.slf4j.Logger;

import java.util.Scanner;

import static java.lang.System.out;


public class Search implements ClassnoVypolnil {
    @Override
    public boolean supports(String name) {
        return "search".equals(name);
    }

    @Override

    public void vypolni(Scanner sc, ToDoList toDoList, Logger logger) {
        String slovo = sc.nextLine();
        logger.info("search {}", slovo);
        for (Zadanie u : toDoList.getSpisok()) {
            if (u.zadacha.contains(slovo)) {
                out.println(u);
                logger.info(String.valueOf(u));
            }
        }
    }
}
