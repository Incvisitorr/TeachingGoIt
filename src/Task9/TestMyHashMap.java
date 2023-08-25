package Task9;

import java.util.*;

public class TestMyHashMap {
    public static void main(String[] args) {
        MyHashMap<String,String> hm=new MyHashMap<>();
        hm.put("a","1");
        hm.put("b","2");
        hm.put("c","3");
        hm.put("d","4");
        hm.put("f","5");

        System.out.println(hm.get("b"));
        hm.remove("b");
        System.out.println(hm.get("b"));
        hm.clear();
        System.out.println(hm.size());
    }
}

class MyHashMap<K, V> {
    private Node<K, V>[] hashtable;
    private int size;
    private float resize;

    public MyHashMap() {
        hashtable = new Node[16];
        resize = hashtable.length * 0.75f;
    }

    public boolean put(final K key, final V value) {
        if (size + 1 >= resize) {
            resize *= 2;
            arrayGrow();
        }
        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);
        if (hashtable[index] == null) {
            return simpleAdd(index, newNode);
        }
        List<Node<K, V>> nodeList = hashtable[index].getNodes();
        for (Node<K, V> node : nodeList) {
            if (keyExistButValNew(node, newNode, value) || collision(node, newNode, nodeList)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(final K key) {
        int index = hash(key);
        if (hashtable[index] == null) {
            return false;
        }
        if (hashtable[index].getNodes().size() == 1) {///???Просто hashtable.size()
            hashtable[index]=null;
            return true;
        }
        List<Node<K, V>> nodeList = hashtable[index].getNodes();
        for (Node<K, V> node : nodeList) {
            nodeList.remove(node);
            return true;
        }
        return false;
    }

    public V get(final K key) {
        int index = hash(key);
        if (index < hashtable.length && hashtable[index] != null) {
            if(hashtable[index].getNodes().size()==1){
                return hashtable[index].getNodes().get(0).getValue();
            }
            List<Node<K, V>> nodeList = hashtable[index].getNodes();
            for (Node<K, V> node : nodeList) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Node<K, V>[] tab;
        if ((tab = hashtable) != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
    }

    private void arrayGrow() {
        Node<K, V>[] oldHashTable = hashtable;
        hashtable = new Node[oldHashTable.length * 2];
        size = 0;
        for (Node<K, V> newNode : oldHashTable) {
            if (newNode != null) {
                for (Node<K, V> oldNode : newNode.getNodes()) {
                    put(oldNode.key, oldNode.value);
                }
            }
        }
    }

    private int hash(final K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash%hashtable.length;
    }

    private boolean collision(final Node<K, V> nodeFromList, final Node<K, V> newNode, final List<Node<K, V>> nodes) {
        if (newNode.hashCode() == nodeFromList.hashCode() &&
                !Objects.equals(newNode.key, nodeFromList.key) &&
                !Objects.equals(newNode.value, nodeFromList.value)) {
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }

    private boolean keyExistButValNew(final Node<K, V> nodeFromList, final Node<K, V> newNode, V value) {
        if (newNode.getKey().equals(nodeFromList.getKey()) &&
                !newNode.getValue().equals(nodeFromList.getValue())) {
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }

    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashtable[index] = new Node<>(null, null);
        hashtable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    private class Node<K, V> {
        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<>();
        }

        private List<Node<K, V>> getNodes() {
            return nodes;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        private int hash() {
            return hashCode()%hashtable.length;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Node) {
                Node<K, V> node = (Node) o;
                return (Objects.equals(key, node.getKey())) &&
                        Objects.equals(value, node.getValue()) ||
                        Objects.equals(hash, node.hashCode());
            }
            return false;
        }

    }
}
