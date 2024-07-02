package com.kumarmudur.hms.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumarmudur.hms.doclogin.entity.Appointment;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Long> {

}
