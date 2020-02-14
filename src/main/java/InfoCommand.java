public class InfoCommand implements Executable {
    @Override
    public String exec(String command, Storable storable, UI ui, StoredTypeReader reader, Workerable worker) {
        return String.format("Тип коллекции: %s\nДата инициализации: %s\nКоличество элементов: %d",
                storable.getCollectionType(),
                storable.getCreateDate().toString(),
                storable.getSize());
    }

    @Override
    public boolean checkCommand(String command) {
        String[] splitted = command.split(" ");
        return splitted[0].toLowerCase().equals("info");
    }
}
