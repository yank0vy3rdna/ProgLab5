public class UpdateCommand implements Executable {
    @Override
    public String exec(String command, Storable storable, UI ui, StoredTypeReader reader, Workerable worker) {
        reader.setUI(ui);
        String[] splitted = command.split(" ");
        String key = ui.readField("key");
        if (storable.getElementById(key)==null) {
            storable.insert(key, reader.create());
            return "Обновлено";
        }else {
            return "Элемента с таким ключом нет";
        }
    }

    @Override
    public boolean checkCommand(String command) {
        String[] splitted = command.split(" ");
        return splitted[0].toLowerCase().equals("update");
    }
}
