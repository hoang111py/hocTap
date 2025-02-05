package Controller;

import Entity.ChuyenXe;
import Service.ChuyenXeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/chuyenxe")
public class ChuyenXeController {
    private final ChuyenXeService service;

    public ChuyenXeController(ChuyenXeService service) {
        this.service = service;
    }

    @GetMapping
    public List<ChuyenXe> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ChuyenXe getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ChuyenXe create(@RequestBody ChuyenXe chuyenXe) {
        return service.create(chuyenXe);
    }

    @PutMapping("/{id}")
    public ChuyenXe update(@PathVariable Long id, @RequestBody ChuyenXe chuyenXe) {
        return service.update(id, chuyenXe);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

