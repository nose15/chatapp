package org.studnia.chatapp.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studnia.chatapp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
