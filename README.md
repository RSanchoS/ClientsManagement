# Client Managenment

Demo project with clients management and role security

## Installation

Use the package manager [maven](https://maven.apache.org) to install project.

```bash
mvn spring-boot:run
```

## Usage

To consult the REST API calls, please consult the file /src/resources/httpTest.http

To gain access to the API it is necessary to make the following call:

- Admin Access

```http
POST http://localhost:8001/api/v0.1/login HTTP/1.1
Content-Type: application-json

{
    "user": "user1@a.com",
    "password": "password1"
}
```

- User Access

```http
POST http://localhost:8001/api/v0.1/login HTTP/1.1
Content-Type: application-json

{
    "user": "user2@a.com",
    "password": "password2"
}
```

Please copy the Authorization header in order to make the following calls:

- To get all the clients

```http
GET http://localhost:8001/api/v0.1/client HTTP/1.1
Authorization: token
```

- To get a client by email

```http
GET http://localhost:8001/api/v0.1/client/email/user1@a.com HTTP/1.1
Authorization: token
```

- To get clients in the date range

```http
GET http://localhost:8001/api/v0.1/client/birthDate?firstDate=1999-09-30T12:47:29&finalDate=2000-10-30T12:47:29 HTTP/1.1
Authorization: token
```
The following calls can only be accessed with the admin profile.

- To crete a client

```http
POST http://localhost:8001/api/v0.1/client HTTP/1.1
Content-Type: application/json 
Authorization: token


  {
    "email": "user5@a.com",
    "name": "User",
    "surname": "E",
    "birthDate": "2000-09-30T12:47:29+02:00"
  }
```
The object entered must meet the following characteristics.

- Email in correct format.
- Name and surname only with text.
- Date of birth over 14 years old.

- To remove a client

```http
DELETE  http://localhost:8001/api/v0.1/client HTTP/1.1
Content-Type: application/json 
Authorization: 

  {
    "id": 5,  
    "email": "user5@a.com",
    "name": "User",
    "surname": "E",
    "birthDate": "2000-09-30T12:47:29+02:00"
  }
```
To consult the data in database, please consult the file /src/resources/data.sql


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.


