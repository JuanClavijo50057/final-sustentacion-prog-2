package com.cine.gestion.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cine.gestion.app.domain.IrCine;

public interface IrCineRepository extends JpaRepository<IrCine, Long> {

}
