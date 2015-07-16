Cloud Endpoints - Spring Framework POC
==================

POC (proof of concept) application using Cloud Endpoints and Spring Framework.

## Authors ##

Alvin Llobrera <alvin.llobrera@cloudsherpas.com>

Jordan Duabe <jordan.duabe@cloudsherpas.com>

Reynald Pader <reynald.pader@cloudsherpas.com>

## Architecture Layers ##
### a. Data Access Object (DAO) Layer ###

This application uses a Data Access Object layer which implements all the persistence logic within the app. In this way, instead of having the domain logic communicate directly with the database, the domain logic speaks to a DAO layer instead. This DAO layer then communicates with the underlying persistence system or service such as Datastore or Cloud SQL.

### b. Service Layer ###

The service layer implements all the business logic in the app. Also if the domain logic needs to make atomic transactions in the persistence layer (via DAO calls), the Service layer is the one responsible in starting and ending the transaction.

### DAO and Service layer ###

Using DAO and service layer helps us to separate persistence logic from the business logic which will reduce coupling in the system. This will help us to easily change a part of the system without affecting the other layer.

### c. Resource ###

Resource layer is the entry point for all HTTP requests. This layer is responsible on accepting request and serving response.


## Interaction between Layers ##

### Models and Data Transfer Object (DTO) ###

Models and Data Transfer Objects (DTO) are Plain Old Java Objects (POJO). Model is used to contain the data that need to be stored in the database such as the entity used for Datastore. On the other hand, DTO is used for containing the data for presentation and for encapsulating data coming outside from the system (such as converting the payload of a HTTP request to a Java object).

Using these two different containers allows us to hide the implementation of the data layer and gives us more control on manipulating and changing the structure of data that we serve (either request or response) without directly affecting the persistence layer.