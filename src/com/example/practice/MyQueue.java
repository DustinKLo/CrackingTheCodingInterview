package com.example.practice;

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

    public void remove() {
        if(first == last) {

        } else {

        }
    }

}
