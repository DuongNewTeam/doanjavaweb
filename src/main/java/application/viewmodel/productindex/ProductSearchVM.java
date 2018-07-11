package application.viewmodel.productindex;

import application.data.model.User;
import application.model.ProductDetailModel;

import java.util.ArrayList;

public class ProductSearchVM {
    private ArrayList<ProductDetailModel> productDetailModels;
    private String keyWord;

    public ArrayList<ProductDetailModel> getProductDetailModels() {
        return productDetailModels;
    }

    public void setProductDetailModels(ArrayList<ProductDetailModel> productDetailModels) {
        this.productDetailModels = productDetailModels;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    private ProductDetailModel info;

    public ProductDetailModel getInfo() {
        return info;
    }

    public void setInfo(ProductDetailModel info) {
        this.info = info;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
