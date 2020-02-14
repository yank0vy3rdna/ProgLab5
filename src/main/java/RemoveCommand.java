public class RemoveCommand implements Executable{
    @Override
    public String exec(String command, Storable storable, UI ui, StoredTypeReader reader, Workerable worker) {
        return "В множествах нет индексов гений";
    }
    @Override
    public boolean checkCommand(String command) {
        String[] splitted = command.split(" ");
        return splitted[0].toLowerCase().equals("remove_by_id");
    }
}
