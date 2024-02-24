package com.azship.gerenciadordefrete.controller;

import com.azship.gerenciadordefrete.dto.FreteDTO;
import com.azship.gerenciadordefrete.dto.InsertFreteDTO;
import com.azship.gerenciadordefrete.service.FreteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fretes")
public class FreteController {

    @Autowired
    private FreteService freteService;

    @Operation(
            tags = "Cadastrar frete",
            description = "Cadastrar novo frete",
            responses = {
                    @ApiResponse(
                            description = "Frete cadastrado",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Frete não cadastrado, dados obrigatório não informados, valores informados inválidos ou frete já cadastrado",
                            responseCode = "400"
                    )
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FreteDTO create(@RequestBody @Valid InsertFreteDTO insertFreteDTO) {
        return freteService.create(insertFreteDTO);
    }

    @Operation(
            tags = "Buscar frete",
            description = "Buscar frete pelo id",
            responses = {
                    @ApiResponse(
                            description = "frete encontrado",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "frete não encontrado",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping("/{id}")
    public FreteDTO findById(@PathVariable Long id) {
        return freteService.findById(id);
    }

    @Operation(
            tags = "Listar fretes",
            description = "Listar todos os fretes",
            responses = {
                    @ApiResponse(
                            description = "Retorna todos os fretes cadastrados",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping
    public List<FreteDTO> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return freteService.findAll(pageable);
    }

    @Operation(
            tags = "Listar fretes por cubagem",
            description = "Listar todos os fretes com cubagem particular",
            responses = {
                    @ApiResponse(
                            description = "Retorna os fretes cadastrados com cubagem particular",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping("/findByCubagem/{cubagem}")
    public List<FreteDTO> findByCubagem(@PathVariable Double cubagem, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return freteService.findByCubagem(cubagem, pageable);
    }

    @Operation(
            tags = "Listar fretes por peso",
            description = "Listar todos os fretes com peso particular",
            responses = {
                    @ApiResponse(
                            description = "Retorna os fretes cadastrados com peso particular",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping("/findByPeso/{peso}")
    public List<FreteDTO> findByPeso(@PathVariable Double peso,  @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return freteService.findByPeso(peso, pageable);
    }
    
    @Operation(
            tags = "Listar fretes por distancia",
            description = "Listar todos os fretes com distancia particular",
            responses = {
                    @ApiResponse(
                            description = "Retorna os fretes cadastrados com distancia particular",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping("/findByDistancia/{distancia}")
    public List<FreteDTO> findByDistancia(@PathVariable Double distancia, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return freteService.findByDistancia(distancia, pageable);
    }

    @Operation(
            tags = "Listar fretes por tempo",
            description = "Listar todos os fretes com tempo particular",
            responses = {
                    @ApiResponse(
                            description = "Retorna os fretes cadastrados com tempo particular",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping("/findByTempo/{tempo}")
    public List<FreteDTO> findByTempo(@PathVariable Long tempo, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return freteService.findByTempo(tempo, pageable);
    }

    @Operation(
            tags = "Deletar frete",
            description = "Deletar frete pelo id",
            responses = {
                    @ApiResponse(
                            description = "frete deletado",
                            responseCode = "204"
                    ),
                    @ApiResponse(
                            description = "frete não encontrado",
                            responseCode = "404"
                    )
            }
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        freteService.delete(id);
    }

    @Operation(
            tags = "Atualizar frete",
            description = "Atualizar frete pelo id",
            responses = {
                    @ApiResponse(
                            description = "frete atualizado",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "frete não encontrado",
                            responseCode = "404"
                    ),
                    @ApiResponse(
                            description = "Frete não cadastrado, dados obrigatório não informados, valores informados inválidos ou frete já cadastrado",
                            responseCode = "400"
                    )
            }
    )
    @PutMapping("/{id}")
    public FreteDTO update(@PathVariable Long id, @RequestBody @Valid InsertFreteDTO insertFreteDTO) {
        return freteService.update(id, insertFreteDTO);
    }
}
