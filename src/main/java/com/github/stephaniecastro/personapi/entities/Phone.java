package com.github.stephaniecastro.personapi.entities;

import com.github.stephaniecastro.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data //anotação do lombok que automaticamente insere @Getter, @Setter, @ToString, @EqualsAndHashCode
@Builder //anotação do lombok de padrão de projetos para construção de objetos
@AllArgsConstructor//anotação do lombok que gera construtor com um parâmetro para casa campo da classe
@NoArgsConstructor //anotação do lombok que gera construtor sem parâmetros
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false, unique = true)
    private String number;
}