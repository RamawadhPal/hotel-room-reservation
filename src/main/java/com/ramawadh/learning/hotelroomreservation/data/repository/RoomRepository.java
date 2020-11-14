package com.ramawadh.learning.hotelroomreservation.data.repository;

import com.ramawadh.learning.hotelroomreservation.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
