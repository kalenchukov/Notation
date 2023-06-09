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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link Notations}.
 *
 * @author Алексей Каленчуков
 */
public class NotationsTest
{
	/**
	 * Проверка метода {@link Notations#is(String, NotationType)} для нотации Upper Case.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"HELLO", "HELLO_WORLD", "HELLO_WORLD_MATRIX", "HELLO_WORLD1",
		"HEL1LO_000_WORLD1"
	})
	public void isNotationTypeUpperCase(String value)
	{
		boolean actual = Notations.is(value, NotationType.UPPER_CASE);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#is(String, NotationType)} для нотации Kebab Case.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"hello", "hello-world", "hello-world-matrix",
		"hello-world1", "hel1lo-000-world1"
	})
	public void isNotationTypeKebabCase(String value)
	{
		boolean actual = Notations.is(value, NotationType.KEBAB_CASE);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#is(String, NotationType)} для нотации Train Case.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"HELLO", "HELLO-WORLD", "HELLO-WORLD-MATRIX",
		"HELLO-WORLD1", "HEL1LO-000-WORLD1"
	})
	public void isNotationTypeTrainCase(String value)
	{
		boolean actual = Notations.is(value, NotationType.TRAIN_CASE);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#is(String, NotationType)} для нотации Snake Case.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"hello", "hello_world", "hello_world_matrix",
		"hello_world1", "hel1lo_000_world1"
	})
	public void isNotationTypeSnakeCase(String value)
	{
		boolean actual = Notations.is(value, NotationType.SNAKE_CASE);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#is(String, NotationType)} для нотации Camel Case.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"hello", "helloWorld", "helloWorldMatrix", "helloWorld1",
		"hel1lo000World1", "helloWorld1", "hellOWorld", "helloWorlD"
	})
	public void isNotationTypeCamelCase(String value)
	{
		boolean actual = Notations.is(value, NotationType.CAMEL_CASE);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#is(String, NotationType)} для нотации Pascal Case.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"Hello", "HelloWorld", "HelloWorldMatrix", "HelloWorld1",
		"Hel1lo000World1", "HelloWorld1", "HellOWorld", "HelloWorlD"
	})
	public void isNotationTypePascalCase(String value)
	{
		boolean actual = Notations.is(value, NotationType.PASCAL_CASE);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#isUpperCase(String)}.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"HELLO", "HELLO_WORLD", "HELLO_WORLD_MATRIX", "HELLO_WORLD1",
		"HEL1LO_000_WORLD1"
	})
	public void isUpperCase(String value)
	{
		boolean actual = Notations.isUpperCase(value);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#isUpperCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", "_", "__", "0", "0123456789", "0_12345678_9", "_0_0_", "0_0", "hello World",
		"hello_world", "HELLo_WORLD", "HELLO_WORLd", "h_WORLD1",
		"_HELLo_WORLD", "HELLO_WORLd_", "_HELLO_WORLd_",
		"HELLO__WORLD", "__HELLO_WORLD_MATRIX", "HELLO_WORLD1__", "HELLO_123__",
		"HELLO____WORLD", "____HELLO_WORLD_MATRIX", "HELLO_WORLD1____", "HELLO_123____"
	})
	public void isUpperCaseNotCorrect(String value)
	{
		boolean actual = Notations.isUpperCase(value);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link Notations#isKebabCase(String)}.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"hello", "hello-world", "hello-world-matrix",
		"hello-world1", "hel1lo-000-world1"
	})
	public void isKebabCase(String value)
	{
		boolean actual = Notations.isKebabCase(value);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#isKebabCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", "-", "--", "0", "0123456789", "0-12345678-9", "-0-0-", "0-0", "hello world",
		"HELLO-WORLD", "hellO-world", "hello-worlD", "H-world1",
		"-hellO-world", "hellO-world-", "-hellO-world-",
		"hello--world", "--hello-world-matrix", "hello-world1--", "hello-123--",
		"hello----world", "----hello-world-matrix", "hello-world1----", "hello-123----"
	})
	public void isKebabCaseNotCorrect(String value)
	{
		boolean actual = Notations.isKebabCase(value);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link Notations#isTrainCase(String)}.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"HELLO", "HELLO-WORLD", "HELLO-WORLD-MATRIX",
		"HELLO-WORLD1", "HEL1LO-000-WORLD1"
	})
	public void isTrainCase(String value)
	{
		boolean actual = Notations.isTrainCase(value);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#isTrainCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", "-", "--", "0", "0123456789", "0-12345678-9", "-0-0-", "0-0", "HELLO WORLD",
		"hello-world", "HELLo-WORLD", "HELLO-WORLd", "h-WORLD1",
		"-HELLo-WORLD", "HELLo-WORLD-", "-HELLo-WORLD-",
		"HELLO--WORLD", "--HELLO-WORLD-MATRIX", "HELLO-WORLD1--", "HELLO-123--",
		"HELLO----WORLD", "----HELLO-WORLD-MATRIX", "HELLO-WORLD1----", "HELLO-123----"
	})
	public void isTrainCaseNotCorrect(String value)
	{
		boolean actual = Notations.isTrainCase(value);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link Notations#isSnakeCase(String)}.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"hello", "hello_world", "hello_world_matrix",
		"hello_world1", "hel1lo_000_world1"
	})
	public void isSnakeCase(String value)
	{
		boolean actual = Notations.isSnakeCase(value);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#isSnakeCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", "_", "__", "0", "0123456789", "0_12345678_9", "_0_0_", "0_0", "hello world",
		"HELLO_WORLD", "hellO_world", "hello_worlD", "H_world1",
		"_hello_worlD", "hello_worlD_", "_hello_worlD_",
		"hello__world", "__hello_world_matrix", "hello_world1__", "hello_123__",
		"hello____world", "____hello_world_matrix", "hello_world1____", "hello_123____"
	})
	public void isSnakeCaseNotCorrect(String value)
	{
		boolean actual = Notations.isSnakeCase(value);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link Notations#isCamelCase(String)}.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"hello", "helloWorld", "helloWorldMatrix", "helloWorld1",
		"hel1lo000World1", "helloWorld1", "hellOWorld", "helloWorlD"
	})
	public void isCamelCase(String value)
	{
		boolean actual = Notations.isCamelCase(value);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#isCamelCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", "H", "HH", "0", "0123456789", "0H12345678H9", "H0H0H", "0H0", "hello World",
		"HELLOWORLD", "HWorld1",
		"HelloWorld", "HHelloWorldMatrix", "HelloWorld1", "Hello123"
	})
	public void isCamelCaseNotCorrect(String value)
	{
		boolean actual = Notations.isCamelCase(value);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link Notations#isPascalCase(String)}.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"Hello", "HelloWorld", "HelloWorldMatrix", "HelloWorld1",
		"Hel1lo000World1", "HelloWorld1", "HellOWorld", "HelloWorlD"
	})
	public void isPascalCase(String value)
	{
		boolean actual = Notations.isPascalCase(value);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#isPascalCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", "h", "hh", "0", "0123456789", "0h12345678h9", "h0h0h", "h0h0h", "0h0", "Hello World",
		"hELLOwORLD", "hWorld1",
		"helloworld", "hhelloWorldMatrix", "helloWorld1", "hello123"
	})
	public void isPascalCaseNotCorrect(String value)
	{
		boolean actual = Notations.isPascalCase(value);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link Notations#isDotCase(String)}.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"hello", "hello.world", "hello.world.matrix",
		"hello.world1", "hel1lo.000.world1"
	})
	public void isDotCase(String value)
	{
		boolean actual = Notations.isDotCase(value);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link Notations#isDotCase(String)} с некорректными значениями.
	 *
	 * @param value проверяемое значение.
	 */
	@ParameterizedTest
	@ValueSource(strings = {
		"", ".", "..", "0", "0123456789", "0.12345678.9", ".0.0.", "0.0", "hello world",
		"HELLO.WORLD", "hellO.world", "hello.worlD", "H.world1",
		".hellO.world", "hellO.world.", ".hellO.world.",
		"hello..world", "..hello.world.matrix", "hello.world1..", "hello.123..",
		"hello....world", "....hello.world.matrix", "hello.world1....", "hello.123...."
	})
	public void isDotCaseNotCorrect(String value)
	{
		boolean actual = Notations.isDotCase(value);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link Notations#to(String, NotationType)} для нотации Upper Case.
	 */
	@ParameterizedTest
	@CsvSource({
			"hello, HELLO",
			"HELLO, HELLO",
			"hello, HELLO",
			"hello, HELLO",
			"hello, HELLO",
			"Hello, HELLO",
			"hello, HELLO",
			"HELLO, HELLO",
			"HELLO WORLD, HELLO_WORLD",
			"HELLO_WORLD, HELLO_WORLD",
			"helloWorld, HELLO_WORLD",
			"hello-world, HELLO_WORLD",
			"hello_world, HELLO_WORLD",
			"HelloWorld, HELLO_WORLD",
			"hello.world, HELLO_WORLD",
			"HELLO-WORLD, HELLO_WORLD",
			"hello World MATRIX, HELLO_WORLD_MATRIX",
			"HELLO_WORLD_MATRIX, HELLO_WORLD_MATRIX",
			"helloWorldMatrix, HELLO_WORLD_MATRIX",
			"hello-world-matrix, HELLO_WORLD_MATRIX",
			"hello_world_matrix, HELLO_WORLD_MATRIX",
			"HelloWorldMatrix, HELLO_WORLD_MATRIX",
			"hello.world.matrix, HELLO_WORLD_MATRIX",
			"HELLO-WORLD-MATRIX, HELLO_WORLD_MATRIX",
			"Hello World1, HELLO_WORLD1",
			"HELLO_WORLD1, HELLO_WORLD1",
			"helloWorld1, HELLO_WORLD1",
			"hello-world1, HELLO_WORLD1",
			"hello_world1, HELLO_WORLD1",
			"HelloWorld1, HELLO_WORLD1",
			"hello.world1, HELLO_WORLD1",
			"HELLO-WORLD1, HELLO_WORLD1"
	})
	public void toNotationTypeUpperCase(String value, String expected)
	{
		String actual = Notations.to(value, NotationType.UPPER_CASE);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#to(String, NotationType)} для нотации Kebab Case.
	 */
	@ParameterizedTest
	@CsvSource({
			"hello, hello",
			"HELLO, hello",
			"hello, hello",
			"hello, hello",
			"hello, hello",
			"Hello, hello",
			"hello, hello",
			"HELLO, hello",
			"HELLO WORLD, hello-world",
			"HELLO_WORLD, hello-world",
			"helloWorld, hello-world",
			"hello-world, hello-world",
			"hello_world, hello-world",
			"HelloWorld, hello-world",
			"hello.world, hello-world",
			"HELLO-WORLD, hello-world",
			"hello World MATRIX, hello-world-matrix",
			"HELLO_WORLD_MATRIX, hello-world-matrix",
			"helloWorldMatrix, hello-world-matrix",
			"hello-world-matrix, hello-world-matrix",
			"hello_world_matrix, hello-world-matrix",
			"HelloWorldMatrix, hello-world-matrix",
			"hello.world.matrix, hello-world-matrix",
			"HELLO-WORLD-MATRIX, hello-world-matrix",
			"Hello World1, hello-world1",
			"HELLO_WORLD1, hello-world1",
			"helloWorld1, hello-world1",
			"hello-world1, hello-world1",
			"hello_world1, hello-world1",
			"HelloWorld1, hello-world1",
			"hello.world1, hello-world1",
			"HELLO-WORLD1, hello-world1"
	})
	public void toNotationTypeKebabCase(String value, String expected)
	{
		String actual = Notations.to(value, NotationType.KEBAB_CASE);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#to(String, NotationType)} для нотации Train Case.
	 */
	@ParameterizedTest
	@CsvSource({
			"hello, HELLO",
			"HELLO, HELLO",
			"hello, HELLO",
			"hello, HELLO",
			"hello, HELLO",
			"Hello, HELLO",
			"hello, HELLO",
			"HELLO, HELLO",
			"HELLO WORLD, HELLO-WORLD",
			"HELLO_WORLD, HELLO-WORLD",
			"helloWorld, HELLO-WORLD",
			"hello-world, HELLO-WORLD",
			"hello_world, HELLO-WORLD",
			"HelloWorld, HELLO-WORLD",
			"hello.world, HELLO-WORLD",
			"HELLO-WORLD, HELLO-WORLD",
			"hello World MATRIX, HELLO-WORLD-MATRIX",
			"HELLO_WORLD_MATRIX, HELLO-WORLD-MATRIX",
			"helloWorldMatrix, HELLO-WORLD-MATRIX",
			"hello-world-matrix, HELLO-WORLD-MATRIX",
			"hello_world_matrix, HELLO-WORLD-MATRIX",
			"HelloWorldMatrix, HELLO-WORLD-MATRIX",
			"hello.world.matrix, HELLO-WORLD-MATRIX",
			"HELLO-WORLD-MATRIX, HELLO-WORLD-MATRIX",
			"Hello World1, HELLO-WORLD1",
			"HELLO_WORLD1, HELLO-WORLD1",
			"helloWorld1, HELLO-WORLD1",
			"hello-world1, HELLO-WORLD1",
			"hello_world1, HELLO-WORLD1",
			"HelloWorld1, HELLO-WORLD1",
			"hello.world1, HELLO-WORLD1",
			"HELLO-WORLD1, HELLO-WORLD1"
	})
	public void toNotationTypeTrainCase(String value, String expected)
	{
		String actual = Notations.to(value, NotationType.TRAIN_CASE);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#to(String, NotationType)} для нотации Snake Case.
	 */
	@ParameterizedTest
	@CsvSource({
			"hello, hello",
			"HELLO, hello",
			"hello, hello",
			"hello, hello",
			"hello, hello",
			"Hello, hello",
			"hello, hello",
			"HELLO, hello",
			"HELLO WORLD, hello_world",
			"HELLO_WORLD, hello_world",
			"helloWorld, hello_world",
			"hello-world, hello_world",
			"hello_world, hello_world",
			"HelloWorld, hello_world",
			"hello.world, hello_world",
			"HELLO-WORLD, hello_world",
			"hello World MATRIX, hello_world_matrix",
			"HELLO_WORLD_MATRIX, hello_world_matrix",
			"helloWorldMatrix, hello_world_matrix",
			"hello-world-matrix, hello_world_matrix",
			"hello_world_matrix, hello_world_matrix",
			"HelloWorldMatrix, hello_world_matrix",
			"hello.world.matrix, hello_world_matrix",
			"HELLO-WORLD-MATRIX, hello_world_matrix",
			"Hello World1, hello_world1",
			"HELLO_WORLD1, hello_world1",
			"helloWorld1, hello_world1",
			"hello-world1, hello_world1",
			"hello_world1, hello_world1",
			"HelloWorld1, hello_world1",
			"hello.world1, hello_world1",
			"HELLO-WORLD1, hello_world1"
	})
	public void toNotationTypeSnakeCase(String value, String expected)
	{
		String actual = Notations.to(value, NotationType.SNAKE_CASE);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#to(String, NotationType)} для нотации Camel Case.
	 */
	@ParameterizedTest
	@CsvSource({
			"hello, hello",
			"HELLO, hello",
			"hello, hello",
			"hello, hello",
			"hello, hello",
			"Hello, hello",
			"hello, hello",
			"HELLO, hello",
			"HELLO WORLD, helloWorld",
			"HELLO_WORLD, helloWorld",
			"helloWorld, helloWorld",
			"hello-world, helloWorld",
			"hello_world, helloWorld",
			"HelloWorld, helloWorld",
			"hello.world, helloWorld",
			"HELLO-WORLD, helloWorld",
			"hello World MATRIX, helloWorldMatrix",
			"HELLO_WORLD_MATRIX, helloWorldMatrix",
			"helloWorldMatrix, helloWorldMatrix",
			"hello-world-matrix, helloWorldMatrix",
			"hello_world_matrix, helloWorldMatrix",
			"HelloWorldMatrix, helloWorldMatrix",
			"hello.world.matrix, helloWorldMatrix",
			"HELLO-WORLD-MATRIX, helloWorldMatrix",
			"Hello World1, helloWorld1",
			"HELLO_WORLD1, helloWorld1",
			"helloWorld1, helloWorld1",
			"hello-world1, helloWorld1",
			"hello_world1, helloWorld1",
			"HelloWorld1, helloWorld1",
			"hello.world1, helloWorld1",
			"HELLO-WORLD1, helloWorld1"
	})
	public void toNotationTypeCamelCase(String value, String expected)
	{
		String actual = Notations.to(value, NotationType.CAMEL_CASE);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#to(String, NotationType)} для нотации Pascal Case.
	 */
	@ParameterizedTest
	@CsvSource({
			"hello, Hello",
			"HELLO, Hello",
			"hello, Hello",
			"hello, Hello",
			"hello, Hello",
			"Hello, Hello",
			"hello, Hello",
			"HELLO, Hello",
			"HELLO WORLD, HelloWorld",
			"HELLO_WORLD, HelloWorld",
			"helloWorld, HelloWorld",
			"hello-world, HelloWorld",
			"hello_world, HelloWorld",
			"HelloWorld, HelloWorld",
			"hello.world, HelloWorld",
			"HELLO-WORLD, HelloWorld",
			"hello World MATRIX, HelloWorldMatrix",
			"HELLO_WORLD_MATRIX, HelloWorldMatrix",
			"helloWorldMatrix, HelloWorldMatrix",
			"hello-world-matrix, HelloWorldMatrix",
			"hello_world_matrix, HelloWorldMatrix",
			"HelloWorldMatrix, HelloWorldMatrix",
			"hello.world.matrix, HelloWorldMatrix",
			"HELLO-WORLD-MATRIX, HelloWorldMatrix",
			"Hello World1, HelloWorld1",
			"HELLO_WORLD1, HelloWorld1",
			"helloWorld1, HelloWorld1",
			"hello-world1, HelloWorld1",
			"hello_world1, HelloWorld1",
			"HelloWorld1, HelloWorld1",
			"hello.world1, HelloWorld1",
			"HELLO-WORLD1, HelloWorld1"
	})
	public void toNotationTypePascalCase(String value, String expected)
	{
		String actual = Notations.to(value, NotationType.PASCAL_CASE);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#to(String, NotationType)} для нотации Dot Case.
	 */
	@ParameterizedTest
	@CsvSource({
			"hello, hello",
			"HELLO, hello",
			"hello, hello",
			"hello, hello",
			"hello, hello",
			"Hello, hello",
			"hello, hello",
			"HELLO, hello",
			"HELLO WORLD, hello.world",
			"HELLO_WORLD, hello.world",
			"helloWorld, hello.world",
			"hello-world, hello.world",
			"hello_world, hello.world",
			"HelloWorld, hello.world",
			"hello.world, hello.world",
			"HELLO-WORLD, hello.world",
			"hello World MATRIX, hello.world.matrix",
			"HELLO_WORLD_MATRIX, hello.world.matrix",
			"helloWorldMatrix, hello.world.matrix",
			"hello-world-matrix, hello.world.matrix",
			"hello_world_matrix, hello.world.matrix",
			"HelloWorldMatrix, hello.world.matrix",
			"hello.world.matrix, hello.world.matrix",
			"HELLO-WORLD-MATRIX, hello.world.matrix",
			"Hello World1, hello.world1",
			"HELLO_WORLD1, hello.world1",
			"helloWorld1, hello.world1",
			"hello-world1, hello.world1",
			"hello_world1, hello.world1",
			"HelloWorld1, hello.world1",
			"hello.world1, hello.world1",
			"HELLO-WORLD1, hello.world1"
	})
	public void toNotationTypeDotCase(String value, String expected)
	{
		String actual = Notations.to(value, NotationType.DOT_CASE);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#toUpperCase(String)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"hello, HELLO",
		"HELLO, HELLO",
		"hello, HELLO",
		"hello, HELLO",
		"hello, HELLO",
		"Hello, HELLO",
		"hello, HELLO",
		"HELLO, HELLO",
		"HELLO WORLD, HELLO_WORLD",
		"HELLO_WORLD, HELLO_WORLD",
		"helloWorld, HELLO_WORLD",
		"hello-world, HELLO_WORLD",
		"hello_world, HELLO_WORLD",
		"HelloWorld, HELLO_WORLD",
		"hello.world, HELLO_WORLD",
		"HELLO-WORLD, HELLO_WORLD",
		"hello World MATRIX, HELLO_WORLD_MATRIX",
		"HELLO_WORLD_MATRIX, HELLO_WORLD_MATRIX",
		"helloWorldMatrix, HELLO_WORLD_MATRIX",
		"hello-world-matrix, HELLO_WORLD_MATRIX",
		"hello_world_matrix, HELLO_WORLD_MATRIX",
		"HelloWorldMatrix, HELLO_WORLD_MATRIX",
		"hello.world.matrix, HELLO_WORLD_MATRIX",
		"HELLO-WORLD-MATRIX, HELLO_WORLD_MATRIX",
		"Hello World1, HELLO_WORLD1",
		"HELLO_WORLD1, HELLO_WORLD1",
		"helloWorld1, HELLO_WORLD1",
		"hello-world1, HELLO_WORLD1",
		"hello_world1, HELLO_WORLD1",
		"HelloWorld1, HELLO_WORLD1",
		"hello.world1, HELLO_WORLD1",
		"HELLO-WORLD1, HELLO_WORLD1"
	})
	public void toUpperCase(String value, String expected)
	{
		String actual = Notations.toUpperCase(value);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#toKebabCase(String)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"hello, hello",
		"HELLO, hello",
		"hello, hello",
		"hello, hello",
		"hello, hello",
		"Hello, hello",
		"hello, hello",
		"HELLO, hello",
		"HELLO WORLD, hello-world",
		"HELLO_WORLD, hello-world",
		"helloWorld, hello-world",
		"hello-world, hello-world",
		"hello_world, hello-world",
		"HelloWorld, hello-world",
		"hello.world, hello-world",
		"HELLO-WORLD, hello-world",
		"hello World MATRIX, hello-world-matrix",
		"HELLO_WORLD_MATRIX, hello-world-matrix",
		"helloWorldMatrix, hello-world-matrix",
		"hello-world-matrix, hello-world-matrix",
		"hello_world_matrix, hello-world-matrix",
		"HelloWorldMatrix, hello-world-matrix",
		"hello.world.matrix, hello-world-matrix",
		"HELLO-WORLD-MATRIX, hello-world-matrix",
		"Hello World1, hello-world1",
		"HELLO_WORLD1, hello-world1",
		"helloWorld1, hello-world1",
		"hello-world1, hello-world1",
		"hello_world1, hello-world1",
		"HelloWorld1, hello-world1",
		"hello.world1, hello-world1",
		"HELLO-WORLD1, hello-world1"
	})
	public void toKebabCase(String value, String expected)
	{
		String actual = Notations.toKebabCase(value);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#toTrainCase(String)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"hello, HELLO",
		"HELLO, HELLO",
		"hello, HELLO",
		"hello, HELLO",
		"hello, HELLO",
		"Hello, HELLO",
		"hello, HELLO",
		"HELLO, HELLO",
		"HELLO WORLD, HELLO-WORLD",
		"HELLO_WORLD, HELLO-WORLD",
		"helloWorld, HELLO-WORLD",
		"hello-world, HELLO-WORLD",
		"hello_world, HELLO-WORLD",
		"HelloWorld, HELLO-WORLD",
		"hello.world, HELLO-WORLD",
		"HELLO-WORLD, HELLO-WORLD",
		"hello World MATRIX, HELLO-WORLD-MATRIX",
		"HELLO_WORLD_MATRIX, HELLO-WORLD-MATRIX",
		"helloWorldMatrix, HELLO-WORLD-MATRIX",
		"hello-world-matrix, HELLO-WORLD-MATRIX",
		"hello_world_matrix, HELLO-WORLD-MATRIX",
		"HelloWorldMatrix, HELLO-WORLD-MATRIX",
		"hello.world.matrix, HELLO-WORLD-MATRIX",
		"HELLO-WORLD-MATRIX, HELLO-WORLD-MATRIX",
		"Hello World1, HELLO-WORLD1",
		"HELLO_WORLD1, HELLO-WORLD1",
		"helloWorld1, HELLO-WORLD1",
		"hello-world1, HELLO-WORLD1",
		"hello_world1, HELLO-WORLD1",
		"HelloWorld1, HELLO-WORLD1",
		"hello.world1, HELLO-WORLD1",
		"HELLO-WORLD1, HELLO-WORLD1"
	})
	public void toTrainCase(String value, String expected)
	{
		String actual = Notations.toTrainCase(value);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#toSnakeCase(String)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"hello, hello",
		"HELLO, hello",
		"hello, hello",
		"hello, hello",
		"hello, hello",
		"Hello, hello",
		"hello, hello",
		"HELLO, hello",
		"HELLO WORLD, hello_world",
		"HELLO_WORLD, hello_world",
		"helloWorld, hello_world",
		"hello-world, hello_world",
		"hello_world, hello_world",
		"HelloWorld, hello_world",
		"hello.world, hello_world",
		"HELLO-WORLD, hello_world",
		"hello World MATRIX, hello_world_matrix",
		"HELLO_WORLD_MATRIX, hello_world_matrix",
		"helloWorldMatrix, hello_world_matrix",
		"hello-world-matrix, hello_world_matrix",
		"hello_world_matrix, hello_world_matrix",
		"HelloWorldMatrix, hello_world_matrix",
		"hello.world.matrix, hello_world_matrix",
		"HELLO-WORLD-MATRIX, hello_world_matrix",
		"Hello World1, hello_world1",
		"HELLO_WORLD1, hello_world1",
		"helloWorld1, hello_world1",
		"hello-world1, hello_world1",
		"hello_world1, hello_world1",
		"HelloWorld1, hello_world1",
		"hello.world1, hello_world1",
		"HELLO-WORLD1, hello_world1"
	})
	public void toSnakeCase(String value, String expected)
	{
		String actual = Notations.toSnakeCase(value);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#toCamelCase(String)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"hello, hello",
		"HELLO, hello",
		"hello, hello",
		"hello, hello",
		"hello, hello",
		"Hello, hello",
		"hello, hello",
		"HELLO, hello",
		"HELLO WORLD, helloWorld",
		"HELLO_WORLD, helloWorld",
		"helloWorld, helloWorld",
		"hello-world, helloWorld",
		"hello_world, helloWorld",
		"HelloWorld, helloWorld",
		"hello.world, helloWorld",
		"HELLO-WORLD, helloWorld",
		"hello World MATRIX, helloWorldMatrix",
		"HELLO_WORLD_MATRIX, helloWorldMatrix",
		"helloWorldMatrix, helloWorldMatrix",
		"hello-world-matrix, helloWorldMatrix",
		"hello_world_matrix, helloWorldMatrix",
		"HelloWorldMatrix, helloWorldMatrix",
		"hello.world.matrix, helloWorldMatrix",
		"HELLO-WORLD-MATRIX, helloWorldMatrix",
		"Hello World1, helloWorld1",
		"HELLO_WORLD1, helloWorld1",
		"helloWorld1, helloWorld1",
		"hello-world1, helloWorld1",
		"hello_world1, helloWorld1",
		"HelloWorld1, helloWorld1",
		"hello.world1, helloWorld1",
		"HELLO-WORLD1, helloWorld1"
	})
	public void toCamelCase(String value, String expected)
	{
		String actual = Notations.toCamelCase(value);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#toPascalCase(String)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"hello, Hello",
		"HELLO, Hello",
		"hello, Hello",
		"hello, Hello",
		"hello, Hello",
		"Hello, Hello",
		"hello, Hello",
		"HELLO, Hello",
		"HELLO WORLD, HelloWorld",
		"HELLO_WORLD, HelloWorld",
		"helloWorld, HelloWorld",
		"hello-world, HelloWorld",
		"hello_world, HelloWorld",
		"HelloWorld, HelloWorld",
		"hello.world, HelloWorld",
		"HELLO-WORLD, HelloWorld",
		"hello World MATRIX, HelloWorldMatrix",
		"HELLO_WORLD_MATRIX, HelloWorldMatrix",
		"helloWorldMatrix, HelloWorldMatrix",
		"hello-world-matrix, HelloWorldMatrix",
		"hello_world_matrix, HelloWorldMatrix",
		"HelloWorldMatrix, HelloWorldMatrix",
		"hello.world.matrix, HelloWorldMatrix",
		"HELLO-WORLD-MATRIX, HelloWorldMatrix",
		"Hello World1, HelloWorld1",
		"HELLO_WORLD1, HelloWorld1",
		"helloWorld1, HelloWorld1",
		"hello-world1, HelloWorld1",
		"hello_world1, HelloWorld1",
		"HelloWorld1, HelloWorld1",
		"hello.world1, HelloWorld1",
		"HELLO-WORLD1, HelloWorld1"
	})
	public void toPascalCase(String value, String expected)
	{
		String actual = Notations.toPascalCase(value);

		assertEquals(expected, actual);
	}

	/**
	 * Проверка метода {@link Notations#toDotCase(String)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"hello, hello",
		"HELLO, hello",
		"hello, hello",
		"hello, hello",
		"hello, hello",
		"Hello, hello",
		"hello, hello",
		"HELLO, hello",
		"HELLO WORLD, hello.world",
		"HELLO_WORLD, hello.world",
		"helloWorld, hello.world",
		"hello-world, hello.world",
		"hello_world, hello.world",
		"HelloWorld, hello.world",
		"hello.world, hello.world",
		"HELLO-WORLD, hello.world",
		"hello World MATRIX, hello.world.matrix",
		"HELLO_WORLD_MATRIX, hello.world.matrix",
		"helloWorldMatrix, hello.world.matrix",
		"hello-world-matrix, hello.world.matrix",
		"hello_world_matrix, hello.world.matrix",
		"HelloWorldMatrix, hello.world.matrix",
		"hello.world.matrix, hello.world.matrix",
		"HELLO-WORLD-MATRIX, hello.world.matrix",
		"Hello World1, hello.world1",
		"HELLO_WORLD1, hello.world1",
		"helloWorld1, hello.world1",
		"hello-world1, hello.world1",
		"hello_world1, hello.world1",
		"HelloWorld1, hello.world1",
		"hello.world1, hello.world1",
		"HELLO-WORLD1, hello.world1"
	})
	public void toDotCase(String value, String expected)
	{
		String actual = Notations.toDotCase(value);

		assertEquals(expected, actual);
	}
}