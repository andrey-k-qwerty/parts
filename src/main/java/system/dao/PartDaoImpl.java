package system.dao;

import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import system.model.Part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PartDaoImpl implements PartDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Part> allParts() {
        return sessionFactory.getCurrentSession().createQuery("from Part").list();
    }

    @Override
    public void add(Part part) {
        sessionFactory.getCurrentSession().persist(part);

    }

    @Override
    public void delete(Part part) {
        sessionFactory.getCurrentSession().delete(part);

    }

    @Override
    public void update(Part part) {
        sessionFactory.getCurrentSession().update(part);

    }

    @Override
    public Part getPartById(int id) {
        return sessionFactory.getCurrentSession().get(Part.class, id);
    }

    @Override
    public int getCountNeed() {
        return (int) sessionFactory.getCurrentSession().createSQLQuery("select min(p.count) as c from part p " +
                "where p.need = 1").addScalar("c", IntegerType.INSTANCE).uniqueResult();
    }

/*
    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);
    private static List<Part> parts = new ArrayList<>();

    public static int getAutoId() {
        return AUTO_ID.get();
    }

    public static int nextID() {
        return AUTO_ID.getAndIncrement();
    }

    static {
        parts.add(new Part(AUTO_ID.getAndIncrement(), "материнская плата", true));
        parts.add(new Part(AUTO_ID.getAndIncrement(), "звуковая карта", false));
        parts.add(new Part(AUTO_ID.getAndIncrement(), "процессор", true));
        parts.add(new Part(AUTO_ID.getAndIncrement(), "подсветка корпуса", false));
        parts.add(new Part(AUTO_ID.getAndIncrement(), "HDD диск", false));
        parts.add(new Part(AUTO_ID.getAndIncrement(), "корпус", true));
        parts.add(new Part(AUTO_ID.getAndIncrement(), "память", true));
        parts.add(new Part(AUTO_ID.getAndIncrement(), "SSD диск", true));
        parts.add(new Part(AUTO_ID.getAndIncrement(), "видеокарта", false));

        parts.forEach(part -> part.setCount((int) (Math.random() * 10)));


    }

    @Override
    public List<Part> allParts() {
        return parts;
    }

    @Override
    public void add(Part part) {
        if (part.getId() == 0)
            part.setId(AUTO_ID.getAndIncrement());
        parts.add(part);
    }

    @Override
    public void delete(Part part) {
        parts.remove(part);
    }

    public void deleteById(int id) {
        parts.removeIf(part -> part.getId() == id);
    }

    @Override
    public void update(Part part) {
        parts.stream().filter(p -> p.getId() == part.getId())
                .forEach(p -> {
                    p.setTitle(part.getTitle());
                    p.setNeed(part.isNeed());
                    p.setCount(part.getCount());
                });


    }

    @Override
    public Part getPartById(int id) {
        return parts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }*/
}
