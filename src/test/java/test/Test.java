package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import context.Singleton;

public class Test {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("catCafeUnit");


		emf.close();
	}
}
