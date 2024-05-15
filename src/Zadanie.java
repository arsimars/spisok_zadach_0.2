public class Zadanie {
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