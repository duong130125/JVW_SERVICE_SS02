package ra.session_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session_02.entity.Seat;
import ra.session_02.repository.SeatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService implements IService<Seat, Long> {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<Seat> findAll() {
        return seatRepository.findAll();
    }

    @Override
    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public Optional<Seat> findById(Long id) {
        return seatRepository.findById(id);
    }

    @Override
    public Seat update(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public void delete(Long id) {
        seatRepository.deleteById(id);
    }
}