package ru.example.todo;

import org.slf4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class Edit implements ClassnoVypolnil {


    @Override
    public boolean supports(String name) {
        return "edit".equals(name);
    }

    @Override
    public void vypolni(Scanner sc, ToDoList toDoList, Logger logger) {
        try {
            int o = sc.nextInt();
            try {
                logger.info("edit {}", o);
                if (0 <= o) {
                    String novai = sc.nextLine();
                    toDoList.newZadacha(o, novai);
                } else {
                    out.println(Print.kiboshing);
                    logger.info(Print.kiboshing);
                }
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                sc.next();
                out.println(Print.kiboshing);
                logger.info(Print.kiboshing);
            }
        } catch (InputMismatchException e) {
            sc.next();
            out.println(Print.kiboshing);
            logger.info(Print.kiboshing);
        }
    }
}
