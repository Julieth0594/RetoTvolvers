Feature: As a user, I need to add products to the cart to validate that the total value of the purchase corresponds
  to that of the products.

  Background:
    Given the user is on the website automation practice

  @SearchBar
  Scenario: Search bar
    When the user adds 3 products of Faded Short Sleeve T-shirts to the cart
    Then the user will be able to visualize the total value of the purchase

  @Women'sSection
  Scenario Outline: Women's section
    When the user selects <quantity> products of <product> from the women's section
    Then the user can verify the total <value> of the products
    Examples:
      | quantity | product               | value  |
      | 3        | Blouse                | $81.00 |
      | 2        | Printed Chiffon Dress | $32.80 |