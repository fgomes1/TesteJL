package com.jlinformatica.domain.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimento_estoque")
public class MovimentoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_movimento", nullable = false)
    private LocalDateTime dataMovimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimento tipo;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;


}
