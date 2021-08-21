package com.shambhu.catalog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shambhu.catalog.model.Category;
import com.shambhu.catalog.model.CategoryAttributes;
import com.shambhu.catalog.model.Product;
import com.shambhu.catalog.service.CatalogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CatalogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogController.class);

    @Autowired
    CatalogService categoryService;

    @Operation(summary = "Add category in catalog application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category added successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Exception occurred while executing rule",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "Service not available",
                    content = @Content)})
    @PostMapping(path = "/category", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Category> category(@RequestBody Category category) throws JsonProcessingException {
        LOGGER.info("Request for category creation {}",category);
        Category category1 = categoryService.saveCategory(category);
        return ResponseEntity.ok(category1);
    }

    @Operation(summary = "Add product in catalog application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product added successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Exception occurred while executing rule",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "Service not available",
                    content = @Content)})
    @PostMapping(path = "/product", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> product(@RequestBody Product product) {
        LOGGER.info("Request for category creation {}",product);
        Product product1 = categoryService.saveProduct(product);
        return ResponseEntity.ok(product1);
    }


    @Operation(summary = "Add category attributes in catalog application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category attributes added successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Exception occurred while executing rule",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "Service not available",
                    content = @Content)})
    @PostMapping(path = "/categoryAttributes/{categoryId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<CategoryAttributes>> categoryAttributes(@PathVariable Long categoryId, @RequestBody List<CategoryAttributes> categoryAttributes) throws Exception {
        LOGGER.info("Request for category attribute creation {}",categoryAttributes);
        List<CategoryAttributes> categoryattr = categoryService.saveCategoryAttributes(categoryId,categoryAttributes);
        return ResponseEntity.ok(categoryattr);
    }

    @Operation(summary = "Add category attributes in catalog application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category attributes added successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Exception occurred while executing rule",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "Service not available",
                    content = @Content)})
    @GetMapping(path = "/categoryAttributes/{categoryId}")
    public ResponseEntity<List<CategoryAttributes>> getCategoryAttributes(@PathVariable Long categoryId) {
        LOGGER.info("Request for category attribute {}",categoryId);
        List<CategoryAttributes> categoryattr = categoryService.getCategoryAttributes(categoryId);
        return ResponseEntity.ok(categoryattr);
    }


    @Operation(summary = "get product in catalog application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Exception occurred while executing rule",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "Service not available",
                    content = @Content)})
    @GetMapping(path = "/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        LOGGER.info("Request for product attribute {}",productId);
        Product productAttr = categoryService.getProduct(productId);
        return ResponseEntity.ok(productAttr);
    }


}
