package vttp5.paf.day24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp5.paf.day24.model.ReservationDetail;
import vttp5.paf.day24.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController 
{
    @Autowired
    ReservationService reservationService;

    @PostMapping("")
    public ResponseEntity<Boolean> makeReservation(@RequestBody ReservationDetail reservation) {
        Boolean bCreated = reservationService.createReservationRecord(reservation.getReservation(), reservation);
        
        return ResponseEntity.ok().body(bCreated);
    }    
}
