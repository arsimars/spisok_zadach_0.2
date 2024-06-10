package ru.example.todo;

import java.util.Scanner;

import org.slf4j.Logger;

import static java.lang.System.out;
@CommandInterface(name = "print")

public class Print implements ClassnoVypolnil {

    String nechego = "";
    public static String kiboshing = "не коретно введена команда";
    public void vypolni (Scanner sc, ToDoList toDoList,Logger logger) {
        App.allnet = sc.nextLine();
        logger.info("print {}", App.allnet);
        if (App.allnet.contains("all")) {
            for (Zadanie alll : toDoList.spisok) {
                out.println(alll);
                logger.info(String.valueOf(alll));
            }
        } else if (App.allnet.equals(nechego)) {
            for (Zadanie t : toDoList.spisok) {
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