package com.dio.livedio.controller;

import com.dio.livedio.model.JornadaTrabalho;
import com.dio.livedio.service.JornadaService;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

  @Autowired
  JornadaService jornadaService;

  @PostMapping
  public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
    return jornadaService.saveJornada(jornadaTrabalho);
  }

  @GetMapping
  public List<JornadaTrabalho> getJornadaList(){
    return jornadaService.findAll();
  }

  @GetMapping("/{idJornada}")
  public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada)
      throws Exception {
    return ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new Exception("jornada não encontrada.")));
  }

  @PutMapping
  public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
    return jornadaService.updateJornada(jornadaTrabalho);
  }

  @DeleteMapping("/{idJornada}")
  public ResponseEntity deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
    try {
      jornadaService.deleteJornada(idJornada);
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
      return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
  }

}
