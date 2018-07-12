package application.data.repository;

import application.data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query("select count(o.id) from tbl_order o")
    long getTotalOrders();

    @Query("select o from tbl_order o where o.username = :username")
    List<Order> getOrderByUser(@Param("username")String username);

    @Query("select count(o.id) from tbl_order o where o.username = :username")
    long getTotalOrdersByUsername(@Param("username")String username);
}
