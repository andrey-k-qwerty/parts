package system.dao;

import system.model.Part;

import java.util.List;

public interface PartDao {
    List allParts();

    void add(Part part);

    void delete(Part part);

    void update(Part part);

    Part getPartById(int id);

    int getCountNeed();

}
