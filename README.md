# MessageApp REST API



### Endpoints

| Method | Endpoint                    | Description                       |
|:-------|:----------------------------|:----------------------------------|
|`GET`| `/user`              | List all users |
|`POST`| `/user/{name}`      | Insert a user to DB |
|`GET`| `/user/{id}` | Returns a specific user |
|`PUT`| `/user/{id}` | Modifies a specific user |
|`DELETE`| `/user/{id}` | Deletes a specific user |
|`POST`| `/message/{sender}/{receiver}?message=` | Send a message (msg) from `{sender}` registered user to `{receiver}` registered user. |
|`GET`| `/message/{name}` | Returns received message list of a registered user. |


