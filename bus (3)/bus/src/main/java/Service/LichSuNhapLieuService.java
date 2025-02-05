package Service;

import Entity.LichSuNhapLieu;
import Repository.LichSuNhapLieuRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LichSuNhapLieuService {
    private final LichSuNhapLieuRepository repository;

    public LichSuNhapLieuService(LichSuNhapLieuRepository repository) {
        this.repository = repository;
    }

    public List<LichSuNhapLieu> getAll() {
        return repository.findAll();
    }

    public LichSuNhapLieu getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy lịch sử"));
    }

    public LichSuNhapLieu create(LichSuNhapLieu lichSu) {
        return repository.save(lichSu);
    }

    public LichSuNhapLieu update(Long id, LichSuNhapLieu lichSu) {
        LichSuNhapLieu existing = getById(id);
        existing.setNgayNhap(lichSu.getNgayNhap());
        existing.setNoiDung(lichSu.getNoiDung());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

