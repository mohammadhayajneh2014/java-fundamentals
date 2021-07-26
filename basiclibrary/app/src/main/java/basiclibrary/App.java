package basiclibrary;

import java.util.Arrays;

public class App{
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
         int n = 6;


        int []rooling =roll(n);
        float avreg=avgForArray(rooling);
        System.out.println(Arrays.toString(rooling));
        System.out.println(containsDuplicates(rooling));
        System.out.println(avreg);
        int[][] weeklyMonthTemperatures = {
                {66, 64,58, 65, 71, 57, 60},
                {57, 65, 65, 70, 72, 65, 51},
                {55, 54, 60, 53, 59, 57, 61},
                {65, 56, 55, 52, 55, 62, 57}
        };
        System.out.println(Arrays.toString(lowAvgForArray(weeklyMonthTemperatures)));
    }

    public static int[] roll(int n) {
        int max = 6;
        int min = 1;
        int []randNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            int rand = (int) (Math.random() *  (max - min + 1)) + min;
            randNumbers[i] = rand;
        }
        return randNumbers ;
       }


    public static boolean containsDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
             if (array[i]==array[j]){
                 return true ;
             }
            }
        }
        return false;
    }

    public static float avgForArray(int[] arr) {
       int sum =0;
       for (int j :arr){
           sum=sum+ j;
       }
       return (float) sum/arr.length;
    }
    public static int[] lowAvgForArray(int[][] arr) {
       float [] avregArr=new float[arr.length];
        for (int i=0;i<arr.length;i++){
            avregArr[i]=avgForArray(arr[i]);
        }
        float zeroAvg=avregArr[0];
        int avgLowIndex =0;
        for (int i=0;i<avregArr.length;i++){
           if (zeroAvg >= avregArr[i]){
               zeroAvg=avregArr[i];
               avgLowIndex=i;
           }
        }
        return arr[avgLowIndex];
    }





}