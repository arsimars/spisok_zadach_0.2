package ru.example.todo;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private int nomerchek = 0;
    private ArrayList<Zadanie> spisok = new ArrayList<Zadanie>();
    private int altnomerochek;

    public void zpisochek_dobav(Zadanie nomer) {
        nomer.nomerochek = nomerchek;
        nomerchek++;
        spisok.add(nomer);
    }

    public List<Zadanie> getSpisok() {
        return spisok;
    }
public void removeSpisok(int h){
    spisok.remove(h);
}
public void hardManala (int i){
    spisok.get(i).menala();
}
public void newZadacha(int o,String novai){
    spisok.get(o).zadacha = novai;
    spisok.get(o).vipolni = "[]";
}
}
