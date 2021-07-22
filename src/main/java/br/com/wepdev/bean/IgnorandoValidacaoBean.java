package br.com.wepdev.bean;

import br.com.wepdev.business.RegioesProvider;
import br.com.wepdev.model.Estado;
import br.com.wepdev.model.Regiao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;


@Named("formIgnoreValidate")
@RequestScoped
public class IgnorandoValidacaoBean implements Serializable {
	
	private Collection<Regiao> regioes;
	private Collection<Estado> estados;
	private String siglaRegiao;
	private String siglaEstado;
	private String cidade;

	@Inject
	private FacesContext context;
	
	@PostConstruct
	protected void init() {
		this.regioes = RegioesProvider.getRegioes();
	}

	/**
	 * facesContext.renderResponse() -> Renderiza na hora para a tela, faz com que a resposta seja enviada antes de uma validacao, pula a validacao
	 * @param event
	 */
	public void carregarEstados(ValueChangeEvent event) {
		this.estados = RegioesProvider.getEstadosByRegiao(event.getNewValue().toString());
		//FacesContext context = FacesContext.getCurrentInstance(); // FOI A INJECAO DE DEPENDENCIA DO FACES CONTEXT
		context.renderResponse();
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
