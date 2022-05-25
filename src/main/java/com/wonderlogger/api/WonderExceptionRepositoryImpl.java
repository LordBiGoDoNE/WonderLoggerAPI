package com.wonderlogger.api;

import com.wonderlogger.dto.WonderExceptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class WonderExceptionRepositoryImpl implements WonderExceptionRepositoryCustom {
    @Autowired
    EntityManager em;

    @Override
    public List<WonderExceptionDTO> getWonderExceptions(long idSoftware, long idVersion, List<Long> idsSoftwareClass,
                                                        List<Long> idsExceptionType, Date dataInicial, Date dataFinal) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<WonderExceptionDTO> cq = cb.createQuery(WonderExceptionDTO.class);

        Root<WonderException> wonderExceptionRoot = cq.from(WonderException.class);
        Join<WonderException, SoftwareClass> softwareClassJoin = wonderExceptionRoot.join("softwareClass", JoinType.INNER);
        Join<WonderException, ExceptionType> exceptionExceptionTypeJoin = wonderExceptionRoot.join("exceptionType", JoinType.INNER);

        List<Predicate> predicatesWhere = new ArrayList<>();
        predicatesWhere.add(cb.equal(wonderExceptionRoot.get("software"), idSoftware));
        predicatesWhere.add(cb.equal(wonderExceptionRoot.get("softwareVersion"), idVersion));

        if (idsSoftwareClass != null && !idsSoftwareClass.isEmpty()) {
            predicatesWhere.add(wonderExceptionRoot.get("softwareClass").in(idsSoftwareClass));
        }

        if (idsExceptionType != null && !idsExceptionType.isEmpty()) {
            predicatesWhere.add(wonderExceptionRoot.get("exceptionType").in(idsExceptionType));
        }

        if (dataInicial != null && dataInicial != null) {
            predicatesWhere.add(cb.greaterThanOrEqualTo(wonderExceptionRoot.get("dateHour"), dataInicial));
            predicatesWhere.add(cb.lessThanOrEqualTo(wonderExceptionRoot.get("dateHour"), dataFinal));
        } else if (dataInicial != null) {
            predicatesWhere.add(cb.greaterThanOrEqualTo(wonderExceptionRoot.get("dateHour"), dataInicial));
        } else if (dataFinal != null) {
            predicatesWhere.add(cb.lessThanOrEqualTo(wonderExceptionRoot.get("dateHour"), dataFinal));
        }

        cq.select(cb.construct(
                WonderExceptionDTO.class,
                wonderExceptionRoot.get("id"),
                exceptionExceptionTypeJoin.get("exceptionName"),
                softwareClassJoin.get("className"),
                wonderExceptionRoot.get("dateHour"),
                wonderExceptionRoot.get("stacktrace")
        )).where(cb.and(predicatesWhere.toArray(Predicate[]::new)));

        return em.createQuery(cq).getResultList();
    }
}
