package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crys_ on 10.11.2017.
 */
public class Gramatica {
    private  List<String> N;
    private List<String> Sigma;
    private List <Productii> P;
    private String Start;
    public Gramatica(){
        this.N=new ArrayList<String>();
        this.Sigma=new ArrayList<String>();
        this.P = new ArrayList<Productii>();
        this.Start="";
    }
    public Gramatica(List<String> n,List<String> s, List<Productii> p, String stt){
        this.N=n;
        this.Sigma=s;
        this.P=p;
        this.Start=stt;
    }

    public List<String> getNeterminale(){
        return this.N;
    }
    public List<String> getSigma(){
        return this.Sigma;
    }
    public String getSimbolStart(){
        return this.Start;
    }
    public List<Productii> getProductii(){
        return this.P;
    }
    public void SetNeterminale(List<String> n){
        this.N=n;
    }
    public void setSigma(List<String> a){
        this.Sigma=a;
    }
    public void setSimbolStart(String s){
        this.Start=s;
    }
    public void setProductii(List<Productii> prod){
        this.P=prod;
    }
    public List<Productii> getProductiiNeterminal(String n){
        List<Productii> prod = getProductii();
        List<Productii> prodn = new ArrayList<Productii>();
        for (int i=0; i<prod.size(); i++){
            Productii productie=prod.get(i);
            if(productie.getPSP().equals(n)){
                prodn.add(productie);
            }
        }
        return prodn;
    }
    public boolean cautaNeterminal(String n){
        boolean gasit=false;
        List<String> neterm=this.getNeterminale();
        for(int i=0; i<neterm.size();i++){
            if(neterm.get(i).equals(n)){
                gasit=true;
                break;
            }
        }
        return gasit;

    }
    public boolean cautaTerminal(String s){
        boolean gasit=false;
        List<String> term=this.getSigma();
        for (int i=0; i<term.size();i++){
            if(term.get(i).equals(s)){
                gasit=true;
                break;
            }
        }
        return gasit;
    }

    public boolean cautaSimbolStart(){
        boolean gasit=false;
        List<Productii> p=this.getProductii();
        for(int j=0; j<p.size(); j++){
            String pd="";
            pd=p.get(j).getPDP();
            for(int i=0;i<pd.length();i++){
                if(pd.substring(i,i+1).equals(this.getSimbolStart())){
                    gasit=true;
                    break;
                }
            }
        }
        return gasit;
    }

    public boolean esteRegulara(){
        boolean ok=true;
        List<Productii> listaP = new ArrayList<Productii>();
        listaP=this.getProductii();
    /*for (int k1=0; k1<listaP.size();k1++){
        System.out.println(listaP.get(k1));
    } */
        for(int i=0; i<listaP.size();i++){
            Productii productie=new Productii();
            productie=listaP.get(i);
            if(productie.getCardinalPDP()>2){
                ok=false;
            }
            else if(productie.getCardinalPDP()==2){
                String simbol1=productie.getPDP().substring(0,1);
                String simbol2=productie.getPDP().substring(1,2);
                if((cautaTerminal(simbol1)==false) ||(cautaNeterminal(simbol2)==false)){
                    ok=false;
                }
            }
            else if(productie.getCardinalPDP()==1){
                String simbol=productie.getPDP();
                if((cautaTerminal(simbol)==false)&&!(simbol.equals("@"))){
                    ok=false;
                }
            }
        }
        if(ok==true){
            List<String> ne=this.getNeterminale();
            for(int i=0; i<ne.size(); i++){
                String net=ne.get(i);
                if(!(net.equals(this.getSimbolStart()))){
                    for(int j=0; j<listaP.size();j++){
                        Productii p=listaP.get(j);
                        if(net.equals(p.getPSP())){
                            if (p.getPDP().equals("@")){
                                ok=false;
                            }
                        }
                    }
                }
                else {
                    for (int k=0; k<listaP.size(); k++){
                        Productii p1=listaP.get(i);
                        if(p1.getPDP().equals("@")){
                            if(cautaSimbolStart()==true){
                                ok=false;
                            }
                        }
                    }
                }
            }
        }

        return ok;

    }

}