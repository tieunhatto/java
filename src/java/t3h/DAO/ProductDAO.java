/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3h.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import t3h.model.Product;

/**
 *
 * @author User name
 */
public class ProductDAO {

    public static Product getProduct(String code, String filepath) {
        try {
            File file = new File(filepath);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                StringTokenizer stz = new StringTokenizer(line, "|");
                String productCode = stz.nextToken();
                if (code.equalsIgnoreCase(productCode)) {
                    String description = stz.nextToken();
                    double price = Double.parseDouble(stz.nextToken());
                    Product p = new Product();
                    p.setCode(code);
                    p.setDescriptio(description);
                    p.setPrice(price);
                    in.close();
                    return p;
                }
                line = in.readLine();
            }
            in.close();
            return null;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    public static ArrayList<Product> getProducts(String filepath){
        ArrayList<Product>products = new ArrayList<Product>();
        File file = new File(filepath);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line!=null) {
                StringTokenizer stz = new StringTokenizer(line,"|");
                String code = stz.nextToken();
                String description = stz.nextToken();
                String priceAsString = stz.nextToken();
                double price = Double.parseDouble(priceAsString);
                Product p = new Product();
                p.setCode(code);
                p.setDescriptio(description);
                p.setPrice(price);
                products.add(p);
                line = in.readLine();
            }
            in.close();
            return products;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
