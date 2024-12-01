Feature: Product Flow

  Scenario: The user performs product adding, updating and deleting operations
    When User submits login information
    Then The user has logged in successfully
    When The user adds a product
    Then The product was added successfully
    When The user updates the product
    Then The product has been updated successfully
    And The user deletes the product

