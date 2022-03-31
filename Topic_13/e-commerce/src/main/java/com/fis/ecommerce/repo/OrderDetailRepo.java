package com.fis.ecommerce.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fis.ecommerce.entity.OrderDetail;
import com.fis.ecommerce.entity.Product;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
	@Query("Select od.product From OrderDetail od  WHERE od.order.date >= :startDate AND od.order.date <= :endDate GROUP BY od.product ORDER BY sum(od.quantity) DESC")
	List<Product> findBestSellingProduct(Date startDate, Date endDate, Pageable pageable);
}
