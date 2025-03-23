package com.example.api_rest.controller;

import com.example.api_rest.medic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("medicos")
public class MedicController {

    @Autowired
    private MedicRepository medicRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid MedicRegisterData data) {
        medicRepository.save(new Medic(data));
    }


    @GetMapping
    public List<MedicListData> medicList(){
        return medicRepository.findAllByAtivoTrue().stream()
                .map(m -> new MedicListData(m.getId(), m.getNome(), m.getEmail(), m.getCrm(), m.getEspecialidade()))
                .collect(Collectors.toList());
    }

    @PutMapping
    @Transactional
    public void updateMedicInformations(@RequestBody @Valid UpdateMedicData data) {
        Medic medic = medicRepository.getReferenceById(data.id());
        medic.updateInfo(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMedic(@PathVariable Long id) {
        Medic medic = medicRepository.getReferenceById(id);
        medic.delete();
    }

}
