public class AddIfMaxCommand implements Executable {
    public String exec(String command, Storable storable, UI ui, StoredTypeReader reader, Workerable worker) {
        reader.setUI(ui);
        StoredType storedObject = reader.create();
        if(storable.ifMax(storedObject)) {
            storable.insert(storedObject);
            return "Добавлено";
        }else {
            return "Не максимальный";
        }
    }

    @Override
    public boolean checkCommand(String command) {
        String[] splitted = command.split(" ");
        return splitted[0].toLowerCase().equals("add_if_max");
    }
}
