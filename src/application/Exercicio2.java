package application;

import model.entity.Account;
import model.exception.BusinessException;
import model.exception.ValidationDomainException;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       try {
           System.out.println("Enter account data");
           System.out.print("Number: ");
           int number = sc.nextInt();
           System.out.print("Holder: ");
           String holder = sc.next();
           System.out.print("Initial balance: ");
           double balance = sc.nextDouble();
           System.out.print("Withdraw limit: ");
           double withdrawLimit = sc.nextDouble();
           Account account = new Account(number,holder,balance,withdrawLimit);

           System.out.println();

           System.out.print("Enter amount for withdraw: ");
           double amount = sc.nextDouble();
           account.withdraw(amount);
           System.out.printf("New balance:  %.2f%n", account.getBalance());
       }catch (BusinessException e ){
           System.out.println("Exception: "+ e.getMessage());
       }catch (RuntimeException e ){
           System.out.println("RuntimeException: "+e);
       }
        sc.close();
    }
}

