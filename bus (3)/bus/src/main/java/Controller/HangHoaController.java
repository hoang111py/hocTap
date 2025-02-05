package Controller;

import Entity.HangHoa;
import Service.HangHoaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hanghoa")
public class HangHoaController {
    private final HangHoaService service;

    public HangHoaController(HangHoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<HangHoa> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HangHoa getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public HangHoa create(@RequestBody HangHoa hangHoa) {
        return service.create(hangHoa);
    }

    @PutMapping("/{id}")
    public HangHoa update(@PathVariable Long id, @RequestBody HangHoa hangHoa) {
        return service.update(id, hangHoa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
