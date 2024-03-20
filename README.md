# PriceHub API

The PriceHub API is a Spring Boot application designed to provide a RESTful endpoint for managing pricing operations. It exposes endpoints for calculating prices, creating new prices, and retrieving all prices.

## Endpoints

### Calculate Price
- **Endpoint:** `/prices/calculate`
- **Method:** POST
- **Description:** Calculates the price based on the provided parameters.
- **Request Body:** PriceApplyingDTO
- **Response:** ResponseEntity\<PriceCalculationDTO\>

### Create Price
- **Endpoint:** `/prices`
- **Method:** POST
- **Description:** Creates a new price based on the provided data.
- **Request Body:** PriceDTO
- **Response:** ResponseEntity\<PriceDTO\>
- **Status Code:** 201 (Created)

### Get All Prices
- **Endpoint:** `/prices`
- **Method:** GET
- **Description:** Retrieves all prices.
- **Response:** ResponseEntity\<List\<PriceDTO\>\>

## Usage

To use the PriceHub API, send requests to the appropriate endpoints with the required parameters. Below are examples of how to use each endpoint:

### Calculate Price
```http
POST /prices/calculate
Content-Type: application/json

{
  "applicationDate": "2024-03-20T10:00:00",
  "productId": 35455,
  "stringIdentifier": "XYZ"
}
```

### Create Price
```http
POST /prices
Content-Type: application/json

{
  "brandId": 1,
  "startDate": "2024-03-20T00:00:00",
  "endDate": "2024-03-31T23:59:59",
  "priceList": 1,
  "productId": 35455,
  "priority": "LOW",
  "price": 35.50,
  "currency": "EUR"
}
```

### Get All Prices
```http
GET /prices
```

#### Response Body Example
```json
[
  {
    "id": 1,
    "brandId": 1,
    "startDate": "2024-03-20T00:00:00",
    "endDate": "2024-03-31T23:59:59",
    "priceList": 1,
    "productId": 35455,
    "priority": "LOW",
    "price": 35.50,
    "currency": "EUR"
  },
  {
    "id": 2,
    "brandId": 1,
    "startDate": "2024-03-14T15:00:00",
    "endDate": "2024-03-14T18:30:00",
    "priceList": 2,
    "productId": 35455,
    "priority": "MEDIUM",
    "price": 25.45,
    "currency": "EUR"
  },
  ...
]
```

## Testing

The API is equipped with tests to validate its functionality. These tests cover various scenarios to ensure accurate and correct results are returned.

## Value Consideration

The PriceHub API focuses on providing accurate pricing information and efficient operations for managing prices. It prioritizes design and construction of the service, code quality, and correctness of results in the tests.