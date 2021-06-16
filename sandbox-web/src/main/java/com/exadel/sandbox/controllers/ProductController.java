package com.exadel.sandbox.controllers;

import com.exadel.sandbox.dto.pagelist.CategoryPagedList;
import com.exadel.sandbox.dto.pagelist.ProductPagedList;
import com.exadel.sandbox.model.vendorinfo.Category;
import com.exadel.sandbox.model.vendorinfo.Product;
import com.exadel.sandbox.service.ProductService;
import com.exadel.sandbox.ui.mappers.UIProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/")
@RestController
public class ProductController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 3;
    private static final String DEFAULT_FIELD_SORT = "name";

    private ProductService productService;
    private UIProductMapper uiProductMapper;

    @DeleteMapping(path = {"product/{productId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){

        log.debug(">>>>>>>>>>controller delete product by Id");

        //productService.deleteProductById(productId);
    }

    @GetMapping(produces = {"application/json"}, path = "product")
    public ResponseEntity<ProductPagedList> listProducts(
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize  ){


        log.debug(">>>>List all products");

        pageNumber=getPageNumber(pageNumber);
        pageSize=getPageSize(pageSize);

        ProductPagedList productList = productService.listProducts(
                PageRequest.of(
                        pageNumber
                        , pageSize
                        , Sort.by(DEFAULT_FIELD_SORT).ascending()));

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //-----------------------------------------------------------
    private int getPageNumber(Integer pageNumber) {
        if (pageNumber == null || pageNumber < 0) {
            return DEFAULT_PAGE_NUMBER;
        }
        return pageNumber;
    }

    private int getPageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 1) {
            return DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }
}
