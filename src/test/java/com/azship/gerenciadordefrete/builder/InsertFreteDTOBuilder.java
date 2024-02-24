package com.azship.gerenciadordefrete.builder;

import com.azship.gerenciadordefrete.dto.FreteDTO;
import com.azship.gerenciadordefrete.dto.InsertFreteDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsertFreteDTOBuilder {

    @Builder.Default
    private Double cubagem = 20.55;

    @Builder.Default
    private Double peso = 1000.00;

    @Builder.Default
    private Double distancia = 90.5;

    @Builder.Default
    private Long tempo = 2L;

    public InsertFreteDTO buildInsertFreteDTO() {
        return new InsertFreteDTO(cubagem, peso, distancia, tempo);
    }
}
