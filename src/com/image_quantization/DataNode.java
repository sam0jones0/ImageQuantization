package com.image_quantization;


import java.util.Objects;

/**
 * A DataNode of a SkipList. Holds a key and associated value. Has references
 * to the next node of its level and to the node on the level below.
 */
public class DataNode extends Node {
    private final int key;
    private Object data;


    public DataNode() {
        this.key = this.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataNode dataNode = (DataNode) o;
        return key == dataNode.key && Objects.equals(data, dataNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, data);
    }


    public int getKey() {
        return key;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public Node getDown() {
        return down;
    }

    @Override
    public void setDown(Node down) {
        this.down = down;
    }


}
