package stack;

public class Stack<E> {
    private int capacity;
    private E[] arr;
    private int top;

    /**
     * Stack Constructor
     * @param capacity
     */
    public Stack (int capacity){
        this.capacity = capacity;
        this.arr = (E[]) new Object[capacity];
        this.top = -1;
    }

    /**
     * isFull Method
     * @return True if top equals the capacity-1
     */
    public boolean isFull(){
        return (this.top == this.capacity-1); 
    }

    /**
     * isEmpty Method
     * @return True if top is -1
     */
    public boolean isEmpty(){
        return this.top == -1;
    }

    /**
     * push Method
     * added data to the top of the Stack
     * @param data
     */
    public void push(E data){
        if(isFull()) System.out.println("Stack is Full");
        else{
            this.arr[++this.top] = data;
        }
    }
    
    /**
     * pop Method
     * removes and returns the top element of the stack
     * @return ele
     */
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

    /**
     * peek Method
     * returns the top element of the Stack (doesnt remove)
     * @return arr[top]
     */
    public E peek(){
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        else{
            return this.arr[this.top];
        }
    }

    /**
     * getSize Method
     * @return top+1
     */
    public int getSize(){
        return this.top+1;
    }
}