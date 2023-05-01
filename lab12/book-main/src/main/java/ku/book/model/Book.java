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
public class Book {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String author;
    private int rating;
    private Instant createdAt;
}
