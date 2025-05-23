package utils;

public class BSTNode<K, V> {
    K key;
    V data;
    BSTNode<K, V> left, right, parent;

    public BSTNode(K key, V data) {
        this.key = key;
        this.data = data;
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
