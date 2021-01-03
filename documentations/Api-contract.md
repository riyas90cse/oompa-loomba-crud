### API Contract Specification

###### Endpoints

##### Base URI : http://localhost:20211

> GET - /api/oompaloompas - Get All OompaLoompas

###### Request
* "http://localhost:20211/api/oompaloompas" can be without limit and page
* "http://localhost:20211/api/oompaloompas?limit=1&page=1" with limit & page as query param

###### Response
```
[
  {
    "name": "Mark Twain",
    "age": 32,
    "jobTitle": "Factory Supervisor"
  }
]
```

> GET - /api/oompaloompas/{id} - Get OompaLoompa Detail By Id

###### Request
"http://localhost:20211/api/oompaloompas/{id}" - ID as Path Variable

###### Response
```
{
  "id": "5ff21c69aec26c31ffa60189",
  "name": "Mark Twain",
  "age": 32,
  "jobTitle": "Factory Supervisor",
  "height": 5.2,
  "weight": 150,
  "description": "Serving legend in Willy Wonka's chocolate factory",
  "createdAt": "01-03-2021 19:35:05",
  "updatedAt": "01-03-2021 19:35:05"
}
```
> POST - /api/oompaloompas - Save OompaLoompa

###### Request
```
{
  "age": 32,
  "description": "Serving legend in Willy Wonka's chocolate factory",
  "height": 5.2,
  "jobTitle": "Factory Supervisor",
  "name": "Mark Twain",
  "weight": 150
}
```

###### Response
```
{
  "id": "5ff21c69aec26c31ffa60189",
  "name": "Mark Twain",
  "age": 32,
  "jobTitle": "Factory Supervisor",
  "height": 5.2,
  "weight": 150,
  "description": "Serving legend in Willy Wonka's chocolate factory",
  "createdAt": "01-03-2021 19:35:05",
  "updatedAt": "01-03-2021 19:35:05"
}
```

> PUT - /api/oompaloompas - Update OompaLoompa

###### Request

http://localhost:20211/api/oompaloompas/{id} - ID as path variable and request body below

```
{
  "age": 32,
  "description": "Serving legend in Willy Wonka's chocolate factory",
  "height": 5.3,
  "jobTitle": "Factory Supervisor",
  "name": "Mark Twain",
  "weight": 150
}
```

###### Response

```
{
  "id": "5ff21c69aec26c31ffa60189",
  "name": "Mark Twain",
  "age": 32,
  "jobTitle": "Factory Supervisor",
  "height": 5.3,
  "weight": 150,
  "description": "Serving legend in Willy Wonka's chocolate factory",
  "createdAt": "01-03-2021 19:35:05",
  "updatedAt": "01-03-2021 19:37:56"
}
```