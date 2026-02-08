package agent.ai.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Doctor {
    private String doctorId;
    private String name;
    private List<TimeSlot> availability;
    private String profile;

    @Data
    @Builder
    @AllArgsConstructor
    public static class TimeSlot {
        private DayOfWeek day;
        private LocalTime startTime;
        private LocalTime endTime;

        public TimeSlot(String day, String time) {
            this.day = DayOfWeek.valueOf(day.toUpperCase());
            this.startTime = LocalTime.parse(time);
            this.endTime = startTime.plusHours(1);
        }
    }
}
