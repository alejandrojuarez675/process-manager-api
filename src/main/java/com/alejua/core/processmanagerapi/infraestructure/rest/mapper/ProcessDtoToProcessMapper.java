package com.alejua.core.processmanagerapi.infraestructure.rest.mapper;

import com.alejua.core.processmanagerapi.domain.Process;
import com.alejua.core.processmanagerapi.infraestructure.rest.dto.ProcessDTO;

public class ProcessDtoToProcessMapper {
    public static Process map(ProcessDTO dto) {
        return new Process();
    }
}
