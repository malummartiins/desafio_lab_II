package etapa_4;

import etapa_3.OverflowException;
import etapa_3.UnderflowException;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> back;
    private int size;

    public LinkedQueue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        
        return false;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void enqueue(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            back.setNext(newNode);
        }
        back = newNode;
        size++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        
        E data = front.getData();
        front = front.getNext();
        size--;
        if (isEmpty()) {
            back = null;
        }
        return data;
    }

    @Override
    public E front() throws UnderflowException {
        
        return front.getData();
    }

    @Override
    public E back() throws UnderflowException {
        
        return back.getData();
    }
}
