# ElectricityCalculator
## Проект "Калькулятор электроэнергии"

Цель проекта - создать калькулятор для расчета стоимости потребляемой за месяц электроэнергии по двухтарифному электросчетчику. 
Необходимо учесть разницу в стоимости потребления в двух зонах — дневной (с 7.00 до 23.00) и ночной (с 23.00 до 7.00), а также разницу в системе расчетов
при потреблении электроэнергии в пределах нормы - 85 кВт/ч за месяц, и сверх нормы.

### Входные данные: 
Показания элекросчетчика по тарифу 'День' и по тарифу 'Ночь' за предыдущий и текущий месяцы.

### Реализовано:

Входные данные запрашиваются у пользователя, считываются с помощью сканера и сохраняются в переменные типа `int`.
Для реализации расчетов сверх нормы портебления по тарифу 'День' и по тарифу 'Ночь' созданы два статических метода `sumDay()` и `sumNight()`.
Методика выбора системы расчетов при потреблении электроэнергии в пределах, либо сверх нормы определяется оператором  `if`. Результаты расчетов выводятся на экран.

Но в связи с тем, что используемая в основе программы переменная `double` не дает необходимой арифметической точности при вычислениях и искажает конечные расчеты, 
принято решение о целесообразности замены ее на объекты класса `BigDecimal`.

Создана отдельная ветка bigDecimal. В ней реализованы расчеты дробных (с плавающей точкой) чисел с помощью специального класса `BigDecimal`. Благодаря этому классу 
добиваемся максимальной точности в конечном результате вычислений.
