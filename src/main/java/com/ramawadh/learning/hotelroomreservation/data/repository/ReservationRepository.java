package com.ramawadh.learning.hotelroomreservation.data.repository;

import com.ramawadh.learning.hotelroomreservation.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    public Iterable<Reservation> findReservationByReservationDate(Date date);
}
