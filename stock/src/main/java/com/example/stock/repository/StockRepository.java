package com.example.stock.repository;

import com.example.stock.pojo.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StockRepository extends JpaRepository<Stock, String>, JpaSpecificationExecutor<Stock> {

    @Transactional
    @Modifying
    @Query("update Stock s set s.surplusNum = s.surplusNum - ?2 where s.goodsId = ?1 and s.surplusNum - ?2 > 0 and s.status = 1 and s.deleteStatus = 0")
    int decr(String goodsId, int num);
}
