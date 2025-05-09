# GraphQL Aggregate Service Demo

This project demonstrates a complex aggregate service using Spring Boot and GraphQL. It implements an e-commerce system that aggregates data from multiple services.

## Features

- GraphQL API for querying and mutating data
- Complex data aggregation across multiple services
- JPA/Hibernate for data persistence
- H2 in-memory database
- GraphiQL interface for testing queries

## Prerequisites

- Java 17 or higher
- Gradle

## Running the Application

```bash
./gradlew bootRun
```

## Accessing the Application

- GraphQL endpoint: http://localhost:8080/graphql
- GraphiQL interface: http://localhost:8080/graphiql
- H2 Console: http://localhost:8080/h2-console

## Example Queries

### Query a Product
```graphql
query {
  product(id: "1") {
    id
    name
    price
    category
  }
}
```

### Query Products by Category
```graphql
query {
  products(category: "Electronics") {
    id
    name
    price
    stockQuantity
  }
}
```

### Query Order with Details
```graphql
query {
  orderWithDetails(id: "1") {
    order {
      id
      customerId
      status
      totalAmount
    }
    customer {
      name
      email
    }
    shippingAddress {
      street
      city
      state
    }
    paymentInfo {
      method
      status
    }
  }
}
```

### Update Order Status
```graphql
mutation {
  updateOrderStatus(id: "1", status: "SHIPPED") {
    id
    status
  }
}
```

## Project Structure

- `model/`: Domain entities
- `repository/`: JPA repositories
- `resolver/`: GraphQL resolvers
- `resources/graphql/`: GraphQL schema

## Configuration

The application uses an H2 in-memory database for demonstration purposes. In a production environment, you would want to:

1. Configure a persistent database
2. Implement proper security measures
3. Add proper error handling
4. Implement real microservice calls for the aggregate data
5. Add caching mechanisms
6. Implement proper logging and monitoring 