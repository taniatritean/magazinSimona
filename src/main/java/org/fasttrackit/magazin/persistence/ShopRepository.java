package org.fasttrackit.magazin.persistence;

import org.fasttrackit.magazin.domain.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShopRepository extends PagingAndSortingRepository<Shop, Long>
{
}
