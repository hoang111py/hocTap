package Service;

import Entity.ChuyenXe;
import Repository.ChuyenXeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChuyenXeService {
    private final ChuyenXeRepository repository;

    public ChuyenXeService(ChuyenXeRepository repository) {
        this.repository = repository;
    }

    public List<ChuyenXe> getAll() {
        return repository.findAll();
    }

    public ChuyenXe getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy chuyến xe"));
    }

    public ChuyenXe create(ChuyenXe chuyenXe) {
        return repository.save(chuyenXe);
    }

    public ChuyenXe update(Long id, ChuyenXe chuyenXe) {
        ChuyenXe existing = getById(id);
        existing.setLoaiXe(chuyenXe.getLoaiXe());
        existing.setNgayXuatPhat(chuyenXe.getNgayXuatPhat());
        existing.setGioXuatPhat(chuyenXe.getGioXuatPhat());
        existing.setDiemDi(chuyenXe.getDiemDi());
        existing.setDiemDen(chuyenXe.getDiemDen());
        existing.setTaiXe(chuyenXe.getTaiXe());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

