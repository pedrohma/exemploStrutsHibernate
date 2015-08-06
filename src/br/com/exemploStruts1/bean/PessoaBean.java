package br.com.exemploStruts1.bean;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import br.com.exemploStruts1.entity.Pessoa;
import br.com.exemploStruts1.persistence.PessoaDao;

public class PessoaBean extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	
	private Collection<Pessoa> listaPessoas;
	
	public PessoaBean() {
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Collection<Pessoa> getListaPessoas() {
		
		try{
			listaPessoas = new PessoaDao().listar();
		}
		catch(Exception e){
			System.out.println("Erro -> " + e.getMessage());
			e.printStackTrace();
		}
		return listaPessoas;
	}

	public void setListaPessoas(Collection<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}	

}
