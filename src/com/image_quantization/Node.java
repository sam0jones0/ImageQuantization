package com.image_quantization;

abstract public class Node {

    protected Node next;
    protected Node down;


    abstract public Node getNext();

    abstract public void setNext(Node next);

    abstract public Node getDown();

    abstract public void setDown(Node down);
}
