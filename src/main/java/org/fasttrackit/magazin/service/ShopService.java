package org.fasttrackit.magazin.service;

import org.fasttrackit.magazin.domain.Product;
import org.fasttrackit.magazin.domain.Shop;
import org.fasttrackit.magazin.dto.ProductDTO;
import org.fasttrackit.magazin.dto.ShopDTO;
import org.fasttrackit.magazin.persistence.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service

public class ShopService {

    @Autowired
    private ShopRepository magazinRepository;

    @Transactional
    public void saveMagazin(Shop magazin) {
        if (magazin.getNume() == null) {
            throw new IllegalArgumentException("Nume can not be null");
        }
        if (magazin.getAdresa() == null) {
            throw new IllegalArgumentException("Adresa can not be null");
        }
        try {
            //open transaction
            magazinRepository.save(magazin);
//            close
        } catch (Exception e) {
            System.out.println("Error when saving magazin " + e);
        }
    }

    @Transactional
    public List<ShopDTO> getShops() {
        Iterator<Shop> iterator =
                magazinRepository.findAll().iterator();


        List<ShopDTO> list = new ArrayList<>();

        while (iterator.hasNext()) {
            Shop shop = iterator.next();

            ShopDTO shopDTO = new ShopDTO();
            shopDTO.setNume(shop.getNume());
            shopDTO.setAdresa(shop.getAdresa());
            shopDTO.setId(shop.getId());


            List<Product> products = shop.getProducts();
            int nrOfProd = 0;
            while (nrOfProd < 5 && products.size() >= 5) {

                Product product = products.get(nrOfProd);
                ProductDTO productDTO = new ProductDTO();

                productDTO.setId(product.getId());
                productDTO.setName(product.getName());
                productDTO.setPret(product.getPret());

                shopDTO.getFirstlements().add(productDTO);
                nrOfProd++;
            }

            list.add(shopDTO);
        }

        return list;


    }
}
