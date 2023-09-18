package com.pedrodib.porfolio.service;

import com.pedrodib.porfolio.model.Projeto;
import com.pedrodib.porfolio.repository.ProjetoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    ProjetoDao projetoDao;

    public ResponseEntity<List<Projeto>> getAllProjetos() {
        try {
            return new ResponseEntity<>(projetoDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Projeto>> getProjetosPorRisco(String risco) {
        try {
            return new ResponseEntity<>(projetoDao.findByRisco(risco), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> insertProjeto(Projeto projeto) {
        projetoDao.save(projeto);
        return new ResponseEntity<>("Projeto inserido com sucesso.", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteProjeto(Long id) {
        try {
            projetoDao.deleteById(id);
            return new ResponseEntity<>("Projeto deletado com sucesso.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Falha ao deletar o projeto.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateProjeto(Long id, Projeto updatedProjeto) {
        Optional<Projeto> existingProjetoOptional = projetoDao.findById(id);
        if (existingProjetoOptional.isPresent()) {
            Projeto existingProjeto = existingProjetoOptional.get();
            existingProjeto.setNome(updatedProjeto.getNome());
            projetoDao.save(existingProjeto);
            return new ResponseEntity<>("Projeto atualizado com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Projeto não encontrado.", HttpStatus.NOT_FOUND);
        }
    }

    /* private Projeto getProjeto(Long id) {
        return projetoDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "conta não encontrada"));
    }
    */

}
