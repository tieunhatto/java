/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3h.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import t3h.DAO.ProductDAO;
import t3h.model.Cart;
import t3h.model.LineItem;
import t3h.model.Product;

/**
 *
 * @author User name
 */
public class CartServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";
        }
        
        String url = "/index.jsp";
        if (action.equals("shop")) {
            url = "/index.jsp";
        } else if (action.equals("cart")) {
            String productCode = request.getParameter("productCode");
            String quantityString = request.getParameter("quantity");
            
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }
            
            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity<0) {
                    quantity = 1;
                }
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }
            
            String path = getServletContext().getRealPath("/WEB-INF/product.txt");
            Product p = ProductDAO.getProduct(productCode, path);
            
            LineItem lineItem = new LineItem();
            lineItem.setProduct(p);
            lineItem.setQuantity(quantity);
            
            if (quantity>0) {
                cart.addItem(lineItem);
            }else if (quantity == 0) {
                cart.removeItem(lineItem);
            }
            
            session.setAttribute("cart", cart);
            url = "/checkout.jsp";
            
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        
    }
    
}
