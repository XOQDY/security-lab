package ku.kinkao.dto;

import lombok.Data;

@Data
public class RestaurantRequest {
   private String name;
   private String address;
   private int rating;
}
