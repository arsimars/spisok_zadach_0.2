import org.slf4j.Logger;

import java.util.Scanner;

public class VsePloho implements ClassnoVypolnil {
    @Override
    public void vypolni(Scanner sc, ToDoList toDoList, Logger logger) {
        System.out.println("не верно введена команда");
        logger.info("не верно введена команда");
    }
}
