package ge.paso22.springaitexttosql.service;

import ge.paso22.springaitexttosql.domain.Player;
import ge.paso22.springaitexttosql.exception.PlayersNotFoundException;
import ge.paso22.springaitexttosql.repository.PlayerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceBean implements PlayerService {

  private final PlayerRepository playerRepository;

  private final EntityManager entityManager;

  @Override
  public List<Player> findAll() {
    return playerRepository.findAll();
  }

  @Override
  public List<?> findAll(String query) {
    Query nativeQuery = entityManager.createNativeQuery(query);
    List<?> resultList = nativeQuery.getResultList();
    if (resultList.isEmpty()) {
      throw new PlayersNotFoundException("Can not found players for a given query");
    }
    return nativeQuery.getResultList();
  }
}
