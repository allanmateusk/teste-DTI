package com.example.teste_dti.service;

import com.example.teste_dti.models.Estudante;
import com.example.teste_dti.repository.EstudanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EstudanteService {
    private final EstudanteRepository repo;

    public EstudanteService(EstudanteRepository repo) {
        this.repo = repo;
    }

    public Estudante Salvar(Estudante e) {
        List<Double> notasCorrigidas = e.getNotas().stream()
            .map(n -> Math.max(0, Math.min(10, n)))
            .collect(Collectors.toList());
        e.setNotas(notasCorrigidas);

        e.setFrequencia(Math.max(0, Math.min(100, e.getFrequencia())));
    
        return repo.save(e);
    }
    

    public List<Estudante> listar() {
        return repo.findAll();
    }

    public List<Double> mediasPorDisciplina() {
        int disciplinas = 5;
        List<Estudante> alunos = listar();
        return IntStream.range(0, disciplinas)
                .mapToDouble(i -> alunos.stream()
                        .mapToDouble(a -> a.getNotas().get(i))
                        .average()
                        .orElse(0.0))
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Estudante> acimaMediaTurma() {
        double mediaTurma = listar().stream()
                .mapToDouble(Estudante::getMedia)
                .average()
                .orElse(0.0);
        return listar().stream()
                .filter(a -> a.getMedia() > mediaTurma)
                .collect(Collectors.toList());
    }

    public List<Estudante> baixaFrequencia() {
        return listar().stream()
                .filter(a -> a.getFrequencia() < 75.0)
                .collect(Collectors.toList());
    }
}