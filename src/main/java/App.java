

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static String zadacha;
    public static String allnet;
    public static Integer nomerchek = 0;

    public static void main(String[] args) {
        setProperty("LOG_LEVEL", "info");
        String kiboshing = "не коретно введена команда";
        logger.trace("Entering method foo()");
        logger.debug("Received request from 198.12.34.56");
        logger.info("User logged in: john");
        logger.warn("Connection to server lost. Retrying...");
        logger.error("Failed to write data to file: myFile.txt");
        Scanner sc = new Scanner(in);
        var todolist = new ToDoList();
        while (sc.hasNext()) {
            String command = sc.next();
            switch (command) {
                case "add" -> {
                    zadacha = sc.nextLine();
                    var add = new Add();
                    add.dobavka(sc, todolist,logger);
                }
                case "quit" -> exit(0);
                case "print" -> {
                    var print = new Print();
                    print.nepokaz(sc, todolist,logger);
                }
                case "toggle" -> {
                    var toggle = new Toggle();
                    toggle.menalaApp(sc,todolist,logger);
                }
                case "delete" -> {
                    var delete = new Delete();
                    delete.udalit(sc,todolist,logger);
                }
                case "edit" -> {
                    var edit = new Edit();
                    edit.pomenala(sc,todolist,logger);
                }
                case "search" -> {
                    var search = new Search();
                    search.iskala(sc,todolist,logger);
                }
                case "help" -> {
                    var help = new Help();
                    help.helpanul();
                    logger.info("help");
                }
            }
        }
    }
}

