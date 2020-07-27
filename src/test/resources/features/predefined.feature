@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@value='Google Search'])[2]"
    Then I wait for element with xpath "//div[@id='res']" to be present
    Then element with xpath "//div[@id='res']" should contain text "Cucumber"
    
    
  @predefined2
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com/"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    Then I click on element with xpath "//label[@class='search icon tooltip']//*[local-name()='svg']"


    