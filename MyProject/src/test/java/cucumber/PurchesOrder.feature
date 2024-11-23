
@tag
Feature: Purchases the order from e-commerce website
  I want to use this template for my feature file

  Background: 
  Given I landed on Ecommerce page
  @Regrassion
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productname> to cart
    And Checkout product <productname> and submit the order
    Then "Thankyou for the order." message displayed on confirmation page

    Examples: 
      | name  							 | password | productname  |
      |cybersonet07@gmail.com|Sk@876844 | ZARA COAT 3  |
