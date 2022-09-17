package com.image_quantization;


/**
 * A DataNode of a SkipList. Holds a key and associated value. Has references
 * to the next node of its level and to the node on the level below.
 */
public class DataNode extends Node {
    private int key;
    private Object data;


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }
}
