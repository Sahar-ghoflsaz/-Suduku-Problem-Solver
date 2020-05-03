/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package model;

import java.util.Random;

/**
 *
 * @author LIFE
 */
/*public class GAmodel {
    
    private int parent[][][];
    
    private double fit[];
    
    private double fitBar[];
    
    private int child[][][];
    
    private int goal[][];
    
    private int count;
    
    private int chNO;
    private int moraba;
    int n;
    
    //--------------------------methods
    
    public void SetFirstParents(int n, int chNO){
        this.n=n;
        this.chNO=chNO;
        goal = new int[n][n];
        count=0;
        parent = new int[chNO][n][n];
           if(n==4)moraba=2;
           else moraba=3;
        child = new int[chNO][n][n];
        fit=new double[chNO];
        fitBar=new double[chNO];
        
        Random rand = new Random();
        for(int l=0;l<chNO;l++){
        for(int i=0 ; i<n ; i++){
            for (int j=0 ; j<n; j++){
                parent[l][i][j]=rand.nextInt(n)+1;
                //child[l][i][j]=rand.nextInt(n)+1;
            }
        }
        }
    }
    
    /*public int EachFitnessFunc(int[][] array){
        int satr=0;
        int soton=0;
        int kocholo=0;
        
        int temp1;
        
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
        
        //-------------------------------------------Har koshol moraba--------------------------------------//
        
        for (int i=0 ; i<n ; i=i+moraba){ 
            
            for(int j=0 ; j<n ; j=j+moraba){
                
                for(int l=i ; l<i+moraba ; l++){
                    
                    for(int o=j ; o<j+moraba ; o++){
                        
                        for(int q=i ; q<i+moraba ; q++){
                            
                            for(int r=j ;r<j+moraba;r++){
                                
                                
                                if(array[l][o]== array[q][r] && l!=q && o!=r){
                                    kocholo++;
                                    
                                }  
                            }
                        }
                    }
               
                }
            }
        
        }
//----------------------------------------------------------------
        
        
        return kocholo+satr+soton/2;
    }*/
    
     /*public void FitnessFunc(){
        int satr=0;
        int soton=0;
        int kocholo=0;
        double sum=0;
        int temp1;
        for(int p=0;p<chNO;p++){
        for(int i=0 ; i<n ; i++){
            for (int j=0 ; j<n; j++){
                temp1=parent[p][i][j];
                for(int l=0 ; l<n ; l++){
                    if(parent[p][i][l]== temp1 && l!=j){
                       satr++;
                    }   
                }
                for(int l=0 ; l<n ; l++){
                    if(parent[p][l][j]== temp1 && l!=i){
                        soton++;
                    }   
                }
                }
            }
        
        //-------------------------------------------Har koshol moraba--------------------------------------//
        
        for (int i=0 ; i<n ; i=i+moraba){ 
            
            for(int j=0 ; j<n ; j=j+moraba){
                
                for(int l=i ; l<i+moraba ; l++){
                    
                    for(int o=j ; o<j+moraba ; o++){
                        
                        for(int q=i ; q<i+moraba ; q++){
                            
                            for(int r=j ;r<j+moraba;r++){
                                
                                
                                if(parent[p][l][o]== parent[p][q][r] && l!=q && o!=r){
                                   kocholo++;
                                    
                                }  
                            }
                        }
                    }
               
                }
            }
        
        }
//----------------------------------------------------------------
        
        
        
        sum=kocholo+satr+soton/2.0;
        
        fit[p]= sum;  
        kocholo=0;
        satr=0;
        soton=0;
        //sum=0;
        
    }
        
    }
    public void fitnessBar(){
        double total=0;
        for(int i=0;i<chNO;i++){
         total+=fit[i];
        }
        for(int i=0;i<chNO;i++)
        fitBar[i]=(fit[i]/total);

        /*for(int i=0;i<chNO;i++){

         System.out.println(fit[i]);
        }
         System.out.println(total);*/
    /*}
    
    public void makeChild(){
        
        //double first=0;
        
        double mahdode[];
        mahdode = new double[chNO+1];
        for(int i=0;i<chNO;i++){
            mahdode[i]=0;
            for(int j=0 ;j<i ;j++){
                mahdode[i]+=fitBar[j];
            }   
        }
        mahdode[chNO]=1;
        
       /* System.out.println(fitBar[1]);
        System.out.println(fitBar[3]);
        System.out.println(fitBar[5]);
        System.out.println(fitBar[7]);
        System.out.println(fitBar[9]);*/
        
        /*Random rand = new Random();
        
        
        
        
        for(int l=0;l<chNO;l=l+2){
           double now= rand.nextDouble();
        //Random rand = new Random();
        double later= rand.nextDouble();
        boolean a=true;
        while(a==true){
        a=false;
        for(int i=0;i<chNO ;i++){
        if(mahdode[i]<=now && now< mahdode[i+1]){
            for( int j=0; j<chNO;j++){
            
            if(mahdode[j]<=later && later< mahdode[j+1]){
                if (i==j){
                    later= rand.nextDouble();
                     a=true;
                }
                else{
                    child(i,j,l);
                }
                    
            }
            }
        }
        }
        }
      
    }
    }
    public void child(int a, int b,int childNO){
        
            for(int i=0 ; i<n ; i++){
                for (int j=0 ; j<n/2; j++){
                    child[childNO][i][j]=parent[a][i][j];

                }
            }
            for(int i=0 ; i<n ; i++){
                for (int j=n/2 ; j<n; j++){
                    child[childNO+1][i][j]=parent[a][i][j];
                }
            }
        
            for(int i=0 ; i<n ; i++){
                for (int j=n/2 ; j<n; j++){
                    child[childNO][i][j]=parent[b][i][j];
                }
            }
            for(int i=0 ; i<n ; i++){
                for (int j=0 ; j<n/2; j++){
                    child[childNO+1][i][j]=parent[b][i][j];

                }
            }
           
    }
    public void jahesh(int b){
        int a=b;
        while(a>0){
        
        Random rand = new Random();
        int satr1  ;
        int soton1  ;
        int meghdar1  ;
        
        for(int i=0 ; i<chNO;i++){
            satr1 = rand.nextInt(n) ;
            soton1 = rand.nextInt(n) ;
            meghdar1 = rand.nextInt(n)+1 ;
            child[i][satr1][soton1]= meghdar1;
        }
        
        a--;
    }
    }
    public void swap(){
        
        for(int i=0 ; i<chNO ; i++){
             
            parent[i]=child[i];
     
        }
    }
    public boolean cheak(){
        int round=0;
        int array[][];
        array =new int[n][n];
        boolean a=false;
        while (round<chNO && a==false){
            for(int i=0;i<chNO;i++){
                if(round==i) array=child[i];
                round++;
            }
            int temp1;

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
        
        if(a==true) goal= array;
    }
        return a;
    }
    
    public int[][] getArray(){
       /*System.out.println(fit[0]);
       System.out.println(fitBar[0]);*/
     /*   return goal;
    }
    
    /*public void chooseNewGen(){
        int newGen[][][];
        int key[][];
        
        newGen=new int[2*chNO][n][n];
        key=new int[n][n];
        
        for (int i=0 ; i<chNO ; i++){ 
            for(int j=0 ; j<n ; j++){
                for(int l=0 ; l<n ; l++){
                    newGen[i][j][l]=parent[i][j][l];
                }
            }
        }
        for (int i=chNO ; i<2*chNO ; i++){ 
            for(int j=0 ; j<n ; j++){
                for(int l=0 ; l<n ; l++){
                    newGen[i][j][l]=child[i-chNO][j][l];
                }
            }
        }
        
        for (int i=1; i<2*chNO; ++i) 
        { 
            key = newGen[i]; 
            int j = i-1; 
  
            while (j>=0 && EachFitnessFunc(newGen[j]) > EachFitnessFunc(key)) 
            { 
                newGen[j+1] = newGen[j]; 
                j = j-1; 
            } 
            newGen[j+1] = key; 
        } 
       for (int i=0 ; i<chNO ; i++){ 
           parent[i]=newGen[i];
       }
    }*/

    /*Function to sort array using insertion sort*/



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
public class GAmodel {
    
    private int parent[][][];
    
    private double fit[];
    
    private double fitBar[];
    
    private int child[][][];
    
    private int goal[][];
    
    private int count;
    
    private int moraba;
    int n;
    
    //--------------------------methods
    
    public void SetFirstParents(int n){
        this.n=n;
        goal = new int[n][n];
        count=0;
        parent = new int[10][n][n];
           if(n==4)moraba=2;
           if(n==9) moraba=3;
        child = new int[10][n][n];
        fit=new double[10];
        fitBar=new double[10];
        
        Random rand = new Random();
        for(int l=0;l<10;l++){
        for(int i=0 ; i<n ; i++){
            for (int j=0 ; j<n; j++){
                parent[l][i][j]=rand.nextInt(n)+1;
            }
        }
        }
    }
    
    public void FitnessFunc(){
        int satr=0;
        int soton=0;
        double sum=0;
        int kocholo=0;
        int temp1;
        for(int p=0;p<10;p++){
        for(int i=0 ; i<n ; i++){
            for (int j=0 ; j<n; j++){
                temp1=parent[p][i][j];
                for(int l=0 ; l<n ; l++){
                    if(parent[p][i][l]== temp1 && l!=j){
                       satr++;
                    }   
                }
                for(int l=0 ; l<n ; l++){
                    if(parent[p][l][j]== temp1 && l!=i){
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
                            
                            for(int r=j ;r<j+moraba;r++){
                                
                                
                                if(parent[p][l][o]== parent[p][q][r] && l!=q && o!=r){
                                   kocholo++;
                                    
                                }  
                            }
                        }
                    }
               
                }
            }
        
        }
        sum=satr+soton+kocholo/2.0;
        fit[p]= sum;   
        satr=0;
        soton=0;
        kocholo=0;
        }
        
    }
    public void fitnessBar(){
        double total=0;
        for(int i=0;i<10;i++){
         total+=fit[i];
        }
        for(int i=0;i<10;i++)
        fitBar[i]=(fit[i]/total);

        /*for(int i=0;i<10;i++){

         System.out.println(fit[i]);
        }
         System.out.println(total);*/
    }
    
    public void makeChild(){
        
        double first=0;
        
        double mahdode[];
        mahdode = new double[11];
        for(int i=0;i<10;i++){
            mahdode[i]=0;
            for(int j=0 ;j<i ;j++){
                mahdode[i]+=fitBar[j];
            }   
        }
        mahdode[10]=1;
        
       /* System.out.println(fitBar[1]);
        System.out.println(fitBar[3]);
        System.out.println(fitBar[5]);
        System.out.println(fitBar[7]);
        System.out.println(fitBar[9]);*/
        
        Random rand = new Random();
        double now= rand.nextDouble();
        //Random rand = new Random();
        double later= rand.nextDouble();
        boolean a=true;
        
        
        for(int l=0;l<10;l=l+2){
            
        while(a==true){
        a=false;
        for(int i=0;i<10 ;i++){
        if(mahdode[i]<=now && now< mahdode[i+1]){
            for( int j=0; j<10;j++){
            
            if(mahdode[j]<=later && later< mahdode[j+1]){
                if (i==j){
                    later= rand.nextDouble();
                     a=true;
                }
                else{
                    child(i,j,l);
                }
                    
            }
            }
        }
        }
        }
      
    }
    }
    public void child(int a, int b,int childNO){
        
            for(int i=0 ; i<n ; i++){
                for (int j=0 ; j<n/2; j++){
                    child[childNO][i][j]=parent[a][i][j];

                }
            }
            for(int i=0 ; i<n ; i++){
                for (int j=n/2 ; j<n; j++){
                    child[childNO+1][i][j]=parent[a][i][j];
                }
            }
        
            for(int i=0 ; i<n ; i++){
                for (int j=n/2 ; j<n; j++){
                    child[childNO][i][j]=parent[b][i][j];
                }
            }
            for(int i=0 ; i<n ; i++){
                for (int j=0 ; j<n/2; j++){
                    child[childNO+1][i][j]=parent[b][i][j];

                }
            }
           
    }
    public void jahesh(int b){
        int a=b;
        while(a>0){
        
        Random rand = new Random();
        int satr1  ;
        int soton1  ;
        int meghdar1  ;
        
        for(int i=0 ; i<10;i++){
            satr1 = rand.nextInt(n) ;
            soton1 = rand.nextInt(n) ;
            meghdar1 = rand.nextInt(n)+1 ;
            child[i][satr1][soton1]= meghdar1;
        }
        
        a--;
    }
    }
    public void swap(){
        
        for(int i=0 ; i<5 ; i++){
             
            parent[i]=child[i];
     
        }
    }
    public boolean cheak(){
        int round=0;
        int array[][];
        array =new int[n][n];
        boolean a=false;
        while (round<10 && a==false){
            for(int i=0;i<10;i++){
                if(round==i) array=child[i];
                //round++;
            }
            round++;
            int temp1;
        //int temp2;
        
       
        //System.out.println(moraba);
        
        
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
        
        if(a==true) goal= array;
    }
        return a;
    }
    
    public int[][] getArray(){
        
        return goal;
    }
}
