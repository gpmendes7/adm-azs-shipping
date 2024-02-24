package com.azship.gerenciadordefrete.service;

import com.azship.gerenciadordefrete.dto.FreteDTO;
import com.azship.gerenciadordefrete.dto.InsertFreteDTO;
import com.azship.gerenciadordefrete.exception.FreteNotFoundException;
import com.azship.gerenciadordefrete.model.Frete;
import com.azship.gerenciadordefrete.repository.FreteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FreteService {

    private final static ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private FreteRepository freteRepository;

    public FreteDTO create(InsertFreteDTO insertFreteDTO) {
        Frete freteToCreate = modelMapper.map(insertFreteDTO, Frete.class);
        Frete createdFrete = freteRepository.save(freteToCreate);
        return modelMapper.map(createdFrete, FreteDTO.class);
    }

    public FreteDTO update(Long id, InsertFreteDTO insertFreteToUpdateDTO) {
        verifyAndGetFrete(id);

        Frete freteToUpdate = modelMapper.map(insertFreteToUpdateDTO, Frete.class);
        freteToUpdate.setId(id);

        Frete updatedFrete = freteRepository.save(freteToUpdate);
        return modelMapper.map(updatedFrete, FreteDTO.class);
    }

    public FreteDTO findById(Long id) {
        Frete foundedFrete = verifyAndGetFrete(id);
        return modelMapper.map(foundedFrete, FreteDTO.class);
    }

    public List<FreteDTO> findAll(Pageable pageable) {
        return freteRepository.findAll(pageable)
                .stream()
                .map(foundedFrete -> modelMapper.map(foundedFrete, FreteDTO.class))
                .collect(Collectors.toList());
    }

    public List<FreteDTO> findByCubagem(Double cubagem, Pageable pageable) {
        List<Frete> fretes = freteRepository.findByCubagem(cubagem, pageable);
        return fretes.stream()
                .map(frete -> modelMapper.map(frete, FreteDTO.class))
                .collect(Collectors.toList());
    }

    public List<FreteDTO> findByPeso(Double peso, Pageable pageable) {
        List<Frete> fretes = freteRepository.findByPeso(peso, pageable);
        return fretes.stream()
                .map(frete -> modelMapper.map(frete, FreteDTO.class))
                .collect(Collectors.toList());
    }

    public List<FreteDTO> findByDistancia(Double distancia, Pageable pageable) {
        List<Frete> fretes = freteRepository.findByDistancia(distancia, pageable);
        return fretes.stream()
                .map(frete -> modelMapper.map(frete, FreteDTO.class))
                .collect(Collectors.toList());
    }

    public List<FreteDTO> findByTempo(Long tempo, Pageable pageable) {
        List<Frete> fretes = freteRepository.findByTempo(tempo, pageable);
        return fretes.stream()
                .map(frete -> modelMapper.map(frete, FreteDTO.class))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        verifyAndGetFrete(id);
        freteRepository.deleteById(id);
    }

    private Frete verifyAndGetFrete(Long id) {
        return freteRepository.findById(id)
                .orElseThrow(() -> new FreteNotFoundException(id));
    }

}
