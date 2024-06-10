package ru.example.todo;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;
@CommandInterface(name = "help")
public class Help implements ClassnoVypolnil{
    @Override

    public void vypolni(Scanner sc, ToDoList toDoList, org.slf4j.Logger logger) {
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
        logger.info("help");

        for (Command d : commands) {
            out.println(d);
        }
    }
    }

