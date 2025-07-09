package ra.session_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.session_02.entity.Showtime;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findByMovieId(Long movieId);
    List<Showtime> findByScreenRoomId(Long screenRoomId);
    List<Showtime> findByMovieIdAndScreenRoomId(Long movieId, Long screenRoomId);
}