package peaksoft.dao.impl;

import peaksoft.dao.LaptopsDao;
import peaksoft.enums.OperationSystem;
import peaksoft.models.Laptop;
import peaksoft.service.LaptopsService;
import peaksoft.service.impl.LaptopServiceImpl;

import java.util.List;
import java.util.Map;

public class LaptopsDaoImpl implements LaptopsDao {

    LaptopsService laptopsDao=new LaptopServiceImpl();
    @Override
    public String saveLaptops(Laptop laptops) {
        return laptopsDao.saveLaptops(laptops);
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        return laptopsDao.saveAll(laptops);
    }

    @Override
    public Laptop deleteById(Long id) {
        return laptopsDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        laptopsDao.deleteAll();

    }

    @Override
    public List<Laptop> findAll() {
        return laptopsDao.findAll();
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        return laptopsDao.update(id,laptop);
    }

    @Override
    public Map<OperationSystem, List<Laptop>> groupBy() {
        return laptopsDao.groupBy();
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        return laptopsDao.sortByDifferentColumn(column,ascOrDesc);
    }
}
