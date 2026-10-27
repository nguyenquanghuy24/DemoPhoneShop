package com.example.phoneshop;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PhoneService {
    private final PhoneRepository repo;

    public PhoneService(PhoneRepository repo) {
        this.repo = repo;
    }

    public List<Phone> getAll() {
        return repo.findAll();
    }

    public Phone getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy id " + id));
    }

    public Phone create(Phone phone) {
        return repo.save(phone);
    }

    public Phone update(Long id, Phone newData) {
        Phone phone = getById(id);
        phone.setName(newData.getName());
        phone.setBrand(newData.getBrand());
        phone.setPrice(newData.getPrice());
        phone.setStock(newData.getStock());
        return repo.save(phone);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}