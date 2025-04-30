package com.senai.controle_de_acesso_spring.domain.entity.usuarios;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AQV")
public class AQV extends Usuario{
}
