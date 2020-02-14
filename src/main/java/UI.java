import java.util.Scanner;
class UI {
	private final Controller commander;
	private final String filename;
	private final Scanner in;

	public String getFilename() {
		return filename;
	}
	public Controller getCommander(){
		return commander;
	}

	public UI(Controller cmd, String filename){
		this.commander = cmd;
		this.filename = filename;
		in = new Scanner(System.in);
	}
	public String readField(String fieldName){
		System.out.print("Введите значение поля "+fieldName+": ");
		return in.nextLine();
	}
	public void start(){
		commander.begin(filename);
		this.run();
		commander.end(filename);
	}
	private void run(){

		while(true){
			System.out.print("> ");	
        	String line = in.nextLine();
        	if (line.equals("quit") || line.equals("exit")){
        		break;
        	}else{
        		System.out.print(commander.execute(line,this));
        	}
		}
	}
}