package Games;

import java.util.Scanner;

public class ECD_Game  {
    public static double GCD(double num1,double num2){
        if(num2==0)
            return num1;
        else
            return GCD(num2, num1 % num2);

    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println(" Enter two numbers: ");
        int num1=read.nextInt();
        int num2=read.nextInt();
        System.out.println("GCD: "+GCD(num1,num2));

        if(num1/GCD(num1,num2)%2!=0){
            System.out.println("First player wins ");
        }
        else
            System.out.println(" Second player wins");
    }
}
