# Журнал изменений
## v1.7.0 - 08.07.2023
### Добавлено
* Добавлено перечисление SeparatorType.SPACE.

### Изменено
* Переименован класс Notation -> Notations.
* Переименовано перечисление NotationRegexp -> Regexp.
* Изменена версия Java на 17.
* Переименован метод SeparatorType.getSeparatorSymbol() -> SeparatorType.getSymbol().
* Переименован метод SeparatorType.getAllSeparatorSymbols() -> SeparatorType.getAllSymbols().
* Изменён метод SeparatorType.getAllSymbols().

## v1.6.0 - 14.05.2023
### Добавлено
* Добавлен метод Notation.is(String, NotationType).
* Добавлен метод Notation.isDotCase(String).
* Добавлен метод Notation.toDotCase(String).
* Добавлен метод Notation.isTrainCase(String).
* Добавлен метод Notation.toTrainCase(String).
* Добавлено преобразование слов разделённых пробелами в нотацию.

## v1.5.0 - 19.01.2023
### Добавлено
* Добавлен AUTHOR.MD.
* Добавлен INSTALL.MD.
* Добавлен CHANGELOG.MD.
* Добавлен метод Notation.isUpperCase(String).
* Добавлен метод Notation.isKebabCase(String).
* Добавлен метод Notation.isSnakeCase(String).
* Добавлен метод Notation.isCamelCase(String).
* Добавлен метод Notation.isPascalCase(String).

### Изменено
* Обновлён README.MD.

## v1.4.0 - 16.10.2022
### Добавлено
* Добавлено перечисление NotationType.
* Добавлен метод Notation.to(String, NotationType).
* Добавлен плагин maven-assembly в pom.xml.
* Добавлен плагин maven-compiler в pom.xml.
* Добавлен плагин maven-dependency в pom.xml.
* Добавлен плагин maven-javadoc в pom.xml.
* Добавлен плагин maven-source в pom.xml.

### Изменено
* Переименовано перечисление Separator -> SeparatorType.

## v1.3.0 - 07.08.2022
### Изменено
* Обновлён README.MD.

## v1.2.0 - 18.06.2022
### Изменено
* Переименован проект.

## v1.1.0 - 27.03.2022
### Добавлено
* Добавлена проверка входящих параметров на null.

### Исправлено
* Исправлены баги.
