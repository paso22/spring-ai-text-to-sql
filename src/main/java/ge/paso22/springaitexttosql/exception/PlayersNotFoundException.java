package ge.paso22.springaitexttosql.exception;

public class PlayersNotFoundException extends RuntimeException {

  public PlayersNotFoundException(String message) {
    super(message);
  }
}
