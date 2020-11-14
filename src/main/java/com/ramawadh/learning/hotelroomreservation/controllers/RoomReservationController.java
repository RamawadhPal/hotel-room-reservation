package com.ramawadh.learning.hotelroomreservation.controllers;

import com.ramawadh.learning.hotelroomreservation.business.domain.RoomReservation;
import com.ramawadh.learning.hotelroomreservation.business.service.ReservationService;
import com.ramawadh.learning.hotelroomreservation.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
public class RoomReservationController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestParam(name = "date", required = false)String dateString) {
        Date date = DateUtils.createDateFromString(dateString);
        return this.reservationService.getRoomReservationForDate(date);
    }
}
