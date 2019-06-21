package com.nielsensport.CodeExcercise.service.impl;

import com.nielsensport.CodeExcercise.model.Appointment;
import com.nielsensport.CodeExcercise.repository.AppointmentRepository;
import com.nielsensport.CodeExcercise.service.AppointmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *  Implementation of the Service
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    /**
     *  Logger
     */
    public static Logger log = Logger.getLogger (AppointmentServiceImpl.class.getName ());

    /**
     * Declaration of the AppointmentRepository
     */
    private final AppointmentRepository repo;


    /**
     * Constructor of the Service Implementation
     * @param _repo The repository of the application to be invoked using autowire tag
     */
    @Autowired
    public AppointmentServiceImpl(AppointmentRepository _repo) {
        this.repo = _repo;
    }

    /**
     * Returns all the appointments stored in the database
     * @return java.util.List<Appointment>
     */
    @Override
    public List<Appointment> all() {

        List<Appointment> appointments = repo.findAll ();
        return appointments;
    }
    /**
     * Deletes the given appointment
     * @param appointment Appointment
     */
    @Override
    public void delete(Appointment appointment) {
        repo.delete (appointment);
    }

    /**
     * Returns the appointment based on the given id of the appointment
     * @param id - Long, the id of the tuple
     * @return Appointment
     */
    @Override
    public Appointment get(Long id) {
        return repo.findById (id).get ();
    }

    /**
     * Stores the given appointment into the database
     * @param appointment Appointment
     * @return Boolean, true in case if the data are stored
     */
    @Override
    public Boolean add(Appointment appointment) {
        Appointment app = repo.save (appointment);
        System.err.println (app);
        return app.getId () > -1 ? true : false;
    }

    /**
     * Updates the status of the given id of the appointment
     * @param id - Long, the id of the Appointment tuple
     * @param status Status that is going to be put into the Status field of the tuple and saved
     * @return Boolean, true if data are stored otherwise false
     */
    @Override
    public Boolean updateStatus(Long id, Boolean status) {
        Appointment app = repo.findById (id).get ();
        app.setStatus (status);
        Appointment resI = repo.saveAndFlush (app);

        if (resI.getId () > 0) {
           return true;
        }
        return false;
    }

    /**
     *  This method loads the appointments between two dates and sorts then by price ascending
     * @param date1 java.util.Date
     * @param date2 java.util.Date
     * @return java.util.List<Appointment>
     */
    @Override
    public List<Appointment> loadsByDateBetweenDateAndSortedByPrice(Date startDate, Date endDate) {
        log.info ("Start date: " + startDate + " | End date: " + endDate);
        List<Appointment> apps = repo.findByDateGreaterThanEqualAndDateLessThanEqualOrderByPriceAsc (startDate, endDate);
        log.info (apps);
        return apps;
    }
}
