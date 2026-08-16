Feature: Fake Store API

#adding new scenario
  @GetAPI
  Scenario: Get store API all product
    Given endpoint is 'https://fakestoreapi.com/products'
    When user send GET request
    Then status code is 200
    And validate response product details


  @GetAPI1
  Scenario: Get store API one product
    Given endpoint is 'https://fakestoreapi.com/products/21'
    When user send GET request
    Then status code is 200
    And validate response of single product


  @GetAPI2
  Scenario: Get store API one product
    Given endpoint is 'https://jsonplaceholder.typicode.com/posts/1'
    When user send GET request
    Then status code is 200
    And validate response of single product

    @Post
    Scenario: Create new product
      Given endpoint is "https://fakestoreapi.com/products"
      When user send POST request
      Then status code is 201
      And validate response of newly created product

      @PUT
      Scenario: Update product details
        Given endpoint is "https://fakestoreapi.com/products/1"
        When user send PUT request
        Then status code is 200
        And validate response of updated product

  @Delete
  Scenario: Delete product details
    Given endpoint is "https://fakestoreapi.com/products/21"
    When user send DELETE request
    Then status code is 200
    And validate response of deleted product



