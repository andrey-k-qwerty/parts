package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import system.dao.PartDao;
import system.dao.PartDaoImpl;
import system.model.Part;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PartServiceImpl implements PartService {

    private PartDao partDao = new PartDaoImpl();


    @Override
    public List<Part> allParts() {
        return partDao.allParts();
    }

    @Override
    public void add(Part part) {
      partDao.add(part);
    }

    @Override
    public void delete(Part part) {
        partDao.delete(part);
    }



    @Override
    public void update(Part part) {
     partDao.update(part);

    }

    @Override
    public Part getPartById(int id) {
        return  partDao.getPartById(id);
    }
}
