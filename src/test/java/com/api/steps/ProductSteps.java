package com.api.steps;

import com.api.services.ProductService;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class ProductSteps {

    @When("User submits login information")
    public void createToken() {
        ProductService.createToken();
    }

    @Then("The user has logged in successfully")
    public static void validateToken() {
        ProductService.validateToken();
    }

    @When("The user adds a product")
    public void addProduct() {
        ProductService.addProduct();
    }

    @Then("The product was added successfully")
    public void validatePostProduct(){
        ProductService.validatePostProduct();
    }

    @When("The user updates the product")
    public void updateProduct() {
        ProductService.updateProduct();
    }

    @Then("The product has been updated successfully")
    public void validatePutProduct(){
        ProductService.validatePutProduct();
    }

    @And("The user deletes the product")
    public void deleteProduct() {
        ProductService.deleteProduct();
    }
}
