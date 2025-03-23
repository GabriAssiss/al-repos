package com.example.api_rest.medic;

import com.example.api_rest.adress.AddressData;
import jakarta.validation.constraints.NotNull;

public record UpdateMedicData(
        @NotNull
        Long id,
        String nome,
        String telefone,
        AddressData endereco) {
}
