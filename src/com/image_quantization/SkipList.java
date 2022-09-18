package com.image_quantization;

import java.util.NoSuchElementException;


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

    /**
     * Searches the SkipList for a key and if found, returns the data stored in that Node.
     *
     * @param key The key of the Node to search for.
     * @return The first Node with a key matching the provided key.
     * @throws NoSuchElementException If no Node matching the provided key is found.
     */
    public Node search(int key) throws NoSuchElementException {
        Node current = this.head;

        while (current != null) {
            if (current.getNext() != null) {
                DataNode next = current.getNext();
                if (next.getKey() == key) {
                    return next;
                } else if (next.getKey() < key) {
                    current = next;
                } else {
                    current = current.getDown();
                }
            }
        }
        throw new NoSuchElementException("No node with key '" + key + "' found.");
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
