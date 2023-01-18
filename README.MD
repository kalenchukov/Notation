# WordNotation

Нотации составных слов.

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

### Проверка нотации

#### Проверка нотации Upper Case

```java
WordNotation.isUpperCase("HELLO_WORLD");
// Результат выполнения: true
```

#### Проверка нотации Kebab Case

```java
WordNotation.isKebabCase("hello-world");
// Результат выполнения: true
```

#### Проверка нотации Snake Case

```java
WordNotation.isSnakeCase("hello_world");
// Результат выполнения: true
```

#### Проверка нотации Camel Case

```java
WordNotation.isCamelCase("helloWorld");
// Результат выполнения: true
```

### Конвертирование нотации

#### Конвертирование в указанную нотацию

```java
WordNotation.to("HelloWorld", NotationType.UPPER_CASE);
// Результат выполнения: HELLO_WORLD
```

#### Конвертирование в нотацию Camel Case

```java
WordNotation.toCamelCase("hello-world");
// Результат выполнения: helloWorld
```

#### Конвертирование в нотацию Kebab Case

```java
WordNotation.toKebabCase("helloWorld");
// Результат выполнения: hello-world
```

#### Конвертирование в нотацию Upper Case

```java
WordNotation.toUpperCase("HelloWorld");
// Результат выполнения: HELLO_WORLD
```

#### Конвертирование в нотацию Snake Case

```java
WordNotation.toSnakeCase("hello-world");
// Результат выполнения: hello_world
```

#### Конвертирование в нотацию Pascal Case

```java
WordNotation.toPascalCase("hello_world");
// Результат выполнения: HelloWorld
```
