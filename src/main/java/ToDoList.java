import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.lang.System.out;

public class ToDoList {
    int nomerchek = 0;
    ArrayList<Zadanie> spisok = new ArrayList<Zadanie>();

    public void zpisochek_dobav(Zadanie nomer) {
        spisok.add(nomer);
    }

}
