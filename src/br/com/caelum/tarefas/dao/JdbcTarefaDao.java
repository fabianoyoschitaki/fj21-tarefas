package br.com.caelum.tarefas.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import br.com.caelum.tarefas.model.Tarefa;

public class JdbcTarefaDao {
	
	public static List<Tarefa> TAREFAS = new ArrayList<Tarefa>();
	public static long ID = 1L;
	static {
		TAREFAS.add(new Tarefa(ID++, "Criar agenda", true, Calendar.getInstance()));
		TAREFAS.add(new Tarefa(ID++, "Dar comida pra galinha", false, null));
		TAREFAS.add(new Tarefa(ID++, "Plantar farofa", true, Calendar.getInstance()));
		TAREFAS.add(new Tarefa(ID++, "Comprar caminhão", false, null));
	}
	
	public List<Tarefa> lista() {
		return TAREFAS;
	}

	public void adiciona(Tarefa tarefa) {
		if (tarefa.getId() == null){
			tarefa.setId(ID++);
		}
		if (tarefa.getFinalizado() == null){
			tarefa.setFinalizado(Boolean.FALSE);
		}
		TAREFAS.add(tarefa);
	}

	public void remove(Tarefa tarefa) {
		for (Iterator<Tarefa> it = TAREFAS.iterator(); it.hasNext();) {
			Tarefa t = it.next();
			if (tarefa.getId().equals(t.getId())){
				it.remove();
				break;
			}
		}
	}
	
	public void removePorId(Long id) {
		for (Iterator<Tarefa> it = TAREFAS.iterator(); it.hasNext();) {
			Tarefa t = it.next();
			if (id.equals(t.getId())){
				it.remove();
				break;
			}
		}
	}

	public Tarefa buscaPorId(Long id) {
		Tarefa retorno = null;
		for (Tarefa tarefa : TAREFAS) {
			if (tarefa.getId().equals(id)){
				retorno = tarefa;
				break;
			}
		}
		return retorno;
	}

	public void altera(Tarefa tarefa) {
		Tarefa t = this.buscaPorId(tarefa.getId());
		if (t != null){
			t.setDataFinalizacao(tarefa.getDataFinalizacao());
			t.setDescricao(tarefa.getDescricao());
			//TODO verificar porque checkbox passa null em vez de false
			if (tarefa.getFinalizado() != null){
				t.setFinalizado(tarefa.getFinalizado());
			} else {
				t.setFinalizado(Boolean.FALSE);
			}
			
			if (!t.getFinalizado()){
				t.setDataFinalizacao(null);
			}
		}
	}

	public void finaliza(Long id) {
		Tarefa tarefa = buscaPorId(id);
		if (tarefa != null){
			tarefa.setFinalizado(Boolean.TRUE);
			tarefa.setDataFinalizacao(Calendar.getInstance());
		}
	}
}
