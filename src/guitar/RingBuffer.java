/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitar;

/**
 *
 * @author adecar3
 */
public class RingBuffer {
    private int capacity;
    private double rb[];
    private int first; // stores the index to the least recently inserted item
    private int last;// stores the index one beyond the most recently inserted item
    private int size;
    
    /**
     * creates an empty ring buffer
     */
    public RingBuffer(){
        this.capacity = 0;      
    }
    /**
     * creates a ring buffer with a max capacity
     * @param capacity 
     */
    public RingBuffer(int capacity){
        this.capacity = capacity;
        rb = new double[capacity];
        first = 0;
        last = 0;
        size = 0;
        
    }
    /**
     * returns the number of items currently in the buffer
     * @return 
     */
    public int size(){
        return size;  
        }
    /**
     * returns if the buffer is of size 0 
     * @return 
     */
    public boolean isEmpty(){
        return (size == 0);
    }
    /**
     * returns when the buffer is full
     * @return 
     */
    public boolean isFull(){
        return (size == capacity);   
    }
    /**
     * adds an item x to the end of the buffer
     * @param x 
     */
    public void enqueue(double x){
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last++] = x;
        last %= capacity;
        size++;
    }
    /**
     * deletes and returns to the front
     * @return 
     */
    public double dequeue(){
          if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        double front = rb[first++]; 
        first %= capacity;   
        size--;
        return front;
    }
    /**
     * returns the item in the front
     * @return 
     */
    public double peek(){
        return rb[first];   
    }
    
}
