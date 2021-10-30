# Store SpringBoot API with MySQL - Backend Bootcamp.

This document provides an example of a Store REST API.

Main features:
- Manage your store by purchases.
- Add/Update/Delete customers by ID
- Add/Update/Delete purchases by ID
- Add/Update/Delete products  by ID

# CRUD Methods

## customer-controller

| HTTP METHOD             | GET                |
| ----------------------- | ------------------ |
| CRUD OP                 | READ               |
| ​/api/customers         | Get all customers  |
| ​/api​/getCustomerById​ | Get customer by Id |
|                         |

| HTTP METHOD            | CREATE                |
| ---------------------- | --------------------- |
| CRUD OP                | POST                  |
| ​​/api​/customerCreate | Create a new customer |

| HTTP METHOD                   | UPDATE                |
| ----------------------------- | --------------------- |
| CRUD OP                       | PUT                   |
| ​​​/api​/updateCustomer​/{id} | Update customer by ID |

| HTTP METHOD                   | DELETE                |
| ----------------------------- | --------------------- |
| CRUD OP                       | DELETE                |
| ​​​​/api​/deleteCustomer/{id} | Delete customer by ID |

## product-controller

| HTTP METHOD              | GET                |
| ------------------------ | ------------------ |
| CRUD OP                  | READ               |
| ​/api/products           | Get all products   |
| /api/getProductById/{id} | Get products by ID |

| HTTP METHOD              | CREATE                  |
| ------------------------ | ----------------------- |
| CRUD OP                  | POST                    |
| ​​/api/product-create    | Add a new product       |
| ​​/api/product-purchases | Add product to purchase |

| HTTP METHOD                | UPDATE               |
| -------------------------- | -------------------- |
| CRUD OP                    | PUT                  |
| ​​​/api/updateProduct/{id} | Update product by ID |

| HTTP METHOD                 | DELETE               |
| --------------------------- | -------------------- |
| CRUD OP                     | DELETE               |
| ​​​​/api/deleteProduct/{id} | Delete product by ID |

## purchase-controller

| HTTP METHOD               | GET                 |
| ------------------------- | ------------------- |
| CRUD OP                   | READ                |
| ​/api/purchases           | Get all purchases   |
| /api/getPurchaseById/{id} | Get purchases by ID |

| HTTP METHOD            | CREATE                   |
| ---------------------- | ------------------------ |
| CRUD OP                | POST                     |
| ​​/api/purchaseCreate  | Add a new purchase       |
| ​​/api/purchasesCreate | Add purchase to customer |

| HTTP METHOD                 | UPDATE                |
| --------------------------- | --------------------- |
| CRUD OP                     | PUT                   |
| ​​​/api/updatePurchase/{id} | Update purchase by ID |

| HTTP METHOD                  | DELETE                |
| ---------------------------- | --------------------- |
| CRUD OP                      | DELETE                |
| ​​​​/api/deletePurchase/{id} | Delete purchase by ID |

