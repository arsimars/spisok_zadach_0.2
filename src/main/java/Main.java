import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String zadacha = "";
        String vipolni = "[]";
        Integer nomerchek = 0;
        String nechego = "";
        ArrayList<Zadanie> spisok = new ArrayList ();
        ArrayList<Command> commands = new ArrayList ();

        commands.add(new Command(" 1.Формат команды: add <описание задачи>\n" + "\n" + "Описание задачи может содержать любые символы, кроме перевода строки.\n" + "Перевод строки (нажатие клавиши Enter) означает завершение ввода описания задачи.\n"));
        commands.add(new Command("2.Формат команды: print [all]\n" + "\n" + "Выводит на печать список задач.\n"));
        commands.add(new Command("3.формат команды: print\n" + "По-умолчанию выводятся только невыполненные задачи\n"));
        commands.add(new Command("4.Формат команды: toggle <идентификатор задачи>\n" + "\n" + "Переключает состояние задачи (с \"выполнена\" на \"не выполнена\" и наоборот) по идентификатору\n"));
        commands.add(new Command("5.Формат команды: quit\n" + "\n" + "Завершает работу программы\n"));
        commands.add(new Command("6.Формат команды: search <substring>\n" + "\n" + "Выводит на печать список задач, описание которых содержит substring. \n"));
        commands.add(new Command("7.Формат команды: delete <идентификатор задачи>\n" + "\n" + "Удаляет задачу из списка задач.\n"));
        commands.add(new Command("8.Формат команды: edit <идентификатор задачи> <новое значение>\n" + "\n" + "Меняет описание задачи.\n"));
        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equals("add")) {
                zadacha = sc.nextLine();
                if (!zadacha.equals("")) {
                    Zadanie nomer = new Zadanie();
                    nomer.vipolni = vipolni;
                    nomer.zadacha = zadacha;
                    nomer.nomerochek = nomerchek;
                    ++nomerchek;
                    spisok.add(nomer);
                } else {
                    System.out.println("ошибка");
                }
            } else if (command.equals("quit")) {
                System.exit(0);
            } else if (command.equals("print")) {
                String K = sc.nextLine();
                if (K.equals("all")) {
                    for (Zadanie f : spisok) {
                        System.out.println(f);
                    }
                } else if (K.equals(nechego)) {
                    for (Zadanie t : spisok) {
                        if (t.vipolni.equals("[]")) {
                            System.out.println(t);
                        }
                    }
                } else ;
                {
                    System.out.println("не коретно введена команда");
                }
            } else if (command.equals("toggle")) {
                Integer i = -120;
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
            } else if (command.equals("delete")) {
                try {
                    int h = sc.nextInt();
                    if (nomerchek > h) {
                        if (0 <= h) {
                            spisok.get(h).vipolni = "";
                            spisok.get(h).zadacha = "";
                        } else {
                            System.out.println("не коретно введена команда");
                        }
                    } else {
                        System.out.println("не коретно введена команда");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("не коретно введена команда");
                }
            } else if (command.equals("edit")) {
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
            } else if (command.equals("search")) {
                String slovo = sc.nextLine();
                for (Zadanie u : spisok) {
                    if (u.zadacha.contains(slovo)) ;
                    System.out.println(u);
                }
            } else if (command.equals("help")) {
                for (Command d : commands) {
                    System.out.println(d);
                }
            }
        }
    }

}