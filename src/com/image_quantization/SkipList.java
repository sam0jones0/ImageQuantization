package com.image_quantization;

import java.util.NoSuchElementException;
import java.util.Stack;


/*
A two-dimensional linked list which allows insertion and searching of key-value
pairs in O(log(n)) time, for use in the Map data type.
All keys must be unique and of the same comparable data type.
 */
public class SkipList {
    private HeaderNode head;

    private int len = 0;
    private int totalDataNodes = 0;


    /**
     * Checks if this SkipList is empty.
     *
     * @return True if this SkipList is empty, False otherwise.
     */
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

    public void insert(int key, Object value) {
        if (this.getHead() == null) {  // This is the first item to be added to the SkipList.
            this.setHead(new HeaderNode());
            DataNode topLevelTempNode = new DataNode(key, value);
            this.getHead().setNext(topLevelTempNode);
            DataNode top = topLevelTempNode;
            this.totalDataNodes += 1;

            while (Math.random() < 0.5) {
                // Add another layer to the tower.
                HeaderNode newHead = new HeaderNode();
                DataNode subLevelTempNode = new DataNode(key, value);
                subLevelTempNode.setDown(top);
                newHead.setDown(this.getHead());
                newHead.setNext(subLevelTempNode);
                this.setHead(newHead);
                top = subLevelTempNode;
                this.totalDataNodes += 1;
            }
        } else {
            // This is not the first item to be added to this SkipList.
            Stack<Node> tower = new Stack<>();
            Node current = this.getHead();
            // Build a stack for the new nodes position at each level of the tower.
            while (current != null) {
                if (current.getNext() != null) {
                    if (key < current.getNext().getKey()) {
                        tower.push(current);
                        current = current.getDown();
                    } else {
                        current = current.getNext();
                    }
                } else {
                    tower.push(current);
                    current = current.getDown();
                }
            }
            Node lowestLevelNode = tower.pop();
            DataNode subLevelTempNode = new DataNode(key, value);
            subLevelTempNode.setNext(lowestLevelNode.getNext());
            lowestLevelNode.setNext(subLevelTempNode);
            DataNode top = subLevelTempNode;
            this.totalDataNodes += 1;

            while (Math.random() < 0.5) {
                // Add the new node to its correct position on the next level up.
                if (tower.isEmpty()) {
                    HeaderNode newHead = new HeaderNode();
                    DataNode tempNode = new DataNode(key, value);
                    tempNode.setDown(top);
                    newHead.setDown(this.getHead());
                    newHead.setNext(tempNode);
                    this.setHead(newHead);
                    top = tempNode;
                } else {
                    // Move up a level and insert the DataNode into its correct position.
                    Node nextLevelNode = tower.pop();
                    DataNode tempNode = new DataNode(key, value);
                    tempNode.setNext(nextLevelNode.getNext());
                    nextLevelNode.setNext(tempNode);
                    tempNode.setDown(top);
                    top = tempNode;
                }
                this.totalDataNodes += 1;
            }
        }
        this.len += 1;
    }

    /**
     * @return The Datanode in the SkipList with the lowest key.
     * @throws NoSuchElementException If the SkipList is empty.
     */
    public DataNode getMin() throws NoSuchElementException {
        HeaderNode currentHead = this.getHead();
        while (currentHead.getDown() != null) {
            currentHead = (HeaderNode) currentHead.getDown();
        }
        if (currentHead.getNext() != null) {
            return currentHead.getNext();
        } else {
            throw new NoSuchElementException("The SkipList is empty and has no min node.");
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
