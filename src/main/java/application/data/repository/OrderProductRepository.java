package application.data.repository;

import application.data.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Integer> {
//    @Query("select op from tbl_orderproduct op where op.orderid = :orderid")
//    List<OrderProduct> getAllProductsByOrder(@Param("orderid")int orderid);

//    @Query("select op from tbl_orderproduct op where op.productid = :productid and op.orderid = :orderid")
//    OrderProduct findOrderProducsByProductidAndOrderid(@Param("productid") int productid, @Param("orderid") int orderid);

}
