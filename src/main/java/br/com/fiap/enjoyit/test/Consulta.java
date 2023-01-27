package br.com.fiap.enjoyit.test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("enjoyit");
		//EntityManager em = emf.createEntityManager();
		
		try {
			
			consultarUltimaCompra();
			consultarFrequencia();
			consultarTicketMedio();
			consultarCervejaFavorita();
		
		} finally {
			
			//em.close();
			emf.close();
		}
	}
	
	public static void consultarUltimaCompra() {
		
		// Recupera a data da ultima compra de um cliente 
		
		EntityManager em = Persistence.createEntityManagerFactory("enjoyit").createEntityManager();
		
		Query consulta = em.createQuery("SELECT MAX(p.dataEmissao) FROM Pedido p WHERE p.consumidor = '5511991234567'");
		GregorianCalendar data = (GregorianCalendar) consulta.getSingleResult();		
		System.out.println( "data_ultima_visita:  " + data.getTime());
		
		em.close();
	}

	public static void consultarFrequencia() {
		
		// Recupera a quantidade de compras de um cliente - periodo mensal

		EntityManager em = Persistence.createEntityManagerFactory("enjoyit").createEntityManager();
		
		Query consulta = em.createQuery("SELECT COUNT(p.id) FROM Pedido p WHERE p.consumidor = '5511991234567' AND "
				+ "p.dataEmissao BETWEEN :i AND :f ");
		
		Calendar inicio = new GregorianCalendar(2021,Calendar.SEPTEMBER,01);
		Calendar fim = new GregorianCalendar(2021,Calendar.SEPTEMBER,30); 
		
		Long quantidade = (Long)consulta
				.setParameter("i", inicio)
				.setParameter("f",fim)
				.getSingleResult();
		System.out.println("quantidade_compras: " + quantidade);	
		
		quantidade = 30 / quantidade;
		System.out.println("tempo_medio_entre_visitas: " + quantidade + " dias");	
		
		em.close();
	}

	public static void consultarTicketMedio() {
		
		// Recupera o valor medio gasto de um cliente

		EntityManager em = Persistence.createEntityManagerFactory("enjoyit").createEntityManager();
		
		Query consulta = em.createQuery("SELECT AVG(p.valorTotal) FROM Pedido p WHERE p.consumidor = '5511991234567'");
		Double valor = (Double) consulta.getSingleResult();		
		System.out.println("ticket_medio:  " + valor);

		em.close();
	}	
	
	public static void consultarCervejaFavorita() {
	
		// Recupera a quantidade pedida de uma determinada marca e estilo de bebida
		// O maior numero indica a bebida que mais agrada ao paladar dos clientes

		EntityManager em = Persistence.createEntityManagerFactory("enjoyit").createEntityManager();
		
		Query consulta = em.createQuery("SELECT c.nome, c.estilo, COUNT(ip.pedido)"
				+ "FROM Cerveja c, ItemPedido ip WHERE c.id = ip.cerveja "
				+ " GROUP BY c.nome, c.estilo");
		
		@SuppressWarnings("unchecked")
		List<Object[]> cerveja = consulta.getResultList();
		
		for(Object[] atributo: cerveja) {
		String nome = (String)atributo[0];
		String estilo = (String)atributo[1];
		Long quantidade = (Long)atributo[2];
		System.out.println("cerveja: " + nome + " estilo: " + estilo + " quantidade_pedida: " + quantidade);
		}
		
		em.close();
	}	
}