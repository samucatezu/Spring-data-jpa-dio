package com.samucatezu.springdatajpadio.service.impl;

import com.samucatezu.springdatajpadio.entity.Aluno;
import com.samucatezu.springdatajpadio.entity.Matricula;
import com.samucatezu.springdatajpadio.entity.form.MatriculaForm;
import com.samucatezu.springdatajpadio.repository.AlunoRepository;
import com.samucatezu.springdatajpadio.repository.MatriculaRepository;
import com.samucatezu.springdatajpadio.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

  @Autowired
  private MatriculaRepository matriculaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public Matricula create(MatriculaForm form) {
    Matricula matricula = new Matricula();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    matricula.setAluno(aluno);

    return matriculaRepository.save(matricula);
  }

  @Override
  public Matricula get(Long id) {
    return matriculaRepository.findById(id).get();
  }

  @Override
  public List<Matricula> getAll(String bairro) {

    if(bairro == null){
      return matriculaRepository.findAll();
    }else{
      return matriculaRepository.findAlunosMatriculadosBairro(bairro);
    }

  }

  @Override
  public void delete(Long id) {}



}
