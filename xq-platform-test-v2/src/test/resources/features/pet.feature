Feature: Pet feature

  @hi
  Scenario: Fetch Available PETs 1
    Given Kitty is available in the pet store
    When I ask for a pet using Kitty's ID
    Then I get Kitty as result

  @ha
  Scenario: Fetch Available PETs 2
    Given Kitty is available in the pet store
    When I ask for a pet using Kitty's ID
    Then I get Kitty as result

  @ha
  Scenario: Fetch Available PETs 3
    Given Kitty is available in the pet store
    When I ask for a pet using Kitty's ID
    Then I get Kitty as result
