public class SaveCommand implements Executable{
    public String exec(String command, Storable storable, UI ui, StoredTypeReader reader, Workerable worker) {
        storable.save(ui.getFilename(), worker);
        return "Сохранено";
    }
    @Override
    public boolean checkCommand(String command) {
        String[] splitted = command.split(" ");
        return splitted[0].toLowerCase().equals("clear");
    }
}
