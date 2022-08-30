package com.UdeA.Ciclo3.repository;

import com.UdeA.Ciclo3.Modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
