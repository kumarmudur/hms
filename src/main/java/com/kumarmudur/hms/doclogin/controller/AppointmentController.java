package com.kumarmudur.hms.doclogin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.kumarmudur.hms.doclogin.entity.Appointment;
import com.kumarmudur.hms.doclogin.repository.AppointmentsRepository;

@RestController
@RequestMapping("/api/v2")
public class AppointmentController {

    AppointmentsRepository appointmentsRepository;

    public AppointmentController(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    @PostMapping("/insert")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentsRepository.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentsRepository.findAll();
    }
}
