package com.company;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static Gramatica citesteGramatica() throws IOException {
        Gramatica G=new Gramatica();
        try{
            BufferedReader br=new BufferedReader(new FileReader("dateIntrare"));
            String neterminale=null;
            neterminale = br.readLine();
            String[] n= new String[20];
            n=neterminale.split(" ");
            List<String> listaNeterminale=new ArrayList<String>();
            for(int i=0; i<n.length; i++){
                listaNeterminale.add(n[i]);
            }
         /*for(int i=0; i<listaNeterminale.size();i++){
             System.out.println(listaNeterminale.get(i));
         } */

            String linie=null;
            linie=br.readLine();
            String [] sigma = new String[20];
            sigma=linie.split(" ");
            List<String> listaSigma =new ArrayList<String>();
            for(int i=0; i<sigma.length; i++){
                listaSigma.add(sigma[i]);
            }

            String start="";
            linie=br.readLine();
            linie.trim();
            start=linie;

            List<Productii> listaProductii = new ArrayList<Productii>();
            while ((linie=br.readLine())!=null){
                String [] prod= new String[50];
                prod=linie.split(" ");
                String ps="";
                String pd="";
                ps=prod[0];
                for(int i=1;i<prod.length;i++){
                    pd=pd+prod[i];
                }
                Productii pr=new Productii(ps,pd);
                listaProductii.add(pr);

            }
            G=new Gramatica(listaNeterminale,listaSigma,listaProductii,start);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return G;
    }
    public static void PrelucreazaGramatica(Gramatica G) throws IOException{
        List<String> MN=G.getNeterminale();
        List<String> MSigma=G.getSigma();
        List<Productii> MP=G.getProductii();

        System.out.println("Optiuni:\n 1-pentru multimea neterminalelor;\n 2-pentru multimea terminalelor;\n 3-pentru multimea productiilor;\n 4-pentru productiile unui neterminal dat;\n 5-pt a verifica daca gramatica este regulara\n");
        System.out.println("Introduceti 0 -renuntare...");
        int op=-1;
        while(op!=0){
            System.out.println("Introduceti optiunea dorita");
            BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
            op=Integer.parseInt(br1.readLine());
            if(op==1){
                System.out.println("Multimea neterminalelor este:");
                for(int i=0; i<MN.size();i++){
                    System.out.println(MN.get(i));
                }
            }
            else if(op==2){
                System.out.println("Multimea terminalelor este:");
                for(int i=0;i<MSigma.size();i++){
                    System.out.println(MSigma.get(i));
                }

            }
            else if(op==3){
                System.out.println("Multimea productiilor este:");
                for(int i=0; i<MP.size();i++){
                    System.out.println(MP.get(i).afiseaza());
                }
            }
            else if(op==4){
                System.out.println("Pt ce neterminal doriti sa afisati productiile?");
                String l= br1.readLine();
                String neterm=l.trim();
                List<Productii> ls=new ArrayList<Productii>();
                ls=G.getProductiiNeterminal(neterm);
                System.out.println("Productiile neterminalului "+neterm+" sunt:");
                for(int i=0; i<ls.size();i++){
                    System.out.println(ls.get(i).afiseaza());
                }
            }
            else if(op==5){
                if (G.esteRegulara()==true){
                    System.out.println("gramatica este regulara");
                }
                else {System.out.println("Gramatica nu este regulara");}
            }
        }

    }
    public static Automat citesteAutomat() throws IOException{
        Automat M=new Automat();
        try{
            BufferedReader br=new BufferedReader(new FileReader("dateIntrareAutomate"));
            String linie="";
            linie=br.readLine();
            String[] stari=new String[30];
            stari=linie.split(" ");
            List<String> listaStari=new ArrayList<String>();
            for(int i=0; i<stari.length; i++){
                listaStari.add(stari[i]);
            }

            linie=br.readLine();
            String[] alfabet=new String[30];
            alfabet=linie.split(" ");
            List<String> listaAlfabet=new ArrayList<String>();
            for(int i=0; i<alfabet.length; i++){
                listaAlfabet.add(alfabet[i]);
            }

            linie=br.readLine();
            String stareInitiala="";
            stareInitiala=linie.trim();

            linie=br.readLine();
            String[] fin=new String[30];
            fin=linie.split(" ");
            List<String> stariFinale=new ArrayList<String>();
            for(int i=0; i<fin.length; i++){
                stariFinale.add(fin[i]);
            }

            List<Tranzitii> listaDelta=new ArrayList<Tranzitii>();
            while((linie=br.readLine())!=null){
                String[] d = new String[30];
                d=linie.split(" ");
                Tranzitii t=new Tranzitii(d[0],d[1],d[2]);
                listaDelta.add(t);

            }

            M = new Automat(listaStari,listaAlfabet,stareInitiala,stariFinale,listaDelta);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return M;
    }
    public static void PrelucreazaAutomat(Automat M) throws IOException{
        //  Automat M=new Automat();

        System.out.println("Ce doriti sa afisati?");
        System.out.println("   1. Multimea starilor");
        System.out.println("   2. Alfabetul");
        System.out.println("   3. Tranzitiile");
        System.out.println("   4. Multimea starilor finale");
        System.out.println("   0. Renuntare...");
        int op=-1;
        while(op!=0){
            System.out.println("Ce doriti sa afisati in continuare?");
            BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
            op=Integer.parseInt(br1.readLine());
            if(op==1){
                System.out.println("Multimea starilor este:");
                List<String> multimeStari = M.getStari();
                for(int i=0; i<multimeStari.size(); i++){
                    System.out.println(multimeStari.get(i));
                }
            }
            else if (op==2){
                System.out.println("Alfabetul este:");
                List<String> al=M.getAlfabet();
                for(int i=0; i<al.size();i++){
                    System.out.println(al.get(i));
                }
            }
            else if (op==3){
                System.out.println("Tranzitiile sunt:");
                List<Tranzitii> tr=M.getTranzitii();
                for(int i=0;i<tr.size();i++){
                    System.out.println(tr.get(i).afiseaza());
                }
            }
            else if(op==4){
                System.out.println("Multimea starilor finale este:");
                List<String> sf=M.getStariFinale();
                for(int i=0;i<sf.size();i++){
                    System.out.println(sf.get(i));
                }
            }
            // System.out.println("Ce doriti sa afisati in continuare?");
        }

    }
    public static Automat genereazaAutomatDelaGramatica(Gramatica G){
        Automat M=new Automat();
        if(G.esteRegulara()==true){
            M.setAlfabet(G.getSigma());
            M.setq0(G.getSimbolStart());
            List<String> Q=new ArrayList<String>();
            Q=G.getNeterminale();
            Q.add("K");
            M.setStari(Q);
            List<String> F=new ArrayList<String>();
            List<Productii> prodS= G.getProductiiNeterminal(G.getSimbolStart());
            boolean gasit=false;
            for(int i=0;i<prodS.size();i++){
                if(prodS.get(i).getPDP().equals("@")){
                    gasit=true;
                }
            }
            if(gasit==true){
                F.add("K");
                F.add(G.getSimbolStart());
            }
            else F.add("K");
            M.setF(F);
            List<Tranzitii> lt=new ArrayList<Tranzitii>();
            List<String> prod=G.getNeterminale();
            for(int i=0; i<prod.size();i++){
                String p=prod.get(i);
                List<Productii> listap=G.getProductiiNeterminal(p);
                for(int j=0;j<listap.size();j++){
                    int k=listap.get(j).getCardinalPDP();
                    if(k==2){
                        Tranzitii t=new Tranzitii(p,listap.get(j).getPDP().substring(0,1),listap.get(j).getPDP().substring(1,2));
                        lt.add(t);
                    }
                    else{  k=listap.get(j).getCardinalPDP();
                        if((k==1)&&!(listap.get(j).getPDP().equals("@"))){
                            Tranzitii t=new Tranzitii(p,listap.get(j).getPDP().substring(0,1),"K");
                            lt.add(t);
                        }
                    }
                }
            }

            M.setDelta(lt);
        }

        //else System.out.println("nu se poate genera automatul deoarece gramatica nu este regulara...");
        return M;
    }
    public static Gramatica genereazaGramaticaDelaAutomat(Automat M){
        Gramatica G=new Gramatica();
        G.SetNeterminale(M.getStari());
        G.setSigma(M.getAlfabet());
        G.setSimbolStart(M.getStareInitiala());
        List<Productii> listap=new ArrayList<Productii>();
        List<String> F=M.getStariFinale();
        Productii p=new Productii();
        if(F.contains(M.getStareInitiala())){
            p=new Productii(M.getStareInitiala(),"@");
            listap.add(p);
        }
        List<Tranzitii> lt=M.getTranzitii();
        for(int i=0; i<lt.size();i++){
            if(F.contains(lt.get(i).getRez())){
                p=new Productii(lt.get(i).getArgS(),lt.get(i).getArgA());
                listap.add(p);
            }
            else{String pd="";
                pd=lt.get(i).getArgA()+lt.get(i).getRez();
                p=new Productii(lt.get(i).getArgS(),pd);
                listap.add(p);
            }
        }
        G.setProductii(listap);

        return G;
    }
    public static void main(String args[]) throws IOException {

        int op=-1;
        while(op!=0){
            System.out.println("Optiuni: ");
            System.out.println("   1. Gramatica");
            System.out.println("   2. Automat ");
            System.out.println("   3. Genereaza automat data fiind gramatica");
            System.out.println("   4. Genereaza gramatica dat fiind automatul ");
            System.out.println("   0. Stop executie ");
            System.out.println("Introduceti optiunea dorita:");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            op=Integer.parseInt(br.readLine());
            Gramatica G=new Gramatica();
            Automat M=new Automat();
            if(op==1){
                G=citesteGramatica();
                PrelucreazaGramatica(G);

            }
            else if(op==2){

                M= citesteAutomat();
                PrelucreazaAutomat(M);
            }
            else if(op==3){
                //String s="aA";
                //System.out.println(s.length());
                G=citesteGramatica();
                if(G.esteRegulara()==true){
                    M=genereazaAutomatDelaGramatica(G);
                    PrelucreazaAutomat(M);}
                else System.out.println("Nu se poate genera automatul deoarece gramatica nu este regulara");
            }
            else if(op==4){
                M=citesteAutomat();
                G=genereazaGramaticaDelaAutomat(M);
                PrelucreazaGramatica(G);
            }
        }
        // System.out.println("Introduceti alta optiune");
    }
}
