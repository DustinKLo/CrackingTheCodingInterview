package com.example.practice;


import java.util.NoSuchElementException;

public class MyQueue<T> {

    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        private QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
        QueueNode<T> temp = new QueueNode<T>(item);
        if(last != null) {
            last.next = temp;
            last = temp;
        }
        else {
            last = temp;
            first = last;
        }
    }

    public T remove() {
        if (first== null) throw new NoSuchElementException();

        T firstData = first.data;
        first = first.next;
        if(first == null) {
            last = null;
        }
        return firstData;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
