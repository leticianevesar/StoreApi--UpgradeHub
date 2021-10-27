package com.example.bootcamp.uh.controller.response;


import com.example.bootcamp.uh.controller.request.ProductRequest;
import com.example.bootcamp.uh.model.Product;
import com.example.bootcamp.uh.service.ProductService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class ProductController {

    private final  ProductService productService;

    public ProductController(ProductService productService, ProductService productService1) {
        this.productService = productService1;

    }

    //get all products
    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(){
        List<Product> products = ProductService.getAllProducts();
        List<ProductResponse> productResponseList = new ArrayList<>();

        for(Product product: products){
            productResponseList.add(new ProductResponse(
                    product.getId(),
                    product.getType(),
                    product.getName(),
                    product.getPrice()
            ));
        }

        return productResponseList;
    }

    //get product by Id
    @GetMapping("/products/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        return new ProductResponse(
                product.getId(),
                product.getType(),
                product.getName(),
                product.getPrice()
        );
    }

    //create product
    @PostMapping(value = "/coffees", consumes = "application/json")
    public ProductResponse createProduct(@RequestBody @Valid ProductRequest productRequest){
        Product product= productService.createProduct(Product.builder()
                .name(productRequest.getName())
                .type(productRequest.getType())
                .price(productRequest.getPrice())
                .build());
        return new ProductResponse(
                product.getId(),
                product.getType(),
                product.getName(),
                product.getPrice()
        );
    }

    //add product to purchase
    @PostMapping(value = "/products/purchases", consumes = "application/json")
    public ProductResponse addProductToPurchase(@RequestBody @Valid Long purchaseId, Long productId){
        Product product = productService.addProductToPurchase(purchaseId, productId);
        return new ProductResponse(
                product.getId(),
                product.getType(),
                product.getName(),
                product.getPrice()
        );
    }

    //update product
    @PutMapping("/products/{id}")
    public ProductResponse updateProduct(@PathVariable Long id,@RequestBody @Valid ProductRequest productToEdit){
        Product product = productService.updateProduct(id, productToEdit);
        return new ProductResponse(
                product.getId(),
                product.getType(),
                product.getName(),
                product.getPrice()
        );
    }
    //remove products from purchase
    @DeleteMapping("/products/purchases/{id}")
    public void removeProductFromPurchase(@PathVariable Long purchaseId, Long productId){
        productService.removeProductFromPurchase(purchaseId, productId);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
    }
}

