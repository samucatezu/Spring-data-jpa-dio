package com.samucatezu.springdatajpadio.service.impl;


import com.samucatezu.springdatajpadio.entity.Aluno;
import com.samucatezu.springdatajpadio.entity.AvaliacaoFisica;
import com.samucatezu.springdatajpadio.entity.form.AvaliacaoFisicaForm;
import com.samucatezu.springdatajpadio.entity.form.AvaliacaoFisicaUpdateForm;
import com.samucatezu.springdatajpadio.repository.AlunoRepository;
import com.samucatezu.springdatajpadio.repository.AvaliacaoFisicaRepository;
import com.samucatezu.springdatajpadio.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

  @Autowired
  private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
    AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    avaliacaoFisica.setAluno(aluno);
    avaliacaoFisica.setPeso(form.getPeso());
    avaliacaoFisica.setAltura(form.getAltura());

    return avaliacaoFisicaRepository.save(avaliacaoFisica);
  }

  @Override
  public AvaliacaoFisica get(Long id) {
    return null;
  }

  @Override
  public List<AvaliacaoFisica> getAll() {

    return avaliacaoFisicaRepository.findAll();
  }

  @Override
  public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }
}
