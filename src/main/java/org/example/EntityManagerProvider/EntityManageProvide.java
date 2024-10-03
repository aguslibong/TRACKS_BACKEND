package org.example.EntityManagerProvider;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManageProvide {
    private static EntityManageProvide emp;
    private EntityManager em;

    private EntityManageProvide() {
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("persistence");
        em = ef.createEntityManager();

    }

    public static EntityManager getEntityManagment() {
        if (null==emp){
            emp = new EntityManageProvide();
        }
        return emp.em;
    }

    public static void closeEntityManager() {
        if (emp.em != null)
            emp.em.close();
            emp = null;
    }
}
