package com.ramawadh.learning.hotelroomreservation;

import com.ramawadh.learning.hotelroomreservation.data.entity.Guest;
import com.ramawadh.learning.hotelroomreservation.data.entity.Reservation;
import com.ramawadh.learning.hotelroomreservation.data.entity.Room;
import com.ramawadh.learning.hotelroomreservation.data.repository.GuestRepository;
import com.ramawadh.learning.hotelroomreservation.data.repository.ReservationRepository;
import com.ramawadh.learning.hotelroomreservation.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HotelRoomReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelRoomReservationApplication.class, args);
    }

    @RestController
    @RequestMapping("/rooms")
    public class RoomController {
        @Autowired
        private RoomRepository roomRepository;

        @GetMapping
        public Iterable<Room> getRooms() {
            return this.roomRepository.findAll();
        }
    }

    @RestController
    @RequestMapping("/guests")
    public class GuestController {
        @Autowired
        private GuestRepository guestRepository;

        @GetMapping
        public Iterable<Guest> getRooms() {
            return this.guestRepository.findAll();
        }
    }

    @RestController
    @RequestMapping("/reservations")
    public class ReservationController {
        @Autowired
        private ReservationRepository reservationRepository;

        @GetMapping
        public Iterable<Reservation> getRooms() {
            return this.reservationRepository.findAll();
        }
    }

}
