Feature: Search Functionality
  As a user
  I want the ability to search for any property of my choice in any area
  So that I can purchase the property

  Scenario Outline: User can search for a property
    Given I navigate to the homepage
    When I enter "<Location>" into the search field
    And I click on For Sale button
    And I select radius "<Radius>" of the location
    And minimum price range of "<MinPrice>"
    And maximum price range of "<MaxPrice>"
    And I select "<MinBed>" as the minimum no of bedrooms
    And I select "<MaxBed>" as the maximum no of bedrooms
    And I select "<Property>" as the property type
    And I select "<AddedToSite>" as Added to site option
    And I click on Find properties button
    And I ensure that Search Result page is displayed
    And I click on the second result
    Then the details of the property is displayed

    Examples: Test data for different properties
      | Location   | Radius          | MinPrice | MaxPrice | MinBed | MaxBed | Property | AddedToSite   |
      | Manchester | Within 10 miles | 125,000  | 250,000  | 2      | 4      | Houses   | Last 7 days   |
      | London     | Within 1 mile   | 250,000  | 500,000  | 2      | 4      | Houses   | Last 24 hours |
      | Sheffield  | Within 5 miles  | 125,000  | 200,000  | 3      | 5      | Houses   | Last 7 days   |

