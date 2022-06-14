package com.wonderlogger.repository;

import com.wonderlogger.dto.WonderExceptionDTO;

import java.util.Date;
import java.util.List;

public interface WonderExceptionRepositoryCustom {
    List<WonderExceptionDTO> getWonderExceptions(long idSoftware, long idVersion, List<Long> idsSoftwareClass,
                                                 List<Long> idsExceptionType, Date dataInicial, Date dataFinal);
}
