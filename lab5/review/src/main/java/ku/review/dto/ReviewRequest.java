package ku.review.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.UUID;


@Data
public class ReviewRequest {


   private UUID restaurantId;


   @NotBlank
   private String username;


   @NotBlank
   private String reviewText;
}
