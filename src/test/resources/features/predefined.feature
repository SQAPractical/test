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
    Then I wait for element with xpath "//div[@id='b_content']" to be present
    Then element with xpath "//div[@id='b_content']" should contain text "Cucumber"


  @predefined3
  Scenario: Predefined steps for Yahoo
    Given I open url "https://search.yahoo.com/"
    Then I wait for element with xpath "//*[@id='logo']" to be present
    Then element with xpath "//input[@id='yschsp']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='yschsp']"
    Then I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@id='results']" to be present
    Then element with xpath "//div[@id='results']" should contain text "Cucumber"


  @predefined4
  Scenario: Predefined steps for gibiru
    Given I open url "https://gibiru.com"
    Then I wait for element with xpath "//img[@title='Gibiru']" to be present
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='starter-template']" to be present
    Then element with xpath "//div[@class='starter-template']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for duckduckgo
    Given I open url "https://duckduckgo.com/"
    Then I wait for element with xpath "//*[@id='logo_homepage_link']" to be present
    Then element with xpath "//*[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//*[@name='q']"
    Then I click on element with xpath "//*[@type='submit']"
    Then I wait for element with xpath "//div[@class='results--main']" to be present
    Then element with xpath "//div[@class='results--main']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for swisscows
    Given I open url "https://swisscows.com/"
    Then I wait for element with xpath "//img[@alt='Swisscows']" to be present
    Then element with xpath "//input[@type='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@type='text']"
    Then I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for searchencrypt
    Given I open url "https://www.searchencrypt.com/home"
    Then I wait for element with xpath "//img[@alt='logo']" to be present
    Then element with xpath "//input[@placeholder='Search...']" should be present
    When I type "behavior driven development cucumber" into element with xpath "//input[@placeholder='Search...']"
    Then I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for startpage
    Given I open url "https://www.startpage.com"
    Then I wait for element with xpath "//div[@class='home__section__search-logo']" to be present
    Then element with xpath "//input[@id='q']" should be present
    When I type "behavior driven development" into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//div[@class='ico']"
    Then I wait for element with xpath "//div[@class='show-results']" to be present
    Then element with xpath "//div[@class='show-results']" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for yandex
    Given I open url "https://yandex.com/"
    Then I wait for element with xpath "//div[@aria-label='Yandex']" to be present
    Then element with xpath "//input[@id='text']" should be present
    When I type "behavior driven development" into element with xpath "//input[@id='text']"
    Then I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='main serp i-bem main_js_inited serp_js_inited']" to be present
    Then element with xpath "//div[@class='main serp i-bem main_js_inited serp_js_inited']" should contain text "Cucumber"

  @predefined10
  Scenario: Predefined steps for boardreader
    Given I open url "http://boardreader.com/"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "behavior driven development cucumber" into element with xpath "//input[@id='title-query']"
    Then I click on element with xpath "//button[@value='Go']"
    Then I wait for element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" to be present
    Then element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" should contain text "Cucumber"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I wait for element with xpath "//a[@title='More about Ecosia']" to be present
    When I type "behavior driven development" into element with xpath "//input[@name='q']"
    Then I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='mainline-results']" to be present
    Then element with xpath "//div[@class='mainline-results']" should contain text "Cucumber"






    