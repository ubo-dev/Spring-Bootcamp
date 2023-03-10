package com.ubo.northwind.api.controllers;

import com.ubo.northwind.business.abstracts.ProductService;
import com.ubo.northwind.core.utilites.results.DataResult;
import com.ubo.northwind.core.utilites.results.Result;
import com.ubo.northwind.entities.concretes.Product;
import com.ubo.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController
{
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll()
    {
        return this.productService.getAll();
    }

    @GetMapping("/getProductWithCategoryDetails")
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails()
    {
        return this.productService.getProductWithCategoryDto();
    }

    @GetMapping("/getAllByPage")
    DataResult<List<Product>> getAll(int pageNo, int pageSize)
    {
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getAllDesc")
    DataResult<List<Product>> getAllSorted()
    {
        return this.productService.getAllSorted();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product)
    {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName)
    {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategory")
    public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName,@RequestParam("category") int categoryId)
    {
        return this.productService.getByProductNameAndCategory(productName,categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName)
    {
        return this.productService.getByProductNameContains(productName);
    }
}
