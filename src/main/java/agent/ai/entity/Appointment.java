package agent.ai.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Appointment {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String doctorName;
    private String appointmentTime;
    private String reason;
    private String status; // SCHEDULED, COMPLETED, CANCELLED, RESCHEDULED
    private String notes;
}
