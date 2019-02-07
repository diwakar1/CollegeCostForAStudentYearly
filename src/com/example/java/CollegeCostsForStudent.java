/*
calculate total cost for attending college for one year,
print final total.
make sure student is on campus or not.
if on campus add all living expenses including book and supplies, cost per credit
write separate methods for each methods and ony
use main to call methods

 */

package com.example.java;

import java.util.Scanner;

public class CollegeCostsForStudent {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        String name = getName();
        printTotal(name);
    }


    public static String getName()
    {
        System.out.println("What is the name of the student?");
        String name = in.nextLine();
        return name;
    }


    public static void printTotal(String name)
    {
        double total = 0;
        if (onCampus(name))
        {
            total = calcualateTotal(estimatedLivingExpense(), bookAndSupplies(),
                    creditHours(), costPerCredit());
        } else
            {
            total = calcualateTotal(bookAndSupplies(), creditHours(), costPerCredit());
        }

        String year = getYear();
        if (year.equalsIgnoreCase("other"))
            System.out.printf("The total cost for " + name + " is $%7.2f", total);
        else
            System.out.printf("The total cost for " + name + " as a " + year + " is $%7.2f", total);
        System.out.println();


    }


    public static boolean onCampus(String name)
    {
        boolean invalidResponse = true;
        do {
            System.out.println("is " + name + " living on Campus ? (yes/no)");
            String response = in.nextLine();
            if (response.equalsIgnoreCase("yes"))
                return true;
            else if (response.equalsIgnoreCase("no"))
                return false;
            else
                System.out.println("invalid response");
        } while (invalidResponse);
        return false;
    }


    public static double bookAndSupplies()
    {
        System.out.println("What is the estimated cost of " +
                "textbooks and supplies?");
        double cost = in.nextDouble();
        return cost;
    }


    public static int creditHours()
    {
        System.out.println("how many credit hours is the student planning" +
                " to take ?");
        int hours = in.nextInt();
        return hours;
    }


    public static double costPerCredit()
    {
        System.out.println("What is the cost per credit hour? ");
        double costCredit = in.nextDouble();
        in.nextLine();
        return costCredit;
    }


    public static String getYear()
    {
        System.out.println("What year is the student(Freshman, Sophomore , Senior," +
                "Junior, Other)?");
        String year = in.nextLine();
        return year;
    }


    public static double estimatedLivingExpense()
    {
        double total = 0;
        try {
            System.out.println("How many weeks will the  student live in the campus?");
            String value = in.nextLine();
            int weeks = Integer.parseInt(value);
            System.out.println("What is the estimated weekly living expense?");
            value = in.nextLine();
            double weeklyExpense = Double.parseDouble(value);
            System.out.println("what is the room and board for the year?");
            value = in.nextLine();
            double roomBoard = Double.parseDouble(value);
            total = weeks * weeklyExpense + roomBoard;
        } catch (Exception e) {
            System.out.println("invalid data type");
            e.printStackTrace();
        }
        return total;
    }


    public static double calcualateTotal(double books, int credit, double cost) {
        return books + (credit * cost);
    }



    public static double calcualateTotal(double livingExpenses, double books,
                                         int credit, double cost) {
        return livingExpenses + books + (credit * cost);
    }
}


