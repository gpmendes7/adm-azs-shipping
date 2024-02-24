package com.azship.gerenciadordefrete.service;

import com.azship.gerenciadordefrete.builder.FreteDTOBuilder;
import com.azship.gerenciadordefrete.builder.InsertFreteDTOBuilder;
import com.azship.gerenciadordefrete.dto.FreteDTO;
import com.azship.gerenciadordefrete.dto.InsertFreteDTO;
import com.azship.gerenciadordefrete.exception.FreteNotFoundException;
import com.azship.gerenciadordefrete.model.Frete;
import com.azship.gerenciadordefrete.repository.FreteRepository;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FreteServiceTest {

    private final static ModelMapper modelMapper = new ModelMapper();

    @Mock
    private FreteRepository freteRepository;

    @InjectMocks
    private FreteService freteService;

    private InsertFreteDTOBuilder insertFreteDTOBuilder;
    private FreteDTOBuilder freteDTOBuilder;

    @BeforeEach
    void setUp() {
        insertFreteDTOBuilder = InsertFreteDTOBuilder.builder().build();
        freteDTOBuilder = FreteDTOBuilder.builder().build();
    }

    @Test
    void whenNewFreteIsInformedThenItShouldBeCreated() {
        //given
        InsertFreteDTO expectedInsertFreteToCreateDTO = insertFreteDTOBuilder.buildInsertFreteDTO();
        FreteDTO expectedFreteToCreateDTO = freteDTOBuilder.buildFreteDTO();
        Frete expectedCreatedFreteFromInsertFreteDTO = modelMapper.map(expectedInsertFreteToCreateDTO, Frete.class);
        Frete expectedCreatedFreteFromFreteDTO = modelMapper.map(expectedFreteToCreateDTO, Frete.class);

        //when
        Mockito.when(freteRepository.save(expectedCreatedFreteFromInsertFreteDTO)).thenReturn(expectedCreatedFreteFromFreteDTO);

        //then
        FreteDTO createdFreteDTO = freteService.create(expectedInsertFreteToCreateDTO);

        MatcherAssert.assertThat(createdFreteDTO, Is.is(IsEqual.equalTo(expectedFreteToCreateDTO)));
    }

    @Test
    void whenValidIdIsGivenThenAFreteShouldBeReturned() {
        //given
        FreteDTO expectedFoundedFreteDTO = freteDTOBuilder.buildFreteDTO();
        Frete expectedFoundedFrete = modelMapper.map(expectedFoundedFreteDTO, Frete.class);

        //when
        Mockito.when(freteRepository.findById(expectedFoundedFreteDTO.getId())).thenReturn(Optional.of(expectedFoundedFrete));

        FreteDTO foundedFreteDTO = freteService.findById(expectedFoundedFreteDTO.getId());

        MatcherAssert.assertThat(foundedFreteDTO, Is.is(IsEqual.equalTo(expectedFoundedFreteDTO)));
    }

    @Test
    void whenInvalidIdIsGivenThenAnExceptionShouldBeThrown() {
        //given
        FreteDTO expectedFoundedFreteDTO = freteDTOBuilder.buildFreteDTO();

        //when
        Mockito.when(freteRepository.findById(expectedFoundedFreteDTO.getId())).thenReturn(Optional.empty());

        Assertions.assertThrows(FreteNotFoundException.class, () -> freteService.findById(expectedFoundedFreteDTO.getId()));
    }

    @Test
    void whenListFretesIsCalledThenItShouldBeReturned() {
        FreteDTO expectedFoundedFreteDTO = freteDTOBuilder.buildFreteDTO();
        Frete expectedFoundedFrete = modelMapper.map(expectedFoundedFreteDTO, Frete.class);

        Pageable pageable = PageRequest.of(0, 5);
        Page<Frete> fretesPage = new PageImpl<>(Collections.singletonList(expectedFoundedFrete));
        Mockito.when(freteRepository.findAll(pageable)).thenReturn(fretesPage);

        List<FreteDTO> foundedFretesDTO = freteService.findAll(pageable);

        MatcherAssert.assertThat(foundedFretesDTO.size(), Is.is(1));;
        MatcherAssert.assertThat(foundedFretesDTO.get(0), Is.is(CoreMatchers.equalTo(expectedFoundedFreteDTO)));;;
    }

    @Test
    void whenListFretesIsCalledThenAnEmptyListShouldBeReturned() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Frete> fretesPage = new PageImpl<>(Collections.EMPTY_LIST);
        Mockito.when(freteRepository.findAll(pageable)).thenReturn(fretesPage);

        List<FreteDTO> foundedFretesDTO = freteService.findAll(pageable);

        MatcherAssert.assertThat(foundedFretesDTO.size(), Is.is(0));
    }


    @Test
    void whenInvalidFreteIdIsGivenThenAnExceptionShouldBeThrown() {
        FreteDTO expectedDeletedFreteDTO = freteDTOBuilder.buildFreteDTO();
        Frete expectedDeletedFrete = modelMapper.map(expectedDeletedFreteDTO, Frete.class);

        Long expectedDeletedFreteId = expectedDeletedFreteDTO.getId();
        Mockito.doNothing().when(freteRepository).deleteById(expectedDeletedFreteId);
        Mockito.when(freteRepository.findById(expectedDeletedFreteId)).thenReturn(Optional.of(expectedDeletedFrete));

        freteService.delete(expectedDeletedFreteId);

        Mockito.verify(freteRepository, Mockito.times(1)).deleteById(expectedDeletedFreteId);
        Mockito.verify(freteRepository, Mockito.times(1)).findById(expectedDeletedFreteId);

    }

    @Test
    void whenValidFreteIdIsGivenThenItShouldBeDeleted() {
        var expectedInvalidFreteId = 2L;

        Mockito.when(freteRepository.findById(expectedInvalidFreteId)).thenReturn(Optional.empty());

        Assertions.assertThrows(FreteNotFoundException.class, () -> freteService.delete(expectedInvalidFreteId));
    }

    @Test
    void whenExistingFreteIsInformedThenItShouldBeUpdated() {
        //given
        InsertFreteDTO expectedUpdatedFreteDTOFromInsertFreteDTO = insertFreteDTOBuilder.buildInsertFreteDTO();
        expectedUpdatedFreteDTOFromInsertFreteDTO.setTempo(40L);
        FreteDTO expectedUpdatedFreteDTOFromFreteDTO = freteDTOBuilder.buildFreteDTO();
        expectedUpdatedFreteDTOFromFreteDTO.setTempo(40L);
        Frete expectedUpdatedFrete = modelMapper.map(expectedUpdatedFreteDTOFromFreteDTO, Frete.class);

        //when
        Mockito.when(freteRepository.findById(expectedUpdatedFreteDTOFromFreteDTO.getId())).thenReturn(Optional.of(expectedUpdatedFrete));
        Mockito.when(freteRepository.save(expectedUpdatedFrete)).thenReturn(expectedUpdatedFrete);

        //then
        FreteDTO createdFreteDTO =freteService.update(expectedUpdatedFreteDTOFromFreteDTO.getId(), expectedUpdatedFreteDTOFromInsertFreteDTO);

        MatcherAssert.assertThat(createdFreteDTO, Is.is(IsEqual.equalTo(expectedUpdatedFreteDTOFromFreteDTO)));
    }
}
