package com.example.phoneshop;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/phones")
@CrossOrigin(origins = "http://localhost:5173")
public class PhoneController {
    private final PhoneService service;

    public PhoneController(PhoneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Phone> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Phone getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Phone create(@RequestBody Phone phone) {
        return service.create(phone);
    }

    @PutMapping("/{id}")
    public Phone update(@PathVariable Long id, @RequestBody Phone phone) {
        return service.update(id, phone);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}