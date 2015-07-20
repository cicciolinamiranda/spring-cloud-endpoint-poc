Cloud Endpoints - Spring Framework POC
==================

POC (proof of concept) application using Cloud Endpoints and Spring Framework.

## Authors ##

Alvin Llobrera <alvin.llobrera@cloudsherpas.com>

Jordan Duabe <jordan.duabe@cloudsherpas.com>

## Architecture Layers ##
### a. Data Access Object (DAO) Layer ###

This application uses a Data Access Object layer which implements all the persistence logic 
within the app. In this way, instead of having the domain logic communicate directly with 
the database, the domain logic speaks to a DAO layer instead. This DAO layer then communicates 
with the underlying persistence system or service such as Datastore or Cloud SQL.

### b. Service Layer ###

The service layer implements all the business logic in the app. Also if the domain logic needs 
to make atomic transactions in the persistence layer (via DAO calls), the Service layer is the 
one responsible in starting and ending the transaction.

### DAO and Service layer ###

Using DAO and service layer helps us to separate persistence logic from the business logic which 
will reduce coupling in the system. This will help us to easily change a part of the system 
without affecting the other layer.

### c. Resource ###

Resource layer is the entry point for all HTTP requests. This layer is responsible on accepting 
request and serving response.


## Interaction between Layers ##

### Models and Data Transfer Object (DTO) ###

Models and Data Transfer Objects (DTO) are Plain Old Java Objects (POJO). Model is used to 
contain the data that need to be stored in the database such as the entity used for Datastore. 
On the other hand, DTO is used for containing the data for presentation and for encapsulating 
data coming outside from the system (such as converting the payload of a HTTP request to a 
Java object).

Using these two different containers allows us to hide the implementation of the data layer and 
gives us more control on manipulating and changing the structure of data that we serve (either 
request or response) without directly affecting the persistence layer.

## Project Structure ##

### api ###
This package contains all the classes for the Resource layer

### config ###
This package contains all classes related to system configuration such as the Spring beans configuration.

### dao ###
This package contains the abstract class for Data Access Object layer. Each class should focus only on a
single kind of data in the database (e.g. 1 class for each table in database) and each method of
every class should perform a basic transaction in the data (e.g. remove field value of a single 
record in a table).
Also, to reduce redundancy, it is recommended to create a BaseDao class which will contain the
common methods/operations for all kind of data such as saveEntity, deleteEntity, getEntity. This
BaseDao should be a super class of all other DAO classes.

### dao.impl ###
The implementing classes of all abstract class in the dao package. Each abstract class in dao package
could have many implementing classes in this package for different persistent provider. Such as the
CustomerDao abstract class could have DatastoreCustomerDaoImpl for Datastore and SQLCustomerDaoImpl
for Cloud SQL. With this approach, it is easy to deploy the system across environments with different
persistent mechanism.

### dto ###
This package contains all POJO as Data Transfer Object.

### model ###
This package contains all POJO as database entity.

### service ###
This package contains all classes for the Service layer.

### util ###
This package contains all utility classes.

## Spring Configuration ##
This app uses a Spring setup that is intended for the App Engine Platform. See [Optimizing Spring for GAE] 
(https://cloud.google.com/appengine/articles/spring_optimization) for more info. 

### Annotated Bean Configuration ###
Instead of a component based scanning which slows the system, this app explicitly define a lazy loaded beans 
through Annotated Bean Configuration classes in the config package. In this way, beans do not contribute to 
the App Engine instance creation time.

### Autowiring ###
Instead of just using the @Autowiring annotation, additional annotations are added during autowiring to help 
reduce latency during instance creation on App Engine. These are:
 
```java
@Autowired
@Qualifier("customerService")
@Lazy
private CustomerService customerService;
```

## Accessing the API ##

On your local machine, navigate to the project's root directory, and execute the
following maven command:

```
#!bash

mvn appengine:devserver
```

Or by using the *dev_appserver.sh* shell script (included in the google-appengine-sdk)
through the following command:

```
#!bash

dev_appserver.sh target/spring-cloud-endpoint-poc-1.0.SNAPSHOT
```

The API explorer can be accessed at the following url: [http://localhost:8080/_ah/api/explorer](http://localhost:8080/_ah/api/explorer)

Note: You may need to enable the 'Load unsafe scripts' option on your browser to
properly load the API.
