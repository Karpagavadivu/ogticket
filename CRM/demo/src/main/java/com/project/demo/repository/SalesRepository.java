package com.project.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.demo.entity.Sales;
import java.util.List;
public interface SalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findByProductId(Integer productId);
}
