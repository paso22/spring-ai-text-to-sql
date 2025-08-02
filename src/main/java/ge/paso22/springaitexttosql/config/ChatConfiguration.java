package ge.paso22.springaitexttosql.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ChatConfiguration {

  @Bean
  PromptTemplate systemPromptTemplate(
      @Value("classpath:/data/system-prompt.txt") Resource systemPrompt,
      @Value("classpath:/db/create-tables.sql") Resource createTableScript) {
    PromptTemplate promptTemplate = new PromptTemplate(systemPrompt);
    promptTemplate.add("ddl", createTableScript);
    return promptTemplate;
  }

  @Bean
  ChatClient chatClient(ChatClient.Builder builder, PromptTemplate systemPrompt) {
    return builder.defaultSystem(systemPrompt.render()).build();
  }
}
