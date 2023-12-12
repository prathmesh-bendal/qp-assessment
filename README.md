# qp-assessment
Grocery Management System using Spring Boot

**_NOTE:_** this branch uses Mysql DB for in memory DB use  FeatureWihoutDB  branch

## users present in system, pass these credentials while calling api
| username | password | role       |
| -------- | -------- | ---------  |
| user1    | pass1    | normal user|
| user2    | pass2    | normal user|
| user3    | pass3    | normal user|
| admin1   | root1    | admin      |
| admin2   | root2    | admin      |

New Users can be added by modifying userDetailsService method in /src/main/java/com/pbendal/gms/config/SecurityConfig.java

## DB setup
replace following values in src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/{schema}
spring.datasource.username={username}
spring.datasource.password={password}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

## api endpoints

you can import GMS.postman_collection.json file for api testing
### add product
#### endpoint:v1/product Method: POST
sample request payload
```
{
    "id":"p5",
    "name":"eggs",
    "description":"1 dozen eggs",
    "price":50,
    "stock":15
}
```

### list all products
#### endpoint:v1/product/list Method: GET

### list product by ID
#### endpoint:v1/product/list/{id} Method: GET

### update product
#### endpoint:v1/product Method: PUT
sample request payload
```
{
    "id":"p5",
    "name":"eggs",
    "description":"1 dozen eggs",
    "price":50,
    "stock":15
}
```

### delete product
#### endpoint:v1/product/{id} Method: DELETE

### Place order
#### endpoint:v1/order Method: POST
sample request payload
```
{ "items":
	[
	    {
	        "id":"{product id}",
	        "quantity":5
	    },
	    {
	        "id":"p5",
	        "quantity":5
	    }
	]

}
```





