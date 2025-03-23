package com.example.api_rest.medic;

public record MedicListData(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicListData(Medic medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
