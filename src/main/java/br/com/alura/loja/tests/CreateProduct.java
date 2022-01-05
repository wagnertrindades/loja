package br.com.alura.loja.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.ProductDao;
import br.com.alura.loja.model.Product;

public class CreateProduct {
	public static void main(String[] args) {
		Product smartphone = new Product();
		smartphone.setName("IPhone 26");
		smartphone.setDescription("Apple smartphone with virtual reality");
		smartphone.setPrice(new BigDecimal("700"));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		EntityManager em = factory.createEntityManager();
		
		ProductDao productDao = new ProductDao(em);
		
		em.getTransaction().begin();
		productDao.create(smartphone);
		em.getTransaction().commit();
		em.close();
	}
}
