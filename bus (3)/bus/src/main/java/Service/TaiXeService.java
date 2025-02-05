package Service;

import Entity.TaiXe;
import Repository.TaiXeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaiXeService {
    private final TaiXeRepository repository;

    public TaiXeService(TaiXeRepository repository) {
        this.repository = repository;
    }

    public List<TaiXe> getAll() {
        return repository.findAll();
    }

    public TaiXe getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy tài xế"));
    }

    public TaiXe create(TaiXe taiXe) {
        return repository.save(taiXe);
    }

    public TaiXe update(Long id, TaiXe taiXe) {
        TaiXe existing = getById(id);
        existing.setTenTaixe(taiXe.getTenTaixe());
        existing.setSoDienThoai(taiXe.getSoDienThoai());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
