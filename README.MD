# NotationConverter
Конвертер нотации составных слов.

### Конвертирование в нотацию Camel Case:
```java
NotationConverter.toCamelCase("hello-world");

/*
Результат выполнения: helloWorld
*/
```

### Конвертирование в нотацию Kebab Case:
```java
NotationConverter.toKebabCase("helloWorld");

/*
Результат выполнения: hello-world
*/

```
### Конвертирование в нотацию Upper Case:
```java
NotationConverter.toUpperCase("HelloWorld");

/*
Результат выполнения: HELLO_WORLD
*/
```

### Конвертирование в нотацию Snake Case:
```java
NotationConverter.toSnakeCase("hello-world");

/*
Результат выполнения: hello_world
*/
```

### Конвертирование в нотацию Pascal Case:
```java
NotationConverter.toPascalCase("hello_world");

/*
Результат выполнения: HelloWorld
*/
```