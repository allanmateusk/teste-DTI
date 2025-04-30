package com.example.teste_dti.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste_dti.models.Estudante;
import com.example.teste_dti.service.EstudanteService;

@RestController
@RequestMapping("/api/estudantes")
@CrossOrigin(origins = "http://localhost:3000")
public class EstudanteController {
    private final EstudanteService service;

    public EstudanteController(EstudanteService service) {
        this.service = service;
    }

    @PostMapping
    public Estudante criar(@RequestBody Estudante e) {
        return service.Salvar(e);
    }

    @GetMapping
    public List<Estudante> listar() {
        return service.listar();
    }

    @GetMapping("/medias")
    public List<Double> mediasPorDisciplina() {
        return service.mediasPorDisciplina();
    }

    @GetMapping("/relatorios")
    public Map<String, Object> relatorios() {
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("acimaMedia", service.acimaMediaTurma());
        resposta.put("baixaFrequencia", service.baixaFrequencia());
        return resposta;
    }

    @GetMapping("/saida")
    public String formatarSaida() {
        List<Estudante> estudantes = service.listar();
        List<Double> medias = service.mediasPorDisciplina();
        List<Estudante> acima = service.acimaMediaTurma();
        List<Estudante> baixa = service.baixaFrequencia();
    
        StringBuilder sb = new StringBuilder();
    
        for (Estudante e : estudantes) {
            String notasFormatadas = e.getNotas().stream()
                .map(n -> String.format("%.0f", n))
                .collect(Collectors.joining(" "));
    
            sb.append(String.format("%s %s %.0f%%",
                e.getNome(), notasFormatadas, e.getFrequencia()
            ));
        }
    
        sb.append(medias.stream()
                .map(v -> String.format("%.0f", v))
                .collect(Collectors.joining(" ")) + "");
    
        if (!acima.isEmpty())
            acima.forEach(a -> sb.append(a.getNome() + ""));
        else
            sb.append("");
    
        if (!baixa.isEmpty())
            baixa.forEach(b -> sb.append(b.getNome() + ""));
        else
            sb.append("");
    
        return sb.toString();
    }
}