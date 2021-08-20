package data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<Post, Long> {

}
