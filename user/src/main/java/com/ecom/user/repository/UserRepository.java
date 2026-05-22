package com.ecom.user.repository;

//import com.ecom.user.models.CartItem;
import com.ecom.user.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    //@Nullable List<CartItem> findById(String userId);
}
