package Controller;

import Entity.LichSuNhapLieu;
import Service.LichSuNhapLieuService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lich-su")
public class LichSuNhapLieuController {
    private final LichSuNhapLieuService service;

    public LichSuNhapLieuController(LichSuNhapLieuService service) {
        this.service = service;
    }

    @GetMapping
    public List<LichSuNhapLieu> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LichSuNhapLieu getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public LichSuNhapLieu create(@RequestBody LichSuNhapLieu lichSu) {
        return service.create(lichSu);
    }

    @PutMapping("/{id}")
    public LichSuNhapLieu update(@PathVariable Long id, @RequestBody LichSuNhapLieu lichSu) {
        return service.update(id, lichSu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

