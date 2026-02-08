package agent.ai.service;

import agent.ai.entity.Doctor;
import agent.ai.utils.DoctorDataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    Logger logger = LoggerFactory.getLogger(DoctorService.class);

    private final DoctorDataLoader doctorDataLoader;

    public DoctorService(DoctorDataLoader doctorDataLoader) {
        this.doctorDataLoader = doctorDataLoader;
    }

    public List<Doctor> getDoctors(){

        List<Doctor> list = doctorDataLoader.getDoctors();
        logger.info(" getDoctors list size {}",list.size());
        return list;
    }
}
