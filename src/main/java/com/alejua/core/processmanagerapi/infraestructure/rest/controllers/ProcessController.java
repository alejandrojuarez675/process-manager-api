package com.alejua.core.processmanagerapi.infraestructure.rest.controllers;

import com.alejua.core.processmanagerapi.application.services.ProcessService;
import com.alejua.core.processmanagerapi.infraestructure.rest.dto.ProcessDTO;
import com.alejua.core.processmanagerapi.infraestructure.rest.dto.ProcessForCreationDTO;
import com.alejua.core.processmanagerapi.infraestructure.rest.mapper.ProcessForCreationDtoToProcessMapper;
import com.alejua.core.processmanagerapi.infraestructure.rest.mapper.ProcessToProcessDtoMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/process")
public class ProcessController {

    private final ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping
    public ResponseEntity<?> createProcess(
            @RequestBody ProcessForCreationDTO process
    ) {
        processService.create(ProcessForCreationDtoToProcessMapper.map(process));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProcessDTO> getAllProcess() {
        return processService.getAll()
                .stream()
                .map(ProcessToProcessDtoMapper::map)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessDTO> getProcess(
            @Param("id") String id
    ) {
        return processService.getById(id)
                .map(ProcessToProcessDtoMapper::map)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
