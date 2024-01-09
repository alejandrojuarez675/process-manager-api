package com.alejua.core.processmanagerapi.infraestructure.rest.mapper;

import com.alejua.core.processmanagerapi.domain.Process;
import com.alejua.core.processmanagerapi.infraestructure.rest.dto.ProcessForCreationDTO;

public class ProcessForCreationDtoToProcessMapper {

    public static Process map(ProcessForCreationDTO dto) {
        return new Process();
    }
}
