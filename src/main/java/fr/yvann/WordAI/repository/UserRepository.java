package fr.yvann.WordAI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.yvann.WordAI.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
