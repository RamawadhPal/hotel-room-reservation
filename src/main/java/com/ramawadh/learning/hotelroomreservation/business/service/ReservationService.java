package com.ramawadh.learning.hotelroomreservation.business.service;

import com.ramawadh.learning.hotelroomreservation.business.domain.RoomReservation;
import com.ramawadh.learning.hotelroomreservation.data.entity.Guest;
import com.ramawadh.learning.hotelroomreservation.data.entity.Reservation;
import com.ramawadh.learning.hotelroomreservation.data.entity.Room;
import com.ramawadh.learning.hotelroomreservation.data.repository.GuestRepository;
import com.ramawadh.learning.hotelroomreservation.data.repository.ReservationRepository;
import com.ramawadh.learning.hotelroomreservation.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, ReservationRepository reservationRepository, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
    }

    public List<RoomReservation> getRoomReservationForDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });
        List<RoomReservation> roomReservationList = new ArrayList<>();
        for (Long id: roomReservationMap.keySet()){
            roomReservationList.add(roomReservationMap.get(id));
        }
        return roomReservationList;
    }
}
