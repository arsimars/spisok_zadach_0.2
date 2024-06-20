package ru.example.todo;

import org.slf4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class Delete implements ClassnoVypolnil {

    @Override
    public boolean supports(String name) {
        return "delete".equals(name);
    }

    @Override
    public void vypolni(Scanner sc, ToDoList toDoList, Logger logger) {
        try {
            int h = sc.nextInt();
            logger.info("delete {}", h);
            try {
                if (0 <= h) {
                    toDoList.removeSpisok(h);
                } else {
                    out.println(Print.kiboshing);
                    logger.info(Print.kiboshing);
                }
            } catch (IndexOutOfBoundsException | NullPointerException e) {
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
