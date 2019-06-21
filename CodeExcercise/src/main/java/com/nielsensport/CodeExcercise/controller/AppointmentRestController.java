package com.nielsensport.CodeExcercise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nielsensport.CodeExcercise.model.Appointment;
import com.nielsensport.CodeExcercise.service.AppointmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * This class is the Rest Controller for the Appointments
 * The
 */
@RestController
@RequestMapping(value = "{API_URL}")
public class AppointmentRestController {

    public static Logger log = Logger.getLogger (AppointmentRestController.class.getName ());

    @Autowired
    private AppointmentService service;


    @RequestMapping(value = "{appointments_URL}", method = RequestMethod.GET, produces = "application/json")
    public List<Appointment> getAppointments() {
        return service.all ();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @RequestMapping(value = "{delete_URL}", method = RequestMethod.DELETE)
    public void doDelete(
            @RequestParam(value = "id", required = true) Optional<Long> id)

            throws Exception {

        if (id.isPresent ()) {
            Appointment appointment = service.get (id.get ());
            service.delete (appointment);
            return;
        }
        throw new MissingServletRequestParameterException ("id", "Parameter is missing");
    }


    @RequestMapping(value = "{appointments-add-URL}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity add(@RequestParam(value = "appointment", required = true) String appointment)

            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper ();
        Appointment app = objectMapper.readValue (appointment, Appointment.class);
        app.setId (0l);

        Boolean res = service.add (app);

        if (res) {
            return new ResponseEntity (HttpStatus.OK);
        } else
            return new ResponseEntity (HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "{appointments-bydates-URL}", method = RequestMethod.GET, produces = "application/json")
    public List<Appointment> getAppointmentsBetweenDatesAndSortByPriceAsc(

            @RequestParam(name = "startDate") String startDate,
            @RequestParam(name = "endDate") String endDate) throws ParseException {
        DateFormat df = new SimpleDateFormat ("yyyy-dd-MM hh:mm:ss");

        Date date1 = df.parse (startDate);
        Date date2 = df.parse (endDate);
        List<Appointment> appointments = service.loadsByDateBetweenDateAndSortedByPrice (date1, date2);
        return appointments;
    }

    @RequestMapping(value = "{appointments-updateStatus_URL}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity updateAppointmentStatus(@RequestParam(name = "id") Long id,
                                                  @RequestParam(name = "status") Boolean status) {
        Boolean res =service.updateStatus (id, status);
        if (res) {
            return new ResponseEntity (HttpStatus.OK);
        } else
            return new ResponseEntity (HttpStatus.NOT_FOUND);
    }
}
