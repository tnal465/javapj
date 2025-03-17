package project.repository;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import project.model.Order;

@Mapper
@Repository
public interface OrderDao {
    List<Order> findAll();
}
