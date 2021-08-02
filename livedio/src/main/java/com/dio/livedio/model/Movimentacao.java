package com.dio.livedio.model;

import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao {
  @AllArgsConstructor
  @NoArgsConstructor
  @EqualsAndHashCode
  @Embeddable
  public class MovimentacaoId implements Serializable{
    private long idMovimento;
    private long idUsuario;
  }
  @EmbeddedId
  private MovimentacaoId id;
  private LocalDateTime dataEntrada;
  private LocalDateTime dataSaida;
  private BigDecimal periodo;
  @ManyToOne
  private Ocorrencia ocorrencia;
  @ManyToOne
  private Calendario calendario;

}
