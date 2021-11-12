package com.company;


import com.sun.security.jgss.GSSUtil;

import java.util.Iterator;

public class LinkedList<T> { // implements Iterable depois de fazeres os metodos da maria
    private Node<T> root = null;


    public static void main(String[] args) {
        // write your code here

        LinkedList<Integer> values = new LinkedList<>();

        values.add(1);
        values.add(2);
        values.add(3);
        //   values.add(4);

        System.out.println("");

        try {
            System.out.println(values.get(0));
            System.out.println(values.get(1));
            System.out.println(values.get(7));
        } catch (MyNullPointerException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("");

        try {
            //     values.delete(1);

            System.out.println(values.get(0));
            System.out.println(values.get(1));
            System.out.println(values.get(2));
        } catch (MyNullPointerException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("");


     //   values.add(9, 1);

        values.deleteValue(1);

        try {
            System.out.println(values.get(0));
            System.out.println(values.get(1));
            System.out.println(values.get(2));
            System.out.println(values.get(3));
        } catch (MyNullPointerException e) {
            System.out.println(e.getMessage());
        }

    }
/*
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
              //  Node<T>

                 if () {

                }

                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }  */
    // -----------------------------------------------------------------------


    public void add(T value) {
        if (root == null) {
            root = new Node<>(value);
            System.out.println(root.value);
        } else {
            Node<T> temp = root;

            while (temp.next != null) {
                temp = temp.next;

            }
            temp.next = new Node<>(value);
            System.out.println(temp.next.value);


        }
    }


    public T get(int index) throws MyNullPointerException {

        Node<T> lastNext = root;
        int count = 0;

        while (count != index) {
            lastNext = lastNext.next;
            count++;

            if (lastNext == null) {
                throw new MyNullPointerException();
            }

        }

        return lastNext.value;

    }


    public void deleteIndex(int index) throws MyNullPointerException {

        Node<T> ant = root;
        Node<T> temp = root;

        if (index == 0) {
            root = root.next;
            return;
        }

        for (int i = 0; i < index; i++) {
            ant = temp;
            temp = temp.next;
        }
        ant.next = temp.next;

        if (temp.next == null) {
            throw new MyNullPointerException();
        }

    }

    public void add(T value, int index) {

        Node<T> ant = root;
        Node<T> temp = root;
        int count = 0;

        if (index == 0) {
            root = new Node<>(value);
            root.next = temp;
        }

        while (count != index) {
            ant = temp;
            temp = temp.next;

            count++;
        }

        ant.next = new Node<>(value);
        ant.next.next = temp;

    }


    public void deleteValue(T value) {

      if (root == null) {
          return;
      }

      if (root.value == value) {
          root = root.next;
          return;
      }

      Node<T> ant = root;

      while (ant.next != null) {
          if (ant.next.value == value) {
              ant.next = ant.next.next;
              return;
          }
          ant = ant.next;
      }

    }



  /*  metodo add (value) (já)
        get (index) (retornar o valor) (já)
  delete (index) ja
 -       add(value, index)
            delete (value)
*/

}

