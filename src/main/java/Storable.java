import java.util.Date;

public interface Storable {
    Date getCreateDate();
    boolean remove(StoredType key);
    void removeGreater(StoredType object);
    int getSize();
    String getCollectionType();
    void insert(StoredType hum);
    void clear();
    void save(String fileName, Workerable worker);
    boolean ifMax(StoredType object);
    void init(String fileName, Workerable worker, Class cls);
    void removeLower(StoredType object);
}
