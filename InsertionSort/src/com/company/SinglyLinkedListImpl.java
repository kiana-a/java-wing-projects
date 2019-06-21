package com.company;

import javax.xml.soap.Node;

/**
 * Created by kiana on 3/28/18.
 */
public class SinglyLinkedListImpl<T> {

    private Node<T> head;

    public void add(T element){
        Node nd = new Node<T>();

        nd.setValue(String.valueOf(element));
        System.out.println("Adding " + element);
        Node<T> tmp = head;
        while (true){
            if (tmp == null){
                head = nd;
                break;
            }
            else if (tmp.getNextRef() == null){
                tmp.setNextRef(nd);
                break;
            }else {
                tmp = tmp.getNextRef();
            }
        }


    }


}
