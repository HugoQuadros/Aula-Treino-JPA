package aplicacao;
import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa
{
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(null, "Hugo", "hugo@deloitte.com");
        Pessoa p2 = new Pessoa(null, "Andressa", "andressa@gmail.com");
        Pessoa p3 = new Pessoa(null, "Rita", "rita@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TreinoMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);

        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);
        p.setEmail("andressa@bol.com.br");
        em.persist(p);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
