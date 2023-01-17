package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller insert ===");
        Seller newSeller = new Seller(null, "Antony", "antony@gmail.com", new Date(), 3000.0, new Department(4,null));
        sellerDao.insert(newSeller);
        System.out.println("Inserted ! new id = " + newSeller.getId());

        System.out.println("\n=== TEST 4: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Updated Completed");

        System.out.println("\n=== TEST 5: seller delete ===");
        sellerDao.deleteById(5);
        System.out.println("Deleted");


        System.out.println("\n=== TEST 6: seller findAll ===");
        List<Seller> listAll = sellerDao.findAll();
        for (Seller obj : listAll) {
            System.out.println(obj);
        }

    }
}