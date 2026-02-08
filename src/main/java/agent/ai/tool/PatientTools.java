package agent.ai.tool;

import agent.ai.entity.Appointment;
import agent.ai.entity.Patient;
import agent.ai.service.AppointmentService;
import agent.ai.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PatientTools {

    Logger logger = LoggerFactory.getLogger(PatientTools.class);

    private final AppointmentService appointmentService;

    private final PatientService patientService;

    public PatientTools(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }

    //Tool : add Patient details
    @Tool(name = "addPatient",description = "Create a new patient record. Use only when the patient does not already exist.")
    public Patient addPatient(@ToolParam(description = "Patient details") Patient patient){

        logger.info("add Patient details {}",patient);
        return patientService.save(patient);
    }

    //Tool : get Patient detail by phone number
    @Tool(name = "getPatient",description = "Retrieve patient details using the registered phone number.")
    public Patient getPatient(@ToolParam(description = "phoneNumber") String phoneNumber){

        Patient patient  = patientService.getPatient(phoneNumber);
        logger.info("getPatient details by phone number {}",patient);

        return patient;
    }

    //Tool : Book Appointment
    @Tool(name = "bookAppointment",description = "Schedule a medical appointment for a patient. Requires a registered phone number and appointment date in the format yyyy-MM-dd h a (e.g., 2026-02-09 10 AM).")
    public Map<String, Object> bookAppointment(@ToolParam(description = "appointment details") Appointment appointment){

        logger.info("Book appointment details {}",appointment);

        return appointmentService.bookAppointments(appointment);
    }

}
