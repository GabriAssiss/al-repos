package com.example.api_rest.medic;

import com.example.api_rest.adress.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Address endereco;

    private boolean ativo;

    public Medic(MedicRegisterData data) {
        this.ativo = true;
        this.endereco = new Address(data.endereco());
        this.crm = data.crm();
        this.email = data.email();
        this.especialidade = data.especialidade();
        this.nome = data.nome();
        this.telefone = data.telefone();
    }

    public void updateInfo(UpdateMedicData data) {
        if (data.nome() != null) {
            this.nome = data.nome();
        }

        if (data.telefone() != null) {
            this.telefone = data.telefone();
        }

        if (data.endereco() != null) {
            this.endereco.updateDataInfo(data.endereco());
        }


    }

    public void delete() {
        this.ativo = false;
    }
}
