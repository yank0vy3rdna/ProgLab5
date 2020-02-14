public interface Workerable {
    Object readValue(String json, Class<?> cls);
    String writeValue(Object object);
    Object load(String filename, Class cls);
    void save(Storable object, String filename);
}
