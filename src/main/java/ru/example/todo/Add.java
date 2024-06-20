package ru.example.todo;

import org.slf4j.Logger;

import java.util.Scanner;

import static java.lang.System.out;

public class Add implements ClassnoVypolnil {
    @Override
    public boolean supports(String name) {
        return "add".equals(name);
    }

    @Override
    public void vypolni(Scanner sc, ToDoList toDoList, Logger logger) {
        String vipolni = "[]";
        String zadacha = sc.nextLine();
        logger.info("add {}", zadacha);
        if (!zadacha.isEmpty()) {
            Zadanie nomer = new Zadanie();
            nomer.vipolni = vipolni;
            nomer.zadacha = zadacha;
            toDoList.zpisochek_dobav(nomer);
        } else {
            out.println("ошибка");
            logger.info("ошибка");
        }
    }
}
