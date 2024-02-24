package com.azship.gerenciadordefrete.builder;

import com.azship.gerenciadordefrete.dto.FreteDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FreteDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private Double cubagem = 20.55;

    @Builder.Default
    private Double peso = 1000.00;

    @Builder.Default
    private Double distancia = 90.5;

    @Builder.Default
    private Long tempo = 2L;

    public FreteDTO buildFreteDTO() {
        return new FreteDTO(id, cubagem, peso, distancia, tempo);
    }
}
