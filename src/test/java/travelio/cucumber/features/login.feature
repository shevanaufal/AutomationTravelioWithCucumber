Feature: Login to Travelio
  @TDD
  Scenario: User login to travelio
    Given travelio homepage
    Then user click login button
    When user input email as email
    And user input password as password
    And user click masuk button
    Then user verify login




