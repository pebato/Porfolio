package com.pedrodib.porfolio.controller;
import com.pedrodib.porfolio.model.Pessoa;
import com.pedrodib.porfolio.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pessoa")
@ComponentScan
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("allPessoas")
    public List<Pessoa> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }

}