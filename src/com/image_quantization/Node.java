package com.image_quantization;

abstract public class Node {

    protected DataNode next;
    protected Node down;
    protected int key;
    protected Object data;


    abstract public Node getNext();

    abstract public void setNext(DataNode next);

    abstract public Node getDown();

    abstract public void setDown(Node down);

    abstract public int getKey();

    abstract public void setKey(int key);

    abstract public Object getData();

    abstract public void setData(Object data);
}
