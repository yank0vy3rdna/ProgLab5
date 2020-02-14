import java.util.ArrayList;
import java.util.List;

/**
 * Controller
 * <ul>
 * <li>import {filename} - добавить в коллекцию все элементы из файла</li>
 * <li>info - вывести информацию о коллекции</li>
 * <li>insert {key} {json} - добавить новый элемент с заданным ключом</li>
 * <li>show - вывести все элементы коллекции в строковом представлении в консоль</li>
 * <li>remove {key} - удалить элемент коллекции по его ключу</li>
 * <li>remove greater {json} - удалить элементы коллекции, превышающие заданный</li>
 * <li>remove greater key {key} - удалить элементы коллекции, ключ которых превышает данный</li>
 * </ul>
 */
class Controller {
	private final Domain manager;
	private final List<Executable> commands = new ArrayList<>();
	private final Workerable worker;
	private final Class cls;
	private final StoredTypeReader reader;
	public List<Executable> getCommands(){
		return commands;
	}
	Controller(Domain manager, Workerable worker, Class cls,StoredTypeReader reader){
		this.reader = reader;
		this.cls = cls;
		this.manager = manager;
		this.worker = worker;
	}
	public void addCommands(List<Executable> commands){
		this.commands.addAll(commands);
	}
	public void begin(String filename){
		manager.init(filename, worker, cls);
	}
	public void end(String filename){
		manager.save(filename, worker);
	}

	/**
	 *
	 * метод, выполняющий различные действия в зависимости от введенной команды
	 * @param command
	 * @return output
	 */
	public String execute(String command, UI ui){
		String[] operands = command.split(" ",2);
		for (Executable ex : commands){
			if (ex.checkCommand(command)){
				return manager.execute(command, ex, ui, reader, worker);
			}
		}
		return "Такой команды нет";
	}
}