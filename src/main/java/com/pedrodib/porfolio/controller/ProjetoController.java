package com.pedrodib.porfolio.controller;
import com.pedrodib.porfolio.model.Pessoa;
import com.pedrodib.porfolio.service.PessoaService;
import com.pedrodib.porfolio.model.Projeto;
import com.pedrodib.porfolio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("projeto")
@ComponentScan
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/read")
    public ResponseEntity<List<Projeto>> getAllProjetos() {
        return projetoService.getAllProjetos();
    }

    @GetMapping("read/risco/{risco}")
    public ResponseEntity<List<Projeto>> getProjetosPorRisco(@PathVariable String risco) {
        return projetoService.getProjetosPorRisco(risco);
    }

    @GetMapping("/cadastro")
    public String showCadastroPage(Model model) {
        List<Pessoa> pessoas = pessoaService.getAllPessoas();
        model.addAttribute("pessoaList", pessoas);
        model.addAttribute("projeto", new Projeto());
        return "Cadastro";
    }
    @PostMapping("/create")
    public String insertProjeto(@ModelAttribute Projeto projeto) {
        projetoService.insertProjeto(projeto);
        return "redirect:/projetos" ;
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProjeto(@PathVariable Long id) {
        return projetoService.deleteProjeto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProjeto(@PathVariable Long id, @RequestBody Projeto projeto) {
        return projetoService.updateProjeto(id, projeto);
    }


    @GetMapping("/projetos")
    public List<Projeto> projetos(Model model) {
        List<Projeto> projetosList = projetoService.getAllProjetos().getBody();
        model.addAttribute("projetos", projetosList);
        return projetosList;
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }


    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello from Thymeleaf!");
        return "helloaaa";
    }


}
