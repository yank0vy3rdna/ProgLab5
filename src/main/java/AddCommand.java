public class AddCommand implements Executable{
    @Override
    @SuppressWarnings("unchecked")
    public String exec(String command, Storable storable, UI ui, StoredTypeReader reader, Workerable worker) {
        reader.setUI(ui);
        storable.insert(reader.create());
        return "Добавлено";
    }

    @Override
    public boolean checkCommand(String command) {
        String[] splitted = command.split(" ");
        return splitted[0].toLowerCase().equals("add");
    }
}
