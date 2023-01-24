package peaksoft;

import peaksoft.dao.LaptopsDao;
import peaksoft.dao.impl.LaptopsDaoImpl;
import peaksoft.enums.OperationSystem;
import peaksoft.models.Laptop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        LaptopsDao service=new LaptopsDaoImpl();
//        System.out.println(service.saveLaptops(new Laptop("Lenovo", OperationSystem.LINUX, 7, 67000, "2004-9-3")));
//        List<Laptop> laptopList = new ArrayList<>(Arrays.asList(
//                new Laptop("Macbook", OperationSystem.WINDOWS, 5,23400,"2012-2-4"),
//                new Laptop("Asus", OperationSystem.LINUX, 9,12000, "2-09-1-6")));
//
//        System.out.println(service.saveAll(laptopList));
//
//
//        System.out.println(service.findAll());

//        System.out.println(service.update(1L, new Laptop("Huawei", OperationSystem.WINDOWS, 8, 98000, "2016-9-7")));


    }
}