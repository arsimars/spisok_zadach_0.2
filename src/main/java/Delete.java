import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.out;

public class Delete {
    public void udalit(Scanner sc,ToDoList toDoList,Logger logger)
    {
        try {
            int h = sc.nextInt();
            logger.info("delete {}", h);
            if (App.nomerchek > h) {
                if (0 <= h) {
                    toDoList.spisok.get(h).vipolni = "";
                    toDoList.spisok.get(h).zadacha = "";
                    toDoList.spisok.get(h).nomerochek = null;
                } else {
                    out.println(Print.kiboshing);
                    logger.info(Print.kiboshing);
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
