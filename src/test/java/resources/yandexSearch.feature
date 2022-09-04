Feature: Yandex search
Background:
  Given  pre condition
  Scenario Outline: Search Yandex for TeachMeSkills
    Given  Word for search is it "<searchWord>"
    When I navigate to yandex.by
    And I enter my search word
    And I press my search button
    Then  First result contains my search word in title
    Examples:
      | searchWord    |
      | TeachMeSkills |
      | Iphone        |
      | Selenium      |
 Scenario: Verify search result count
    Given Word for search "TeachMeSkills"
    When I enter a search word
    And I press the search button
    Then There are 10 results are present

