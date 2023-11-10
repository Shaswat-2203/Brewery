package com.moengage.assignment.repository;

import com.moengage.assignment.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByLoginAndPassword(String login, String password);

    Optional<UserModel> findFirstByLogin(String login);
}
