package com.example.repairs.repositories;

import com.example.repairs.entities.Review;
import com.example.repairs.repositories.base.CreateRepo;
import com.example.repairs.repositories.base.DeleteRepo;
import com.example.repairs.repositories.base.ReadRepo;
import com.example.repairs.repositories.base.UpdateRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends CreateRepo<Review>, ReadRepo<Review>, UpdateRepo<Review>, DeleteRepo<Review> {
}
