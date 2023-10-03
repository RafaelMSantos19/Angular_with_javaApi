package com.apitransactions.transactions.repository;

import com.apitransactions.transactions.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface RespositoryInter  extends  JpaRepository<Entity, Long>, JpaSpecificationExecutor<Entity> {

}
