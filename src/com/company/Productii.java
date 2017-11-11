package com.company;

/**
 * Created by crys_ on 10.11.2017.
 */
public class Productii {
    private String psp;
    private String pdp;

    public Productii(){
        this.psp="";
        this.pdp="";
    }
    public Productii(String ps, String pd){
        this.psp=ps;
        this.pdp=pd;
    }
    public void setPSP(String s){
        this.psp=s;
    }
    public void setPDP(String s){
        this.pdp=s;
    }
    public String getPSP(){
        return this.psp;
    }
    public String getPDP(){
        return this.pdp;
    }
    public int getCardinalPDP(){
        return this.pdp.length();
    }

    public String afiseaza(){
        return this.psp+"->"+this.pdp;
    }
}
