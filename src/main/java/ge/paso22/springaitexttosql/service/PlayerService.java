package ge.paso22.springaitexttosql.service;

import ge.paso22.springaitexttosql.domain.Player;
import java.util.List;

public interface PlayerService {

  List<Player> findAll();

  List<?> findAll(String query);
}
