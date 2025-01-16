package vttp5.paf.day24.model;

import java.sql.Date;

// if saving to sql date, automap the date to db
// if use util date need convert to localdate first

public class Reservation 
{
    private int id;
    private String name;
    private Date reservationDate;
    
    public Reservation() {
    }
    
    public Reservation(int id, String name, Date reservationDate) {
        this.id = id;
        this.name = name;
        this.reservationDate = reservationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    
}
