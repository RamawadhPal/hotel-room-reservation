package com.ramawadh.learning.hotelroomreservation.data.repository;

import com.ramawadh.learning.hotelroomreservation.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
