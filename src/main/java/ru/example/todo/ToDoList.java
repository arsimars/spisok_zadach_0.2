package ru.example.todo;

import java.util.ArrayList;

public class ToDoList {
    int nomerchek = 0;
    ArrayList<Zadanie> spisok = new ArrayList<Zadanie>();

    public void zpisochek_dobav(Zadanie nomer) {
        spisok.add(nomer);
    }

}
