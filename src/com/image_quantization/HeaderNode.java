package com.image_quantization;

/**
 * A HeaderNode of a level of a SkipList. Has references to the HeaderNode below
 * and to the first DataNode of its level.
 */
public class HeaderNode extends Node {


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
        return this.down;
    }

    @Override
    public void setDown(Node down) {
        this.down = down;
    }
}
