package ra.session_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session_02.entity.Theater;
import ra.session_02.repository.TheaterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService implements IService<Theater, Long> {

    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public List<Theater> findAll() {
        return theaterRepository.findAll();
    }

    @Override
    public Theater save(Theater theater) {
        return theaterRepository.save(theater);
    }

    @Override
    public Optional<Theater> findById(Long id) {
        return theaterRepository.findById(id);
    }

    @Override
    public Theater update(Theater theater) {
        return theaterRepository.save(theater);
    }

    @Override
    public void delete(Long id) {
        theaterRepository.deleteById(id);
    }
}