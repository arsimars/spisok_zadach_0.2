import java.util.ArrayList;
import java.util.Scanner;



    public static class zadanie {
        String zadacha;
        String vipolni;
        Integer nomerochek;
        public void menala() {
            if (vipolni.equals("[]")) vipolni = ("[X]");
            else vipolni = ("[]");
            System.out.println(nomerochek+vipolni + zadacha);
        }

        @Override
        public String toString() {
            return nomerochek + vipolni + zadacha;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String zadacha = "";
        String vipolni = "[]";
        Integer nomerchek = 0;
        ArrayList<zadanie> spisok = new ArrayList<>();
        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equals("add")) {
                zadacha = sc.nextLine();
                zadanie nomer = new zadanie();
                nomer.vipolni = vipolni;
                nomer.zadacha = zadacha;
                nomer.nomerochek=nomerchek;
                ++nomerchek;
                spisok.add(nomer);
            } else if (command.equals("quit")) {
                System.exit(0);
            } else if (command.equals("print")) {
                for (zadanie t : spisok) {
                    if (t.vipolni.equals("[]")) {
                        System.out.println(t);
                    }
                }
            } else if (command.equals("print[all]")) {
                for (zadanie f : spisok) {
                    System.out.println(f);
                }
            } else if (command.equals("toggle")) {
                int i = sc.nextInt();
                spisok.get(i).menala();
            } else if (command.equals("delete")) {
                int h = sc.nextInt();
                spisok.get(h).vipolni = "";
                spisok.get(h).zadacha = "";
            } else if (command.equals("edit")) {
                int o = sc.nextInt();
                String novai = sc.nextLine();
                spisok.get(o).zadacha = novai;
                spisok.get(o).vipolni = "[]";
            } else if (command.equals("search")) {
                String slovo = sc.nextLine();
                for (zadanie u : spisok) {
                    if (u.zadacha.contains(slovo)) ;
                    System.out.println(u);
                }
            }
        }
    }

