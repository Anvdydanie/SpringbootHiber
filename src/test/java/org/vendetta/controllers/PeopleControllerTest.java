package org.vendetta.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.vendetta.entity.PeopleEntity;
import org.vendetta.services.PeopleService;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PeopleController.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class PeopleControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Long entityId = 1L;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeopleService peopleService;

    @Test
    void indexTest() throws Exception {
        mockMvc.perform(get("/people"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("People are ready")));
    }

    @Test
    void saveEntityTest() throws Exception {
        PeopleEntity peopleEntity = new PeopleEntity(entityId, "Sasha");

        mockMvc.perform(post("/people/save")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(peopleEntity)))
            .andExpect(status().isOk())
            .andDo(print());
    }

    @Test
    void getEntityFoundTest() throws Exception {
        PeopleEntity peopleEntity = new PeopleEntity(entityId, "Sasha");

        when(peopleService.getById(entityId)).thenReturn(
            ResponseEntity.of(
                Optional.of(peopleEntity)
            )
        );

        mockMvc.perform(get("/people/get/{id}", entityId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(peopleEntity.getId()))
            .andExpect(jsonPath("$.name").value(peopleEntity.getName()))
            .andDo(print());
    }

    @Test
    void getEntityNotFoundTest() throws Exception {
        when(peopleService.getById(entityId)).thenReturn(
            ResponseEntity.of(
                Optional.empty()
            )
        );

        mockMvc.perform(get("/people/get/{id}", entityId))
            .andExpect(status().isNotFound())
            .andDo(print());
    }

}
