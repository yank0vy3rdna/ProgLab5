public interface StoredType extends Comparable<StoredType> {
    int compareTo(StoredType obj);
    String toString(Workerable worker);
}
