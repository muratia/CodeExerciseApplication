package com.nielsensport.CodeExcercise.service;

import com.nielsensport.CodeExcercise.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *  This is the service that offers several methods
 */
@Service
public interface AppointmentService {

    /**
     * Returns all the appointments stored in the database
     * @return java.util.List<Appointment>
     */
    List<Appointment> all();

    /**
     * Deletes the given appointment
     * @param appointment Appointment
     */
    void delete(Appointment appointment);

    /**
     * Returns the appointment based on the given id of the appointment
     * @param id - Long, the id of the tuple
     * @return Appointment
     */
    Appointment get(Long id);

    /**
     * Stores the given appointment into the database
     * @param appointment Appointment
     * @return Boolean, true in case if the data are stored
     */
    Boolean add(Appointment appointment);

    /**
     * Updates the status of the given id of the appointment
     * @param id - Long, the id of the Appointment tuple
     * @param status Status that is going to be put into the Status field of the tuple and saved
     * @return Boolean, true if data are stored otherwise false
     */
    Boolean updateStatus(Long id, Boolean status);

    /**
     *  This method loads the appointments between two dates and sorts then by price ascending
     * @param date1 java.util.Date
     * @param date2 java.util.Date
     * @return java.util.List<Appointment>
     */
    List<Appointment> loadsByDateBetweenDateAndSortedByPrice(Date date1, Date date2);
}
