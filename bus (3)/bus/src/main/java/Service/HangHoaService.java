package Service;

import Entity.HangHoa;
import Repository.HangHoaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HangHoaService {
    private final HangHoaRepository repository;

    public HangHoaService(HangHoaRepository repository) {
        this.repository = repository;
    }

    public List<HangHoa> getAll() {
        return repository.findAll();
    }

    public HangHoa getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy hàng hóa"));
    }

    public HangHoa create(HangHoa hangHoa) {
        return repository.save(hangHoa);
    }

    public HangHoa update(Long id, HangHoa hangHoa) {
        HangHoa existing = getById(id);
        existing.setTenHangHoa(hangHoa.getTenHangHoa());
        existing.setKhoiLuongKg(hangHoa.getKhoiLuongKg());
        existing.setChuHang(hangHoa.getChuHang());
        existing.setSoDienThoaiChuHang(hangHoa.getSoDienThoaiChuHang());
        existing.setDiaChiChuHang(hangHoa.getDiaChiChuHang());
        existing.setChuyenXe(hangHoa.getChuyenXe());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
