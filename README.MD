# Справка
## Notation
Нотации составных слов.

## Поддерживаемые нотации
#### Camel Case
Все слова пишутся слитно, начинается со строчной буквы, а первая буква каждого последующего слова должна быть прописной.

#### Kebab Case
Все буквы строчные, а слова разделяются символом дефиса.

#### Upper Case
Все буквы прописные, а слова разделяются символом подчёркивания.

#### Snake Case
Все буквы строчные, а слова разделяются символом подчёркивания.

#### Pascal Case
Все слова пишутся слитно и первая буква каждого слова должна быть прописной.

#### Dot Case
Все буквы строчные, а слова разделяются символом точки.

#### Train Case
Все слова пишутся прописными буквами, а в качестве разделителя слов символ дефиса.

## Использование
### Перечисления
#### Получение регулярного выражения
```java
NotationRegexp.KEBAB_CASE.getPattern();
```

### Проверка нотации
#### Проверка указанной нотации
```java
Notations.is("HELLO_WORLD", NotationType.UPPER_CASE);
```

Результат выполнения:
```
true
```

#### Проверка нотации Upper Case
```java
Notations.isUpperCase("HELLO_WORLD");
```

Результат выполнения:
```
true
```

#### Проверка нотации Kebab Case
```java
Notations.isKebabCase("hello-world");
```

Результат выполнения:
```
true
```

#### Проверка нотации Snake Case
```java
Notations.isSnakeCase("hello_world");
```

Результат выполнения:
```
true
```

#### Проверка нотации Camel Case
```java
Notations.isCamelCase("helloWorld");
```

Результат выполнения:
```
true
```

#### Проверка нотации Pascal Case
```java
Notations.isPascalCase("HelloWorld");
```

Результат выполнения:
```
true
```

#### Проверка нотации Dot Case
```java
Notations.isDotCase("hello.world");
```

Результат выполнения:
```
true
```

#### Проверка нотации Train Case
```java
Notations.isTrainCase("HELLO-WORLD");
```

Результат выполнения:
```
true
```

### Конвертирование нотации
#### Конвертирование в указанную нотацию
```java
Notations.to("HelloWorld", NotationType.UPPER_CASE);
```

Результат выполнения:
```
HELLO_WORLD
```

#### Конвертирование в нотацию Camel Case
```java
Notations.toCamelCase("hello-world");
```

Результат выполнения:
```
helloWorld
```

#### Конвертирование в нотацию Kebab Case
```java
Notations.toKebabCase("helloWorld");
```

Результат выполнения:
```
hello-world
```

#### Конвертирование в нотацию Upper Case
```java
Notations.toUpperCase("HelloWorld");
```

Результат выполнения:
```
HELLO_WORLD
```

#### Конвертирование в нотацию Snake Case
```java
Notations.toSnakeCase("hello-world");
```

Результат выполнения:
```
hello_world
```

#### Конвертирование в нотацию Pascal Case
```java
Notations.toPascalCase("hello_world");
```

Результат выполнения:
```
HelloWorld
```

#### Конвертирование в нотацию Dot Case
```java
Notations.toDotCase("hello World");
```

Результат выполнения:
```
hello.world
```

#### Конвертирование в нотацию Train Case
```java
Notations.toTrainCase("hello World");
```

Результат выполнения:
```
HELLO-WORLD
```