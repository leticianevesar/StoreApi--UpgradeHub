package com.example.bootcamp.uh.service;

import com.example.bootcamp.uh.request.ProductRequest;
import com.example.bootcamp.uh.exception.ProductNotFound;
import com.example.bootcamp.uh.exception.PurchaseNotFound;
import com.example.bootcamp.uh.model.Product;
import com.example.bootcamp.uh.model.Purchase;
import com.example.bootcamp.uh.repository.ProductRepository;
import com.example.bootcamp.uh.repository.PurchaseRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;

    public ProductService(ProductRepository productRepository, PurchaseService purchaseService, PurchaseRepository purchaseRepository) {
        this.productRepository = productRepository;
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

    //get Product by Id
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFound::new);
    }

    //get Purchase by Id
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

    //remove product From Purchase
    public void removeProductsFromPurchase(Long purchaseId, Long productId) {
        Product product = getProductById(productId);
        Purchase purchase = this.getPurchaseById(purchaseId);
        purchase.getPurchase_product().remove(product);
    }

    // update product
    public Product updateProduct(Long id, ProductRequest productRequest) {
        Product productToEdit = getProductById(id);
        productToEdit.setType(productRequest.getType());
        productToEdit.setName(productRequest.getName());
        productToEdit.setPrice(productRequest.getPrice());
        return productToEdit;
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public void removeProductFromPurchase(Long purchaseId, Long productId) {
    }
}

