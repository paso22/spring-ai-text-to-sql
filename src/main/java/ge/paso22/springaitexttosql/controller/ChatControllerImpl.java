package ge.paso22.springaitexttosql.controller;

import ge.paso22.springaitexttosql.domain.Player;
import ge.paso22.springaitexttosql.domain.QueryResponse;
import ge.paso22.springaitexttosql.exception.InvalidQueryException;
import ge.paso22.springaitexttosql.service.PlayerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatControllerImpl implements ChatController {

  private final ChatClient chatClient;

  private final PlayerService playerService;

  @Override
  public ResponseEntity<QueryResponse> getRequestedQueryData(String query) {
    String generatedQuery = chatClient.prompt().user(query).call().content();
    if (generatedQuery != null && !generatedQuery.startsWith("SELECT")) {
      throw new InvalidQueryException(generatedQuery);
    }
    log.info("Generated query: {}", generatedQuery);
    List<?> players = playerService.findAll(generatedQuery);
    return ResponseEntity.ok(new QueryResponse(players));
  }

  @Override
  public List<Player> findAllPlayers() {
    return playerService.findAll();
  }
}
