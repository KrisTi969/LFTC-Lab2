package com.company;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by crys_ on 10.11.2017.
 */
public class Automat {
    private List<String> Q;
    private List<String> Alfabet;
    private String q0;
    private List<String> F;
    private List<Tranzitii> Delta;

    public Automat(){
        this.Q=new ArrayList<String>();
        this.Alfabet=new ArrayList<String>();
        this.q0="";
        this.F=new ArrayList<String>();
        this.Delta=new ArrayList<Tranzitii>();
    }
    public Automat(List<String> q, List<String> a, String si,List<String> f, List<Tranzitii> d){
        this.Q=q;
        this.Alfabet=a;
        this.q0=si;
        this.F=f;
        this.Delta=d;
    }
    public List<String> getStari(){
        return this.Q;
    }
    public List<String> getAlfabet(){
        return this.Alfabet;
    }
    public String getStareInitiala(){
        return this.q0;
    }
    public List<String> getStariFinale(){
        return this.F;
    }
    public List<Tranzitii> getTranzitii(){
        return this.Delta;
    }
    public void setStari(List<String> s){
        this.Q=s;
    }
    public void setAlfabet(List<String> a){
        this.Alfabet=a;
    }
    public void setq0(String q){
        this.q0=q;
    }
    public void setF(List<String> f){
        this.F=f;
    }
    public void setDelta(List<Tranzitii> d){
        this.Delta=d;
    }

}
