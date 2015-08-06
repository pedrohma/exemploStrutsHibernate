package br.com.exemploStruts1.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.exemploStruts1.entity.Pessoa;
import br.com.exemploStruts1.hibernate.HibernateUtil;

public class PessoaDao implements PessoaInterface {
	
	private Session session;
	private Transaction transaction;
	private Query query;

	@Override
	public void alterar(Pessoa p) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(p);
		transaction.commit();
		session.close();
	}

	@Override
	public void excluir(Pessoa p) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(p);
		transaction.commit();
		session.close();
		
	}

	@Override
	public Pessoa encontrar(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		return (Pessoa) session.load(Pessoa.class, id);
	}

	@Override
	public List<Pessoa> listar() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		List<Pessoa> lista = session.createQuery("from Pessoa").list();
		transaction.commit();
		return lista;
	}

	@Override
	public void salvar(Pessoa p) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();
		session.close();		
	}

}
