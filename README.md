# payments_mvc
Payments System (1'st module project)

    + 1.	Вынести из сервисов паттерн command в модуль web.
    + 2.	Переписать сервисы, наподобие dao.
3.	Написать тесты на сервисы.
4.	Написать тесты на dao.
5.	Преобразовать dao. Вынести общие методы в абстрактный класс. Подумать над названиями методов.
6.	Реализовать аутентификационный фильтр с запросом на сервисы.
7.	Реализовать правильно logger.
    + 8.	Попробовать использовать транзакции.
    + 9.	Разобраться с connection pool.
10.	Проверить правильность пакетов.
11.	Конфигурационную информацию хранить в properties-файле, например, такую как: параметры соединения с БД, граничные значения предметной области и сервера приложений (рекомендуется Tomcat).
12. Пофиксать properties файлы, т.к. не видит зависимости и выдает warnings.
13.	javadoc
    + 14. Изучить ThreadLocal http://articles.javatalks.ru/articles/17
15. Валидация?
16. Локальные переменные перенести как переменные класса
17. Проверить все зависимости
    + 18. Переделать синглтоны
19. web зависит только от сервисов
20. Исправить пакеты
21. Должен ли сервисный метод бросать SQLException
22. Создать builders
23. Создать парсер параметров запроса
