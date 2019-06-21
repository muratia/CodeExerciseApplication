package com.nielsensport.CodeExcercise.repository;

import com.nielsensport.CodeExcercise.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    /**
     * This method returns the list of the appointments between two dates and the tuples are ordered by price ascending
     * @param startDate
     * @param endDate
     * @return java.util.List<Appointment>
     */
    List<Appointment> findByDateGreaterThanEqualAndDateLessThanEqualOrderByPriceAsc(Date startDate, Date endDate);

}
