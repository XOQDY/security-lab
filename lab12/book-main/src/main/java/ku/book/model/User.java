package ku.book.model;

import ku.book.config.AttributeEncryptor;
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

    @Convert(converter = AttributeEncryptor.class)
    private String username;

    private String password;

    @Convert(converter = AttributeEncryptor.class)
    private String name;

    private Instant createdAt;
}
