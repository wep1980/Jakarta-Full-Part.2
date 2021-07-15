package br.com.wepdev.bean;

import br.com.wepdev.business.RegioesProvider;
import br.com.wepdev.model.Estado;
import br.com.wepdev.model.Regiao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;


@Named("formActionEvent")
@SessionScoped
public class ActionEventBean implements Serializable {
	
	private Collection<Regiao> regioes;
	private Collection<Estado> estados;
	private String siglaRegiao;
	private String siglaEstado;
	
	@PostConstruct
	public void init() {
		regioes = RegioesProvider.getRegioes();
	}
	
	public Collection<Regiao> getRegioes() {
		return regioes;
	}
	
	public Collection<Estado> getEstados() {
		return estados;
	}
	
	public void carregarEstados(ActionEvent event) {
		this.estados = RegioesProvider.getEstadosByRegiao(siglaRegiao);
	}

	public String getSiglaRegiao() {
		return siglaRegiao;
	}

	public void setSiglaRegiao(String siglaRegiao) {
		this.siglaRegiao = siglaRegiao;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	
}
