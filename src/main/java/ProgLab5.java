import com.google.gson.JsonDeserializer;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

class ProgLab5 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		String filename;
		filename = "data.json";
		Class storageClass = Storage.class;
		JsonDeserializer dragonDeserializer = DragonDeserializer.des;
		DragonReader reader = new DragonReader();
		//List<Object> objects = (ArrayList<Object>) (new JSONWorker(gson)).readValue("[{},\"Feb 12, 2020, 4:43:29 PM\"]", ArrayList.class);
		System.out.println("Fuck society");
		if(args.length!=0){
			filename = args[0];
		}
		Controller controller = new Controller(new Domain(new Storage(new LinkedHashSet<>())),new JSONWorker(dragonDeserializer),storageClass,reader);
		List<Executable> commands = new ArrayList<>();
		commands.add(new HelpCommand());
		commands.add(new AddCommand());
		commands.add(new InfoCommand());
		commands.add(new ShowCommand());
		commands.add(new UpdateCommand());
		commands.add(new RemoveCommand());
		controller.addCommands(commands);
		UI scn = new UI(controller, filename);
		scn.start();
	}
}