package com.azship.gerenciadordefrete.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreteDTO {


    @Schema(description = "Id do frete", example = "1")
    private Long id;

    @Schema(description = "Cubagem do frete", example = "20.55")
    private Double cubagem;

    @Schema(description = "Peso do frete", example = "1000.00")
    private Double peso;

    @Schema(description = "Distância do frete em km", example = "90.5")
    @NotNull
    private Double distancia;

    @Schema(description = "Tempo do frete em horas", example = "2")
    @NotNull
    private Long tempo;
}
