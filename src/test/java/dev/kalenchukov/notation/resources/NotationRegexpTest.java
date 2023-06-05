/*
 * Copyright © 2023 Алексей Каленчуков
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

package dev.kalenchukov.notation.resources;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки констант и методов перечисления {@link NotationRegexp}.
 *
 * @author Алексей Каленчуков
 */
public class NotationRegexpTest
{
	/**
	 * Проверка константы {@link NotationRegexp#UPPER_CASE}.
	 */
	@Test
	public void testUpperCase()
	{
		String value = "CAMEL_CASE";

		Pattern pattern = Pattern.compile(NotationRegexp.UPPER_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.matches());
		assertEquals("CAMEL_CASE", matcher.group(NotationRegexp.UPPER_CASE.getGroup()));
	}

	/**
	 * Проверка константы {@link NotationRegexp#UPPER_CASE} с некорректным значением.
	 */
	@Test
	public void testUpperCaseNotCorrect()
	{
		String value = "CAMEL#CASE";

		Pattern pattern = Pattern.compile(NotationRegexp.UPPER_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertFalse(matcher.matches());
	}

	/**
	 * Проверка константы {@link NotationRegexp#KEBAB_CASE}.
	 */
	@Test
	public void testKebabCase()
	{
		String value = "kebab-case";

		Pattern pattern = Pattern.compile(NotationRegexp.KEBAB_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.matches());
		assertEquals("kebab-case", matcher.group(NotationRegexp.KEBAB_CASE.getGroup()));
	}

	/**
	 * Проверка константы {@link NotationRegexp#KEBAB_CASE} с некорректным значением.
	 */
	@Test
	public void testKebabCaseNotCorrect()
	{
		String value = "kebab#case";

		Pattern pattern = Pattern.compile(NotationRegexp.KEBAB_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertFalse(matcher.matches());
	}

	/**
	 * Проверка константы {@link NotationRegexp#SNAKE_CASE}.
	 */
	@Test
	public void testSnakeCase()
	{
		String value = "snake_case";

		Pattern pattern = Pattern.compile(NotationRegexp.SNAKE_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.matches());
		assertEquals("snake_case", matcher.group(NotationRegexp.SNAKE_CASE.getGroup()));
	}

	/**
	 * Проверка константы {@link NotationRegexp#SNAKE_CASE} с некорректным значением.
	 */
	@Test
	public void testSnakeCaseNotCorrect()
	{
		String value = "snake#case";

		Pattern pattern = Pattern.compile(NotationRegexp.SNAKE_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertFalse(matcher.matches());
	}

	/**
	 * Проверка константы {@link NotationRegexp#CAMEL_CASE}.
	 */
	@Test
	public void testCamelCase()
	{
		String value = "camelCase";

		Pattern pattern = Pattern.compile(NotationRegexp.CAMEL_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.matches());
		assertEquals("camelCase", matcher.group(NotationRegexp.CAMEL_CASE.getGroup()));
	}

	/**
	 * Проверка константы {@link NotationRegexp#CAMEL_CASE} с некорректным значением.
	 */
	@Test
	public void testCamelCaseNotCorrect()
	{
		String value = "camel#case";

		Pattern pattern = Pattern.compile(NotationRegexp.CAMEL_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertFalse(matcher.matches());
	}

	/**
	 * Проверка константы {@link NotationRegexp#PASCAL_CASE}.
	 */
	@Test
	public void testPascalCase()
	{
		String value = "PascalCase";

		Pattern pattern = Pattern.compile(NotationRegexp.PASCAL_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.matches());
		assertEquals("PascalCase", matcher.group(NotationRegexp.PASCAL_CASE.getGroup()));
	}

	/**
	 * Проверка константы {@link NotationRegexp#PASCAL_CASE} с некорректным значением.
	 */
	@Test
	public void testPascalCaseNotCorrect()
	{
		String value = "Pascal#case";

		Pattern pattern = Pattern.compile(NotationRegexp.PASCAL_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertFalse(matcher.matches());
	}

	/**
	 * Проверка константы {@link NotationRegexp#DOT_CASE}.
	 */
	@Test
	public void testDotCase()
	{
		String value = "dot.case";

		Pattern pattern = Pattern.compile(NotationRegexp.DOT_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.matches());
		assertEquals("dot.case", matcher.group(NotationRegexp.DOT_CASE.getGroup()));
	}

	/**
	 * Проверка константы {@link NotationRegexp#DOT_CASE} с некорректным значением.
	 */
	@Test
	public void testDotCaseNotCorrect()
	{
		String value = "dot#case";

		Pattern pattern = Pattern.compile(NotationRegexp.DOT_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertFalse(matcher.matches());
	}

	/**
	 * Проверка константы {@link NotationRegexp#TRAIN_CASE}.
	 */
	@Test
	public void testTrainCase()
	{
		String value = "TRAIN-CASE";

		Pattern pattern = Pattern.compile(NotationRegexp.TRAIN_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.matches());
		assertEquals("TRAIN-CASE", matcher.group(NotationRegexp.TRAIN_CASE.getGroup()));
	}

	/**
	 * Проверка константы {@link NotationRegexp#TRAIN_CASE} с некорректным значением.
	 */
	@Test
	public void testTrainCaseNotCorrect()
	{
		String value = "TRAIN#CASE";

		Pattern pattern = Pattern.compile(NotationRegexp.TRAIN_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertFalse(matcher.matches());
	}
}