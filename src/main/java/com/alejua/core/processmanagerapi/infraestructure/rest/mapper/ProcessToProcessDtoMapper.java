package com.alejua.core.processmanagerapi.infraestructure.rest.mapper;

import com.alejua.core.processmanagerapi.domain.Process;
import com.alejua.core.processmanagerapi.infraestructure.rest.dto.ProcessDTO;

public class ProcessToProcessDtoMapper {
    public static ProcessDTO map(Process dto) {
        return new ProcessDTO();
    }
}
