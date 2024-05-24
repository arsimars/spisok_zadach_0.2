

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        System.setProperty("LOG_LEVEL", "info");

        logger.trace("Entering method foo()");
        logger.debug("Received request from 198.12.34.56");
        logger.info("User logged in: john");
        logger.warn("Connection to server lost. Retrying...");
        logger.error("Failed to write data to file: myFile.txt");
        Scanner sc = new Scanner(System.in);
        String zadacha;
        String vipolni = "[]";
        int nomerchek = 0;
        String nechego = "";
        ArrayList<Zadanie> spisok = new ArrayList<>();
        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new Command("""
                 1.Формат команды: add <описание задачи>

                Описание задачи может содержать любые символы, кроме перевода строки.
                Перевод строки (нажатие клавиши Enter) означает завершение ввода описания задачи.
                """));
        commands.add(new Command("""
                2.Формат команды: print [all]

                Выводит на печать список задач.
                """));
        commands.add(new Command("""
                3.формат команды: print
                По-умолчанию выводятся только невыполненные задачи
                """));
        commands.add(new Command("""
                4.Формат команды: toggle <идентификатор задачи>

                Переключает состояние задачи (с "выполнена" на "не выполнена" и наоборот) по идентификатору
                """));
        commands.add(new Command("""
                5.Формат команды: quit

                Завершает работу программы
                """));
        commands.add(new Command("""
                6.Формат команды: search <substring>

                Выводит на печать список задач, описание которых содержит substring.\s
                """));
        commands.add(new Command("""
                7.Формат команды: delete <идентификатор задачи>

                Удаляет задачу из списка задач.
                """));
        commands.add(new Command("""
                8.Формат команды: edit <идентификатор задачи> <новое значение>

                Меняет описание задачи.
                """));
        while (sc.hasNext()) {
            String command = sc.next();
            switch (command) {
                case "add" -> {
                    zadacha = sc.nextLine();
                    if (!zadacha.isEmpty()) {
                        Zadanie nomer = new Zadanie();
                        nomer.vipolni = vipolni;
                        nomer.zadacha = zadacha;
                        nomer.nomerochek = nomerchek;
                        ++nomerchek;
                        spisok.add(nomer);
                    } else {
                        System.out.println("ошибка");
                    }
                }
                case "quit" -> System.exit(0);
                case "print" -> {
                    String allnet = sc.nextLine();
                    if (allnet.contains("all")) {
                        for (Zadanie f : spisok) {
                            System.out.println(f);
                        }
                    } else if (allnet.equals(nechego)) {
                        for (Zadanie t : spisok) {
                            if (t.vipolni.equals("[]")) {
                                System.out.println(t);
                            }
                        }
                    } else {
                        System.out.println("не коретно введена команда");
                    }
                }
                case "toggle" -> {
                    int i;
                    try {
                        i = sc.nextInt();
                        if (nomerchek > i) {
                            if (0 <= i) {
                                spisok.get(i).menala();

                            } else {
                                System.out.println("не коретно введена команда");
                            }

                        } else {
                            System.out.println("не коретно введена команда");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("не коретно введена команда");
                    }
                }
                case "delete" -> {
                    try {
                        int h = sc.nextInt();
                        if (nomerchek > h) {
                            if (0 <= h) {
                                spisok.get(h).vipolni = "";
                                spisok.get(h).zadacha = "";
                                spisok.get(h).nomerochek= null;
                            } else {
                                System.out.println("не коретно введена команда");
                            }
                        } else {
                            System.out.println("не коретно введена команда");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("не коретно введена команда");
                    }
                }
                case "edit" -> {
                    try {
                        int o = sc.nextInt();
                        if (nomerchek > o) {
                            if (0 <= o) {
                                String novai = sc.nextLine();
                                spisok.get(o).zadacha = novai;
                                spisok.get(o).vipolni = "[]";
                            } else {
                                System.out.println("не коретно введена команда");
                            }
                        } else {
                            System.out.println("не коретно введена команда");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("не коретно введена команда");
                    }
                }
                case "search" -> {
                    String slovo = sc.nextLine();
                    for (Zadanie u : spisok) {
                        if (u.zadacha.contains(slovo)) ;
                        System.out.println(u);
                    }
                }
                case "help" -> {
                    for (Command d : commands) {
                        System.out.println(d);
                    }
                }
            }
        }

    }
}

