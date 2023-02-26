# Rentucha REST API

Простейший REST API, предоставляющий доступ к базе данных,
хранящей объекты Apartment.

Разработан в дополнение к [Rentucha Android App](https://github.com/qwonix/rentucha)

## Технологии

* [Spring Boot](https://spring.io/)
* [Lombok](https://projectlombok.org/)
* [H2 Database](https://www.h2database.com/)

## Установка

### Загрузка исходников

```shell
git clone https://github.com/qwonix/rentucha-api.git
cd rentucha-api
```

### Запуск приложения

```shell
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8085
```

# REST API

Пример REST API приложения описан ниже.

## Получить список Apartments

### Запрос

`GET /apartments/`

    curl -i -H 'Accept: application/json' http://localhost:8085/apartments/

### Ответ

    HTTP/1.1 200
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Sun, 26 Feb 2023 12:00:00 GMT
    Keep-Alive: timeout=60
    Connection: keep-alive

    [
        {
            "id": 1,
            "name": "Апартаменты у Чернышевского",
            "description": "Видовая однокомнатная квартира рядом с метро",
            "countryName": "Россия",
            "cityName": "Санкт-Петербург",
            "pricePerNight": 2360.98,
            "maxPersonCount": 4,
            "latitude": 59.869987,
            "longitude": 30.317229,
            "mainImageUrl": "https://i.imgur.com/kT8SwfY.jpeg",
            "creationTimestamp": "2023-02-26T13:54:13.701496"
        },
        {
        ...
        }
    ]

## Получить список Apartments, подходящих по наименованию

### Запрос

`GET /apartments?query=Гостиница`

    curl -i -H 'Accept: application/json' http://localhost:8085/apartments?query=Гостиница

### Ответ

    HTTP/1.1 200
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Sun, 26 Feb 2023 12:00:00 GMT
    Keep-Alive: timeout=60
    Connection: keep-alive

    [
        {
            "id": 2,
            "name": "Гостиница Турист",
            "description": "Хорошая гостиница рядом с парком",
            "countryName": "Россия",
            "cityName": "Санкт-Петербург",
            "pricePerNight": 3670,
            "maxPersonCount": 4,
            "latitude": 59.877279,
            "longitude": 30.328618,
            "mainImageUrl": "https://i.imgur.com/F6kErHG.jpeg",
            "creationTimestamp": "2023-02-26T13:54:13.703491"
        },
        {
        ...
        }
    ]