package tp2;

public class LinkedHashMap<KeyType, DataType> {

    private static final double COMPRESSION_FACTOR = 2; // 50%
    private static final int DEFAULT_CAPACITY = 20;
    private static final int CAPACITY_INCREASE_FACTOR = 2;

    private Node<KeyType, DataType>[] map;
    private int capacity;
    private int size = 0;

    public LinkedHashMap() {
        capacity = DEFAULT_CAPACITY;
        map = new Node[DEFAULT_CAPACITY];
    }

    public LinkedHashMap(int capacity) {
        this.capacity = capacity;
        map = new Node[capacity];
    }

    /**
     * Finds the index attached to a particular key
     * @param key Value used to access to a particular instance of a DataType within map
     * @return The index value attached to a particular key
     */
    private int getIndex(KeyType key){
        int keyHash = key.hashCode() % capacity;
        return keyHash < 0 ? -keyHash : keyHash;
    }

    private boolean shouldRehash() {
        return size * COMPRESSION_FACTOR > capacity;
    }

    /**
     * Increases capacity by CAPACITY_INCREASE_FACTOR (multiplication) and
     * reassigns all contained values within the new map
     */
    private void rehash() {

        int newCapacity = capacity*CAPACITY_INCREASE_FACTOR;
        Node<KeyType,DataType> [] newMap = new Node [newCapacity];
        int newIndex, oldCapacity = capacity;
        capacity =newCapacity;
        for (int i = 0; i<oldCapacity; i++){
            while (map[i] != null){
                newIndex = getIndex(map[i].key);
                newMap[newIndex] = map[i];
                map[i]= map[i].next;
            }
        }
        map = newMap;
    }

    public int size() {
        return size;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** TODO
     * Finds if map contains a key
     * @param key Key which we want to know if exists within map
     * @return if key is already used in map
     */
    public boolean containsKey(KeyType key) {
        int index = getIndex(key);
        Node<KeyType, DataType> node = map[index];

        if(node == null) {
            return false;
        }

        while(node.next != null) {
            if(node.key.equals(key)){
                return true;
            }
            node = node.next;
        }

        if (node.key.equals(key)){
            return true;
        }

        return false;
    }

    /** TODO
     * Finds the value attached to a key
     * @param key Key which we want to have its value
     * @return DataType instance attached to key (null if not found)
     */
    public DataType get(KeyType key) {

        int index = getIndex(key);
        Node<KeyType, DataType> node =map[index];
        DataType value;

        if(node == null){
            return null;
        }

        while (node.next !=null){
            if(node.key.equals(key)){
                value =node.data;
                return value;
            }
            node = node.next;
        }

        if (node.key.equals(key)){
            value = node.data;
            return value;
        }

        return null;
    }

    /** TODO
     * Assigns a value to a key
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType put(KeyType key, DataType value) {

        int index = getIndex(key);
        Node<KeyType,DataType> node = map[index];
        Node<KeyType,DataType> oldNode = map[index];
        DataType oldValue;

        if (node == null){
            map[index] = new Node<KeyType,DataType>(key, value);
            size++;
            if(shouldRehash())
                rehash();
            return null;
        }

        while(node.next != null){
            if (node.key.equals(key)){
                oldValue = node.data;
                node.data = value;
                return oldValue;
            }
            node = node.next;
        }

        if (node.key.equals(key)){
            oldValue = node.data;
            node.data = value;
            return oldValue;
        }

        oldValue = oldNode.data;
        node.next = new Node <KeyType, DataType> (key, value);
        size++;
        if (shouldRehash())
            rehash();

        return oldValue;
    }

    /** TODO
     * Removes the node attached to a key
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType remove(KeyType key) {

        int index = getIndex(key);
        Node <KeyType, DataType> previousNode = map[index];
        DataType value;
        if (previousNode == null) {
            return null;
        }

        // Noeud attacher qu'on doit retirer
        Node<KeyType,DataType> currentNode = previousNode.next;

        if(currentNode == null){
            if (previousNode.key.equals(key)){
                value = previousNode.data;
                previousNode = null;
                size--;
                return value;
            }
        }

        //Noeud qu'on doit relier afin que la map continue de fonctionne correctement
        Node<KeyType,DataType> followingNode = currentNode.next;

        if (previousNode.key.equals(key)){
            value = previousNode.data;
            previousNode= currentNode;
            previousNode.next = followingNode;
            size--;
            return value;
        }

        while(followingNode !=null){
            if(currentNode.key.equals(key)){
                value = currentNode.data;
                previousNode.next= followingNode;
                size--;
                return value;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
            followingNode =currentNode.next;
        }

        if (currentNode.key.equals(key)){
            value = currentNode.data;
            previousNode.next = followingNode;
            size--;
            return value;
        }

        return null;
    }

    /** TODO
     * Removes all nodes contained within the map
     */
    public void clear() {

        int deleteCounter = 0;
        int position= 0;
        while (deleteCounter != size){
            if (map[position] != null){
                map [position] = null;
                deleteCounter++;
            }
            position++;
        }

    }


    static class Node<KeyType, DataType> {
        final KeyType key;
        DataType data;
        Node next; // Pointer to the next node within a Linked List

        Node(KeyType key, DataType data)
        {
            this.key = key;
            this.data = data;
            next = null;
        }
    }
}


