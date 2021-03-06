package application.controller.admin;

import application.constant.Constant;
import application.controller.web.BaseController;
import application.data.model.*;
import application.data.service.CategoryService;
import application.data.service.OrderProductService;
import application.data.service.OrderService;
import application.data.service.ProductService;
import application.model.CategoryDataModel;
import application.viewmodel.admin.AdminVM;
import application.viewmodel.common.ProductVM;
import application.viewmodel.landing.LandingVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping(path="/admin")

public class AdminController extends BaseController{

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping(path = "/manage_product")
    public String admin(Model model) {

        AdminVM vm = new AdminVM();
        LandingVM landing = new LandingVM();
        long totalProducts = productService.getTotalProducts();
        ArrayList<Product> allProducts = productService.getAll();
        vm.setListAllProducts(allProducts);
        vm.setListCategories(categoryService.getListAllCategories());
        vm.setMessageTotalProducts("Số sản phẩm hiện có: " + totalProducts);

        model.addAttribute("landing",landing);
        model.addAttribute("vm",vm);
        return "admin/manage_product";
    }

    @GetMapping(path = "/manage_member")
    public String memberAdmin() {
        return "admin/manage_member";
    }

    @GetMapping(path = "/manage_order")
    public String orderAdmin(Model model) {
        AdminVM vm = new AdminVM();
        LandingVM landing = new LandingVM();
        long totalOrders = orderService.getTotalOrders();

        List<Order> allOrders = orderService.getListOrders();
        vm.setListOrders(allOrders);

        List<OrderProduct> orderProductList = orderProductService.getListAllProductsOrdered();
        vm.setListOrderProducts(orderProductList);
        model.addAttribute("vm",vm);
        return "admin/manage_order";
    }


    @GetMapping(path = "/manage_feedback")
    public String feedbackAdmin() {
        return "admin/manage_feedback";
    }

    @GetMapping(path = "/manage_subscribers")
    public String subscribersAdmin() {
        return "admin/manage_subscribers";
    }
}
