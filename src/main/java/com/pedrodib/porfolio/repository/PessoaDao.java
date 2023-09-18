package com.pedrodib.porfolio.repository;

import com.pedrodib.porfolio.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaDao extends JpaRepository<Pessoa, Long> {

}
