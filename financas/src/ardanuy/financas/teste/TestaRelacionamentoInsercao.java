package ardanuy.financas.teste;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;

import ardanuy.financas.modelo.Conta;
import ardanuy.financas.modelo.Movimentacao;
import ardanuy.financas.modelo.TipoMovimentacao;
import ardanuy.financas.util.JPAUtil;

public class TestaRelacionamentoInsercao {

	public static void main(String[] args) {
		Conta conta = new Conta();
		
		conta.setTitular("Andrey");
		conta.setAgencia("1987");
		conta.setNumero("12345");
		conta.setBanco("BB");
		
		Movimentacao m1 = new Movimentacao();
		m1.setConta(conta);
		m1.setData(Calendar.getInstance());
		m1.setDescriao("movimentacao nao persistida diretamente");
		m1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		m1.setValor(new Float(123456.789));
		
	    conta.setMovimentacoes(new ArrayList<Movimentacao>());
	    conta.getMovimentacoes().add(m1);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(m1);
		
		em.getTransaction().commit();
		
		em.close();

	}

}
