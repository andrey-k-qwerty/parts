package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
@Repository
public class PartDaoImpl implements PartDao {

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
    }
}
