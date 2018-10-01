/**This class creates a program that Create a report that prints out each
 * country and the number of cities listed in the places
 * file and the number of stuff listed in the stuff file
 */


package peter;

/*
 * (C) Copyright Peter Gartzke 2018
 * */


import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    private static ArrayList<GlobalAppArrayList> GlobApArLi = new ArrayList<>();
    private final static FileInput cardAccts = new FileInput("places.csv");
    private final static FileInput cardPurchases = new FileInput("stuff.csv");
    private static Scanner keyboard = new Scanner(System.in);

    /**
     The main method is the program's starting point
     */
    public static void main(String[] args) {
        setArraylist();
        findTheGoodStuff();
        printFormat();
        cardAccts.fileClose();
        cardPurchases.fileClose();
    }


    public static void setArraylist(){
        int theCount = -1;

        String[] fields;

        String line;

        String name = "";

        while((line = cardAccts.fileReadLine()) != null){
            fields = line.split(",");
            if(fields[0].equals(name)){
                GlobApArLi.get(theCount).AddcityNum1();
            }
            else if(!fields[0].equals(name)){
                GlobApArLi.add(new GlobalAppArrayList((fields[0]),1, 0 ));
                name = fields[0];
                theCount++;
            }

        }
    }


    public static void findTheGoodStuff(){
        String[] field;
        String line2;
        while(((line2 = cardPurchases.fileReadLine()) != null)){
            field = line2.split(",");
            for (int i = 0; i < GlobApArLi.size(); i++) {
                if (field[0].equals(GlobApArLi.get(i).getName1())) {
                    GlobApArLi.get(i).AddstuffNum1();
                }
            }
        }

        GlobApArLi.get(0).AddstuffNum1();
    }


    public static void printFormat(){
        System.out.format("%1s %20s %6s\n", "Country", "Cities", "Stuff");
        System.out.format("%1s %20s %6s\n", "=======", "======", "=====");
        for (GlobalAppArrayList pf: GlobApArLi) {
            System.out.printf("%-20s  %4d %6d\n",pf.getName1(), pf.getCityNum1(), pf.getStuffNum1());
        }
    }
}