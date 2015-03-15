package ardanuy.financas.teste;

import javax.persistence.EntityManager;

import ardanuy.financas.modelo.Conta;
import ardanuy.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setTitular("zeh");
		conta.setBanco("Itau");
		conta.setAgencia("123");
		conta.setNumero("123456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		
		em.close();
		

	}

}
