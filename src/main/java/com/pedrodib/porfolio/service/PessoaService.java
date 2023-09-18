package com.pedrodib.porfolio.service;

import com.pedrodib.porfolio.model.Pessoa;
import com.pedrodib.porfolio.repository.PessoaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaDao pessoaDao;

    public List<Pessoa> getAllPessoas() {
        return pessoaDao.findAll();
    }

}
