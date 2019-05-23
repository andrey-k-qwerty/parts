package system.service;

import system.model.Part;

import java.util.List;

public interface PartService {
    List<Part> allParts();

    void add(Part part);

    void delete(Part part);

    void update(Part part);

    Part getPartById(int id);

    int getCountNeed();

}
