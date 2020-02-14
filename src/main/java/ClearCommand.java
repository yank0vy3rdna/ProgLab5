public class ClearCommand implements Executable{
    public String exec(String command, Storable storable, UI ui, StoredTypeReader reader, Workerable worker) {
        storable.clear();
        return "Очищено";
    }
    @Override
    public boolean checkCommand(String command) {
        String[] splitted = command.split(" ");
        return splitted[0].toLowerCase().equals("clear");
    }
}
