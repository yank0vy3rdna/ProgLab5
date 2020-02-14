interface Executable{
    String syntax = "";
    String exec(String command, Storable storable, UI ui, StoredTypeReader reader, Workerable worker);
    boolean checkCommand(String command);
}
