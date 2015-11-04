package br.com.caelum.tarefas.model;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {
	
	private Long id;
	@NotNull
	@Size(min = 5)
	private String descricao;
	private Boolean finalizado;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataFinalizacao;

	public Tarefa() {
		super();
	}

	public Tarefa(Long id, String descricao, Boolean finalizado, Calendar dataFinalizacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.finalizado = finalizado;
		this.dataFinalizacao = dataFinalizacao;
	}

	public String toString(){
		return "[" + (this.id != null ? this.id.toString() : "id nulo") + "][" + this.descricao + "][" + (this.finalizado != null ? this.finalizado.toString() : "finalizado nulo") + "][" + (this.dataFinalizacao != null ? this.dataFinalizacao.getTime().toString() : "data nula")  + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
}
