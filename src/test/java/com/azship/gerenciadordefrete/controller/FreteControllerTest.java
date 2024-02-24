package com.azship.gerenciadordefrete.controller;

import com.azship.gerenciadordefrete.builder.FreteDTOBuilder;
import com.azship.gerenciadordefrete.builder.InsertFreteDTOBuilder;
import com.azship.gerenciadordefrete.dto.FreteDTO;
import com.azship.gerenciadordefrete.dto.InsertFreteDTO;
import com.azship.gerenciadordefrete.service.FreteService;
import com.azship.gerenciadordefrete.utils.JsonConversionUtils;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class FreteControllerTest {

    private static final String FRETE_API_URL_PATH = "/api/v1/fretes";
    @Mock
    private FreteService freteService;

    @InjectMocks
    private FreteController freteController;

    private MockMvc mockMvc;

    private InsertFreteDTOBuilder insertFreteDTOBuilder;
    private FreteDTOBuilder freteDTOBuilder;

    @BeforeEach
    void setUp() {
        insertFreteDTOBuilder = InsertFreteDTOBuilder.builder().build();
        freteDTOBuilder = FreteDTOBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup(freteController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPOSTIsCalledThenCreatedStatusShouldBeReturned() throws Exception {
        InsertFreteDTO expectedCreatedInsertFreteDTO = insertFreteDTOBuilder.buildInsertFreteDTO();
        FreteDTO expectedCreatedFreteDTO = freteDTOBuilder.buildFreteDTO();

        Mockito.when(freteService.create(expectedCreatedInsertFreteDTO))
                .thenReturn(expectedCreatedFreteDTO);

        mockMvc.perform(MockMvcRequestBuilders.post(FRETE_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonConversionUtils.asJsonString(expectedCreatedFreteDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(expectedCreatedFreteDTO.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cubagem", Is.is(expectedCreatedFreteDTO.getCubagem().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.peso", Is.is(expectedCreatedFreteDTO.getPeso().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.distancia", Is.is(expectedCreatedFreteDTO.getDistancia().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tempo", Is.is(expectedCreatedFreteDTO.getTempo().intValue())));
    }

    @Test
    void whenPOSTIsCalledWithoutRequiredFieldThenBadRequestStatusShouldBeReturned() throws Exception {
        InsertFreteDTO expectedCreatedInsertFreteDTO = insertFreteDTOBuilder.buildInsertFreteDTO();
        expectedCreatedInsertFreteDTO.setDistancia(null);

        mockMvc.perform(MockMvcRequestBuilders.post(FRETE_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonConversionUtils.asJsonString(expectedCreatedInsertFreteDTO)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void whenGETWithValidIdIsCalledThenOkStatusShouldBeReturned() throws Exception {
        FreteDTO expectedFoundedFreteDTO = freteDTOBuilder.buildFreteDTO();

        Mockito.when(freteService.findById(expectedFoundedFreteDTO.getId()))
                .thenReturn(expectedFoundedFreteDTO);

        mockMvc.perform(MockMvcRequestBuilders.get(FRETE_API_URL_PATH + "/" + expectedFoundedFreteDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(expectedFoundedFreteDTO.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cubagem", Is.is(expectedFoundedFreteDTO.getCubagem().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.peso", Is.is(expectedFoundedFreteDTO.getPeso().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.distancia", Is.is(expectedFoundedFreteDTO.getDistancia().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tempo", Is.is(expectedFoundedFreteDTO.getTempo().intValue())));
    }

    @Test
    void whenGETListIsCalledThenOkStatusShouldBeReturned() throws Exception {
        FreteDTO expectedFoundedFreteDTO = freteDTOBuilder.buildFreteDTO();

        Pageable pageable = PageRequest.of(0, 5);
        Mockito.when(freteService.findAll(pageable))
                .thenReturn(Collections.singletonList(expectedFoundedFreteDTO));

        mockMvc.perform(MockMvcRequestBuilders.get(FRETE_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Is.is(expectedFoundedFreteDTO.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cubagem", Is.is(expectedFoundedFreteDTO.getCubagem().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].peso", Is.is(expectedFoundedFreteDTO.getPeso().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].distancia", Is.is(expectedFoundedFreteDTO.getDistancia().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].tempo", Is.is(expectedFoundedFreteDTO.getTempo().intValue())));
    }

    @Test
    void whenDELETEWithValidIdIsCalledThenNoContentStatusShouldBeReturned() throws Exception {
        FreteDTO expectedFoundedFreteDTO = freteDTOBuilder.buildFreteDTO();
        var expectedFreteDeletedId = expectedFoundedFreteDTO.getId();

        Mockito.doNothing().when(freteService).delete(expectedFreteDeletedId);

        mockMvc.perform(MockMvcRequestBuilders.delete(FRETE_API_URL_PATH + "/" + expectedFreteDeletedId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void whenPUTIsCalledThenOkStatusCreatedShouldBeReturned() throws Exception {
        FreteDTO expectedFreteToUpdateDTOFromFreteDTO = freteDTOBuilder.buildFreteDTO();
        expectedFreteToUpdateDTOFromFreteDTO.setTempo(40L);

        InsertFreteDTO expectedFreteToUpdateDTOFromInsertFreteDTO = insertFreteDTOBuilder.buildInsertFreteDTO();
        expectedFreteToUpdateDTOFromInsertFreteDTO.setTempo(40L);

        var expectedFreteToUpdateId = 1L;

        Mockito.when(freteService.update(expectedFreteToUpdateId, expectedFreteToUpdateDTOFromInsertFreteDTO))
                .thenReturn(expectedFreteToUpdateDTOFromFreteDTO);

        mockMvc.perform(MockMvcRequestBuilders.put(FRETE_API_URL_PATH + "/" + expectedFreteToUpdateId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonConversionUtils.asJsonString(expectedFreteToUpdateDTOFromFreteDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(expectedFreteToUpdateDTOFromFreteDTO.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cubagem", Is.is(expectedFreteToUpdateDTOFromFreteDTO.getCubagem().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.peso", Is.is(expectedFreteToUpdateDTOFromFreteDTO.getPeso().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.distancia", Is.is(expectedFreteToUpdateDTOFromFreteDTO.getDistancia().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tempo", Is.is(expectedFreteToUpdateDTOFromFreteDTO.getTempo().intValue())));
    }
}
