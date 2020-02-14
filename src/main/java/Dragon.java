import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Dragon implements StoredType{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long age; //Значение поля должно быть больше 0, Поле не может быть null
    private long weight; //Значение поля должно быть больше 0
    private DragonType type; //Поле может быть null
    private DragonCharacter character; //Поле не может быть null
    private Person killer; //Поле может быть null

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getAge() {
        return age;
    }

    public long getWeight() {
        return weight;
    }

    public DragonType getType() {
        return type;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public Person getKiller() {
        return killer;
    }

    public Dragon(long id, String name, Coordinates coordinates, LocalDateTime creationDate, Long age, long weight, DragonType type, DragonCharacter character, Person killer) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.age = age;
        this.weight = weight;
        this.type = type;
        this.character = character;
        this.killer = killer;
    }

    public Dragon(String name, Coordinates coordinates, Long age, long weight, DragonType type, DragonCharacter character, Person killer) throws IllegalArgumentException, NullPointerException{
        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        LocalDateTime creationDate = java.time.LocalDateTime.now();
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        }
        if (age == null || age <= 0){
            throw new IllegalArgumentException("Invalid age");
        }
        if (weight<=0){
            throw new IllegalArgumentException("Invalid weight");
        }
        this.id = id;
        this.name = name;
        this.coordinates = Objects.requireNonNull(coordinates,"invalid coordinates");
        this.creationDate = creationDate;
        this.age = age;
        this.weight = weight;
        this.type = type;
        this.character = Objects.requireNonNull(character,"invalid character");
        this.killer = killer;
    }

    @Override
    public int compareTo(StoredType obj) {
        if (obj instanceof Dragon){
            if (age.equals(((Dragon) obj).age)){
                if (weight == ((Dragon) obj).weight){
                    return name.compareTo(((Dragon) obj).name);
                }
                return Long.compare(weight, ((Dragon) obj).weight);
            }
            return age.compareTo(((Dragon) obj).age);
        }
        return 0;
    }
    public String toString(Workerable worker){
        return worker.writeValue(this);
    }
}
