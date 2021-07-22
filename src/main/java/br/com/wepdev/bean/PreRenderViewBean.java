package br.com.wepdev.bean;

import br.com.wepdev.business.RegioesProvider;
import br.com.wepdev.model.Estado;
import br.com.wepdev.model.Regiao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;


@Named("formPreRenderView")
@RequestScoped
public class PreRenderViewBean implements Serializable {
	
	private Collection<Regiao> regioes;
	private Collection<Estado> estados;
	private String siglaRegiao;
	private String siglaEstado;

	/**
	 * PreRenderView e um evento de sistema, o metodo sera chamado quando a tela estiver prestes
	 * a ser montada
	 */
	public void carregarRegioes(ComponentSystemEvent event){
		this.regioes = RegioesProvider.getRegioes();

	}

	public void carregarEstados(ValueChangeEvent event) {
		this.estados = RegioesProvider.getEstadosByRegiao(event.getNewValue().toString());
	}
	
	public Collection<Regiao> getRegioes() {
		return regioes;
	}
	
	public Collection<Estado> getEstados() {
		return estados;
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
