package org.fasttrackit.magazin;

import org.fasttrackit.magazin.domain.Product;
import org.fasttrackit.magazin.domain.Shop;
import org.fasttrackit.magazin.dto.ShopDTO;
import org.fasttrackit.magazin.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagazinApplication.class, loader = SpringApplicationContextLoader.class, initializers = ConfigFileApplicationContextInitializer.class)
public class ShopIntegrationTest {


    @Autowired
    private ShopService magazinService;



    @Test
    public void testSave() {

        Shop magazin = new Shop();
        magazin.setNume("Sefora2");
        magazin.setAdresa("str. Ion Agarbiceanu, nr.20");
        magazin.setTelefon("0264-123456");

        Product product1 = new Product();
        product1.setName("paine");
        product1.setPret("1.2");
        Product product2 = new Product();
        product2.setName("lapte");
        product2.setPret("1.2");


        magazin.getProducts().add(product1);
        magazin.getProducts().add(product2);
        magazinService.saveMagazin(magazin);

        List<ShopDTO> shops = magazinService.getShops();
        System.out.println("---------------------"+shops.get(0));


    }

}