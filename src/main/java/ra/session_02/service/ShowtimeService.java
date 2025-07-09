package ra.session_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session_02.entity.Showtime;
import ra.session_02.repository.ShowtimeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeService implements IService<Showtime, Long> {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Override
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    @Override
    public Showtime save(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public Optional<Showtime> findById(Long id) {
        return showtimeRepository.findById(id);
    }

    @Override
    public Showtime update(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public void delete(Long id) {
        showtimeRepository.deleteById(id);
    }
}