Feature: Booking search
  Background:
    Given  this is pre condition
  Scenario Outline: Search hotel on Booking
    When I navigate to booking.com
    Given Word for search is "<searchWord>"
    And I enter search word
    And I press search button
    Then Result contains search word in title
    Then The rating of this hotel contains stars
    Examples:
      | searchWord    |
      | The Langham Sydney |
      | The Ultimo |
      | Rydges World SquareOpens in new window |


  Scenario: Search hotel on Booking
    When I navigate to booking.com
    Given Word for search is "The Langham Sydney"
    Given The rating of this hotel is 9.3 stars
    And I enter search word
    And I press search button
    Then Result contains search word in title
    Then The rating of this hotel contains stars

