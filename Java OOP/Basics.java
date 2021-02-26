import java.util.ArrayList;
import java.util.Collections;
public class Basics {
    public static void main(String[] args) {
        //int [] arr={5,7,-8,10};
        //FindMax(arr);
        //Print();
        //Odd();
        //Sum();
        //Iter();
        //int[] arr={1,8,5,3,4};
        //Avg(arr);
        //arrOdd(arr);
        //int[] arr={1,5,8,7,2,6,1,5,4,1};
        //Greater(arr, 4);
        //int [] arr={1,2,3,4};
        //Square(arr);
        ArrayList <Integer> y=new ArrayList <Integer>();
        Collections.addAll(y,1,5,-8,4,-7);
        Negative(y);
    }
    public static void Print(){
        for (int i =1; i<=255; i++){
            System.out.println(i);
        }
    }
    public static void Odd(){
        for (int i =1; i<=255; i++){
            if (i%2 != 0){
              System.out.println(i);
            }
        }
    }
    public static void Sum(){
        int sum = 0;
        for (int i =0; i<=155; i++){
            sum +=i;
            System.out.println("New Number" +i+ "sum" +sum);
        }
    }
    public static void Iter(){
        int [] arr={1,3,5,7,9,13};
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void FindMax(int arr[]){
        int max= arr[0];
       for (int i=0; i<arr.length; i++){
           if (arr[i]> max){
               max = arr[i];
           }
       }
       System.out.println(max);
    }
    public static void Avg(int arr[]){
        int sum=0;
        for(int i=0; i<arr.length;i++){
            sum += i;
        }
        float avg = sum/arr.length;
        System.out.println(avg);


    }
    public static void arrOdd(){
        int[] arr={};
        for(int i=0; i<=255; i++){
            if (i%2 != 0){
               
            }
        }
    }
    public static void Greater(int arr[], int value){
        int counter=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i] > value){
                counter += 1;
            }
        }
        System.out.println(counter);
    }
    public static void Square(int arr[]){
        ArrayList<Integer>  x= new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++){
            arr[i]=arr[i]*arr[i];
            x.add(arr[i]);
        }
        System.out.println(x);
    }
    public static void Negative(ArrayList <Integer>y){
        for (int i=0; i<arr.length; i++){
            if (arr[i]<0){
                arr[i]=0;
                y.get(arr[i]);
            }
        y.get(arr[i]);    
        }
    }
    public static void MaxMinAvg(int [] arr){
        int max = arr[0];
        int min = arr[0];
        int avg;
        int sum = 0;
        for (int i=0; i<arr.length;i++){
            if (arr[i]>max){
                max =arr[i];
            }
            if(arr[i]>min){
                min =arr[i];
            }
            sum += arr[i];
            avg = sum/arr.length;
        }
    }
}