package ge.paso22.springaitexttosql.controller;

import ge.paso22.springaitexttosql.domain.Player;
import ge.paso22.springaitexttosql.domain.QueryResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "ChatBot responsible for text-to-sql actions")
@RequestMapping("api/v1/chat")
public interface ChatController {

  @GetMapping
  ResponseEntity<QueryResponse> getRequestedQueryData(@RequestParam String query);

  @GetMapping("/players")
  List<Player> findAllPlayers();
}
