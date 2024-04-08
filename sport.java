package com.pa.collectionsapi;

import java.util.ArrayList;
import java.util.Scanner;

//@FunctionalInterface
//public interface MF {
//    public Integer sqr(int a);
//
//    default String sqr(String a) {
//        return a + a;
//    }
//}
// class Test {
//    public static void main(String[] args) {
//        MF fi = n -> {
//            return n * n;
//        };
//        System.out.println(fi.sqr(5));
//
//    }
//}
interface Sport{
    public void calculateAvgAge(int[] age);
    public void retirePlayer(int playerId);
}

class Cricket implements Sport {

//    public int[] playerIDs ;
    ArrayList<Integer> retiredPlayers;

    Cricket(){
        this.retiredPlayers = new ArrayList<>();
        System.out.println("A new cricket team has been formed");
    }
    public void calculateAvgAge(int[] age){
        double sum = 0;
        double average;
        for(int plage =0; plage<age.length; plage++){
            sum= sum+age[plage];
        }
        average = sum / age.length;
        String formattedDouble = String.format("%.2f", average);
        System.out.println("The average age of the team is " + formattedDouble);
    }
    public void retirePlayer(int playerId){
        if( !this.retiredPlayers.contains(playerId)){
            if( playerId >=20 || playerId <=40){
                System.out.println("Player with id: " +playerId+ " has retired");
            }
        }else{
            System.out.println("Player has already retired");
        }
        this.retiredPlayers.add(playerId);
    }
}

class Football implements Sport{
//    public int[] playerIDs  ;
    ArrayList<Integer> retiredPlayers;
    Football(){
        this.retiredPlayers = new ArrayList<>();
        System.out.println("A new football team has been formed");
    }
    public void calculateAvgAge(int[] age){
        double sum = 0;
        double average;
        for(int plage =0; plage<age.length; plage++){
            sum= sum+age[plage];
        }
        average = sum / age.length;
        String formattedDouble = String.format("%.2f", average) ;
        System.out.println("The average age of the team is " + formattedDouble);
    }
    public void retirePlayer(int playerId){
        System.out.println(playerId);
        if( !this.retiredPlayers.contains(playerId)){
            if( playerId >=20 || playerId <=40){
                System.out.println("Player with id: " +playerId+ " has retired");
            }
        }else{
            System.out.println("Player has already retired");
        }
        this.retiredPlayers.add(playerId);
    }
    public void playerTransfer(int fee, int playerId){
        System.out.println("Player with id: " + playerId+" has been transferred with a fee of "+ fee);
    }
}

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Cricket c = new Cricket();
        Football f = new Football();

        int[] age1 = new int[11];
        int[] age2 = new int[11];

        for(int i = 0; i < 2; i++)
        {
            String[] age = sc.nextLine().split(" ");
            if(i == 0){
                int j = 0;
                for(String s : age)
                    age1[j++] = Integer.parseInt(s);
            }
            else{
                int j = 0;
                for(String s : age)
                    age2[j++] = Integer.parseInt(s);
            }
        }
// these method we are defined in interface and implement  interface into cricket class and now we are just createing a object of cricket class
        //and calling method of interface

        c.calculateAvgAge(age1);
        f.calculateAvgAge(age2);

        for(int i = 0; i < 6; i++){

            if(i < 3){
                int x = Integer.parseInt(sc.nextLine());

                c.retirePlayer(x);
            }
            else if(i < 5){
                int x = Integer.parseInt(sc.nextLine());
                f.retirePlayer(x);
            }
            else {
                String[] temp = sc.nextLine().split(" ");
                f.playerTransfer(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            }
        }
    }
}
