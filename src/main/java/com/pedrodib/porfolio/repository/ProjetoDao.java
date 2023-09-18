package com.pedrodib.porfolio.repository;

import com.pedrodib.porfolio.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoDao extends JpaRepository<Projeto, Long> {

    List<Projeto> findByRisco(String risco);

}
