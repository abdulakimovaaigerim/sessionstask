package peaksoft.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DatabaseConnection;
import peaksoft.enums.OperationSystem;
import peaksoft.models.Laptop;
import peaksoft.service.LaptopsService;

import java.util.*;
import java.util.stream.Stream;

public class LaptopServiceImpl implements LaptopsService {

    EntityManagerFactory entityManagerFactory = DatabaseConnection.createEntityManagerFactory();

    @Override
    public String saveLaptops(Laptop laptop) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved!";
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Laptop laptop : laptops) {
            entityManager.persist(laptop);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public Laptop deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop laptop = entityManager.createQuery("delete from Laptop where id = ?", Laptop.class).getSingleResult();
        entityManager.setProperty("id", id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;
    }

    @Override
    public void deleteAll() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete  from Laptop ");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Laptop> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> laptops = new ArrayList<>();
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public Laptop update(Long id, Laptop laptops) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop laptop = entityManager.createQuery("select l from Laptop l where l.id = ?", Laptop.class)
                .setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;
    }

    @Override
    public Map<OperationSystem, List<Laptop>> groupBy() {
        Map<OperationSystem, List<Laptop>> map = new HashMap<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.createQuery("select Laptop from Laptop group by ?", Laptop.class).getSingleResult();
        entityManager.getTransaction().begin();
        entityManager.close();
        return map;
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        List<Laptop> laptops = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        switch (column){
            case "asc":
                entityManager.createQuery("select Laptop from Laptop order by ?", Laptop.class).getSingleResult();
                break;
            case "desc":
                entityManager.createQuery("select Laptop from Laptop order by 1", Laptop.class).getSingleResult();
                break;
        }
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        return laptops;
    }
}
