package agent.ai.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartBotService {

    Logger logger = LoggerFactory.getLogger(ChartBotService.class);

    private final ChatClient chartClient;

    public ChartBotService(ChatClient chartClient) {
        this.chartClient = chartClient;
    }

    public String appointmentAgent(String query){

        String charmResp = chartClient.prompt(createPromptForBookingAppointment(query))
                //.advisors(a -> a.param(ChatMemory.CONVERSATION_ID, userId))
                .call()
                .content();
        logger.info("Book appointment chart Agent response : {} ",charmResp);
        return charmResp;

    }

    private Prompt createPromptForBookingAppointment(String userInput) {

        SystemMessage systemMessage = new SystemMessage("""
            You are an expert at giving extremely concise answers.
            RULES:
            1. Maximum 3 sentences
            2. No introductory phrases
            3. No concluding remarks
            4. Use bullet points only if explicitly requested
            5. Get straight to the point
            If the question requires more detail, say:
            "Briefly: [concise answer]. For more details, ask specifically."
            """);

        UserMessage userMessage = new UserMessage(userInput);
        return new Prompt(
                List.of(systemMessage, userMessage),
                ChatOptions.builder()
                        .maxTokens(300)           // Hard limit
                        .temperature(0.3)         // Less creative, more focused
                        .topP(0.8)                // Narrower word selection
                        .build()
        );
    }
}
