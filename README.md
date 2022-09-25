# Дипломный проект профессии «Тестировщик»

## О проекте

В проекте необходимо автоматизировать тестирование комплексного сервиса, взаимодействующего с СУБД и API банка.

Автоматизируемое приложение представляет из себя веб-сервис по продаже тура. Приложение предлагает купить тур по определенной цене с помощью двух способов:
1. Оплата по дебетовой карте
2. Кредит по данным банковской карты

Данные по картам, в зависимости от способа оптаты, пересылаются банковским сервисам:
1. Сервис платежей (Payment Gate)
2. Кредитный сервис (Credit Gate)

Приложение сохраняет в собственной СУБД информацию о способах совершения платежей и результатах транзакций.

Полное описание задачи доступно по [ссылке](https://github.com/netology-code/qa-diploma)

## Документация

[План автоматизации тестирования](https://github.com/KleshchenkoSergei/qa-diploma-kleshchenko/blob/main/documents/Plan.md)

[Отчет о тестировании](https://github.com/KleshchenkoSergei/qa-diploma-kleshchenko/blob/main/documents/Report.md)

[Отчет об автоматизации](https://github.com/KleshchenkoSergei/qa-diploma-kleshchenko/blob/main/documents/Summary.md)

## Автоматизация

### Настройка среды для тестирования

1. Установить Docker, настроить его на IP 192.168.99.100 и запустить
2. Клонировать [репозиторий проекта](https://github.com/KleshchenkoSergei/qa-diploma-kleshchenko)
3. Установить и запустить Intellij IDEA
4. Установить плагины Docker и Lombok в Intellij IDEA

### Запуск MySQL, PostgresSQL, NodeJS и теструемого приложения

1. Во вкладке терминала Intellij IDEA (далее терминала) ввести команду 'docker-compose up' и дождаться окончания загрузки
2. В новой вкладке терминала запустить тестируемое приложение (в зависимости от используемой БД)
    - для MySQL:'java "-Dspring.datasource.url=jdbc:mysql://192.168.99.100:3306/app" -jar artifacts/aqa-shop.jar'
    - для PostgresSQL: 'java "-Dspring.datasource-postgresql.url=jdbc:postgresql://192.168.99.100:5432/app" -jar artifacts/aqa-shop.jar'
   Дождаться зарпуска приложения. Приложение будет доступно по ссылке: [http://localhost:8080](http://localhost:8080)

### Запуск тестов

В новой вкладке терминала ввести команду:
- MySQL: 'gradlew clean test "-Ddb.url=jdbc:mysql://192.168.99.100:3306/app"'
- PostgresSQL: 'gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"'

### Подготовка отчета Allure

После запуска тестов в новой вкладке терминала ввести команду: ./gradlew allureServe.
Отчет автоматически сформируется и откроется в браузере


