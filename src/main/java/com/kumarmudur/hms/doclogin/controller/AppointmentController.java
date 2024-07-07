package com.kumarmudur.hms.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kumarmudur.hms.doclogin.entity.Appointment;
import com.kumarmudur.hms.doclogin.repository.AppointmentsRepository;

import javax.management.AttributeNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
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

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {
        Appointment appointment = appointmentsRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Appointment not found with id " + id));
        appointmentsRepository.delete(appointment);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
