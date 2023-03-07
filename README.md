# Kata_09

# Implementation Details


**Price:** A class that provides immutable unit price. 

**Product Price:** A class that represents the pricing information for a product.
 It stores the SKU of the product and a pricing rule.  It is a maintainable code, i.e., easy to modify and extend. For instance,  a list of price rule properties can be introduced if a user requests the ability to enable several rules for the same SKU. In that case , additional strategy selector classes may be required for pricing calculation.

**PricingRule:** An interface that defines a method for calculating the price of a given quantity of items based on the pricing rule.

**PricingRuleFactory:** A class that provides factory methods for creating pricing rules.

**BulkPricingRule:** A class implements the PricingRule interface, which defines the getPrice method. It represents a pricing rule for bulk purchasing of a product.

**SimplePricingRule:** A class implements the PricingRule interface, which defines the getPrice method that calculates the total price of a quantity of items using a fixed unit price.

**ShoppingCart:** A class represents a shopping cart that hold a collection of SKU items.

**CheckOut:** A class that represents the checkout system for a store. It contains a map of pricing rules for each SKU and a shopping cart to store scanned items. It provides methods for scanning items and calculating the total price of all items in the cart, taking into account their pricing rules.

**Helper:** It is a simple utility class that adds pricing rules to the given map of pricing rules for a checkout system.


## Design Patterns
The following design patterns are used in the code:

**Strategy Pattern**:

- The PricingRule interface defines a strategy for calculating the price of an item based on its quantity. 
- The SimplePricingRule and BulkPricingRule classes implement this interface to provide different pricing strategies.

**Factory Method Pattern**:

- The PricingRuleFactory class provide factory methods that create instances of PricingRule.

**Dependency Injection**: 

- The CheckOut class takes in pricingRules and cart objects through its constructor instead of creating them internally. 
- This makes Checkout loosely coupled with these dependencies and allows them to be easily replaced with mock objects during testing or runtime.

**Immutable Object Pattern**: 

- The Price class is an immutable object as it has only one constructor, and its fields are final and private.

## SOLID principles 
Followings are implemented to follow SOLID principles: 

**1.	Single Responsibility Principle (SRP):** For instance, CheckOut class is responsible for calculating the total price of all items in the cart, the ShoppingCart class is responsible for keeping track of the items in the cart, and the PricingRule classes are responsible for calculating the price for a given quantity of items based on the pricing rules.

**2.	Open-Closed Principle (OCP):** For instance, the pricing rules can be extended by creating new classes that implement the PricingRule interface without modifying the existing classes. If a new pricing rule is introduced in the future, a new class can be created that implements the PricingRule interface, and the new pricing rule can be added to the pricingRules map in the CheckOut class.

**3.	Liskov Substitution Principle (LSP):** The code use interfaces and inheritance correctly . So objects of superclass can be replaceable with objects of its subclasses. 

**4.	Interface Segregation Principle (ISP):** For instance, PricingRule interface only contains the getPrice method that is needed for calculating the price based on the pricing rules. 

**5.	Dependency Inversion Principle (DIP):** For instance, CheckOut class is dependent on the ProductPrice interface instead of the concrete implementation of the PricingRule classes. This allows for flexibility in choosing the implementation of the PricingRule classes and adheres to the DIP.









