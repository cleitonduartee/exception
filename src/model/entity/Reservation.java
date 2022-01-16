package model.entity;

import model.exception.ValidationDomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkin, Date checkout)  {
        this.validaDates(checkin,checkout);
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }
    public void updateDates(Date checkin,  Date checkout) {
        this.validaDates(checkin,checkout);
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public void validaDates(Date checkin, Date checkout)  {
        Date now = new Date();
        if(checkin.before(now) || checkout.before(now)){
            throw new ValidationDomainException("Error in reservation: Reservation dates for update must be future dates");
        }
        if(!checkout.after(checkin)){
            throw new ValidationDomainException("Error in reservation: Check-out date must be after check-in date");
        }
    }

    @Override
    public String toString() {

        return  "Room "
                + roomNumber
                +", check-in: "
                + sdf.format(checkin)
                +", check-out: "
                + sdf.format(checkout)
                +", "
                +this.duration()
                +" nights";
    }
}

