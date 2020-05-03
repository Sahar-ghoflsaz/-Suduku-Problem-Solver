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
public class simpleModel implements java.io.Serializable {
    private int n;
    private int array[][];
    private int count;
    //private int moraba1;
    public static simpleModel four= new simpleModel();
    
    public void setValue(int n) {
        this.n=n;
        count=0;
        array = new int[n][n];
        for(int i=0 ; i<n ; i++){
            for (int j=0 ; j<n; j++){
                array[i][j]=j+1;
            }
        }
    }
    
    public boolean solve() {
        
        boolean a=false;
        //while(a==false){
        //System.out.printf("calculate...\n");
        
        
        //--------------------------------------------JABEJAEE
        Random rand = new Random();
       /* int satr1 = rand.nextInt(n) ;
        int soton1 = rand.nextInt(n) ;
        int satr2 = rand.nextInt(n) ;
        int soton2 = rand.nextInt(n) ;
        //swap(satr1,soton1,satr2,soton2);
        int temp;
        temp= array[satr1][soton1];
        array[satr1][soton1]= array[satr2][soton2];
        array[satr2][soton2]=temp;*/
        
        int satr1 = rand.nextInt(n);
           int temp[];
           temp=new int[n];
           
            for(int i=0;i<n;i++){
                    temp[i]=array[satr1][i];
                    //child[satr1][i+1]=child[satr1][i];
            }
            for(int i=0;i<n-1;i++){
                    //temp[i]=child[satr1][i+1];
                    array[satr1][i+1]=temp[i];
            }
            array[satr1][0]=temp[n-1];
        count++;
        //int a = cheak(n,array[][]);.
        //-----------------------------------------shoro check
        
        int temp1;
        int temp2;
        int moraba;
       
        if(n==4) moraba=2;
        else moraba=3;
        // int s=0;
        a=true;
        
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
     
      public int getCount() {
        return count;
    }


}

  
/*package model;

import java.util.Random;
import java.util.Scanner;
import static javafx.application.Application.launch;

/**
 *
 * @author LIFE
 */
/*public class main {
    
    
    public static void main(String[] args) {
        
        //---------------------------------------------begin-----------------
        
        
       Scanner input = new Scanner(System.in);
        int n;
        int array[][];
        n = input.nextInt();
        array = new int[n][n];
        for (int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
             array[i][j]=j+1;   
            }
        }
        
        for (int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                System.out.printf("   " + array[i][j] );
            }
                System.out.printf("\n");
        }
        boolean a=false;
        while(a==false){
        //System.out.printf("calculate...\n");
        Random rand = new Random();
        int satr1 = rand.nextInt(n) ;
        int soton1 = rand.nextInt(n) ;
        int satr2 = rand.nextInt(n) ;
        int soton2 = rand.nextInt(n) ;
        //swap(satr1,soton1,satr2,soton2);
        int temp;
        temp= array[satr1][soton1];
        array[satr1][soton1]= array[satr2][soton2];
        array[satr2][soton2]=temp;
        //int a = cheak(n,array[][]);.
        //---------------------------------------------
        
        int temp1;
        int temp2;
        int moraba;
       
        if(n==4) moraba=2;
        else moraba=3;
        // int s=0;
        a=true;
        
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

//-----------------------------------------------------------------------------------------------//        
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
        
        }
        //-----------------------------
        
        if(a==true){
        for (int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                System.out.printf("   " + array[i][j] );
            }
                System.out.printf("\n");
        }
        }
    }
    
}*/
