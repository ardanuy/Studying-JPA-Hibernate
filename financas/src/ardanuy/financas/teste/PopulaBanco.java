package ardanuy.financas.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import ardanuy.financas.modelo.Conta;
import ardanuy.financas.modelo.Movimentacao;
import ardanuy.financas.modelo.TipoMovimentacao;
import ardanuy.financas.util.JPAUtil;

public class PopulaBanco {

	public static void main(String[] args) {
		
		
		List<Conta> contas = new ArrayList<Conta>();
		
		for(int i=0; i < 10; i++){
			Conta conta = new Conta();
			conta.setTitular("Seu Zeh" + i+1);
			conta.setBanco("Banco " + i+1);
			conta.setNumero("12345" + i+1);
			conta.setAgencia("123" + i+1);
			
			contas.add(conta);
		}

		
		Movimentacao m1 = new Movimentacao();
		m1.setConta(contas.get(contas.size() - 1));
		m1.setData(Calendar.getInstance());
		m1.setDescriao("Conta de luz");
		m1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		m1.setValor(new Float(223.5));
	
		Movimentacao m2 = new Movimentacao();
		m2.setConta(contas.get(contas.size() - 1));
		m2.setData(Calendar.getInstance());
		m2.setDescriao("Condominio");
		m2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		m2.setValor(new Float(100.5));
		
		
		Movimentacao m3 = new Movimentacao();
		m3.setConta(contas.get(1));
		m3.setData(Calendar.getInstance());
		m3.setDescriao("Aluguel");
		m3.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		m3.setValor(new Float(1650.8));

		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		
		for(Conta conta : contas){
			em.persist(conta);
		}
				
		em.getTransaction().commit();
		em.close();
		
		
	}

}
