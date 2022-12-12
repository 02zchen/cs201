import java.lang.ProcessHandle.Info;
import java.util.concurrent.LinkedBlockingDeque;

import javax.xml.transform.Templates;

public class LinkStrand implements IDnaStrand {

    private class Node {
        String info;
        Node next;

        public Node(String s, Node n) {
            info = s;
            next = n;
        }
    }
    /*
     * myIndex tracks the last character we accessed with the charAt() method.
     * Initialize this as 0.
     * 
     * myCurrent tracks the last node holding the character at position myIndex.
     * Initialize this as myFirst.
     * 
     * myLocalIndex tracks the last character we accessed within the Node.
     * Initialize this as 0.
     */

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    private int myIndex;
    private Node myCurrent;
    private int myLocalIndex;

    // default constructor
    public LinkStrand() {
        this("");
    }

    // String based constructor
    public LinkStrand(String s) {
        initialize(s);
    }

    @Override
    public long size() {
        return this.mySize;
    }

    @Override
    public void initialize(String source) {
        myFirst = new Node(source, null);
        this.myCurrent = myFirst;

        this.mySize = source.length();

        this.myIndex = 0;
        this.myLocalIndex = 0;

        this.myLast = myCurrent;
        this.myAppends = 0;

    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        /*
         * myFirst doesn't change, myLast changes to point to the new node added
         * 
         * mySize is incremented by six, myAppends is incremented by one (because a new
         * node is added).
         */
        // store next DNA string in a temp node
        Node temp = new Node(dna, null);
        // set myLast.next (points to current last node in the linked list) to temp
        myLast.next = temp;
        // advance myLast to newly appended node
        myLast = myLast.next;
        mySize += dna.length();
        myAppends++;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        Node temp = myFirst;
        while (temp != null) {
            ret.append(temp.info);
            temp = temp.next;

        }
        return ret.toString();

    }

    @Override
    public IDnaStrand reverse() {
        LinkStrand ret = new LinkStrand();
        Node start = myFirst;
        while (myFirst != null) {
            ret.addFirst(myFirst.info);
            myFirst = myFirst.next;
        }
        myFirst = start;
        return ret;
    }

    private void addFirst(String s) {
        StringBuilder ret = new StringBuilder(s);
        ret.reverse();
        String reve = new String(ret);
        Node temp = myFirst;
        myFirst = new Node(reve, null);
        myFirst.next = temp;
        mySize += s.length();
    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public char charAt(int index) {
        // amount you need to travel forwards from a reference point
        int tempIndex;
        if (index < 0 || index > mySize - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (myIndex == index) {
            return myCurrent.info.charAt(myLocalIndex);
        }

        if (index < myIndex) {
            tempIndex = index;
            myCurrent = myFirst;
            while (tempIndex >= myCurrent.info.length()) {
                tempIndex -= myCurrent.info.length();
                myCurrent = myCurrent.next;
            }
            myIndex = index;
            myLocalIndex = tempIndex;
            return myCurrent.info.charAt(tempIndex);
        }

        if (index > myIndex) {
            // the amount you need to travel is the new index - old index + amount youre
            // already currently in for the node
            tempIndex = index - myIndex + myLocalIndex;
            while (tempIndex >= myCurrent.info.length()) {
                tempIndex -= myCurrent.info.length();
                myCurrent = myCurrent.next;
            }
            myIndex = index;
            myLocalIndex = tempIndex;
            return myCurrent.info.charAt(tempIndex);

        }
        return ' ';

    }

}

/*
 * 
 * list = save;
 * while(list != null){
 * if(tempIndex < list.info.length()){
 * myLocalIndex = tempIndex;
 * myCurrent = list;
 * return list.info.charAt(tempIndex);
 * }
 * if(tempIndex >= list.info.length()){
 * tempIndex = (tempIndex) - (list.info.length());
 * list = list.next;
 * 
 * }
 * }
 * return list.info.charAt(tempIndex);
 * 
 * 
 * while (tempIndex > list.info.length()-1) {
 * long localLength = list.info.length();
 * tempIndex -= localLength;
 * if (list.next == null){
 * throw new IndexOutOfBoundsException("yo moms a hoe");
 * }
 * list = list.next;
 * 
 * 
 * }
 * myLocalIndex = (int) tempIndex;
 * char ret = list.info.charAt(myLocalIndex);
 * myCurrent = list;
 * 
 * return ret;
 * 
 */