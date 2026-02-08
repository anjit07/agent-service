package agent.ai.config;

import agent.ai.tool.DoctorTools;
import agent.ai.tool.PatientTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChatClientConfig {

    Logger logger = LoggerFactory.getLogger(ChatClientConfig.class);

    /*
    @Bean
    public ChatClient chatClient(ChatMemory chatMemory, ChatClient.Builder builder, PatientTools patientTools, DoctorTools doctorTools) {
        MessageChatMemoryAdvisor messageChatMemoryAdvisor= MessageChatMemoryAdvisor.builder(chatMemory).build();
        return builder.defaultSystem("""
                        You are a hospital virtual assistant.
                        Rules:
                        - Use tools for booking and availability.
                        - Never give medical diagnosis.
                        - If unsure, recommend consulting a doctor.
                        - Be calm and empathetic.
                        """)
        .defaultTools(patientTools,doctorTools).build();
    }
     */


    @Bean
    public ChatClient chatClientAgent(ChatMemory chatMemory,
                                      ChatModel chatModel,
                                      DoctorTools doctorTools,
                                      PatientTools patientTools) {

        logger.info("## Build chart client Agent ## : {}",chatMemory.getClass().getName());

        MessageChatMemoryAdvisor messageChatMemoryAdvisor= MessageChatMemoryAdvisor.builder(chatMemory).build();
        return ChatClient.builder(chatModel)
                .defaultAdvisors(messageChatMemoryAdvisor,new SimpleLoggerAdvisor())
                .defaultTools(doctorTools,patientTools)
                .build();
    }


}
