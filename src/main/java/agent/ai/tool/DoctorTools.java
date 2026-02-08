package agent.ai.tool;

import agent.ai.entity.Doctor;
import agent.ai.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorTools {

    Logger logger = LoggerFactory.getLogger(DoctorTools.class);

    private final DoctorService doctorService;

    public DoctorTools(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Tool(name = "getDoctors",description = "Retrieve the list of available doctors. Use this tool before booking an appointment so the user can choose a doctor.")
    public List<Doctor> addPatient(){

        logger.info("calls getDoctors tools ..!");
        return doctorService.getDoctors();
    }
}
