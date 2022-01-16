package application;

import model.entity.Reservation;
import model.exception.ValidationDomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyyy");

       try{
           System.out.print("Room number: ");
           int room = sc.nextInt();
           System.out.print("Check-in date (dd/MM/yyyy): ");
           Date checkin = sdf.parse(sc.next());
           System.out.print("Check-out date (dd/MM/yyyy): ");
           Date checkout = sdf.parse(sc.next());
           Reservation reservation = new Reservation(room,checkin,checkout);
           System.out.println("Reservation: "+reservation);

           System.out.println();

           System.out.println("Enter data to update the reservation:");
           System.out.print("Check-in date (dd/MM/yyyy): ");
           checkin = sdf.parse(sc.next());
           System.out.print("Check-in date (dd/MM/yyyy): ");
           checkout = sdf.parse(sc.next());
           reservation.updateDates(checkin,checkout);
           System.out.println("Reservation: "+reservation);
       }catch (ValidationDomainException | ParseException e){
           System.out.println(e.getMessage());
       }

        sc.close();
    }
}
