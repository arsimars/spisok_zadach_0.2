import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.out;

public class Add extends Zadanie {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public void dobavka(Scanner sc, ToDoList toDoList) {
        String vipolni = "[]";
        logger.info("add {}", zadacha);
        if (!App.zadacha.isEmpty()) {
            Zadanie nomer = new Zadanie();
            nomer.vipolni = vipolni;
            nomer.zadacha = App.zadacha;
            nomer.nomerochek = App.nomerchek;
            ++App.nomerchek;
            toDoList.zpisochek_dobav(nomer);
        } else {
            out.println("ошибка");
            logger.info("ошибка");
        }
    }
}
