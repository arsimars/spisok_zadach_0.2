import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.out;
public class Search {
    public void iskala(Scanner sc, ToDoList toDoList, Logger logger) {
        String slovo = sc.nextLine();
        logger.info("search {}", slovo);
        for (Zadanie u : toDoList.spisok) {
            if (u.zadacha.contains(slovo)) {
            out.println(u);
            logger.info(String.valueOf(u));
            }
        }
    }
}
