/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.notationconverter;

import org.junit.Test;

import static org.junit.Assert.*;

public class NotationConverterTest
{
	private static final String[] UPPER_CASE = {
		"HELLO", "HELLO_WORLD", "HELLO_WORLD_MATRIX", "HELLO_WORLD1", "__HELLO_WORLD_MATRIX", "_HELLO_"
	};

	private static final String[] CAMEL_CASE = {
		"hello", "helloWorld", "helloWorldMatrix", "helloWorld1", "__helloWorldMatrix", "_hello_"
	};

	private static final String[] KEBAB_CASE = {
		"hello", "hello-world", "hello-world-matrix", "hello-world1", "__hello-world-matrix", "_hello_"
	};

	private static final String[] SNAKE_CASE = {
		"hello", "hello_world", "hello_world_matrix", "hello_world1", "__hello_world_matrix", "_hello_"
	};

	private static final String[] PASCAL_CASE = {
		"Hello", "HelloWorld", "HelloWorldMatrix", "HelloWorld1", "__HelloWorldMatrix", "_Hello_"
	};

	@Test
	public void testToUpperCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(NotationConverter.toUpperCase(UPPER_CASE[i]), UPPER_CASE[i]);
			assertEquals(NotationConverter.toUpperCase(CAMEL_CASE[i]), UPPER_CASE[i]);
			assertEquals(NotationConverter.toUpperCase(KEBAB_CASE[i]), UPPER_CASE[i]);
			assertEquals(NotationConverter.toUpperCase(SNAKE_CASE[i]), UPPER_CASE[i]);
			assertEquals(NotationConverter.toUpperCase(PASCAL_CASE[i]), UPPER_CASE[i]);
		}
	}

	@Test
	public void testToKebabCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(NotationConverter.toKebabCase(UPPER_CASE[i]), KEBAB_CASE[i]);
			assertEquals(NotationConverter.toKebabCase(CAMEL_CASE[i]), KEBAB_CASE[i]);
			assertEquals(NotationConverter.toKebabCase(KEBAB_CASE[i]), KEBAB_CASE[i]);
			assertEquals(NotationConverter.toKebabCase(SNAKE_CASE[i]), KEBAB_CASE[i]);
			assertEquals(NotationConverter.toKebabCase(PASCAL_CASE[i]), KEBAB_CASE[i]);
		}
	}

	@Test
	public void testToSnakeCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(NotationConverter.toSnakeCase(UPPER_CASE[i]), SNAKE_CASE[i]);
			assertEquals(NotationConverter.toSnakeCase(CAMEL_CASE[i]), SNAKE_CASE[i]);
			assertEquals(NotationConverter.toSnakeCase(KEBAB_CASE[i]), SNAKE_CASE[i]);
			assertEquals(NotationConverter.toSnakeCase(SNAKE_CASE[i]), SNAKE_CASE[i]);
			assertEquals(NotationConverter.toSnakeCase(PASCAL_CASE[i]), SNAKE_CASE[i]);
		}
	}

	@Test
	public void testToCamelCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(NotationConverter.toCamelCase(UPPER_CASE[i]), CAMEL_CASE[i]);
			assertEquals(NotationConverter.toCamelCase(CAMEL_CASE[i]), CAMEL_CASE[i]);
			assertEquals(NotationConverter.toCamelCase(KEBAB_CASE[i]), CAMEL_CASE[i]);
			assertEquals(NotationConverter.toCamelCase(SNAKE_CASE[i]), CAMEL_CASE[i]);
			assertEquals(NotationConverter.toCamelCase(PASCAL_CASE[i]), CAMEL_CASE[i]);
		}
	}

	@Test
	public void testToPascalCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(NotationConverter.toPascalCase(UPPER_CASE[i]), PASCAL_CASE[i]);
			assertEquals(NotationConverter.toPascalCase(CAMEL_CASE[i]), PASCAL_CASE[i]);
			assertEquals(NotationConverter.toPascalCase(KEBAB_CASE[i]), PASCAL_CASE[i]);
			assertEquals(NotationConverter.toPascalCase(SNAKE_CASE[i]), PASCAL_CASE[i]);
			assertEquals(NotationConverter.toPascalCase(PASCAL_CASE[i]), PASCAL_CASE[i]);
		}
	}
}