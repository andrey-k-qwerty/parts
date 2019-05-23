package system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.dao.PartDao;
import system.dao.PartDaoImpl;
import system.model.Part;

import java.util.List;
@Service
public class PartServiceImpl implements PartService {
    private final PartDao partDao;// = new PartDaoImpl();

    public PartServiceImpl(PartDaoImpl partDao) {
        this.partDao = partDao;
    }


    @Override
    @Transactional
    public List<Part> allParts() {
        return partDao.allParts();
    }

    @Override
    @Transactional
    public void add(Part part) {
      partDao.add(part);
    }

    @Override
    @Transactional
    public void delete(Part part) {
        partDao.delete(part);
    }



    @Override
    @Transactional
    public void update(Part part) {
     partDao.update(part);

    }

    @Override
    @Transactional
    public Part getPartById(int id) {
        return  partDao.getPartById(id);
    }

    @Override
    @Transactional
    public  int getCountNeed() {
     return   partDao.getCountNeed()  ;
    }
}
