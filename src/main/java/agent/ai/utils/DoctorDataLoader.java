package agent.ai.utils;

import agent.ai.entity.Doctor;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorDataLoader {

    private final List<Doctor> doctors = new ArrayList<>();

    public List<Doctor> getDoctors(){

        return doctors;
    }

    @PostConstruct
    private void init() {
        doctors.addAll(List.of(
                // 1. Gynecologist
                Doctor.builder()
                        .doctorId("DOC101")
                        .name("Dr. Mandakini Kumari")
                        .availability(List.of(
                                new Doctor.TimeSlot(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(18, 0)),
                                new Doctor.TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(18, 0)),
                                new Doctor.TimeSlot(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(15, 0)),
                                new Doctor.TimeSlot(DayOfWeek.SATURDAY, LocalTime.of(9, 0), LocalTime.of(13, 0))
                        ))
                        .profile("MBBS, MD (Obstetrics and Gynaecology), PG Diploma in Sonography - Obstetrics and Gynecology specialist with 12 years experience")
                        .build(),

                // 2. Cardiologist
                Doctor.builder()
                        .doctorId("DOC102")
                        .name("Dr. Rajesh Sharma")
                        .availability(List.of(
                                new Doctor.TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(9, 30), LocalTime.of(17, 30)),
                                new Doctor.TimeSlot(DayOfWeek.THURSDAY, LocalTime.of(9, 30), LocalTime.of(17, 30)),
                                new Doctor.TimeSlot(DayOfWeek.FRIDAY, LocalTime.of(9, 30), LocalTime.of(14, 30)),
                                new Doctor.TimeSlot(DayOfWeek.SATURDAY, LocalTime.of(10, 0), LocalTime.of(14, 0))
                        ))
                        .profile("MBBS, MD (General Medicine), DM (Cardiology) - Senior Interventional Cardiologist with 15 years experience")
                        .build(),

                // 3. Pediatrician
                Doctor.builder()
                        .doctorId("DOC103")
                        .name("Dr. Priya Patel")
                        .availability(List.of(
                                new Doctor.TimeSlot(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(17, 0)),
                                new Doctor.TimeSlot(DayOfWeek.WEDNESDAY, LocalTime.of(9, 0), LocalTime.of(17, 0)),
                                new Doctor.TimeSlot(DayOfWeek.FRIDAY, LocalTime.of(9, 0), LocalTime.of(17, 0)),
                                new Doctor.TimeSlot(DayOfWeek.SUNDAY, LocalTime.of(10, 0), LocalTime.of(13, 0))
                        ))
                        .profile("MBBS, MD (Pediatrics), DCH - Neonatology and Child Healthcare specialist with 10 years experience")
                        .build(),

                // 4. Orthopedic Surgeon
                Doctor.builder()
                        .doctorId("DOC104")
                        .name("Dr. Vikram Singh")
                        .availability(List.of(
                                new Doctor.TimeSlot(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(16, 0)),
                                new Doctor.TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(8, 0), LocalTime.of(16, 0)),
                                new Doctor.TimeSlot(DayOfWeek.THURSDAY, LocalTime.of(8, 0), LocalTime.of(16, 0)),
                                new Doctor.TimeSlot(DayOfWeek.SATURDAY, LocalTime.of(9, 0), LocalTime.of(13, 0))
                        ))
                        .profile("MBBS, MS (Orthopedics), MCh (Orthopedic Surgery) - Joint Replacement and Sports Injury specialist")
                        .build(),

                // 5. Ayurvedic Doctor
                Doctor.builder()
                        .doctorId("DOC105")
                        .name("Dr. Anjali Gupta")
                        .availability(List.of(
                                new Doctor.TimeSlot(DayOfWeek.MONDAY, LocalTime.of(9, 30), LocalTime.of(18, 30)),
                                new Doctor.TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(9, 30), LocalTime.of(18, 30)),
                                new Doctor.TimeSlot(DayOfWeek.THURSDAY, LocalTime.of(9, 30), LocalTime.of(18, 30)),
                                new Doctor.TimeSlot(DayOfWeek.FRIDAY, LocalTime.of(9, 30), LocalTime.of(14, 30))
                        ))
                        .profile("BAMS, MD (Ayurveda), PG Diploma in Panchakarma - Ayurvedic physician specializing in chronic diseases and wellness")
                        .build(),

                // 6. Dermatologist
                Doctor.builder()
                        .doctorId("DOC106")
                        .name("Dr. Arjun Reddy")
                        .availability(List.of(
                                new Doctor.TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(11, 0), LocalTime.of(19, 0)),
                                new Doctor.TimeSlot(DayOfWeek.WEDNESDAY, LocalTime.of(11, 0), LocalTime.of(19, 0)),
                                new Doctor.TimeSlot(DayOfWeek.THURSDAY, LocalTime.of(11, 0), LocalTime.of(19, 0)),
                                new Doctor.TimeSlot(DayOfWeek.SATURDAY, LocalTime.of(10, 0), LocalTime.of(16, 0))
                        ))
                        .profile("MBBS, MD (Dermatology), DVD - Cosmetic Dermatology and Skin Allergy specialist with 8 years experience")
                        .build(),

                // 7. ENT Specialist
                Doctor.builder()
                        .doctorId("DOC107")
                        .name("Dr. Sunita Desai")
                        .availability(List.of(
                                new Doctor.TimeSlot(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(17, 0)),
                                new Doctor.TimeSlot(DayOfWeek.WEDNESDAY, LocalTime.of(9, 0), LocalTime.of(17, 0)),
                                new Doctor.TimeSlot(DayOfWeek.FRIDAY, LocalTime.of(9, 0), LocalTime.of(17, 0)),
                                new Doctor.TimeSlot(DayOfWeek.SUNDAY, LocalTime.of(9, 30), LocalTime.of(12, 30))
                        ))
                        .profile("MBBS, MS (ENT), DLO - Ear, Nose and Throat specialist with expertise in endoscopic surgeries")
                        .build(),

                // 8. Psychiatrist
                Doctor.builder()
                        .doctorId("DOC108")
                        .name("Dr. Rohan Mehra")
                        .availability(List.of(
                                new Doctor.TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(20, 0)),
                                new Doctor.TimeSlot(DayOfWeek.WEDNESDAY, LocalTime.of(14, 0), LocalTime.of(20, 0)),
                                new Doctor.TimeSlot(DayOfWeek.THURSDAY, LocalTime.of(14, 0), LocalTime.of(20, 0)),
                                new Doctor.TimeSlot(DayOfWeek.SATURDAY, LocalTime.of(10, 0), LocalTime.of(16, 0))
                        ))
                        .profile("MBBS, MD (Psychiatry), DPM - Clinical Psychiatrist specializing in anxiety, depression and relationship counseling")
                        .build(),

                // 9. Ophthalmologist
                Doctor.builder()
                        .doctorId("DOC109")
                        .name("Dr. Kavita Nair")
                        .availability(List.of(
                                new Doctor.TimeSlot(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(18, 0)),
                                new Doctor.TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(18, 0)),
                                new Doctor.TimeSlot(DayOfWeek.FRIDAY, LocalTime.of(10, 0), LocalTime.of(18, 0)),
                                new Doctor.TimeSlot(DayOfWeek.SUNDAY, LocalTime.of(9, 0), LocalTime.of(13, 0))
                        ))
                        .profile("MBBS, MS (Ophthalmology), FRCS - Cataract and Refractive Surgery specialist with 12 years experience")
                        .build(),

                // 10. General Physician
                Doctor.builder()
                        .doctorId("DOC110")
                        .name("Dr. Sanjay Kumar")
                        .availability(List.of(
                                new Doctor.TimeSlot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(19, 30)),
                                new Doctor.TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(8, 30), LocalTime.of(19, 30)),
                                new Doctor.TimeSlot(DayOfWeek.WEDNESDAY, LocalTime.of(8, 30), LocalTime.of(19, 30)),
                                new Doctor.TimeSlot(DayOfWeek.THURSDAY, LocalTime.of(8, 30), LocalTime.of(19, 30)),
                                new Doctor.TimeSlot(DayOfWeek.FRIDAY, LocalTime.of(8, 30), LocalTime.of(16, 30)),
                                new Doctor.TimeSlot(DayOfWeek.SATURDAY, LocalTime.of(9, 0), LocalTime.of(15, 0))
                        ))
                        .profile("MBBS, MD (General Medicine) - Senior Physician with 20 years experience in general medicine and diabetes care")
                        .build()
        ));
    }

}
