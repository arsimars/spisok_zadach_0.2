package ru.example.todo;

import java.util.Scanner;

import org.slf4j.Logger;

import static java.lang.System.out;
public class Add implements ClassnoVypolnil {
    @Override
    public void supports(String name) {
        name = "add";
    }
    @Override
    public void vypolni(Scanner sc, ToDoList toDoList, Logger logger) {
        String vipolni = "[]";
        App.zadacha = sc.nextLine();
        logger.info("add {}", App.zadacha);
        if (!App.zadacha.isEmpty()) {
            Zadanie nomer = new Zadanie();
            nomer.vipolni = vipolni;
            nomer.zadacha = App.zadacha;
            nomer.nomerochek = App.nomerchek;
            ++App.nomerchek;
            toDoList.zpisochek_dobav(nomer);
        } else {
            out.println("ошибка");
            logger.info("ошибка");
        }
    }
}
