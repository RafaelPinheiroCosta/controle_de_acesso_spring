package com.senai.controle_de_acesso_spring.interface_ui.controller.usuarios.aluno;


import com.senai.controle_de_acesso_spring.application.service.usuarios.aluno.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    public void criarOcorrenciaAtraso(String idAcesso){
        ocorrenciaService.criarOcorrenciaAtraso(idAcesso);
    }
}
