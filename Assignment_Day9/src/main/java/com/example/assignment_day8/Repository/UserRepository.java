package com.example.assignment_day8.Repository;

import com.example.assignment_day8.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
    User findUserByRole(String role);
    User findAllByRole(String role);
    User findAllByAgeGreaterThanEqual(Integer age);
    User findDistinctByUsernameAndPassword(String username, Integer password);
    User findUserByUsername(String username);
    User findUserByPassword(Integer password);
    User findUserByEmail(String email);
    @Query("select n from User n where n.username = ?1 and n.password = ?2" )
    User findUsernamePass(String username, Integer password);
}
