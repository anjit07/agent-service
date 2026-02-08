package agent.ai.rest;

import agent.ai.service.ChartBotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chart-boot")
public class ChartBotController {

    private final ChartBotService chartBotService;

    public ChartBotController(ChartBotService chartBotService) {
        this.chartBotService = chartBotService;
    }

    @GetMapping(value = "/appointment-agent")
    public ResponseEntity<String> chart(@RequestParam String query){

        return ResponseEntity.ok(chartBotService.appointmentAgent(query));
    }
}
