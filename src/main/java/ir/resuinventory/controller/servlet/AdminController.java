package ir.resuinventory.controller.servlet;

import ir.resuinventory.model.entity.Category;
import ir.resuinventory.model.entity.Product;
import ir.resuinventory.model.service.CategoryService;
import ir.resuinventory.model.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminController", urlPatterns = "/adminController/*")
public class AdminController extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        String url = "/admin";
        if (requestURI.endsWith("/displayProducts")) {
            url = displayProducts(req, resp);
        } else if (requestURI.endsWith("/addProduct")) {
            url = addProduct(req, resp);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        String url = "/admin";
        if (requestURI.endsWith("/displayProducts")) {
            url = displayProducts(req, resp);
        } else if (requestURI.endsWith("/loadAddProduct")) {
            url = loadAddProduct(req, resp);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }

    //    [{"id":7,"productName":"ASUS ROG Strix","categories":"Gaming Laptops-Laptops-Electronics"}]
    private String displayProducts(HttpServletRequest req, HttpServletResponse rsp) throws Exception {

        List<Product> products
                = ProductService.getProductService().selectAllFully();

        String url;
        if (products != null) {
            if (products.size() <= 0) {
                products = null;
            }
        }

        HttpSession session = req.getSession();
        session.setAttribute("products", products);
        url = "/admin/products.jsp";
        return url;
    }

    private void displayProduct(){}
    private void editProduct(){}
    private String loadAddProduct(HttpServletRequest req, HttpServletResponse rsp) throws Exception {

        List<Category> categories
                = CategoryService.getCategoryService().selectAll();

        HttpSession session = req.getSession();
        session.setAttribute("categories", categories);

        return "/admin/add_product.jsp";
    }

    private String addProduct(HttpServletRequest req, HttpServletResponse rsp) throws Exception {

        long categoryId = Long.parseLong(req.getParameter("categoryId"));
        String productName = req.getParameter("productName");

        Product product = new Product();
        product.setProductName(productName);
        ProductService.getProductService().insertProduct(product, categoryId);

        return "/admin";
    }
}
