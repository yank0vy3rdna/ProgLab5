import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.*;

class JSONWorker implements Workerable {
	private final Gson gson;
//"age":3,"weight":5,"type":"AIR","character":"CHAOTIC_EVIL","killer":{"name":"Убивец","birthday":"Feb 13, 2020, 12:48:11 PM","height":2,"weight":5}}}
	JSONWorker(JsonDeserializer<? extends Object> des) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(StoredType.class, des);
		gson = builder.create();
	}

	@SuppressWarnings("unchecked")
	public Object readValue(String json, Class cls){
		return (gson).fromJson(json, cls);
	}
	public String writeValue(Object object){
		return (new GsonBuilder().setPrettyPrinting().create()).toJson(object);
	}
	public Object load(String filename, Class cls){
		try {
			Object object;
			BufferedReader file = new BufferedReader(new FileReader(new File(filename)));
			StringBuilder jsonBuilder = new StringBuilder();
			int c;
			while(file.ready()){
				String string = Character.toString((char)(file.read()));
				jsonBuilder.append(string);
			}
			String json = jsonBuilder.toString();
			object =  cls.cast( readValue(json, cls));
			file.close();
			return object;
		}
		catch (java.io.FileNotFoundException e){
			return null;
		}
		catch (java.io.IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void save(Storable objects, String filename) {
		try{
			BufferedOutputStream file = new BufferedOutputStream(new FileOutputStream(filename));
			String json;
			json = writeValue(objects);
			byte[] buffer = json.getBytes();
			file.write(buffer);
			file.close();
		}
		catch(java.io.IOException ex){
			ex.printStackTrace();
		}
	}
}