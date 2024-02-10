package ir.resuinventory.controller.servlet;

import ir.resuinventory.model.entity.Product;
import ir.resuinventory.model.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", urlPatterns = "/productController/*")
public class ProductController extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        String url = "/";
        if (requestURI.endsWith("/displayProducts")) {
            url = displayProducts(req, resp);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        String url = "/";
        if (requestURI.endsWith("/displayProducts")) {
            url = displayProducts(req, resp);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }

    private String displayProducts(HttpServletRequest req, HttpServletResponse rsp) throws Exception {

        List<Product> products
                = ProductService.getProductService().selectAllProducts();

        String url;
        if (products != null) {
            if (products.size() <= 0) {
                products = null;
            }
        }

        HttpSession session = req.getSession();
        session.setAttribute("products", products);
        url = "/product";
        return url;
    }
}
