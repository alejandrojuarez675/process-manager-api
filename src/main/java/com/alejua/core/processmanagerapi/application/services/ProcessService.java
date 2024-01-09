package com.alejua.core.processmanagerapi.application.services;

import com.alejua.core.processmanagerapi.domain.Process;

import java.util.List;
import java.util.Optional;

public interface ProcessService {
    Process create(Process process);
    List<Process> getAll();
    Optional<Process> getById(String id);
}
