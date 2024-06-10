package ru.example.todo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static java.lang.System.*;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static String zadacha;
    public static String allnet;
    public static Integer nomerchek = 0;

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        setProperty("LOG_LEVEL", "info");
        logger.trace("Entering method foo()");
        logger.debug("Received request from 198.12.34.56");
        logger.info("User logged in: john");
        logger.warn("Connection to server lost. Retrying...");
        logger.error("Failed to write data to file: myFile.txt");
        Scanner sc = new Scanner(in);
        var todolist = new ToDoList();
        var factory = new Factory();
        while (sc.hasNext()) {
            String command = sc.next();
            var cmd = factory.createCommand(command);
            cmd.vypolni(sc, todolist, logger);
        }
    }
}


