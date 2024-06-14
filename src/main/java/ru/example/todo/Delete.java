package ru.example.todo;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;

import static java.lang.System.out;

public class Delete implements ClassnoVypolnil {

    @Override
    public void supports(String name) {
        name = "delete";
    }
    @Override
    public void vypolni(Scanner sc, ToDoList toDoList, Logger logger)
    {
        try {
            int h = sc.nextInt();
            logger.info("delete {}", h);
            if (App.nomerchek > h) {
                if (0 <= h) {
                    toDoList.spisok.remove(h);
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
