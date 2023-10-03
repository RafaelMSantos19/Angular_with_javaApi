package com.apitransactions.transactions.controller;

import com.apitransactions.transactions.entity.Entity;
import com.apitransactions.transactions.repository.RespositoryInter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class Controller {

    @Autowired
    private RespositoryInter respositoryInter;

    @GetMapping
    public List<Entity> getEntity(
            @RequestParam(name = "max", required = false, defaultValue = "50")Integer max,
            @RequestParam(name = "offset", required = false, defaultValue = "0")Integer offset,
            @RequestParam(name = "valor", required = false)Float valor,
            @RequestParam(name = "bandeira", required = false)String bandeira,
            @RequestParam(name = "cnpj",required = false)String cnpj,
            @RequestParam(name = "status",required = false)String status,
            @RequestParam(name = "card_bin", required = false)String card_bin
            ){


            Specification<Entity> specification = (Root<Entity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (valor != null) {
                predicates.add(criteriaBuilder.equal(root.get("valor"), valor));
            }

            if (bandeira != null) {
                predicates.add(criteriaBuilder.equal(root.get("bandeira"), bandeira));
            }

            if (cnpj != null){
                predicates.add(criteriaBuilder.equal(root.get("cnpj"), cnpj));
            }

            if (status != null){
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }

            if (card_bin != null){
                predicates.add(criteriaBuilder.equal(root.get("card_bin"), card_bin));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        if (max == null || max <= 0) {
            return respositoryInter.findAll(specification);
        } else {
            return respositoryInter.findAll(specification, PageRequest.of(offset, max)).getContent();
        }

    }

}
