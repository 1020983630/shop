package com.example.order.repository;

import com.example.order.pojo.DisLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DisLockRepository extends JpaRepository<DisLock, Integer>, JpaSpecificationExecutor<DisLock> {

}
