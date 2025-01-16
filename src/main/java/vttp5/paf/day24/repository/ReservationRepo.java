package vttp5.paf.day24.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import vttp5.paf.day24.model.Reservation;
import vttp5.paf.day24.model.ReservationDetail;
import vttp5.paf.day24.util.Queries;

@Repository
public class ReservationRepo
{
    @Autowired
    JdbcTemplate template;

    public int createReservation(Reservation reservation)
    {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException 
            {
                PreparedStatement ps = con.prepareStatement(Queries.insertReservationSQL, new String[]{"id"});

                ps.setString(1, reservation.getName());
                ps.setDate(2, reservation.getReservationDate()); // using sql date

                return ps;
            }
            
        };

        template.update(psc, keyHolder);

        // pri key is in keyholder, so 

        //return the primary key stored in the reference variable KeyHolder of the parameter template.update
        int iReservationId = keyHolder.getKey().intValue();

        return iReservationId;
    }

    public Boolean createReservationDetails(ReservationDetail reservationDetails) // can split to 2 repo too, but if split thn need to autowired 2 repo in the service layer
    {
        // note that this way cannot return you an array for the batch update in slides, this one is one by one?
        int iUpdated = template.update(Queries.insertReservationDetailsSQL, reservationDetails.getBook().getId(), reservationDetails.getReservation().getId());

        if (iUpdated>0)
        {
            return true;
        }
        return false;
    }
    
    
}
