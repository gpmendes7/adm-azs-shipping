package com.azship.gerenciadordefrete.repository;

import com.azship.gerenciadordefrete.model.Frete;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreteRepository extends JpaRepository<Frete, Long> {

    List<Frete> findByCubagem(Double cubagem, Pageable pageable);

    List<Frete> findByPeso(Double peso, Pageable pageable);
    List<Frete> findByDistancia(Double distancia, Pageable pageable);

    List<Frete> findByTempo(Long tempo, Pageable pageable);

}
