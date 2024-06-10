package etapa_4;

import etapa_3.OverflowException;
import etapa_3.UnderflowException;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        // por padrao retorna false
        return false;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void push(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public E pop() throws UnderflowException {
        //if (isEmpty()) {
        //    throw new UnderflowException("Pilha está vazia");
        //}
        E data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    @Override
    public E top() throws UnderflowException {
       // if (isEmpty()) {
         //   throw new UnderflowException("Pilha está vazia");
        //}
        return top.getData();
    }
}
