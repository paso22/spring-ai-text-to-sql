package ge.paso22.springaitexttosql.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

  @Id private int id;

  private String name;

  private int goals;

  private int assists;

  private int shirtNumber;

  private String position;

  private String nationality;

  private int age;
}
