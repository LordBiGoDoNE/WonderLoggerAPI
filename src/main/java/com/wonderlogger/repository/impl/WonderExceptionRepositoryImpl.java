package com.wonderlogger.repository.impl;

import com.wonderlogger.repository.WonderExceptionRepositoryCustom;
import com.wonderlogger.dto.WonderExceptionDTO;
import com.wonderlogger.entity.ExceptionType;
import com.wonderlogger.entity.SoftwareClass;
import com.wonderlogger.entity.WonderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.*;

@Repository
public class WonderExceptionRepositoryImpl implements WonderExceptionRepositoryCustom {
    @Autowired
    EntityManager em;

    @Override
    public List<WonderExceptionDTO> getWonderExceptions(long idSoftware, long idVersion, List<Long> idsSoftwareClass,
                                                        List<Long> idsExceptionType, Date dataInicial, Date dataFinal) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<WonderExceptionDTO> query = builder.createQuery(WonderExceptionDTO.class);

        Root<WonderException> wonderExceptionRoot = query.from(WonderException.class);
        Join<WonderException, SoftwareClass> softwareClassJoin = wonderExceptionRoot.join("softwareClass", JoinType.INNER);
        Join<WonderException, ExceptionType> exceptionExceptionTypeJoin = wonderExceptionRoot.join("exceptionType", JoinType.INNER);

        List<Predicate> predicatesWhere = new ArrayList<>();
        predicatesWhere.add(builder.equal(wonderExceptionRoot.get("software"), idSoftware));
        predicatesWhere.add(builder.equal(wonderExceptionRoot.get("softwareVersion"), idVersion));

        if (idsSoftwareClass != null && !idsSoftwareClass.isEmpty()) {
            predicatesWhere.add(wonderExceptionRoot.get("softwareClass").in(idsSoftwareClass));
        }

        if (idsExceptionType != null && !idsExceptionType.isEmpty()) {
            predicatesWhere.add(wonderExceptionRoot.get("exceptionType").in(idsExceptionType));
        }

        if (dataInicial != null && dataInicial != null) {
            predicatesWhere.add(builder.greaterThanOrEqualTo(wonderExceptionRoot.get("dateHour"), dataInicial));
            predicatesWhere.add(builder.lessThanOrEqualTo(wonderExceptionRoot.get("dateHour"), dataFinal));
        } else if (dataInicial != null) {
            predicatesWhere.add(builder.greaterThanOrEqualTo(wonderExceptionRoot.get("dateHour"), dataInicial));
        } else if (dataFinal != null) {
            predicatesWhere.add(builder.lessThanOrEqualTo(wonderExceptionRoot.get("dateHour"), dataFinal));
        }

        query.select(builder.construct(
                WonderExceptionDTO.class,
                wonderExceptionRoot.get("id"),
                exceptionExceptionTypeJoin.get("exceptionName"),
                softwareClassJoin.get("className"),
                wonderExceptionRoot.get("dateHour"),
                wonderExceptionRoot.get("stacktrace")
        )).where(builder.and(predicatesWhere.toArray(Predicate[]::new)));

        return em.createQuery(query).getResultList();
    }
}
