package com.image_quantization;

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

    public DataNode search() throws SearchFiledException {

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
