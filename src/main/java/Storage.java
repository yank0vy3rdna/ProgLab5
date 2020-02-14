import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
class Storage implements Storable{
    private  Date createDate;

    public Set<StoredType> getSet() {
        return set;
    }

    public Date getCreateDate() {
        return createDate;
    }
    private Set<StoredType> set;
    Storage(Set<StoredType> set) {
        this.set = set;
        createDate = new Date();
    }
    public boolean ifMax(StoredType object){
        for (StoredType obj : set){
            if(obj.compareTo(object)>=0)
                return false;
        }
        return true;
    }
    public boolean remove(StoredType object){
        return set.remove(object);
    }

    public void removeGreater(StoredType object){
        set = set.stream()
                .filter(e -> e.compareTo(object)>0)
                .collect(Collectors.toSet());
    }
    public void removeLower(StoredType object){
        set = set.stream()
                .filter(e -> e.compareTo(object)<0)
                .collect(Collectors.toSet());
    }
    public int getSize(){
        return set.size();
    }
    public String getCollectionType(){
        return set.getClass().getSimpleName();
    }
    public void insert(StoredType object){
        set.add(object);
    }

    @Override
    public void clear() {
        set.clear();
    }

    public void save(String fileName, Workerable worker){
        Object[] objects = {set, createDate};
        worker.save(this, fileName);
    }
    @SuppressWarnings("unchecked")
    public void init(String fileName, Workerable worker, Class cls) {
        Storage data = (Storage) worker.load(fileName, cls);
        if (data == null){
            data = new Storage(set);
        }
        set = data.getSet();
        createDate = data.getCreateDate();
    }
}
