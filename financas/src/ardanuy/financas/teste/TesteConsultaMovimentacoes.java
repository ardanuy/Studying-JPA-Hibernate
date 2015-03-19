package ardanuy.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import ardanuy.financas.dao.MovimentacaoDao;
import ardanuy.financas.modelo.Conta;
import ardanuy.financas.modelo.Movimentacao;
import ardanuy.financas.util.JPAUtil;

public class TesteConsultaMovimentacoes {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(21);
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
		
		List<Movimentacao> movimentacoes = movimentacaoDao.listaMovimentacoesPorConta(conta);
		
		for(Movimentacao mov : movimentacoes){
			System.out.println("\nDescricao.....: " + mov.getDescriao());
			System.out.println("Valor.........: R$ " + mov.getValor());
		}
	}

}
