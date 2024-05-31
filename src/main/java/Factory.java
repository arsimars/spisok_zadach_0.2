public class Factory {

    public ClassnoVypolnil createCommand(String command) {
        switch (command) {
            case "add" -> {
                return new Add();
            }
            case "quit" ->{
                return new Quit();
            }
            case "print" -> {
                return new Print();
            }
            case "toggle" -> {
                return new Toggle();
            }
            case "delete" -> {
                return new Delete();
            }
            case "edit" -> {
                return new Edit();
            }
            case "search" -> {
                return new Search();
            }
            case "help" -> {
                return new Help();
            }
        }
        return new VsePloho();
    }
}