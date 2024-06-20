package ru.example.todo;

import org.slf4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;


public class Toggle implements ClassnoVypolnil {
    private Object e;

    @Override
    public boolean supports(String name) {
        return "toggle".equals(name);
    }

    @Override
    public void vypolni(Scanner sc, ToDoList toDoList, Logger logger) {
        int i;
        toDoList.getSpisok();
        try {
            i = sc.nextInt();
            logger.info("toggle {}", i);
            try {
                if (0 <= i) {
                    toDoList.hardManala(i);
                } else {
                    out.println(Print.kiboshing);
                    logger.info(Print.kiboshing);
                }
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                sc.nextLine();
                out.println(Print.kiboshing);
                logger.info(Print.kiboshing);
            }

        } catch (
                InputMismatchException e) {
            sc.nextLine();
            out.println(Print.kiboshing);
            logger.info(Print.kiboshing);
        }
    }
}
