package com.company;

/**
 * Created by crys_ on 10.11.2017.
 */
public class Tranzitii {
    private String argS;
    private String argA;
    private String rez;
    public Tranzitii(){
        this.argS="";
        this.argA="";
        this.rez="";
    }
    public Tranzitii(String as, String aa, String r){
        this.argS=as;
        this.argA=aa;
        this.rez=r;
    }

    public String getArgS(){
        return this.argS;
    }
    public String getArgA(){
        return this.argA;
    }
    public String getRez(){
        return this.rez;
    }

    public void setArgS(String a){
        this.argS=a;
    }
    public void setArgA(String a){
        this.argA=a;
    }
    public String afiseaza(){
        return "delta("+this.argS+","+this.argA+")"+"="+this.rez;
    }
}

