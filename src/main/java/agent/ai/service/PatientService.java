package agent.ai.service;

import agent.ai.entity.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PatientService {

    Logger logger = LoggerFactory.getLogger(PatientService.class);

    private final Map<String, Patient> patients = new ConcurrentHashMap<>();

    public Patient save(Patient patient){

        String patientId = "PST-"+System.currentTimeMillis();
        patient.setPatientId(patientId);
        patients.put(patient.getPhoneNumber(), patient);

        logger.info("Patient details successfully saved {}",patient);
        return patient;
    }

    public Patient getPatient(String phone){
        Patient patient = patients.get(phone);
        logger.info("getPatient method call for phone  {},{}",phone,patient);
       return patient;
    }
}
