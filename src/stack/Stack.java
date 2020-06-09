package stack;

public class Stack<E> {
    private int capacity;
    private E[] arr;
    private int top;

    public Stack (int capacity){
        this.capacity = capacity;
        this.arr = (E[]) new Object[capacity];
        this.top = -1;
    }

    public boolean isFull(){
        return (this.top == this.capacity-1); 
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public void push(E data){
        if(isFull()) System.out.println("Stack is Full");
        else{
            this.arr[++this.top] = data;
        }
    }

    public E pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        else{
            E ele = this.arr[this.top--];
            return ele;
        }
    }

    public E peek(){
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        else{
            return this.arr[this.top];
        }
    }

    public int getSize(){
        return this.top+1;
    }
}