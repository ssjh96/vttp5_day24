package vttp5.paf.day24.model;

public class ReservationDetail 
{
    // Auto incr in db
    private int id;
    
    // when read in the reservation, we want to store the whole book obj? other way is link by bookId
    // must be a valid book record
    private Book book;

    // to link back to the reservation table, got other ways tooo
    // no info on create new
    private Reservation reservation;

    public ReservationDetail() {
    }

    public ReservationDetail(int id, Book book, Reservation reservation) {
        this.id = id;
        this.book = book;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    
}
