
@tag
Feature: Validate error messages and product operations on the e-commerce website
  I want to use this template for my feature file

  @ErrorHandaling
  Scenario Outline: Validate login error message
    Given I landed on Ecommerce page
    When Logged in with username <name> and password <password>
    Then I should see an error message "Incorrect email or password."

    Examples: 
      | name  								 | password
      | cybersonet08@gmail.com | Sk@876844   
      
  
