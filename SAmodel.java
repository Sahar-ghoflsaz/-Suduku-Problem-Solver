/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Random;

/**
 *
 * @author LIFE
 */
public class SAmodel {
    
    private int n;
    private int array[][];
    private int child[][];
    private int count;
    double e=2.718281828459045;
    double alfa=0.01;
    double t= 100000000;
    int time=0;
   
    public void firstSet(int n){
       // e=2.718281828459045;
        Random rand = new Random();
        this.n=n;
        count=0;
        array = new int[n][n];
        child = new int[n][n];
        for(int i=0 ; i<n ; i++){
            for (int j=0 ; j<n; j++){
                array[i][j]=j+1;
                
            }
        }
       
    }
    
    public void getChild(){
        
        boolean a=false;
       Random rand = new Random();
       while(a==false){
        /*int satr1 = rand.nextInt(n) ;
        int soton1 = rand.nextInt(n) ;
        int satr2 = rand.nextInt(n) ;
        int soton2 = rand.nextInt(n) ;
        child=array;
        int temp;
        temp= child[satr1][soton1];
        child[satr1][soton1]= child[satr2][soton2];
        child[satr2][soton2]=temp;*/
           int satr1 = rand.nextInt(n);
           int temp[];
           temp=new int[n];
            child=array;
           
            for(int i=0;i<n;i++){
                    temp[i]=child[satr1][i];
                    //child[satr1][i+1]=child[satr1][i];
            }
            for(int i=0;i<n-1;i++){
                    //temp[i]=child[satr1][i+1];
                    child[satr1][i+1]=temp[i];
            }
            child[satr1][0]=temp[n-1];
                         
           
        double p=arzyabi(array);
        double c=arzyabi(child);
        if(c<p){
            array=child;
            a=true;
        }
        else {
            double ehtem=ehtemal(p,c);
            if(rand.nextDouble()<=ehtem){
                array=child;
                a=true;
            }
            else{
                a=false;
            }
        }
        //count++;
    }
    }
    public double arzyabi(int[][] array){

        int satr=0;
        int soton=0;
        int kocholo=0;
        double sum;
        int temp1;
        int moraba;
        if(n==4) moraba=2;
        else moraba=3;
        for(int i=0 ; i<n ; i++){
            for (int j=0 ; j<n; j++){
                temp1=array[i][j];
                for(int l=0 ; l<n ; l++){
                    if(array[i][l]== temp1 && l!=j){
                       satr++;
                    }   
                }
                for(int l=0 ; l<n ; l++){
                    if(array[l][j]== temp1 && l!=i){
                        soton++;
                    }   
                }
            }
        }
        
        for (int i=0 ; i<n ; i=i+moraba){ 
            
            for(int j=0 ; j<n ; j=j+moraba){
                
                for(int l=i ; l<i+moraba ; l++){
                    
                    for(int o=j ; o<j+moraba ; o++){
                        
                        for(int q=i ; q<i+moraba ; q++){
                            
                            for(int p=j ; p<j+moraba;p++){
                                
                                
                                if(array[l][o]== array[q][p] && l!=q && o!=p){
                                    kocholo++;
                                    
                                }  
                            }
                        }
                    }
               
                }
            }
        
        }
        sum=kocholo+satr+soton/2.0;
        return sum;
    }
    public double ehtemal(double p,double c){
        
        //time++;
        t--;
        return (Math.pow(e,(p-c)/t));
    }
    
    public boolean cheak(){
       int temp1;
        //int temp2;
        int moraba;
       
        if(n==4) moraba=2;
        else moraba=3;
        // int s=0;
        boolean a=true;
        
//-------------------------------------------Har koshol moraba--------------------------------------//
        
        for (int i=0 ; i<n ; i=i+moraba){ 
            
            for(int j=0 ; j<n ; j=j+moraba){
                
                for(int l=i ; l<i+moraba ; l++){
                    
                    for(int o=j ; o<j+moraba ; o++){
                        
                        for(int q=i ; q<i+moraba ; q++){
                            
                            for(int p=j ; p<j+moraba;p++){
                                
                                
                                if(array[l][o]== array[q][p] && l!=q && o!=p){
                                    a=false;
                                    
                                }  
                            }
                        }
                    }
               
                }
            }
        
        }

//----------------------------------satr o soton cheak-------------------------------------------------------------//        
        for (int i=0 ; i<n ; i++){ 
            for(int j=0 ; j<n ; j++){
                temp1=array[i][j];
                for(int l=0 ; l<n ; l++){
                    if(array[i][l]== temp1 && l!=j){
                       a=false;
                    }   
                }
                for(int l=0 ; l<n ; l++){
                    if(array[l][j]== temp1 && l!=i){
                        a=false;
                    }   
                }
               
            }
        
        }
        return a;
    }
     public int[][] getArray() {
        return array;
    }
}
