package vttp5.paf.day24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp5.paf.day24.model.Reservation;
import vttp5.paf.day24.model.ReservationDetail;
import vttp5.paf.day24.repository.ReservationRepo;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepo reservationRepo;

    @Transactional
    public boolean createReservationRecord(Reservation reservation, ReservationDetail reservationDetail)
    {
        Boolean bCreated = false;
        // start transaction
        // already in transaction based on the @Transactional annotation?

        // create the reservation record
        int iReservationId = reservationRepo.createReservation(reservation);

        // uncommment to simulate error
        // throw new IllegalArgumentException("Simulate error after creating reservation...");

        // created the reservation detail record
        reservationDetail.getReservation().setId(iReservationId);
        reservationRepo.createReservationDetails(reservationDetail);

        // uncommment to simulate error
        // throw new IllegalArgumentException("Simulate error after creating reservation details...");

        // commit transaction
        // auto commited because already annoted with @Transactional

        bCreated = true;
        
        return bCreated;
    }
}
