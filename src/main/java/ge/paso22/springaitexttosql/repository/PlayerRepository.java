package ge.paso22.springaitexttosql.repository;

import ge.paso22.springaitexttosql.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {}
