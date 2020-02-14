public class ShowCommand implements Executable {
    @Override
    public String exec(String command, Storable storable, UI ui, StoredTypeReader reader, Workerable worker) {
        StringBuilder answ = new StringBuilder();
        for (String key:
             storable.getKeySet()) {
            answ.append(key).append(" : ").append(storable.getElementById(key).toString(worker)).append("\n");
        }
        return answ.toString();
    }

    @Override
    public boolean checkCommand(String command) {
        String[] splitted = command.split(" ");
        return splitted[0].toLowerCase().equals("show");
    }
}
