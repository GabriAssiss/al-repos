package com.example.api_rest.medic;

import com.example.api_rest.adress.AddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicRegisterData(@NotNull
                                @NotBlank
                                String nome,

                                @NotBlank
                                @Email
                                String email,

                                @NotBlank
                                @Pattern(regexp = "\\d{12}")
                                String telefone,

                                @NotBlank
                                @Pattern(regexp = "\\d{4,6}")
                                String crm,

                                @NotNull
                                Especialidade especialidade,

                                @NotNull
                                @Valid
                                AddressData endereco) {
}
