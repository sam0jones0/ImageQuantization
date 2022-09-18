package com.image_quantization;


import java.util.Objects;

/**
 * A DataNode of a SkipList. Holds a key and associated value. Has references
 * to the next node of its level and to the node on the level below.
 */
public class DataNode extends Node {


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

    @Override
    public Node getDown() {
        return down;
    }

    @Override
    public void setDown(Node down) {
        this.down = down;
    }

    @Override
    public DataNode getNext() {
        return this.next;
    }

    @Override
    public void setNext(DataNode next) {
        this.next = next;
    }

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


}
