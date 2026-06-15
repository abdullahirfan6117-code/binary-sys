/*Part (a) Write Java program that takes input an integer number and converts it into a  binary number
                 TEST CASES (1) 32 = 10000   (2)   27 = 11011    (3)  26 = 11010
Part (b) Write user defined Java functions to carry out calculation as mentioned in Part (a). This function should take an
integer number as parameter, calculates its binary representation, stores it in an integer array and returns that array of
integers (that contains its binary digits) as return value
Part (c) Write user defined Java functions to carry out calculation as mentioned in Part (a). This function should take an
integer number as parameter, calculates its binary representation, stores these bits in a string and returns that string
(that has its binary digit representation) as return value */

import java.util.Scanner;

public class BinaryConversion
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        // Part (a)
        System.out.println("Part (a): " + num + " in binary = " + Integer.toBinaryString(num));

        // Part (b)
        int[] binaryArray = convertToBinaryArray(num);
        System.out.print("Part (b): Binary array = [");
        for(int i = 0; i < binaryArray.length; i++) {
            System.out.print(binaryArray[i]);
            if(i < binaryArray.length-1) System.out.print(", ");
        }
        System.out.println("]");

        // Part (c)
        String binaryString = convertToBinaryString(num);
        System.out.println("Part (c): Binary string = " + binaryString);

        sc.close();
    }

    // Part (b) - Returns binary digits as integer array
    public static int[] convertToBinaryArray(int n) {
        if(n == 0) return new int[]{0};

        int num = Math.abs(n);
        int temp = num, count = 0;
        while(temp > 0) {
            count++;
            temp /= 2;
        }

        int[] binary = new int[count];
        for(int i = count-1; i >= 0; i--) {
            binary[i] = num % 2;
            num /= 2;
        }
        return binary;
    }

    // Part (c) - Returns binary digits as string
    public static String convertToBinaryString(int n) {
        if(n == 0) return "0";

        StringBuilder sb = new StringBuilder();
        int num = Math.abs(n);

        while(num > 0) {
            sb.insert(0, num % 2);
            num /= 2;
        }

        return sb.toString();
    }
}