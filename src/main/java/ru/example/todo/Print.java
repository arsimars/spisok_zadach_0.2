package ru.example.todo;

import org.slf4j.Logger;

import java.util.Scanner;

import static java.lang.System.out;


public class Print implements ClassnoVypolnil {

    String nechego = "";
    public static String kiboshing = "не коретно введена команда";

    @Override
    public boolean supports(String name) {
        return "print".equals(name);
    }

    @Override
    public void vypolni(Scanner sc, ToDoList toDoList, Logger logger) {
        toDoList.getSpisok();
        String allnet = sc.nextLine();
        logger.info("print {}", allnet);
        if (allnet.contains("all")) {
            for (Zadanie alll : toDoList.getSpisok()) {
                out.println(alll);
                logger.info(String.valueOf(alll));
            }
        } else if (allnet.equals(nechego)) {
            for (Zadanie t : toDoList.getSpisok()) {
                if (t.vipolni.equals("[]")) {
                    out.println(t);
                    logger.info(String.valueOf(t));
                }
            }
        } else {
            out.println(kiboshing);
            logger.info(kiboshing);
        }
    }
}