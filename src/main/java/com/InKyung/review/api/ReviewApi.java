package com.InKyung.review.api;

import com.InKyung.review.api.request.CreateReviewRequest;
import com.InKyung.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewApi {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public void createReview(
            @RequestBody CreateReviewRequest request
    ){
        reviewService.createReview(request.getRestaurantId(), request.getContent(), request.getScore());
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") Long reviewId){
        reviewService.deleteReview(reviewId);
    }
}