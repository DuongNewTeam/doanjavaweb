package application.controller.web;


import application.data.model.Cart;
import application.data.model.New;
import application.data.model.Product;
import application.data.model.User;
import application.data.service.CartService;
import application.data.service.NewService;
import application.data.service.ProductService;
import application.data.service.UserService;
import application.model.NewDetailModel;
import application.model.ProductDetailModel;
import application.viewmodel.landing.LandingVM;
import application.viewmodel.productindex.ProductIndexVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/news")
public class NewController extends BaseController {

    @Autowired
    private NewService newService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    public String news(Model model){
        LandingVM vm = new LandingVM();
        this.setLayoutHeaderVM(vm);

        String  username = SecurityContextHolder.getContext().getAuthentication().getName();

        User listUsers = userService.findUserByUsername(username);
        vm.setUser(listUsers);
        ArrayList<New> news = newService.getAll();
        model.addAttribute("news",news);
        return "news";
    }

    @GetMapping(path = "/{newId}")
    public String detailNews(Model model, @PathVariable int newId) {
        LandingVM vm = new LandingVM();
        this.setLayoutHeaderVM(vm);

        String  username = SecurityContextHolder.getContext().getAuthentication().getName();

        User listUsers = userService.findUserByUsername(username);
        vm.setUser(listUsers);

        New existedNew = newService.findOne(newId);
        try {
            ModelMapper modelMapper = new ModelMapper();
            NewDetailModel newDetailModel = modelMapper.map(existedNew,NewDetailModel.class);
            model.addAttribute("news",newDetailModel);
        }catch (Exception e) {
            e.printStackTrace();
        }

        List<Cart> listCart = cartService.findByUserName(username);
        vm.setListCart(listCart);

        model.addAttribute("vm",vm);
        return "news/index";
    }

}
