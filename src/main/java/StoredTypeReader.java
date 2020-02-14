public interface StoredTypeReader {
    UI ui = null;
    StoredType create();
    void setUI(UI ui);
}
