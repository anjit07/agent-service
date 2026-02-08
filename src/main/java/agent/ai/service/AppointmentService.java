package agent.ai.service;


import agent.ai.entity.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

@Service
public class AppointmentService {

    Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    final Map<String, List<Map<String, Object>>> appointments = new HashMap<>();


    public Map<String, Object> bookAppointments(Appointment appointment){

        String appointmentId = "APT-" + System.currentTimeMillis();

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("yyyy-MM-dd h a") //"2026-02-09 10 am";
                .toFormatter(Locale.ENGLISH);

        LocalDateTime ldt = LocalDateTime.parse(appointment.getAppointmentTime(), formatter);

        Map<String, Object> bookAppointment = new HashMap<>();
        bookAppointment.put("appointmentId", appointmentId);
        bookAppointment.put("patientId", appointment.getPatientId());
        bookAppointment.put("scheduledTime",ldt);
        bookAppointment.put("reason", appointment.getReason());
        bookAppointment.put("doctorId", appointment.getDoctorId() != null ? appointment.getDoctorId() : "AUTO_ASSIGN");
        bookAppointment.put("doctorName",appointment.getDoctorName());
        bookAppointment.put("status", "SCHEDULED");
        bookAppointment.put("instructions", "Arrive 15 minutes early with insurance card and ID");

        appointments.computeIfAbsent(appointment.getPatientId(), k -> new ArrayList<>()).add(bookAppointment);

        return Map.of(
                "success", true,
                "appointmentId", appointmentId,
                "scheduledTime", appointment.getAppointmentTime(),
                "doctorName", appointment.getDoctorName()
        );
    }

    /*
    public Map<String, Object> bookAppointments(String patientId, LocalDateTime preferredDateTime,
                                                String department, String reason, String doctorId){

        String appointmentId = "APT-" + System.currentTimeMillis();

        Map<String, Object> appointment = new HashMap<>();
        appointment.put("appointmentId", appointmentId);
        appointment.put("patientId", patientId);
        appointment.put("scheduledTime", preferredDateTime.toString());
        appointment.put("department", department);
        appointment.put("reason", reason);
        appointment.put("doctorId", doctorId != null ? doctorId : "AUTO_ASSIGN");
        appointment.put("status", "SCHEDULED");
        appointment.put("instructions", "Arrive 15 minutes early with insurance card and ID");

        appointments.computeIfAbsent(patientId, k -> new ArrayList<>()).add(appointment);


        return Map.of(
                "success", true,
                "appointmentId", appointmentId,
                "scheduledTime", preferredDateTime.toString(),
                "department", department,
                "doctorAssigned", doctorId != null ? doctorId : "To be assigned"
        );
    }

     */


}
