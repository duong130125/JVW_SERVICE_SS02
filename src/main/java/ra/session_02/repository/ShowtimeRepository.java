package ra.session_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.session_02.entity.Showtime;

import java.time.LocalDate;
import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findByMovieId(Long movieId);
    List<Showtime> findByScreenRoomId(Long screenRoomId);
    List<Showtime> findByMovieIdAndScreenRoomId(Long movieId, Long screenRoomId);

    // Truy vấn động cho bộ lọc
    @Query("SELECT s FROM Showtime s WHERE " +
            "(:movieId IS NULL OR s.movie.id = :movieId) AND " +
            "(:screenRoomId IS NULL OR s.screenRoom.id = :screenRoomId) AND " +
            "(:date IS NULL OR FUNCTION('DATE', s.startTime) = :date)")
    List<Showtime> searchByFilters(
            @Param("movieId") Long movieId,
            @Param("screenRoomId") Long screenRoomId,
            @Param("date") LocalDate date
    );
}