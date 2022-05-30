Feature: As a user I need to make a reservation to acquire a service

  Background:
    Given the user makes a reservation

  @CreateUser
  Scenario: make reservation
    When the user performs the data registration
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | deicy     | rios     | 235        | true        | 2022-05-22 | 2022-05-27 | Breakfast       |
    Then the user will obtain a confirmation of their reservation

  @GetInformation
  Scenario Outline: get information
    When the user gets the data registration with <id>
    Then the user will get the information from the registered with <code>
    Examples:
      | id    | code |
      | 997   | 200  |
      | 40800 | 404  |

  @UpdateInformation
  Scenario Outline: update information
    When the user authorizes updating the information of <id>
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |


    Then the user can validate that the data has been updated with <code>
    Examples:
      | id  | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds | code |
      | 997 | deicy     | rios     | 235        | true        | 2022-05-22 | 2022-05-27 | Breakfast       | 200  |

