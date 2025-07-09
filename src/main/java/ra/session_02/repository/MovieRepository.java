package ra.session_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.session_02.entity.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContainingIgnoreCase(String title);
}