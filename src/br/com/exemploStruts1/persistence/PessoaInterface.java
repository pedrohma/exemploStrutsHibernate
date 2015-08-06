package br.com.exemploStruts1.persistence;

import java.util.List;

import br.com.exemploStruts1.entity.Pessoa;

public interface PessoaInterface {
	
	public void salvar(Pessoa p) throws Exception;
	
	public void alterar(Pessoa p) throws Exception;
	
	public void excluir(Pessoa p) throws Exception;
	
	public Pessoa encontrar(Integer id) throws Exception;
	
	public List<Pessoa> listar() throws Exception;

}
