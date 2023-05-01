package ku.book.model;

import ku.book.config.AttributeEncryptor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Column;
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

    @Column(columnDefinition="VARBINARY(256)")
    @ColumnTransformer(
            read = "cast(AES_DECRYPT(username, UNHEX('key')) as char(255))",
            write = "AES_ENCRYPT(?, UNHEX('key'))"
    )
    private String username;

    private String password;

    @Column(columnDefinition="VARBINARY(256)")
    @ColumnTransformer(
            read = "cast(AES_DECRYPT(name, UNHEX('key')) as char(255))",
            write = "AES_ENCRYPT(?, UNHEX('key'))"
    )
    private String name;

    private Instant createdAt;
}
