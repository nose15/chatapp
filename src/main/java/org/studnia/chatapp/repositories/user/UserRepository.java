package org.studnia.chatapp.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studnia.chatapp.dtos.UserDTO;
import org.studnia.chatapp.models.UserData;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
}
