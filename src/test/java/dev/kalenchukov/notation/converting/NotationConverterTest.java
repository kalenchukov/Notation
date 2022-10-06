/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.notation.converting;

import dev.kalenchukov.notation.converting.resources.NotationType;
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
	public void testToNotationTypeUpperCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(UPPER_CASE[i], NotationConverter.to(UPPER_CASE[i], NotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], NotationConverter.to(CAMEL_CASE[i], NotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], NotationConverter.to(KEBAB_CASE[i], NotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], NotationConverter.to(SNAKE_CASE[i], NotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], NotationConverter.to(PASCAL_CASE[i], NotationType.UPPER_CASE));
		}
	}

	@Test
	public void testToNotationTypeKebabCase()
	{
		for (int i = 0; i < KEBAB_CASE.length; i++)
		{
			assertEquals(KEBAB_CASE[i], NotationConverter.to(UPPER_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], NotationConverter.to(CAMEL_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], NotationConverter.to(KEBAB_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], NotationConverter.to(SNAKE_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], NotationConverter.to(PASCAL_CASE[i], NotationType.KEBAB_CASE));
		}
	}

	@Test
	public void testToNotationTypeSnakeCase()
	{
		for (int i = 0; i < SNAKE_CASE.length; i++)
		{
			assertEquals(SNAKE_CASE[i], NotationConverter.to(UPPER_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], NotationConverter.to(CAMEL_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], NotationConverter.to(KEBAB_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], NotationConverter.to(SNAKE_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], NotationConverter.to(PASCAL_CASE[i], NotationType.SNAKE_CASE));
		}
	}

	@Test
	public void testToNotationTypeCamelCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(CAMEL_CASE[i], NotationConverter.to(UPPER_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], NotationConverter.to(CAMEL_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], NotationConverter.to(KEBAB_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], NotationConverter.to(SNAKE_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], NotationConverter.to(PASCAL_CASE[i], NotationType.CAMEL_CASE));
		}
	}

	@Test
	public void testToNotationTypePascalCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(PASCAL_CASE[i], NotationConverter.to(UPPER_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], NotationConverter.to(CAMEL_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], NotationConverter.to(KEBAB_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], NotationConverter.to(SNAKE_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], NotationConverter.to(PASCAL_CASE[i], NotationType.PASCAL_CASE));
		}
	}

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