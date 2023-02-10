package com.samucatezu.springdatajpadio.controller;

import com.samucatezu.springdatajpadio.entity.Matricula;
import com.samucatezu.springdatajpadio.entity.form.MatriculaForm;
import com.samucatezu.springdatajpadio.service.impl.MatriculaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

  @Autowired
  private MatriculaServiceImpl service;

  @PostMapping
  public Matricula create(@Valid @RequestBody MatriculaForm form) {
    return service.create(form);
  }

  @GetMapping
  public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
    return service.getAll(bairro);
  }

}

