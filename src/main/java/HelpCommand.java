public class HelpCommand implements Executable {
    @Override
    public String exec(String command, Storable storable, UI ui, StoredTypeReader reader, Workerable worker) {
        return "help : вывести справку по доступным командам"+
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n"+
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n"+
                "add {element} : добавить новый элемент в коллекцию\n"+
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n"+
                "remove_by_id id : удалить элемент из коллекции по его id\n"+
                "clear : очистить коллекцию\n"+
                "save : сохранить коллекцию в файл\n"+
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. \n" +
                "exit : завершить программу (без сохранения в файл) \n" +
                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "sum_of_age : вывести сумму значений поля age для всех элементов коллекции\n" +
                "count_less_than_age age : вывести количество элементов, значение поля age которых меньше заданного\n" +
                "filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку";
    }

    @Override
    public boolean checkCommand(String command) {
        String[] splitted = command.split(" ");
        return splitted[0].toLowerCase().equals("help");
    }
}
