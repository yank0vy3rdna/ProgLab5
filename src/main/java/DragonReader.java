import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DragonReader implements StoredTypeReader{
    private UI ui;
    DragonReader(){ }
    public void setUI(UI ui){
        this.ui = ui;
    }
    public Dragon create(){
        String name = ui.readField("dragonname");
        Coordinates coordinates = new Coordinates(
                Double.valueOf(ui.readField("coordinates.x")),
                Float.parseFloat(ui.readField("coordinates.y"))
        );
        Long age = Long.parseLong(ui.readField("age"));
        long weight = Long.parseLong(ui.readField("weight"));
        DragonType dragonType;
        String dragonTypestr = ui.readField("type");
        if (dragonTypestr.isEmpty()){
            dragonType=null;
        }
        else {
            dragonType = DragonType.valueOf(dragonTypestr);
        }
        DragonCharacter dragonCharacter = DragonCharacter.valueOf(ui.readField("character"));
        Person killer;
        String killername = ui.readField("killer.name");
        if (killername.isEmpty()){
            killer = null;
        }else {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date birthday;
            Location location;
            String birthdaystr = ui.readField("birthday(format: dd-MM-yyyy)");
            if(!birthdaystr.isEmpty()) {
                try {
                    birthday = format.parse(birthdaystr);
                } catch (ParseException e) {
                    birthday=null;
                }
            }else {
                birthday=null;
            }
            long killerheight = Long.parseLong(ui.readField("killer.height"));
            Long killerweight = Long.parseLong(ui.readField("killer.weight"));
            String locationx = ui.readField("locationx");
            if(locationx.isEmpty()){
                location=null;
            }else {
                String locationy = ui.readField("locationy");
                String locationz = ui.readField("locationz");
                String locationname = ui.readField("locationname");
                location = new Location(Double.parseDouble(locationx), Float.parseFloat(locationy),Long.parseLong(locationz),locationname);
            }
            killer = new Person( // Person(String name, Date birthday, long height, Long weight, Location location
                    killername,
                    birthday,
                    killerheight,
                    killerweight,
                    location);

        }
        //Dragon(long id, String name, Coordinates coordinates, LocalDateTime creationDate, Long age, long weight, DragonType type, DragonCharacter character, Person killer)
        return new Dragon(name,coordinates,age,weight,dragonType,dragonCharacter,killer);
    }
}
