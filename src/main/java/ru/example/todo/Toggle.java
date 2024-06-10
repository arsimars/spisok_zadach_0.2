package ru.example.todo;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;

import static java.lang.System.out;

@CommandInterface(name = "toggle")

public class Toggle implements ClassnoVypolnil{
    public void vypolni (Scanner sc, ToDoList toDoList,Logger logger){
        int i;
        try {
            i = sc.nextInt();
            logger.info("toggle {}", i);
            if (App.nomerchek > i) {
                if (0 <= i) {
                    toDoList.spisok.get(i).menala();
                } else {
                    out.println(Print.kiboshing);
                    logger.info( Print.kiboshing);
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
