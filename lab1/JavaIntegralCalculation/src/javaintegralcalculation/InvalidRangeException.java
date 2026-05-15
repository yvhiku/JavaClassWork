/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaintegralcalculation;

/**
 *
 * @author firki
 */
public class InvalidRangeException extends Exception{
    double errVal;
    
    public InvalidRangeException(String message){
        super(message);
    }
    
    public double getErrVal(){
        return errVal;
    }
    
    public InvalidRangeException(String message, double num){
        super(message);
        errVal = num;
    }

}