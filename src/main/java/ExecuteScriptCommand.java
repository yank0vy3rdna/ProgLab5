import java.io.*;

public class ExecuteScriptCommand implements Executable{
    @Override
    public String exec(String command, Storable storable, UI ui, StoredTypeReader reader, Workerable worker) {
        String filename = command.split(" ")[1];
        try {
            BufferedReader filereader = new BufferedReader(new FileReader(new File(filename)));
            String line;
            while (filereader.ready()){
                line = filereader.readLine();
                switch (line.split(" ")[0].toLowerCase()){
                    case "add":
                    case "update":
                    case "add_if_max":
                    case "remove_greater":
                    case "remove_lower":
                        break;
                    default:
                        ui.getCommander().execute(line, ui);
                }
            }
            return "Выполнено";
        } catch (FileNotFoundException e) {
            return "Файл не найден";
        } catch (IOException e) {
            e.printStackTrace();
            return "IO Exception";
        }
    }

    @Override
    public boolean checkCommand(String command) {
        return false;
    }
}
