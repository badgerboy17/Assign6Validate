
/**
 * Name: Bryce Sulin (sulin)
 * Course: CSCI 241 - Computer Science I
 * Section: 001
 * Assignment: 6
 * 
 * Project/Class Description:
 * This program will validate a particular credit card number through the utilization
 * of separate class-level methods. The main method will call these methods to calculate the algorithim of
 * whether the "total" variable is equally divisible by 10.
 * 
 * Known bugs: none
 */

import java.util.Scanner;

public class CreditCard
{
    /** This is the main method, num variable is the credit card number, and the total variable checks that
     *  the sum of the evens and odds digit numbers is equally divisible by 10.
     *  A for loop, and if statement, assist in checking that the total variable is equally divisible.
     *  The main method does not return anything, thus it is void.
     */
    public static void main(String[] args)
    {
        // Set up a scanner for input
        Scanner input = new Scanner(System.in);
        int b = 0;
        long total;
        for ( b = 0; b >= 0;)
        { 
            System.out.print("Enter a credit card number as a long integer: ");
            long num = input.nextLong();
            total = sumOfEvensDoubled(num) + sumOfOddPlaces(num);
            if (total % 10 == 0) 
            {
                System.out.println(num + " is a valid number.");
                break;
            }
            else
            {
                System.out.println(num + " is an invalid number.");
            }
        }
    }

    /**
     * This sumofEvensDoubled method helps calculate the total sum variable of
     * all the credit card's evens digits, while doubling each evens digit. 
     * A while loop assists in this method and the remainder variable
     * helps shrink the credit card number to capture all the individual digits.
     * This method returns an integer variable, and has long num as its parameter.
     */
    public static int sumOfEvensDoubled(long num)
    {
        int sum = 0;
        num = num / 10;
        while (num != 0) 
        {
            sum += shrinkToOneDigit((int)((num % 10) * 2));
            num = num / 100;
        }
        return  sum;
    }

    /**
     * This shrinkTooOneDigit method takes the evens' digits sum number calculated in the first step
     * and returns an integer. Its purpose is to return the original value of the parameter
     * if it is a single digit, otherwise it breaks the two digits apart, adds them together,
     * and returns that number. This method returns an integer variable,
     * and has integer num as it's parameter.
     */
    public static int shrinkToOneDigit(int num) 
    {
        if (num <= 9) 
        {
            return num;
        } 
        else if (num > 9)
        {
            return (num % 10 + num / 10);
        }
        return num;
    }

    /**
     * This sumOfOddPlaces method helps calculate the total sum of all the credit card's odds digits. 
     * A while loop assists in this method, and an integer variable is returned. Long num is the parameter.
     */
    public static int sumOfOddPlaces(long num) 
    {
        int sum = 0;
        while (num != 0) 
        {
            sum += (int)(num % 10);
            num = num / 100;
        }
        return sum;
    }
}
