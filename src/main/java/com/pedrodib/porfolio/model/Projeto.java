package com.pedrodib.porfolio.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Projeto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dataInicio;

    private String dataPrevisaoFim;

    private String dataFim;

    private String descricao;

    private String status;

    private Integer orcamento;

    private String risco;

    @ManyToOne
    private Pessoa gerente;


}
