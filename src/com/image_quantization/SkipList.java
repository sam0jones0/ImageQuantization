package com.image_quantization;

import java.util.NoSuchElementException;
import java.util.Stack;
import java.awt.Color;


/*
A two-dimensional linked list which allows insertion and searching of key-value
pairs in O(log(n)) time, for use in the Map data type.
All keys must be unique and of the same comparable data type.
 */
public class SkipList {
    private HeaderNode head;

    private int len = 0;
    private int totalDataNodes = 0;

    public boolean isEmpty() {
        return this.totalDataNodes == 0;
    }

    public DataNode search(int key) throws NoSuchElementException {
        Node current = this.head;

        while (current != null) {
            if (current.next != null) {
                // Key should be some efficient to search representation of RGB space.
                if (current.getNext().getKey() == key) {

                }
            }
        }
    }

    public HeaderNode getHead() {
        return head;
    }

    public void setHead(HeaderNode head) {
        this.head = head;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getTotalDataNodes() {
        return totalDataNodes;
    }

    public void setTotalDataNodes(int totalDataNodes) {
        this.totalDataNodes = totalDataNodes;
    }



}
