package com.taske.taskDelat.repo;

import com.taske.taskDelat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
