package basiclibrary;

import java.util.*;
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
        weatherdata(weeklyMonthTemperatures);

        List<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");
        votes.add("Shrub");
        votes.add("Bush");
        votes.add("Hedge");
        votes.add("Bush");
        String winner = tally(votes);
        System.out.println(winner + " received the most votes!");

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


    public static List<String> weatherdata(int[][] arr) {
        Set <Integer> set = new HashSet<Integer>();
        int[] arrayForAll=new int[50];
        int min =arr[0][0];
        int max =arr[0][0];
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if (min>arr[i][j]){
                    min=arr[i][j];
                }else if (max<arr[i][j]){
                    max=arr[i][j];
                }
                set.add(arr[i][j]);

            }
        }
        System.out.println("High:"+max);
        System.out.println("Low:"+min);
        List<Integer> list =new ArrayList<Integer>(set);
        Collections.sort(list);
        int currentValue = list.get(0);
        List<String> stringArray = new ArrayList<String>();
        for(int i=0; i<list.size();i++){
            if(list.get(i) != currentValue){
                for(int j=currentValue;j<list.get(i);j++){
                    String str= "Never saw temperature: " + j;
                    stringArray.add(str);
                    System.out.println("Never saw temperature: " + j);
                }
            }
            currentValue = list.get(i)+1;
        }
        return stringArray;
    }

    public static String tally(List arr) {
        // Create HashMap to store word and it's frequency
        HashMap<String, Integer> votes = new HashMap<String, Integer>();
        // Iterate through array of words
        for (int i = 0; i < arr.size(); i++) {
            // If word already exist in HashMap then increase it's count by 1
            if (votes.containsKey(arr.get(i))) {
                votes.put((String) arr.get(i), votes.get(arr.get(i)) + 1);
            }
            // Otherwise add word to HashMap
            else {
                votes.put((String) arr.get(i), 1);
            }
        }
        // Create set to iterate over HashMap
        Set<Map.Entry<String, Integer> > set = votes.entrySet();
        String topvot = "";
        int value = 0;
        for (Map.Entry<String, Integer> me : set) {
            // Check for word having highest frequency
            if (me.getValue() > value) {
                value = me.getValue();
                topvot = me.getKey();
            }
        }
        // Return word having highest frequency
        return topvot;
    }



}