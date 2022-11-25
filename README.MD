# NotationConverting

Конвертер нотации составных слов.

## Поддерживаемые нотации

#### Верблюжья (Camel Case)

Все слова пишутся слитно, начинается со строчной буквы, а первая буква каждого последующего слова должна быть прописной.

#### Шашлычная (Kebab Case)

Все буквы строчные, а слова разделяются символом дефиса.

#### Верхняя (Upper Case)

Все буквы прописные, а слова разделяются символом подчёркивания.

#### Змеиная (Snake Case)

Все буквы строчные, а слова разделяются символом подчёркивания.

#### Паскаля (Pascal Case)

Все слова пишутся слитно и первая буква каждого слова должна быть прописной.

## Использование

#### Конвертирование в указанную нотацию

```java
NotationConverter.to("HelloWorld", NotationType.UPPER_CASE);
// Результат выполнения: HELLO_WORLD
```

#### Конвертирование в нотацию Camel Case

```java
NotationConverter.toCamelCase("hello-world");
// Результат выполнения: helloWorld
```

#### Конвертирование в нотацию Kebab Case

```java
NotationConverter.toKebabCase("helloWorld");
// Результат выполнения: hello-world
```

#### Конвертирование в нотацию Upper Case

```java
NotationConverter.toUpperCase("HelloWorld");
// Результат выполнения: HELLO_WORLD
```

#### Конвертирование в нотацию Snake Case

```java
NotationConverter.toSnakeCase("hello-world");
// Результат выполнения: hello_world
```

#### Конвертирование в нотацию Pascal Case

```java
NotationConverter.toPascalCase("hello_world");
// Результат выполнения: HelloWorld
```
