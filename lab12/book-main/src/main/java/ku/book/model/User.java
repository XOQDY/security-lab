package ku.book.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String password;
    private String name;

    private Instant createdAt;
}
