# Rentucha Android App + Spring Boot REST API

Мобильное приложение Rentucha позволяет изучить предложения рынка о посуточной аренде жилья. Все
апартаменты отображаются на карте, что добавляет наглядности и удобства для пользователя

![Preview gif](docs/preview.gif "Пример работы")

## Содержание

- [Технологии](#технологии)
- [Загрузка приложеия](#загрузка-приложеия)
- [REST API](#REST-API)
- [Зачем вы разработали этот проект?](#Зачем-вы-разработали-этот-проект)
- [TODO](#todo)
- [Источники](#источники)
- [Использование](#использование)

## Технологии

* [Yandex MapKit](https://yandex.ru/dev/maps/mapkit)
* [Retrofit](https://square.github.io/retrofit/)
* [Picasso](https://square.github.io/picasso/)
* [Material Design](https://m2.material.io/develop/android)
* [Spring Boot](https://spring.io/)
* [Lombok](https://projectlombok.org/)
* [H2 Database](https://www.h2database.com/)

## Загрузка приложеия

Последнюю версию приложения можно скачать на [странице релизов](https://github.com/qwonix/rentucha/releases).

### Загрузка исходников сервера

```shell
git clone https://github.com/qwonix/rentucha-api.git
cd rentucha-api
```

### Запуск сервера

```shell
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8085
```

# REST API

Простейший REST API, предоставляющий доступ к базе данных,
хранящей объекты Apartment.

Список запросов и подробное описание в [Rentucha REST API](rentucha-api/README.md)

### Зачем вы разработали этот проект?

Приложение разработано в рамках курсовой работы 4 кура ФСПО ГУАП на тему «Разработка мобильного
приложения Система бронирования жилья»

## TODO

- [x] Добавить README
- [ ] Исправить отображение SplashScreen
- [ ] Оптимизировать отображение маркеров на карте
- [ ] Улучшить алгоритмы поиска по запросу
- [ ] Добавить рейтинг для апартаментов

## Источники

Дизайн приложения основан на
дизайн [iOS Airbnb App](https://apps.apple.com/ru/app/airbnb/id401626263), однако имеет ряд
упрощений:

* отсутствие анимаций переходов
* использование карты Yandex MapKit
* упрощенный функционал

## Использование

Для работы приложения необходимо запустить
сервер [Rentucha API](https://github.com/qwonix/rentucha-api)
и указать его адрес в `apikey.properties`. А также указать
ключ [Yandex MapKit](https://developer.tech.yandex.ru/services/)