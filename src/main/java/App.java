

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
        int nomerchek = 0;
        String nechego = "";
        ArrayList<Zadanie> spisok = new ArrayList<>();
        while (sc.hasNext()) {
            String command = sc.next();
            switch (command) {
                case "add" -> {
                    zadacha = sc.nextLine();
                    var add = new Add();
                    add.dobavka(sc, todolist);
                    ++nomerchek;
                }
                case "quit" -> exit(0);
                case "print" -> {
                    App.allnet = sc.nextLine();
                    var print = new Print();
                    print.nepokaz(sc, todolist);
                }
                case "toggle" -> {
                    int i;
                    try {
                        i = sc.nextInt();
                        logger.info("toggle {}", i);
                        if (nomerchek > i) {
                            if (0 <= i) {
                                spisok.get(i).menala();
                            } else {
                                out.println("не коретно введена команда");
                                logger.info("{}", kiboshing);
                            }

                        } else {
                            out.println("не коретно введена команда");
                            logger.info("{}", kiboshing);
                        }
                    } catch (InputMismatchException e) {
                        out.println("не коретно введена команда");
                        logger.info("{}", kiboshing);
                    }
                }
                case "delete" -> {
                    try {
                        int h = sc.nextInt();
                        logger.info("delete {}", h);
                        if (nomerchek > h) {
                            if (0 <= h) {
                                spisok.get(h).vipolni = "";
                                spisok.get(h).zadacha = "";
                                spisok.get(h).nomerochek = null;
                            } else {
                                out.println("не коретно введена команда");
                                logger.info("{}", kiboshing);
                            }
                        } else {
                            out.println("не коретно введена команда");
                            logger.info("{}", kiboshing);
                        }
                    } catch (InputMismatchException e) {
                        out.println("не коретно введена команда");
                        logger.info("{}", kiboshing);
                    }
                }
                case "edit" -> {
                    try {
                        int o = sc.nextInt();
                        logger.info("edit {}", o);
                        if (nomerchek > o) {
                            if (0 <= o) {
                                String novai = sc.nextLine();
                                spisok.get(o).zadacha = novai;
                                spisok.get(o).vipolni = "[]";
                            } else {
                                out.println("не коретно введена команда");
                                logger.info("{}", kiboshing);
                            }
                        } else {
                            out.println("не коретно введена команда");
                            logger.info("{}", kiboshing);
                        }
                    } catch (InputMismatchException e) {
                        out.println("не коретно введена команда");
                        logger.info("{}", kiboshing);
                    }
                }
                case "search" -> {
                    String slovo = sc.nextLine();
                    logger.info("search {}", slovo);
                    for (Zadanie u : spisok) {
                        if (u.zadacha.contains(slovo)) ;
                        out.println(u);
                    }
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

