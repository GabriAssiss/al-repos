package com.example.api_rest.adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressData(@NotBlank
                          String logradouro,

                          @NotNull
                          String bairro,

                          @NotBlank
                          @Pattern(regexp = "\\d{8}")
                          String cep,

                          @NotBlank
                          String cidade,

                          @NotBlank
                          String uf,

                          String numero,

                          String complemento
) {
}
