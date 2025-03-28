package com.example.api_rest.adress;

import com.example.api_rest.medic.UpdateMedicData;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@Embeddable
public class Address {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Address(AddressData data) {
        this.logradouro = data.logradouro();
        this.bairro = data.bairro();
        this.cep = data.cep();
        this.cidade = data.cidade();
        this.uf = data.uf();
        this.numero = data.numero();
        this.complemento = data.complemento();
    }

    public Address() {

    }

    public void updateDataInfo(AddressData data) {
        if (data.logradouro() != null) {
            this.logradouro = data.logradouro();
        }

        if (data.bairro() != null) {
            this.bairro = data.bairro();
        }

        if (data.cep() != null) {
            this.cep = data.cep();
        }

        if (data.cidade() != null) {
            this.cidade = data.cidade();
        }

        if (data.uf() != null) {
            this.uf = data.uf();
        }

        if (data.numero() != null) {
            this.numero = data.numero();
        }

        if (data.complemento() != null) {
            this.complemento = data.complemento();
        }

    }

}

