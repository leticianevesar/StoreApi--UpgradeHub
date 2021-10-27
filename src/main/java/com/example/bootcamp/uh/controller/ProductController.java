package com.example.bootcamp.uh.controller;

import com.example.bootcamp.uh.controller.request.ProductRequest;
import com.example.bootcamp.uh.exception.ProductNotFound;
import com.example.bootcamp.uh.exception.PurchaseNotFound;
import com.example.bootcamp.uh.model.Product;
import com.example.bootcamp.uh.model.Purchase;
import com.example.bootcamp.uh.repository.ProductRepository;
import com.example.bootcamp.uh.repository.PurchaseRepository;
import com.example.bootcamp.uh.service.ProductService;
import com.example.bootcamp.uh.service.PurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductController {
    ProductService productService;

    private static ProductRepository productRepository;
    private PurchaseRepository purchaseRepository;

    public void ProductService(ProductRepository productRepository, PurchaseService purchaseService, PurchaseRepository purchaseRepository) {
        this.productRepository = productRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public ProductController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    //Create product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    //get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //get product by Id
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFound::new);
    }

    //get purchase by Id
    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id).orElseThrow(PurchaseNotFound::new);
    }

    //add product to purchase
    public Product addProductToPurchase(Long purchaseId, Long productId) {
        Product product = this.getProductById(productId);
        Purchase purchase = this.getPurchaseById(purchaseId);
        purchase.getPurchase_product().add(product);
        return product;
    }

    //remove product from purchase
    public void removeProductFromPurchase(Long purchaseId, Long productId) {
        Product product = getProductById(productId);
        Purchase purchase = this.getPurchaseById(purchaseId);
        purchase.getPurchase_product().remove(product;
    }

    // update product
    public Product updateProduct(Long id, ProductRequest productRequest) {
        Product productToEdit = getProductById(id);
        productToEdit.setType(productRequest.getType());
        productToEdit.setName(productRequest.getName());
        productToEdit.setPrice(productRequest.getPrice());
        return productToEdit;
    }

    @DeleteMapping(value = "/delete-book/{id}")
    public void deleteBook(@PathVariable(value = "id") Long id) {
        productService.deleteProductById(id);

    }
}
