package com.example.test.service.order;

import com.example.test.model.Order;
import com.example.test.service.IGeneralService;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService extends IGeneralService<Order> {
    Page<Order> findAll(Pageable pageable);
}
