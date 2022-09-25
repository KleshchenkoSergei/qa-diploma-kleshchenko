# Отчёт о преведенном тестировании

## Краткое описание

Автоматизировно тестирование комплексного сервиса покупки тура, взаимодействующего с СУБД и API Банка.

Общее количество тестов: 54

## Процент успешных/ неуспешных тестов

### СУБД MySQL


![](https://drive.google.com/uc?export=view&id=1DckWJhfF3AWdahO5uyQCv0XOcBWIeJ0j)

* Успешных тестов: 28
* Неуспешных тестов: 26

#### Тестирование UI

![](https://drive.google.com/uc?export=view&id=1YLFLZbl4LS5-y2eAG5gBj09lPA5Unct0)

##### Happy path
* Успешных тестов: 1
* Неуспешных тестов: 1
##### Поля ввода
* Успешных тестов: 23
* Неуспешных тестов: 25
#### Тестирование API

![](https://drive.google.com/uc?export=view&id=1OkoyZMSsxjwO7BD0s1etp1UMT8jsSHF3)
* Успешных тестов: 4
* Неуспешных тестов: 0


### СУБД PostgreSQL

![](https://drive.google.com/uc?export=view&id=1lSzrwkCIRLEABIMb0wbJugxV-kESPbHl)

* Успешных тестов: 26
* Неуспешных тестов: 28

#### Тестирование UI

![](https://drive.google.com/uc?export=view&id=1LVrVi8mwPEi6yw51e2l9ZkX_kXRRMMMl)

##### Happy path
* Успешных тестов: 0
* Неуспешных тестов: 2
##### Поля ввода
* Успешных тестов: 22
* Неуспешных тестов: 26
#### Тестирование API

![](https://drive.google.com/uc?export=view&id=1wVpqc8KqSnfB9WiQofFhFRU0_ehtZvfh)
* Успешных тестов: 4
* Неуспешных тестов: 0

## Общие рекомендации

1. Исправить регистрацию картой с отметкой "DECLINED"
2. Корректировать подписи к полям
3. Запретить регистрацию при невалидных данных владельца карты
4. Запретить регистрацию при невалидных данных месяца и года
5. Корректировать наименование вкладки и название тура

Список дефектов находится по [ссылке](https://github.com/KleshchenkoSergei/qa-diploma-kleshchenko/issues).