/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.notation.converting;

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
			assertEquals(UPPER_CASE[i], NotationConverter.toUpperCase(UPPER_CASE[i]));
			assertEquals(UPPER_CASE[i], NotationConverter.toUpperCase(CAMEL_CASE[i]));
			assertEquals(UPPER_CASE[i], NotationConverter.toUpperCase(KEBAB_CASE[i]));
			assertEquals(UPPER_CASE[i], NotationConverter.toUpperCase(SNAKE_CASE[i]));
			assertEquals(UPPER_CASE[i], NotationConverter.toUpperCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToKebabCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(KEBAB_CASE[i], NotationConverter.toKebabCase(UPPER_CASE[i]));
			assertEquals(KEBAB_CASE[i], NotationConverter.toKebabCase(CAMEL_CASE[i]));
			assertEquals(KEBAB_CASE[i], NotationConverter.toKebabCase(KEBAB_CASE[i]));
			assertEquals(KEBAB_CASE[i], NotationConverter.toKebabCase(SNAKE_CASE[i]));
			assertEquals(KEBAB_CASE[i], NotationConverter.toKebabCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToSnakeCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(SNAKE_CASE[i], NotationConverter.toSnakeCase(UPPER_CASE[i]));
			assertEquals(SNAKE_CASE[i], NotationConverter.toSnakeCase(CAMEL_CASE[i]));
			assertEquals(SNAKE_CASE[i], NotationConverter.toSnakeCase(KEBAB_CASE[i]));
			assertEquals(SNAKE_CASE[i], NotationConverter.toSnakeCase(SNAKE_CASE[i]));
			assertEquals(SNAKE_CASE[i], NotationConverter.toSnakeCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToCamelCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(CAMEL_CASE[i], NotationConverter.toCamelCase(UPPER_CASE[i]));
			assertEquals(CAMEL_CASE[i], NotationConverter.toCamelCase(CAMEL_CASE[i]));
			assertEquals(CAMEL_CASE[i], NotationConverter.toCamelCase(KEBAB_CASE[i]));
			assertEquals(CAMEL_CASE[i], NotationConverter.toCamelCase(SNAKE_CASE[i]));
			assertEquals(CAMEL_CASE[i], NotationConverter.toCamelCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToPascalCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(PASCAL_CASE[i], NotationConverter.toPascalCase(UPPER_CASE[i]));
			assertEquals(PASCAL_CASE[i], NotationConverter.toPascalCase(CAMEL_CASE[i]));
			assertEquals(PASCAL_CASE[i], NotationConverter.toPascalCase(KEBAB_CASE[i]));
			assertEquals(PASCAL_CASE[i], NotationConverter.toPascalCase(SNAKE_CASE[i]));
			assertEquals(PASCAL_CASE[i], NotationConverter.toPascalCase(PASCAL_CASE[i]));
		}
	}
}