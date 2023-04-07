package ku.review.service;

import ku.review.dto.ReviewRequest;
import ku.review.dto.ReviewResponse;
import ku.review.model.Review;
import ku.review.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReviewService {

   @Autowired
   private ReviewRepository repository;

   @Autowired
   private ModelMapper modelMapper;

   public List<Review> getAll() {
       return repository.findAll();
   }

   public List<ReviewResponse> getAllReviewsForRestaurant(UUID restaurantId) {
       List<Review> reviews = repository.findByRestaurantId(restaurantId);

       List<ReviewResponse> dtos = reviews
               .stream()
               .map(review -> modelMapper.map(review, ReviewResponse.class))
               .collect(Collectors.toList());

       return dtos;
   }

   public void addReview(ReviewRequest reviewRequest) {
       Review review = modelMapper.map(reviewRequest, Review.class);
       review.setCreatedAt(Instant.now());
       repository.save(review);
   }
}
