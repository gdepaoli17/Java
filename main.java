/**     This is the Pay Calculator Program
 Gino De Paoli
 CPT 307 Data Structures & Algorithms
 8/23/2021
 */

package com.ginodepaoli;

import java.util.Scanner;

public class Main {

    static double grossPay (float pay, byte hours){
        if (hours < 40){
            return pay * 40;
        } else{
            return ((hours - 40) * (pay * 1.5)) + (40 * pay);
        }

    }

    static double deductions(float pay) {
        final float fedTax = .15F;
        final float stateTax = .0307F;
        final float medicare = .0145F;
        final float socialSecurity = .062F;
        final float unemploymentInsurance = .0007F;

        double fedDuct = fedTax * pay;
        double stateDuct = stateTax * pay;
        double medDuct = medicare * pay;
        double sSDuct = socialSecurity * pay;
        double unIDuct = unemploymentInsurance * pay;

        return (fedDuct + stateDuct + medDuct + sSDuct + unIDuct);
    }

    static double netIncome(float gross, double deductions){
        return gross - deductions;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        final String employeeName = scanner.nextLine();

        System.out.println("Enter your rate of pay: ");
        final double rateOfPay = scanner.nextFloat();

        System.out.println("Enter your hours worked for the week: ");
        final byte hoursWorked = scanner.nextByte();
        byte overTime = 0;
        if (hoursWorked >= 41){
            overTime = (byte) (hoursWorked - 40);
        }

        double grossIncome = grossPay((float) rateOfPay, hoursWorked);
        double totalDeductions = deductions((float) rateOfPay);
        double netPay = netIncome((float) grossIncome, totalDeductions);

        System.out.println("Your name is: " + employeeName);
        System.out.println("Your rate of pay is: " + rateOfPay);
        System.out.println("The hours your worked this week are: " + hoursWorked);
        System.out.println("Your overtime hours your worked this week are: " + overTime);
        System.out.println("Your gross income is: " + grossIncome);
        System.out.println("The total amount of deductions are: " + totalDeductions);
        System.out.println("Your total net pay is: " + netPay);

        scanner.close();
    }
}
