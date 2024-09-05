package com.example.demo.services.cohort;

import com.example.demo.data.models.dtos.requests.CohortRequest;
import com.example.demo.data.models.entities.Cohort;
import com.example.demo.data.repositories.CohortRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CohortServiceImplTest {

    @InjectMocks
    private CohortServiceImpl cohortServiceImpl;

    @Mock
    private CohortRepository cohortRepository;



    @Test
    void createCohort() {
        when(cohortRepository.save(any())).thenReturn(new Cohort());
        cohortServiceImpl.createCohort(new CohortRequest());
    }

    @Test
    void getCohortById() {
        when(cohortRepository.findById(any())).thenReturn(Optional.of(new Cohort()));
        cohortServiceImpl.getCohortById(UUID.randomUUID().toString());
    }

    @Test
    void getAllCohorts() {
        when(cohortRepository.findAll()).thenReturn(null);
        cohortServiceImpl.getAllCohorts();
    }

    @Test
    void updateCohort() {

    }

    @Test
    void deleteCohort() {
    }
}