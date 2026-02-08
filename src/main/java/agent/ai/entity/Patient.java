package agent.ai.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Patient {

    private String patientId;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;


}
