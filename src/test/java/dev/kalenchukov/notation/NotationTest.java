/*
 * Copyright © 2022-2023 Алексей Каленчуков
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

package dev.kalenchukov.notation;

import dev.kalenchukov.notation.resources.NotationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotationTest
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
		assertTrue(Notation.isUpperCase("HELLO"));
		assertTrue(Notation.isUpperCase("HELLO_WORLD"));
		assertTrue(Notation.isUpperCase("HELLO_WORLD_MATRIX"));
		assertTrue(Notation.isUpperCase("HELLO_WORLD1"));
		assertTrue(Notation.isUpperCase("HEL1LO_000_WORLD1"));
		assertTrue(Notation.isUpperCase("_HELLO_WORLD_1"));
	}

	@Test
	public void testIsUpperCaseNotCorrect()
	{
		assertFalse(Notation.isUpperCase(""));
		assertFalse(Notation.isUpperCase("_"));
		assertFalse(Notation.isUpperCase("__"));
		assertFalse(Notation.isUpperCase("0"));
		assertFalse(Notation.isUpperCase("0123456789"));
		assertFalse(Notation.isUpperCase("0_12345678_9"));
		assertFalse(Notation.isUpperCase("_0_0_"));
		assertFalse(Notation.isUpperCase("0_0"));

		assertFalse(Notation.isUpperCase("hello_world"));
		assertFalse(Notation.isUpperCase("HELLo_WORLD"));
		assertFalse(Notation.isUpperCase("HELLO_WORLd"));
		assertFalse(Notation.isUpperCase("h_WORLD1"));

		assertFalse(Notation.isUpperCase("HELLO__WORLD"));
		assertFalse(Notation.isUpperCase("__HELLO_WORLD_MATRIX"));
		assertFalse(Notation.isUpperCase("HELLO_WORLD1__"));
		assertFalse(Notation.isUpperCase("HELLO_123__"));

		assertFalse(Notation.isUpperCase("HELLO____WORLD"));
		assertFalse(Notation.isUpperCase("____HELLO_WORLD_MATRIX"));
		assertFalse(Notation.isUpperCase("HELLO_WORLD1____"));
		assertFalse(Notation.isUpperCase("HELLO_123____"));
	}

	@Test
	public void testIsKebabCase()
	{
		assertTrue(Notation.isKebabCase("hello"));
		assertTrue(Notation.isKebabCase("hello-world"));
		assertTrue(Notation.isKebabCase("hello-world-matrix"));
		assertTrue(Notation.isKebabCase("hello-world1"));
		assertTrue(Notation.isKebabCase("hel1lo-000-world1"));
		assertTrue(Notation.isKebabCase("-hello-world-1"));
	}

	@Test
	public void testIsKebabCaseNotCorrect()
	{
		assertFalse(Notation.isKebabCase(""));
		assertFalse(Notation.isKebabCase("-"));
		assertFalse(Notation.isKebabCase("--"));
		assertFalse(Notation.isKebabCase("0"));
		assertFalse(Notation.isKebabCase("0123456789"));
		assertFalse(Notation.isKebabCase("0-12345678-9"));
		assertFalse(Notation.isKebabCase("-0-0-"));
		assertFalse(Notation.isKebabCase("0-0"));

		assertFalse(Notation.isKebabCase("HELLO-WORLD"));
		assertFalse(Notation.isKebabCase("hellO-world"));
		assertFalse(Notation.isKebabCase("hello-worlD"));
		assertFalse(Notation.isKebabCase("H-world1"));

		assertFalse(Notation.isKebabCase("hello--world"));
		assertFalse(Notation.isKebabCase("--hello-world-matrix"));
		assertFalse(Notation.isKebabCase("hello-world1--"));
		assertFalse(Notation.isKebabCase("hello-123--"));

		assertFalse(Notation.isKebabCase("hello----world"));
		assertFalse(Notation.isKebabCase("----hello-world-matrix"));
		assertFalse(Notation.isKebabCase("hello-world1----"));
		assertFalse(Notation.isKebabCase("hello-123----"));
	}

	@Test
	public void testIsSnakeCase()
	{
		assertTrue(Notation.isSnakeCase("hello"));
		assertTrue(Notation.isSnakeCase("hello_world"));
		assertTrue(Notation.isSnakeCase("hello_world_matrix"));
		assertTrue(Notation.isSnakeCase("hello_world1"));
		assertTrue(Notation.isSnakeCase("hel1lo_000_world1"));
		assertTrue(Notation.isSnakeCase("_hello_world_1"));
	}

	@Test
	public void testIsSnakeCaseNotCorrect()
	{
		assertFalse(Notation.isSnakeCase(""));
		assertFalse(Notation.isSnakeCase("_"));
		assertFalse(Notation.isSnakeCase("__"));
		assertFalse(Notation.isSnakeCase("0"));
		assertFalse(Notation.isSnakeCase("0123456789"));
		assertFalse(Notation.isSnakeCase("0_12345678_9"));
		assertFalse(Notation.isSnakeCase("_0_0_"));
		assertFalse(Notation.isSnakeCase("0_0"));

		assertFalse(Notation.isSnakeCase("HELLO_WORLD"));
		assertFalse(Notation.isSnakeCase("hellO_world"));
		assertFalse(Notation.isSnakeCase("hello_worlD"));
		assertFalse(Notation.isSnakeCase("H_world1"));

		assertFalse(Notation.isSnakeCase("hello__world"));
		assertFalse(Notation.isSnakeCase("__hello_world_matrix"));
		assertFalse(Notation.isSnakeCase("hello_world1__"));
		assertFalse(Notation.isSnakeCase("hello_123__"));

		assertFalse(Notation.isSnakeCase("hello____world"));
		assertFalse(Notation.isSnakeCase("____hello_world_matrix"));
		assertFalse(Notation.isSnakeCase("hello_world1____"));
		assertFalse(Notation.isSnakeCase("hello_123____"));
	}

	@Test
	public void testIsCamelCase()
	{
		assertTrue(Notation.isCamelCase("hello"));
		assertTrue(Notation.isCamelCase("helloWorld"));
		assertTrue(Notation.isCamelCase("helloWorldMatrix"));
		assertTrue(Notation.isCamelCase("helloWorld1"));
		assertTrue(Notation.isCamelCase("hel1lo000World1"));
		assertTrue(Notation.isCamelCase("helloWorld1"));
		assertTrue(Notation.isCamelCase("hellOWorld"));
		assertTrue(Notation.isCamelCase("helloWorlD"));
	}

	@Test
	public void testIsCamelCaseNotCorrect()
	{
		assertFalse(Notation.isCamelCase(""));
		assertFalse(Notation.isCamelCase("H"));
		assertFalse(Notation.isCamelCase("HH"));
		assertFalse(Notation.isCamelCase("0"));
		assertFalse(Notation.isCamelCase("0123456789"));
		assertFalse(Notation.isCamelCase("0H12345678H9"));
		assertFalse(Notation.isCamelCase("H0H0H"));
		assertFalse(Notation.isCamelCase("0H0"));

		assertFalse(Notation.isCamelCase("HELLOWORLD"));
		assertFalse(Notation.isCamelCase("HWorld1"));

		assertFalse(Notation.isCamelCase("HelloWorld"));
		assertFalse(Notation.isCamelCase("HHelloWorldMatrix"));
		assertFalse(Notation.isCamelCase("HelloWorld1"));
		assertFalse(Notation.isCamelCase("Hello123"));
	}

	@Test
	public void testIsPascalCase()
	{
		assertTrue(Notation.isPascalCase("Hello"));
		assertTrue(Notation.isPascalCase("HelloWorld"));
		assertTrue(Notation.isPascalCase("HelloWorldMatrix"));
		assertTrue(Notation.isPascalCase("HelloWorld1"));
		assertTrue(Notation.isPascalCase("Hel1lo000World1"));
		assertTrue(Notation.isPascalCase("HelloWorld1"));
		assertTrue(Notation.isPascalCase("HellOWorld"));
		assertTrue(Notation.isPascalCase("HelloWorlD"));
	}

	@Test
	public void testIsPascalCaseNotCorrect()
	{
		assertFalse(Notation.isPascalCase(""));
		assertFalse(Notation.isPascalCase("h"));
		assertFalse(Notation.isPascalCase("hh"));
		assertFalse(Notation.isPascalCase("0"));
		assertFalse(Notation.isPascalCase("0123456789"));
		assertFalse(Notation.isPascalCase("0h12345678h9"));
		assertFalse(Notation.isPascalCase("h0h0h"));
		assertFalse(Notation.isPascalCase("0h0"));

		assertFalse(Notation.isPascalCase("hELLOwORLD"));
		assertFalse(Notation.isPascalCase("hWorld1"));

		assertFalse(Notation.isPascalCase("helloworld"));
		assertFalse(Notation.isPascalCase("hhelloWorldMatrix"));
		assertFalse(Notation.isPascalCase("helloWorld1"));
		assertFalse(Notation.isPascalCase("hello123"));
	}

	@Test
	public void testToNotationTypeUpperCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(UPPER_CASE[i], Notation.to(UPPER_CASE[i], NotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], Notation.to(CAMEL_CASE[i], NotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], Notation.to(KEBAB_CASE[i], NotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], Notation.to(SNAKE_CASE[i], NotationType.UPPER_CASE));
			assertEquals(UPPER_CASE[i], Notation.to(PASCAL_CASE[i], NotationType.UPPER_CASE));
		}
	}

	@Test
	public void testToNotationTypeKebabCase()
	{
		for (int i = 0; i < KEBAB_CASE.length; i++)
		{
			assertEquals(KEBAB_CASE[i], Notation.to(UPPER_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], Notation.to(CAMEL_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], Notation.to(KEBAB_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], Notation.to(SNAKE_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(KEBAB_CASE[i], Notation.to(PASCAL_CASE[i], NotationType.KEBAB_CASE));
		}
	}

	@Test
	public void testToNotationTypeSnakeCase()
	{
		for (int i = 0; i < SNAKE_CASE.length; i++)
		{
			assertEquals(SNAKE_CASE[i], Notation.to(UPPER_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], Notation.to(CAMEL_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], Notation.to(KEBAB_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], Notation.to(SNAKE_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(SNAKE_CASE[i], Notation.to(PASCAL_CASE[i], NotationType.SNAKE_CASE));
		}
	}

	@Test
	public void testToNotationTypeCamelCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(CAMEL_CASE[i], Notation.to(UPPER_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], Notation.to(CAMEL_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], Notation.to(KEBAB_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], Notation.to(SNAKE_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(CAMEL_CASE[i], Notation.to(PASCAL_CASE[i], NotationType.CAMEL_CASE));
		}
	}

	@Test
	public void testToNotationTypePascalCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(PASCAL_CASE[i], Notation.to(UPPER_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], Notation.to(CAMEL_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], Notation.to(KEBAB_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], Notation.to(SNAKE_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(PASCAL_CASE[i], Notation.to(PASCAL_CASE[i], NotationType.PASCAL_CASE));
		}
	}

	@Test
	public void testToUpperCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(UPPER_CASE[i], Notation.toUpperCase(UPPER_CASE[i]));
			assertEquals(UPPER_CASE[i], Notation.toUpperCase(CAMEL_CASE[i]));
			assertEquals(UPPER_CASE[i], Notation.toUpperCase(KEBAB_CASE[i]));
			assertEquals(UPPER_CASE[i], Notation.toUpperCase(SNAKE_CASE[i]));
			assertEquals(UPPER_CASE[i], Notation.toUpperCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToKebabCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(KEBAB_CASE[i], Notation.toKebabCase(UPPER_CASE[i]));
			assertEquals(KEBAB_CASE[i], Notation.toKebabCase(CAMEL_CASE[i]));
			assertEquals(KEBAB_CASE[i], Notation.toKebabCase(KEBAB_CASE[i]));
			assertEquals(KEBAB_CASE[i], Notation.toKebabCase(SNAKE_CASE[i]));
			assertEquals(KEBAB_CASE[i], Notation.toKebabCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToSnakeCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(SNAKE_CASE[i], Notation.toSnakeCase(UPPER_CASE[i]));
			assertEquals(SNAKE_CASE[i], Notation.toSnakeCase(CAMEL_CASE[i]));
			assertEquals(SNAKE_CASE[i], Notation.toSnakeCase(KEBAB_CASE[i]));
			assertEquals(SNAKE_CASE[i], Notation.toSnakeCase(SNAKE_CASE[i]));
			assertEquals(SNAKE_CASE[i], Notation.toSnakeCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToCamelCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(CAMEL_CASE[i], Notation.toCamelCase(UPPER_CASE[i]));
			assertEquals(CAMEL_CASE[i], Notation.toCamelCase(CAMEL_CASE[i]));
			assertEquals(CAMEL_CASE[i], Notation.toCamelCase(KEBAB_CASE[i]));
			assertEquals(CAMEL_CASE[i], Notation.toCamelCase(SNAKE_CASE[i]));
			assertEquals(CAMEL_CASE[i], Notation.toCamelCase(PASCAL_CASE[i]));
		}
	}

	@Test
	public void testToPascalCase()
	{
		for (int i = 0; i < UPPER_CASE.length; i++)
		{
			assertEquals(PASCAL_CASE[i], Notation.toPascalCase(UPPER_CASE[i]));
			assertEquals(PASCAL_CASE[i], Notation.toPascalCase(CAMEL_CASE[i]));
			assertEquals(PASCAL_CASE[i], Notation.toPascalCase(KEBAB_CASE[i]));
			assertEquals(PASCAL_CASE[i], Notation.toPascalCase(SNAKE_CASE[i]));
			assertEquals(PASCAL_CASE[i], Notation.toPascalCase(PASCAL_CASE[i]));
		}
	}
}