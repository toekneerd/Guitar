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
public class GuitarGal {
      public static void main(String[] args) {
	String guitar = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] guitarstrings = new GuitarString[37];

        for (int i = 0; i < 37 ; i++){
        	guitarstrings[i] =  new GuitarString(110+(i*20.81));
        }
        boolean flag = true;
       
        while (flag == true) {
        	
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (!(guitar.indexOf(key) == -1)){
                	guitarstrings[guitar.indexOf(key)].pluck();
                } 
                
                
            }
           
            double sample = 0.5;
           
            for (int i = 0; i < 37 ; i++){
            	double s = sample;
            	sample = s + guitarstrings[i].sample();
            }
            
            StdAudio.play(sample);
            
            for (int i = 0; i < 37 ; i++){
            	guitarstrings[i].tic();
            }
            
            
           }
        }
  }

