/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum;

//IMPORTING PACKAGES 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Kyungbin
 */


public class DoublePendulum extends JFrame {
    //PROOPERTIES OF DOUBLE PENDULUM CLASS 
    int xStart = 350;
    int yStart = 360;
    int l1; 
    int l2;
    int m1;
    int m2;
    double angle1= Math.PI/2; 
    double angle2 = Math.PI/2; 
    double angle1Vel = 0;
    double angle2Vel = 0;
    double g = 1;
    Weight weight1 = new Weight(l1,angle1);
    Weight weight2 = new Weight(l2,angle2);
    ArrayList<Integer> array = new ArrayList<>();
    ArrayList<Double> weight1Acc = new ArrayList<>();
    ArrayList<Double> weight2Acc = new ArrayList<>();
    int time; 

    //SLEEP METHOD 
    public  void sleep( int duration ) {
        try {
              Thread.sleep( duration );
            }
        catch (Exception e) {
            }
    }
    
    //PAINT COMPONENT METHOD 
    public void paintComponent(Graphics g){ 
       Image image = createImage();
       g.drawImage(image, 0, 0, this);
       g.setColor(Color.yellow);
      

        
    }
    
    
    //UPDATE ANGLE 
    public void updateAngle(int numG){
 
        //THE DOUBLE PENDULUM EQUATION 
        double num1 = -g * (2* m1 + m2)*Math.sin(angle1);
        double num2 = - m2*g*Math.sin(angle1-2*angle2);
        double num3 = -2*Math.sin(angle1-angle2)*m2;
        double num4 = angle2Vel*angle2Vel*l2 + angle1Vel * angle1Vel* l1*Math.cos(angle1-angle2);
        
        //THE DENOMINATOR OF THE EQUATION 
        double den = l1* (2*m1 + m2- m2*Math.cos(2*angle1 - 2*angle2));

        //FIRST MASS ACCELERATION 
        weight1.acceleration = (num1+num2+num3*num4) / den;
        
        //SECOND DOUBLE PENDULUM EQUATION 
        double num12 = 2* Math.sin(angle1 - angle2);
        double num22 = (angle1Vel*angle1Vel*l1*(m1+m2));
        double num32 = g* (m1+ m2) * Math.cos(angle1);
        double num42 = angle2Vel * angle2Vel * l2 * m2* Math.cos(angle1-angle2);
        double den2 = l2* (2*m1 + m2- m2*Math.cos(2*angle1 - 2*angle2));
        
        //SECOND MASS ACCELERATION
        weight2.acceleration = (num12 * (num22+num32+num42)) / den2 ;
        
        //UPDATING THE ANGLE BY ADDING THE ACCELERATIONS AND PUTTING THEM INTO AN ARRAY LIST 
        angle1Vel = angle1Vel + weight1.acceleration;
        angle2Vel = angle2Vel + weight2.acceleration;
        angle1 = angle1 + angle1Vel; 
        angle2= angle2 + angle2Vel;
        weight1Acc.add(angle1);
        weight2Acc.add(angle2);
       // System.out.println("hi");

        //RECURSIVE CASE WHERE IT UPDATES THE ANGLES IF THE NUMBER OF GENERATIONS IS GREATER THAN 1 
        if (numG >1 ){
            
            updateAngle(numG-1);
        }
        
        
       
    }
    
   
    //FIRST DRAWING THE IMAGE 
    private Image createImage(){
        
        
        BufferedImage bufferedImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
        
        
        //DRAWS THE X AND Y VALUES USING THE ARRAY LIST OF ACCELERATIONS 
        
        double x1 = xStart + l1* Math.sin(weight1Acc.get(time));
        double y1 =  yStart + l1* Math.cos(weight1Acc.get(time));
        
        weight1.x2 = x1 + l2 * Math.sin(weight2Acc.get(time));
        weight1.y2 = y1+ l2 * Math.cos(weight2Acc.get(time));
        int padding = 15;
        
        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
        
        //DRAWS THE TWO LENGTHS AND THE TWO OVALS 
        g.setColor(Color.pink);
        g.drawLine(xStart, yStart, (int)x1, (int)y1);

        g.drawOval((int)x1-padding-2, (int)y1-padding, (int)m1, (int)m1);
        g.fillOval((int)x1-padding-2, (int)y1-padding, (int)m1, (int)m1);
        
        
        g.drawLine((int)x1, (int)y1,(int) weight1.x2, (int)weight1.y2);
        g.drawOval((int)weight1.x2-padding, (int)weight1.y2- padding, (int)m2, (int)m2);
        g.fillOval((int)weight1.x2-padding, (int)weight1.y2-padding, (int)m2, (int)m2);
        
        
        //ADDS THE X AND Y VALUES OF THE FISRT WEIGHTS TO USE IT TO DRAW THE PATHS 
        array.add((int)weight1.x2);
        array.add((int)weight1.y2);
        

        //DRAWS THE OVALS 
         for(int i = 0; i < array.size()-1; i=i+2){
           g.drawOval(array.get(i),array.get(i+1), 3,3);
           g.fillOval(array.get(i), array.get(i+1), 3, 3);
           
       } 
        //System.out.println(array);
        return bufferedImage;

        
        
    }
    
   
    
        
    public static void main(String[] args) {
      
        //CALLS THE OPENING SCREEN WHEN THE PROGRAM IS RUN 
        new OpeningScreen().setVisible(true);

        
           

        
    
    }
     
}
