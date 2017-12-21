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
public class GuitarString {
    private static final int sampleRate = 44100;
    private static final double decay = .994;
    private int numTics = 0;
    private RingBuffer rb;
    private final int N;
    /**
     * creates a guitar string of given frequency
     * @param frequency 
     */
    public GuitarString(double frequency){
        N = (int)(sampleRate / frequency);
        rb = new RingBuffer(N);
        for(int i = 0; i < N; i ++)
            rb.enqueue(0.0);
    }
    /**
     * sets the buffer to white noise and replaces N items with N random values between -0.5 and +0.5
     */
    public void pluck(){
        java.util.Random numGen = new java.util.Random();
        for(int i = 0; i < N; i++){
            rb.dequeue();
            rb.enqueue(numGen.nextDouble()- 0.5);
        }
    }
    /**
     * advance the simulation one time step
     */
    public void tic(){   
        double first = rb.dequeue();
        double second = sample();
        rb.enqueue(decay * ((first + second) / 2));
        numTics++;
    }
    /**
     * returns the current sample
     * @return 
     */
    public double sample(){
        return rb.peek();
    }
    /**
     * returns the number of tics
     * @return 
     */
    public int time(){
        return numTics;
    }
    
}
