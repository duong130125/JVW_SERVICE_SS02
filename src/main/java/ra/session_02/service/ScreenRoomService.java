package ra.session_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session_02.entity.ScreenRoom;
import ra.session_02.repository.ScreenRoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenRoomService implements IService<ScreenRoom, Long> {

    @Autowired
    private ScreenRoomRepository screenRoomRepository;

    @Override
    public List<ScreenRoom> findAll() {
        return screenRoomRepository.findAll();
    }

    @Override
    public ScreenRoom save(ScreenRoom screenRoom) {
        return screenRoomRepository.save(screenRoom);
    }

    @Override
    public Optional<ScreenRoom> findById(Long id) {
        return screenRoomRepository.findById(id);
    }

    @Override
    public ScreenRoom update(ScreenRoom screenRoom) {
        return screenRoomRepository.save(screenRoom);
    }

    @Override
    public void delete(Long id) {
        screenRoomRepository.deleteById(id);
    }
}