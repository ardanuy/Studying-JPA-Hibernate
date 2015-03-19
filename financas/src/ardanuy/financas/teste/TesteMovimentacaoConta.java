package ardanuy.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ardanuy.financas.modelo.Conta;
import ardanuy.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query query = em.createQuery("select c from Conta c join fetch c.movimentacoes");
		
		List<Conta> contas = query.getResultList();
		
		System.out.println("numero de contas encontradas: " + contas.size());
		
		for(Conta conta : contas){
			System.out.println("\nNome do Titular: " + conta.getTitular());
			System.out.println("Numero de movimentacoes: " + conta.getMovimentacoes().size());
		}

	}

}
