package com.APT.Backend;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserInfo, String> {
    boolean existsByUsername(String username);
    UserInfo findByUsername(String username);
}
