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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@code Notation}.
 */
public class NotationTest
{
	/**
	 * Значения в нотации Upper Case.
	 */
	private static final String[] VALUES_UPPER_CASE = {
		"HELLO", "HELLO_WORLD", "HELLO_WORLD_MATRIX", "HELLO_WORLD1", "__HELLO_WORLD_MATRIX", "_HELLO_"
	};

	/**
	 * Значения в нотации Camel Case.
	 */
	private static final String[] VALUES_CAMEL_CASE = {
		"hello", "helloWorld", "helloWorldMatrix", "helloWorld1", "__helloWorldMatrix", "_hello_"
	};

	/**
	 * Значения в нотации Kebab Case.
	 */
	private static final String[] VALUES_KEBAB_CASE = {
		"hello", "hello-world", "hello-world-matrix", "hello-world1", "__hello-world-matrix", "_hello_"
	};

	/**
	 * Значения в нотации Snake Case.
	 */
	private static final String[] VALUES_SNAKE_CASE = {
		"hello", "hello_world", "hello_world_matrix", "hello_world1", "__hello_world_matrix", "_hello_"
	};

	/**
	 * Значения в нотации Pascal Case.
	 */
	private static final String[] VALUES_PASCAL_CASE = {
		"Hello", "HelloWorld", "HelloWorldMatrix", "HelloWorld1", "__HelloWorldMatrix", "_Hello_"
	};

	/**
	 * Проверка метода {@link Notation#isUpperCase(String)} с корректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"HELLO", "HELLO_WORLD", "HELLO_WORLD_MATRIX", "HELLO_WORLD1",
		"HEL1LO_000_WORLD1", "_HELLO_WORLD_1"
	})
	public void testIsUpperCase(String value)
	{
		assertTrue(Notation.isUpperCase(value));
	}

	/**
	 * Проверка метода {@link Notation#isUpperCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", "_", "__", "0", "0123456789", "0_12345678_9", "_0_0_", "0_0",
		"hello_world", "HELLo_WORLD", "HELLO_WORLd", "h_WORLD1",
		"HELLO__WORLD", "__HELLO_WORLD_MATRIX", "HELLO_WORLD1__", "HELLO_123__",
		"HELLO____WORLD", "____HELLO_WORLD_MATRIX", "HELLO_WORLD1____", "HELLO_123____"
	})
	public void testIsUpperCaseNotCorrect(String value)
	{
		assertFalse(Notation.isUpperCase(value));
	}

	/**
	 * Проверка метода {@link Notation#isKebabCase(String)} с корректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"hello", "hello-world", "hello-world-matrix",
		"hello-world1", "hel1lo-000-world1", "-hello-world-1"
	})
	public void testIsKebabCase(String value)
	{
		assertTrue(Notation.isKebabCase(value));
	}

	/**
	 * Проверка метода {@link Notation#isKebabCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", "-", "--", "0", "0123456789", "0-12345678-9", "-0-0-", "0-0",
		"HELLO-WORLD", "hellO-world", "hello-worlD", "H-world1",
		"hello--world", "--hello-world-matrix", "hello-world1--", "hello-123--",
		"hello----world", "----hello-world-matrix", "hello-world1----", "hello-123----"
	})
	public void testIsKebabCaseNotCorrect(String value)
	{
		assertFalse(Notation.isKebabCase(value));
	}

	/**
	 * Проверка метода {@link Notation#isSnakeCase(String)} с корректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"hello", "hello_world", "hello_world_matrix",
		"hello_world1", "hel1lo_000_world1", "_hello_world_1"
	})
	public void testIsSnakeCase(String value)
	{
		assertTrue(Notation.isSnakeCase(value));
	}

	/**
	 * Проверка метода {@link Notation#isSnakeCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", "_", "__", "0", "0123456789", "0_12345678_9", "_0_0_", "0_0",
		"HELLO_WORLD", "hellO_world", "hello_worlD", "H_world1",
		"hello__world", "__hello_world_matrix", "hello_world1__", "hello_123__",
		"hello____world", "____hello_world_matrix", "hello_world1____", "hello_123____"
	})
	public void testIsSnakeCaseNotCorrect(String value)
	{
		assertFalse(Notation.isSnakeCase(value));
	}

	/**
	 * Проверка метода {@link Notation#isCamelCase(String)} с корректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"hello", "helloWorld", "helloWorldMatrix", "helloWorld1",
		"hel1lo000World1", "helloWorld1", "hellOWorld", "helloWorlD"
	})
	public void testIsCamelCase(String value)
	{
		assertTrue(Notation.isCamelCase(value));
	}

	/**
	 * Проверка метода {@link Notation#isCamelCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", "H", "HH", "0", "0123456789", "0H12345678H9", "H0H0H", "0H0",
		"HELLOWORLD", "HWorld1",
		"HelloWorld", "HHelloWorldMatrix", "HelloWorld1", "Hello123"
	})
	public void testIsCamelCaseNotCorrect(String value)
	{
		assertFalse(Notation.isCamelCase(value));
	}

	/**
	 * Проверка метода {@link Notation#isPascalCase(String)} с корректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"Hello", "HelloWorld", "HelloWorldMatrix", "HelloWorld1",
		"Hel1lo000World1", "HelloWorld1", "HellOWorld", "HelloWorlD"
	})
	public void testIsPascalCase(String value)
	{
		assertTrue(Notation.isPascalCase(value));
	}

	/**
	 * Проверка метода {@link Notation#isPascalCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", "h", "hh", "0", "0123456789", "0h12345678h9", "h0h0h", "h0h0h", "0h0",
		"hELLOwORLD", "hWorld1",
		"helloworld", "hhelloWorldMatrix", "helloWorld1", "hello123"
	})
	public void testIsPascalCaseNotCorrect(String value)
	{
		assertFalse(Notation.isPascalCase(value));
	}

	/**
	 * Проверка метода {@link Notation#to(String, NotationType)} для нотации Upper Case.
	 */
	@Test
	public void testToNotationTypeUpperCase()
	{
		for (int i = 0; i < VALUES_UPPER_CASE.length; i++)
		{
			assertEquals(VALUES_UPPER_CASE[i], Notation.to(VALUES_UPPER_CASE[i], NotationType.UPPER_CASE));
			assertEquals(VALUES_UPPER_CASE[i], Notation.to(VALUES_CAMEL_CASE[i], NotationType.UPPER_CASE));
			assertEquals(VALUES_UPPER_CASE[i], Notation.to(VALUES_KEBAB_CASE[i], NotationType.UPPER_CASE));
			assertEquals(VALUES_UPPER_CASE[i], Notation.to(VALUES_SNAKE_CASE[i], NotationType.UPPER_CASE));
			assertEquals(VALUES_UPPER_CASE[i], Notation.to(VALUES_PASCAL_CASE[i], NotationType.UPPER_CASE));
		}
	}

	/**
	 * Проверка метода {@link Notation#to(String, NotationType)} для нотации Kebab Case.
	 */
	@Test
	public void testToNotationTypeKebabCase()
	{
		for (int i = 0; i < VALUES_KEBAB_CASE.length; i++)
		{
			assertEquals(VALUES_KEBAB_CASE[i], Notation.to(VALUES_UPPER_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(VALUES_KEBAB_CASE[i], Notation.to(VALUES_CAMEL_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(VALUES_KEBAB_CASE[i], Notation.to(VALUES_KEBAB_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(VALUES_KEBAB_CASE[i], Notation.to(VALUES_SNAKE_CASE[i], NotationType.KEBAB_CASE));
			assertEquals(VALUES_KEBAB_CASE[i], Notation.to(VALUES_PASCAL_CASE[i], NotationType.KEBAB_CASE));
		}
	}

	/**
	 * Проверка метода {@link Notation#to(String, NotationType)} для нотации Snake Case.
	 */
	@Test
	public void testToNotationTypeSnakeCase()
	{
		for (int i = 0; i < VALUES_SNAKE_CASE.length; i++)
		{
			assertEquals(VALUES_SNAKE_CASE[i], Notation.to(VALUES_UPPER_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(VALUES_SNAKE_CASE[i], Notation.to(VALUES_CAMEL_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(VALUES_SNAKE_CASE[i], Notation.to(VALUES_KEBAB_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(VALUES_SNAKE_CASE[i], Notation.to(VALUES_SNAKE_CASE[i], NotationType.SNAKE_CASE));
			assertEquals(VALUES_SNAKE_CASE[i], Notation.to(VALUES_PASCAL_CASE[i], NotationType.SNAKE_CASE));
		}
	}

	/**
	 * Проверка метода {@link Notation#to(String, NotationType)} для нотации Camel Case.
	 */
	@Test
	public void testToNotationTypeCamelCase()
	{
		for (int i = 0; i < VALUES_UPPER_CASE.length; i++)
		{
			assertEquals(VALUES_CAMEL_CASE[i], Notation.to(VALUES_UPPER_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(VALUES_CAMEL_CASE[i], Notation.to(VALUES_CAMEL_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(VALUES_CAMEL_CASE[i], Notation.to(VALUES_KEBAB_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(VALUES_CAMEL_CASE[i], Notation.to(VALUES_SNAKE_CASE[i], NotationType.CAMEL_CASE));
			assertEquals(VALUES_CAMEL_CASE[i], Notation.to(VALUES_PASCAL_CASE[i], NotationType.CAMEL_CASE));
		}
	}

	/**
	 * Проверка метода {@link Notation#to(String, NotationType)} для нотации Pascal Case.
	 */
	@Test
	public void testToNotationTypePascalCase()
	{
		for (int i = 0; i < VALUES_UPPER_CASE.length; i++)
		{
			assertEquals(VALUES_PASCAL_CASE[i], Notation.to(VALUES_UPPER_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(VALUES_PASCAL_CASE[i], Notation.to(VALUES_CAMEL_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(VALUES_PASCAL_CASE[i], Notation.to(VALUES_KEBAB_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(VALUES_PASCAL_CASE[i], Notation.to(VALUES_SNAKE_CASE[i], NotationType.PASCAL_CASE));
			assertEquals(VALUES_PASCAL_CASE[i], Notation.to(VALUES_PASCAL_CASE[i], NotationType.PASCAL_CASE));
		}
	}

	/**
	 * Проверка метода {@link Notation#toUpperCase(String)}.
	 */
	@Test
	public void testToUpperCase()
	{
		for (int i = 0; i < VALUES_UPPER_CASE.length; i++)
		{
			assertEquals(VALUES_UPPER_CASE[i], Notation.toUpperCase(VALUES_UPPER_CASE[i]));
			assertEquals(VALUES_UPPER_CASE[i], Notation.toUpperCase(VALUES_CAMEL_CASE[i]));
			assertEquals(VALUES_UPPER_CASE[i], Notation.toUpperCase(VALUES_KEBAB_CASE[i]));
			assertEquals(VALUES_UPPER_CASE[i], Notation.toUpperCase(VALUES_SNAKE_CASE[i]));
			assertEquals(VALUES_UPPER_CASE[i], Notation.toUpperCase(VALUES_PASCAL_CASE[i]));
		}
	}

	/**
	 * Проверка метода {@link Notation#toKebabCase(String)}.
	 */
	@Test
	public void testToKebabCase()
	{
		for (int i = 0; i < VALUES_UPPER_CASE.length; i++)
		{
			assertEquals(VALUES_KEBAB_CASE[i], Notation.toKebabCase(VALUES_UPPER_CASE[i]));
			assertEquals(VALUES_KEBAB_CASE[i], Notation.toKebabCase(VALUES_CAMEL_CASE[i]));
			assertEquals(VALUES_KEBAB_CASE[i], Notation.toKebabCase(VALUES_KEBAB_CASE[i]));
			assertEquals(VALUES_KEBAB_CASE[i], Notation.toKebabCase(VALUES_SNAKE_CASE[i]));
			assertEquals(VALUES_KEBAB_CASE[i], Notation.toKebabCase(VALUES_PASCAL_CASE[i]));
		}
	}

	/**
	 * Проверка метода {@link Notation#toSnakeCase(String)}.
	 */
	@Test
	public void testToSnakeCase()
	{
		for (int i = 0; i < VALUES_UPPER_CASE.length; i++)
		{
			assertEquals(VALUES_SNAKE_CASE[i], Notation.toSnakeCase(VALUES_UPPER_CASE[i]));
			assertEquals(VALUES_SNAKE_CASE[i], Notation.toSnakeCase(VALUES_CAMEL_CASE[i]));
			assertEquals(VALUES_SNAKE_CASE[i], Notation.toSnakeCase(VALUES_KEBAB_CASE[i]));
			assertEquals(VALUES_SNAKE_CASE[i], Notation.toSnakeCase(VALUES_SNAKE_CASE[i]));
			assertEquals(VALUES_SNAKE_CASE[i], Notation.toSnakeCase(VALUES_PASCAL_CASE[i]));
		}
	}

	/**
	 * Проверка метода {@link Notation#toCamelCase(String)}.
	 */
	@Test
	public void testToCamelCase()
	{
		for (int i = 0; i < VALUES_UPPER_CASE.length; i++)
		{
			assertEquals(VALUES_CAMEL_CASE[i], Notation.toCamelCase(VALUES_UPPER_CASE[i]));
			assertEquals(VALUES_CAMEL_CASE[i], Notation.toCamelCase(VALUES_CAMEL_CASE[i]));
			assertEquals(VALUES_CAMEL_CASE[i], Notation.toCamelCase(VALUES_KEBAB_CASE[i]));
			assertEquals(VALUES_CAMEL_CASE[i], Notation.toCamelCase(VALUES_SNAKE_CASE[i]));
			assertEquals(VALUES_CAMEL_CASE[i], Notation.toCamelCase(VALUES_PASCAL_CASE[i]));
		}
	}

	/**
	 * Проверка метода {@link Notation#toPascalCase(String)}.
	 */
	@Test
	public void testToPascalCase()
	{
		for (int i = 0; i < VALUES_UPPER_CASE.length; i++)
		{
			assertEquals(VALUES_PASCAL_CASE[i], Notation.toPascalCase(VALUES_UPPER_CASE[i]));
			assertEquals(VALUES_PASCAL_CASE[i], Notation.toPascalCase(VALUES_CAMEL_CASE[i]));
			assertEquals(VALUES_PASCAL_CASE[i], Notation.toPascalCase(VALUES_KEBAB_CASE[i]));
			assertEquals(VALUES_PASCAL_CASE[i], Notation.toPascalCase(VALUES_SNAKE_CASE[i]));
			assertEquals(VALUES_PASCAL_CASE[i], Notation.toPascalCase(VALUES_PASCAL_CASE[i]));
		}
	}
}