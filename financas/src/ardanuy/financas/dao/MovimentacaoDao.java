package ardanuy.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ardanuy.financas.modelo.Conta;
import ardanuy.financas.modelo.Movimentacao;

public class MovimentacaoDao {
	
	private EntityManager entityManager; 
	
	public MovimentacaoDao(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public List<Movimentacao> listaMovimentacoesPorConta(Conta conta){
		Query query = entityManager.createQuery("select m from Movimentacao m where m.conta=:pConta"
				+ " order by m.valor desc");
		
		query.setParameter("pConta", conta);
		
		return query.getResultList();
	}

}
