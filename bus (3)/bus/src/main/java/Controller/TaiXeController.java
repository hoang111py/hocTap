package Controller;

import Entity.TaiXe;
import Service.TaiXeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/taixe")
public class TaiXeController {
    private final TaiXeService service;

    public TaiXeController(TaiXeService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaiXe> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TaiXe getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TaiXe create(@RequestBody TaiXe taiXe) {
        return service.create(taiXe);
    }

    @PutMapping("/{id}")
    public TaiXe update(@PathVariable Long id, @RequestBody TaiXe taiXe) {
        return service.update(id, taiXe);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

