import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.lang.System.out;

public class Print {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    String nechego = "";
    String kiboshing = "не коретно введена команда";
    public void nepokaz (Scanner sc, ToDoList toDoList) {
        App.allnet = sc.nextLine();
        logger.info("print {}", App.allnet);
        if (App.allnet.contains("all")) {
            for (Zadanie alll : toDoList.spisok) {
                out.println(alll);
                logger.info(String.valueOf(alll));
            }
        } else if (App.allnet.equals(nechego)) {
            for (Zadanie t : toDoList.spisok) {
                if (t.vipolni.equals("[]")) {
                    out.println(t);
                    logger.info(String.valueOf(t));
                }
            }
        } else {
            out.println("не коретно введена команда");
            logger.info("{}", kiboshing);
        }
    }
}