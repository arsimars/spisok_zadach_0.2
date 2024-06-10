package ru.example.todo;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;

import static java.lang.System.out;
@CommandInterface(name = "edit")

public class Edit implements ClassnoVypolnil{
    public void vypolni  (Scanner sc, ToDoList toDoList, Logger logger) {
        try {
            int o = sc.nextInt();
            logger.info("edit {}", o);
            if (App.nomerchek > o) {
                if (0 <= o) {
                    String novai = sc.nextLine();
                    toDoList.spisok.get(o).zadacha = novai;
                    toDoList.spisok.get(o).vipolni = "[]";
                } else {
                    out.println(Print.kiboshing);
                    logger.info(Print.kiboshing);
                }
            } else {
                out.println(Print.kiboshing);
                logger.info(Print.kiboshing);
            }
        } catch (
                InputMismatchException e) {
            out.println(Print.kiboshing);
            logger.info(Print.kiboshing);
        }
    }
}
