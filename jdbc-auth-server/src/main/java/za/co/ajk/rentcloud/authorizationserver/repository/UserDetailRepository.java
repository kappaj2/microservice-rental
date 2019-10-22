package za.co.ajk.rentcloud.authorizationserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.ajk.rentcloud.authorizationserver.model.User;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
