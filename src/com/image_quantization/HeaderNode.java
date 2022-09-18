package com.image_quantization;

/**
 * A HeaderNode of a level of a SkipList. Has references to the HeaderNode below
 * and to the first DataNode of its level.
 */
public class HeaderNode extends Node {


    @Override
    public DataNode getNext() {
        return this.next;
    }

    @Override
    public void setNext(DataNode next) {
        this.next = next;
    }

    @Override
    public Node getDown() {
        return this.down;
    }

    @Override
    public void setDown(Node down) {
        this.down = down;
    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public void setKey(int key) {
        this.key = key;

    }

    @Override
    public Object getData() {
        return this.data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }
}
