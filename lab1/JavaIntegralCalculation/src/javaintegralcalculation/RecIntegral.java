/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaintegralcalculation;

/**
 *
 * @author firki
 */
public class RecIntegral {
    private double upperLim;
    private double lowLim;
    private double step;
    private double result;


    public RecIntegral(double lowLim, double upperLim, double step){
        this.lowLim = lowLim;
        this.upperLim = upperLim;
        this.step = step;
        this.result = 0.0;
    }

    public RecIntegral(double lowLim, double upperLim, double step, double result){
        this.lowLim = lowLim;
        this.upperLim = upperLim;
        this.step = step;
        this.result = result;
    }
    
    public double getLowLim(){return lowLim;}
    public double getUpperLim(){return upperLim;}
    public double getStep(){return step;}
    public double getResult(){return result;}
    
    public void setLowLim(double lowLim){
        this.lowLim = lowLim;
    }
    
    public void setUpperLim(double upperLim){
        this.upperLim = upperLim;
    }
    
    public void setStep(double step){
        this.step = step;
    }
    
    public void setResult(double result){
        this.result = result;
    }
    
        public double CalcIntegral(double lowLim, double upLim, double step)
{
    double start = lowLim;
    double h;
    double sumS = 0;

    while (start < upLim) {
        h = Math.min(step, upLim - start);

        sumS += h * (Math.sin(start) + Math.sin(start + h)) / 2;

        start += h;
    }

    return sumS;
}
}