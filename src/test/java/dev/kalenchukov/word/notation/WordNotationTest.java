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

package dev.kalenchukov.word.notation;

import dev.kalenchukov.word.notation.resources.WordNotationType;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordNotationTest
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
	public void testIsUpperCase()
	{
		assertTrue(WordNotation.isUpperCase("HELLO"));
		assertTrue(WordNotation.isUpperCase("HELLO_WORLD"));
		assertTrue(WordNotation.isUpperCase("HELLO_WORLD_MATRIX"));
		assertTrue(WordNotation.isUpperCase("HELLO_WORLD1"));
		assertTrue(WordNotation.isUpperCase("HEL1LO_000_WORLD1"));
		assertTrue(WordNotation.isUpperCase("_HELLO_WORLD_1"));
	}

	@Test
	public void testIsUpperCaseNotCorrect()
	{
		assertFalse(WordNotation.isUpperCase(""));
		assertFalse(WordNotation.isUpperCase("_"));
		assertFalse(WordNotation.isUpperCase("__"));
		assertFalse(WordNotation.isUpperCase("0"));
		assertFalse(WordNotation.isUpperCase("0123456789"));
		assertFalse(WordNotation.isUpperCase("0_12345678_9"));
		assertFalse(WordNotation.isUpperCase("_0_0_"));
		assertFalse(WordNotation.isUpperCase("0_0"));

		assertFalse(WordNotation.isUpperCase("hello_world"));
		assertFalse(WordNotation.isUpperCase("HELLo_WORLD"));
		assertFalse(WordNotation.isUpperCase("HELLO_WORLd"));
		assertFalse(WordNotation.isUpperCase("h_WORLD1"));

		assertFalse(WordNotation.isUpperCase("HELLO__WORLD"));
		assertFalse(WordNotation.isUpperCase("__HELLO_WORLD_MATRIX"));
		assertFalse(WordNotation.isUpperCase("HELLO_WORLD1__"));
		assertFalse(WordNotation.isUpperCase("HELLO_123__"));

		assertFalse(WordNotation.isUpperCase("HELLO____WORLD"));
		assertFalse(WordNotation.isUpperCase("____HELLO_WORLD_MATRIX"));
		assertFalse(WordNotation.isUpperCase("HELLO_WORLD1____"));
		assertFalse(WordNotation.isUpperCase("HELLO_123____"));
	}

	@Test
	public void testToNotationTypeUpperCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(UPPER_CASE[i], WordNotation.to(UPPER_CASE[i], WordNotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], WordNotation.to(CAMEL_CASE[i], WordNotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], WordNotation.to(KEBAB_CASE[i], WordNotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], WordNotation.to(SNAKE_CASE[i], WordNotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], WordNotation.to(PASCAL_CASE[i], WordNotationType.UPPER_CASE));
		}
	}

	@Test
	public void testToNotationTypeKebabCase()
	{
		for (int i = 0; i < KEBAB_CASE.length; i++)
		{
			assertEquals(KEBAB_CASE[i], WordNotation.to(UPPER_CASE[i], WordNotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], WordNotation.to(CAMEL_CASE[i], WordNotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], WordNotation.to(KEBAB_CASE[i], WordNotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], WordNotation.to(SNAKE_CASE[i], WordNotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], WordNotation.to(PASCAL_CASE[i], WordNotationType.KEBAB_CASE));
		}
	}

	@Test
	public void testToNotationTypeSnakeCase()
	{
		for (int i = 0; i < SNAKE_CASE.length; i++)
		{
			assertEquals(SNAKE_CASE[i], WordNotation.to(UPPER_CASE[i], WordNotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], WordNotation.to(CAMEL_CASE[i], WordNotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], WordNotation.to(KEBAB_CASE[i], WordNotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], WordNotation.to(SNAKE_CASE[i], WordNotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], WordNotation.to(PASCAL_CASE[i], WordNotationType.SNAKE_CASE));
		}
	}

	@Test
	public void testToNotationTypeCamelCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(CAMEL_CASE[i], WordNotation.to(UPPER_CASE[i], WordNotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], WordNotation.to(CAMEL_CASE[i], WordNotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], WordNotation.to(KEBAB_CASE[i], WordNotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], WordNotation.to(SNAKE_CASE[i], WordNotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], WordNotation.to(PASCAL_CASE[i], WordNotationType.CAMEL_CASE));
		}
	}

	@Test
	public void testToNotationTypePascalCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(PASCAL_CASE[i], WordNotation.to(UPPER_CASE[i], WordNotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], WordNotation.to(CAMEL_CASE[i], WordNotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], WordNotation.to(KEBAB_CASE[i], WordNotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], WordNotation.to(SNAKE_CASE[i], WordNotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], WordNotation.to(PASCAL_CASE[i], WordNotationType.PASCAL_CASE));
		}
	}

	@Test
	public void testToUpperCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(UPPER_CASE[i], WordNotation.toUpperCase(UPPER_CASE[i]));
			assertEquals(UPPER_CASE[i], WordNotation.toUpperCase(CAMEL_CASE[i]));
			assertEquals(UPPER_CASE[i], WordNotation.toUpperCase(KEBAB_CASE[i]));
			assertEquals(UPPER_CASE[i], WordNotation.toUpperCase(SNAKE_CASE[i]));
			assertEquals(UPPER_CASE[i], WordNotation.toUpperCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToKebabCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(KEBAB_CASE[i], WordNotation.toKebabCase(UPPER_CASE[i]));
			assertEquals(KEBAB_CASE[i], WordNotation.toKebabCase(CAMEL_CASE[i]));
			assertEquals(KEBAB_CASE[i], WordNotation.toKebabCase(KEBAB_CASE[i]));
			assertEquals(KEBAB_CASE[i], WordNotation.toKebabCase(SNAKE_CASE[i]));
			assertEquals(KEBAB_CASE[i], WordNotation.toKebabCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToSnakeCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(SNAKE_CASE[i], WordNotation.toSnakeCase(UPPER_CASE[i]));
			assertEquals(SNAKE_CASE[i], WordNotation.toSnakeCase(CAMEL_CASE[i]));
			assertEquals(SNAKE_CASE[i], WordNotation.toSnakeCase(KEBAB_CASE[i]));
			assertEquals(SNAKE_CASE[i], WordNotation.toSnakeCase(SNAKE_CASE[i]));
			assertEquals(SNAKE_CASE[i], WordNotation.toSnakeCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToCamelCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(CAMEL_CASE[i], WordNotation.toCamelCase(UPPER_CASE[i]));
			assertEquals(CAMEL_CASE[i], WordNotation.toCamelCase(CAMEL_CASE[i]));
			assertEquals(CAMEL_CASE[i], WordNotation.toCamelCase(KEBAB_CASE[i]));
			assertEquals(CAMEL_CASE[i], WordNotation.toCamelCase(SNAKE_CASE[i]));
			assertEquals(CAMEL_CASE[i], WordNotation.toCamelCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToPascalCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(PASCAL_CASE[i], WordNotation.toPascalCase(UPPER_CASE[i]));
			assertEquals(PASCAL_CASE[i], WordNotation.toPascalCase(CAMEL_CASE[i]));
			assertEquals(PASCAL_CASE[i], WordNotation.toPascalCase(KEBAB_CASE[i]));
			assertEquals(PASCAL_CASE[i], WordNotation.toPascalCase(SNAKE_CASE[i]));
			assertEquals(PASCAL_CASE[i], WordNotation.toPascalCase(PASCAL_CASE[i]));
		}
	}
}