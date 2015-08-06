package br.com.exemploStruts1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.exemploStruts1.bean.PessoaBean;
import br.com.exemploStruts1.entity.Pessoa;
import br.com.exemploStruts1.persistence.PessoaDao;

public class ControllerPessoa extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String cmd = request.getParameter("cmd");
		if(cmd.equalsIgnoreCase("cadastrar")){
			return cadastrar(mapping, form, request, response);
		}
		else if(cmd.equalsIgnoreCase("excluir")){
			return excluir(mapping, form, request, response);
		}
		else if(cmd.equalsIgnoreCase("editar")){
			return editar(mapping, form, request, response);
		}
		else if(cmd.equalsIgnoreCase("atualizar")){
			return atualizar(mapping, form, request, response);
		}
		
		return super.execute(mapping, form, request, response);
	}

	private ActionForward atualizar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			PessoaBean pb = (PessoaBean) form;
			new PessoaDao().alterar(pb.getPessoa());
			request.setAttribute("sucesso", pb.getPessoa().getNome() + " atualizado(a) com sucesso!");
			new Pessoa();
		}
		catch(Exception e){
			request.setAttribute("erro1", "Ocorreu um erro ao atualizar -> " + e.getMessage());
		}
		
		return mapping.findForward("pgcadastro");
	}

	private ActionForward editar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			Integer idPessoa = Integer.parseInt(request.getParameter("id"));
			Pessoa pessoa = new PessoaDao().encontrar(idPessoa);
			PessoaBean pb = (PessoaBean) form;
			pb.setPessoa(pessoa);
		}
		catch(Exception e){
			request.setAttribute("erro", "Ocorreu um erro ao editar -> " + e.getMessage());
		}
		
		return mapping.findForward("pgedicao");
	}

	private ActionForward excluir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			Integer idPessoa = Integer.parseInt(request.getParameter("id"));
			Pessoa pessoa = new PessoaDao().encontrar(idPessoa);
			new PessoaDao().excluir(pessoa);
			request.setAttribute("sucesso", pessoa.getNome() + " excluido(a) com sucesso!");
		}
		catch(Exception e){
			request.setAttribute("erro1", "Ocorreu um erro ao excluir -> " + e.getMessage());
		}
		
		return mapping.findForward("pgcadastro");
	}

	private ActionForward cadastrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			PessoaBean pessoaBean = (PessoaBean) form;
			new PessoaDao().salvar(pessoaBean.getPessoa());
			request.setAttribute("msg", pessoaBean.getPessoa().getNome() + " salvo(a) com sucesso!");			
		}
		catch(Exception e){
			request.setAttribute("erro", "Ocorreu um erro -> " + e.getMessage());
		}
		
		return mapping.findForward("pgcadastro");
	}

}
