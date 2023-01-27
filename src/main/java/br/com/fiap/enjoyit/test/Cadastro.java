package br.com.fiap.enjoyit.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.enjoyit.domain.Cerveja;
import br.com.fiap.enjoyit.domain.Consumidor;
import br.com.fiap.enjoyit.domain.Estabelecimento;
import br.com.fiap.enjoyit.domain.ItemPedido;
import br.com.fiap.enjoyit.domain.Pedido;

public class Cadastro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("enjoyit");
		//EntityManager em = emf.createEntityManager();
		
		try {
			
			inserirEstabelecimentos();
			inserirClientes();
			inserirCervejas();
			inserirPedidos();
			inserirItensPedidos();
		
		} finally {
			
			//em.close();
			emf.close();
		}
	}
	
	public static void inserirEstabelecimentos() {
		
		EntityManager em = Persistence.createEntityManagerFactory("enjoyit").createEntityManager();
			
		em.getTransaction().begin();
		
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setCnpj("01000000000101");
		estabelecimento.setNome("Cervejaria Tarantino");
		estabelecimento.setDataCriacao(new GregorianCalendar());
		
		try{
		em.persist(estabelecimento);
		em.getTransaction().commit();
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}	
		em.close();
	}
	
	public static void inserirClientes() {
		
		EntityManager em = Persistence.createEntityManagerFactory("enjoyit").createEntityManager();
		
		em.getTransaction().begin();
		
		Estabelecimento estabelecimento = em.getReference(Estabelecimento.class,1);
		
		Consumidor consumidor = new Consumidor();
		consumidor.setTelefone("5511991234567");
		consumidor.setEstabelecimento(estabelecimento);
		consumidor.setCpf("00100000101");
		consumidor.setNome("Alice");
		consumidor.setGenero("F");
		consumidor.setDataNascimento(new GregorianCalendar(1986,Calendar.APRIL,10));
		consumidor.setEmail("alice@email.com.br");
		consumidor.setCep("01000101");
		consumidor.setEndereco("Rua Miguel Nelson Bechara, 001 - Bairro Limao");
		consumidor.setCidade("Sao Paulo");
		consumidor.setEstado("SP");
		
		try{
		em.persist(consumidor);
		em.getTransaction().commit();
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}	
		em.close();
	}
	
	public static void inserirPedidos() {
		
		EntityManager em = Persistence.createEntityManagerFactory("enjoyit").createEntityManager();
		
		em.getTransaction().begin();
		
		Consumidor consumidor = em.getReference(Consumidor.class,"5511991234567");
		
		Pedido pedido1 = new Pedido();
		pedido1.setId(6578);
		pedido1.setConsumidor(consumidor);
		pedido1.setDataEmissao(new GregorianCalendar(2021,Calendar.SEPTEMBER,10));
		pedido1.setFormaPagamento("Credito - cartao");
		pedido1.setValorDesconto(0);
		pedido1.setValorTotal(83.16);
		
		Pedido pedido2 = new Pedido();
		pedido2.setId(6779);
		pedido2.setConsumidor(consumidor);
		pedido2.setDataEmissao(new GregorianCalendar(2021,Calendar.SEPTEMBER,15));
		pedido2.setFormaPagamento("Debito - cartao");
		pedido2.setValorDesconto(0);
		pedido2.setValorTotal(97.02);
		
		Pedido pedido3 = new Pedido();
		pedido3.setId(6885);
		pedido3.setConsumidor(consumidor);
		pedido3.setDataEmissao(new GregorianCalendar(2021,Calendar.SEPTEMBER,23));
		pedido3.setFormaPagamento("Dinheiro");
		pedido3.setValorDesconto(10.00);
		pedido3.setValorTotal(119.36);
		
		Pedido pedido4 = new Pedido();
		pedido4.setId(6910);
		pedido4.setConsumidor(consumidor);
		pedido4.setDataEmissao(new GregorianCalendar(2021,Calendar.SEPTEMBER,25));
		pedido4.setFormaPagamento("Credito- cartao");
		pedido4.setValorDesconto(0);
		pedido4.setValorTotal(64.68);
		
		Pedido pedido5 = new Pedido();
		pedido5.setId(6955);
		pedido5.setConsumidor(consumidor);
		pedido5.setDataEmissao(new GregorianCalendar(2021,Calendar.SEPTEMBER,29));
		pedido5.setFormaPagamento("Credito - cartao");
		pedido5.setValorDesconto(0);
		pedido5.setValorTotal(41.58);
		
		try{
		em.persist(pedido1);
		em.persist(pedido2);
		em.persist(pedido3);
		em.persist(pedido4);
		em.persist(pedido5);
		em.getTransaction().commit();
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}	
		em.close();
	}
	
	public static void inserirCervejas() {
		
		EntityManager em = Persistence.createEntityManagerFactory("enjoyit").createEntityManager();
		
		em.getTransaction().begin();
		
		Cerveja cerveja1 = new Cerveja();
		cerveja1.setNome("Urban Saison");
		cerveja1.setEstilo("Saison");
		cerveja1.setAmargor(25);
		cerveja1.setTeorAlcoolico(6.0);
		
		Cerveja cerveja2 = new Cerveja();
		cerveja2.setNome("Manga IPA");
		cerveja2.setEstilo("West Coast IPA");
		cerveja2.setAmargor(60);
		cerveja2.setTeorAlcoolico(7.0);
		
		try{
		em.persist(cerveja1);
		em.persist(cerveja2);
		em.getTransaction().commit();
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}	
		em.close();
	}
	
	public static void inserirItensPedidos() {
		
		EntityManager em = Persistence.createEntityManagerFactory("enjoyit").createEntityManager();
		
		em.getTransaction().begin();
		
		Pedido pedido1 = em.getReference(Pedido.class,6578);
		Cerveja cerveja1 = em.getReference(Cerveja.class,1);
		
		ItemPedido itemPedido1 = new ItemPedido();
		itemPedido1.setPedido(pedido1);
		itemPedido1.setCerveja(cerveja1);
		itemPedido1.setValorUnitario(20.79);
		itemPedido1.setDoseConsumida(4);
		
		Pedido pedido2 = em.getReference(Pedido.class,6779);
		Cerveja cerveja2 = em.getReference(Cerveja.class,2);
		
		ItemPedido itemPedido2 = new ItemPedido();
		itemPedido2.setPedido(pedido2);
		itemPedido2.setCerveja(cerveja2);
		itemPedido2.setValorUnitario(32.34);
		itemPedido2.setDoseConsumida(3);
		
		Pedido pedido3 = em.getReference(Pedido.class,6885);
		
		ItemPedido itemPedido3 = new ItemPedido();
		itemPedido3.setPedido(pedido3);
		itemPedido3.setCerveja(cerveja2);
		itemPedido3.setValorUnitario(32.34);
		itemPedido3.setDoseConsumida(4);
		
		Pedido pedido4 = em.getReference(Pedido.class,6910);
		
		ItemPedido itemPedido4 = new ItemPedido();
		itemPedido4.setPedido(pedido4);
		itemPedido4.setCerveja(cerveja2);
		itemPedido4.setValorUnitario(32.34);
		itemPedido4.setDoseConsumida(2);
		
		Pedido pedido5 = em.getReference(Pedido.class,6955);
		
		ItemPedido itemPedido5 = new ItemPedido();
		itemPedido5.setPedido(pedido5);
		itemPedido5.setCerveja(cerveja1);
		itemPedido5.setValorUnitario(20.79);
		itemPedido5.setDoseConsumida(2);
		
		try{
		em.persist(itemPedido1);
		em.persist(itemPedido2);
		em.persist(itemPedido3);
		em.persist(itemPedido4);
		em.persist(itemPedido5);
		em.getTransaction().commit();
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}	
		em.close();
	}
}
