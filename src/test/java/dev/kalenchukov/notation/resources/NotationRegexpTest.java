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

import org.junit.jupiter.api.Nested;
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
	 * Проверка метода {@link NotationRegexp#getGroup()}.
	 */
	@Test
	public void getGroup()
	{
		NotationRegexp regexp = NotationRegexp.CAMEL_CASE;

		String actualGroup = regexp.getGroup();

		assertEquals("camelCase", actualGroup);
	}

	/**
	 * Проверка метода {@link NotationRegexp#getPattern()}.
	 */
	@Test
	public void getPattern()
	{
		NotationRegexp regexp = NotationRegexp.CAMEL_CASE;

		String actualPattern = regexp.getPattern();

		assertFalse(actualPattern.isEmpty());
	}

	/**
	 * Класс проверки регулярного выражения констант перечисления {@link NotationRegexp}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class PatternTest
	{
		/**
		 * Проверка константы {@link NotationRegexp#UPPER_CASE}.
		 */
		@Test
		public void upperCase()
		{
			String value = "CAMEL_CASE";
			Pattern pattern = Pattern.compile(NotationRegexp.UPPER_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertTrue(matcher.matches());

			String actualGroup = matcher.group("upperCase");

			assertEquals("CAMEL_CASE", actualGroup);
		}

		/**
		 * Проверка константы {@link NotationRegexp#UPPER_CASE} с некорректным значением.
		 */
		@Test
		public void upperCaseNotCorrect()
		{
			String value = "CAMEL#CASE";
			Pattern pattern = Pattern.compile(NotationRegexp.UPPER_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertFalse(actual);
		}

		/**
		 * Проверка константы {@link NotationRegexp#KEBAB_CASE}.
		 */
		@Test
		public void kebabCase()
		{
			String value = "kebab-case";
			Pattern pattern = Pattern.compile(NotationRegexp.KEBAB_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertTrue(matcher.matches());

			String actualGroup = matcher.group("kebabCase");

			assertEquals("kebab-case", actualGroup);
		}

		/**
		 * Проверка константы {@link NotationRegexp#KEBAB_CASE} с некорректным значением.
		 */
		@Test
		public void kebabCaseNotCorrect()
		{
			String value = "kebab#case";
			Pattern pattern = Pattern.compile(NotationRegexp.KEBAB_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertFalse(actual);
		}

		/**
		 * Проверка константы {@link NotationRegexp#SNAKE_CASE}.
		 */
		@Test
		public void snakeCase()
		{
			String value = "snake_case";
			Pattern pattern = Pattern.compile(NotationRegexp.SNAKE_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertTrue(matcher.matches());

			String actualGroup = matcher.group("snakeCase");

			assertEquals("snake_case", actualGroup);
		}

		/**
		 * Проверка константы {@link NotationRegexp#SNAKE_CASE} с некорректным значением.
		 */
		@Test
		public void snakeCaseNotCorrect()
		{
			String value = "snake#case";
			Pattern pattern = Pattern.compile(NotationRegexp.SNAKE_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertFalse(actual);
		}

		/**
		 * Проверка константы {@link NotationRegexp#CAMEL_CASE}.
		 */
		@Test
		public void camelCase()
		{
			String value = "camelCase";
			Pattern pattern = Pattern.compile(NotationRegexp.CAMEL_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertTrue(matcher.matches());

			String actualGroup = matcher.group("camelCase");

			assertEquals("camelCase", actualGroup);
		}

		/**
		 * Проверка константы {@link NotationRegexp#CAMEL_CASE} с некорректным значением.
		 */
		@Test
		public void camelCaseNotCorrect()
		{
			String value = "camel#case";
			Pattern pattern = Pattern.compile(NotationRegexp.CAMEL_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertFalse(actual);
		}

		/**
		 * Проверка константы {@link NotationRegexp#PASCAL_CASE}.
		 */
		@Test
		public void pascalCase()
		{
			String value = "PascalCase";
			Pattern pattern = Pattern.compile(NotationRegexp.PASCAL_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertTrue(matcher.matches());

			String actualGroup = matcher.group("pascalCase");

			assertEquals("PascalCase", actualGroup);
		}

		/**
		 * Проверка константы {@link NotationRegexp#PASCAL_CASE} с некорректным значением.
		 */
		@Test
		public void pascalCaseNotCorrect()
		{
			String value = "Pascal#case";
			Pattern pattern = Pattern.compile(NotationRegexp.PASCAL_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertFalse(actual);
		}

		/**
		 * Проверка константы {@link NotationRegexp#DOT_CASE}.
		 */
		@Test
		public void dotCase()
		{
			String value = "dot.case";
			Pattern pattern = Pattern.compile(NotationRegexp.DOT_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertTrue(matcher.matches());

			String actualGroup = matcher.group("dotCase");

			assertEquals("dot.case", actualGroup);
		}

		/**
		 * Проверка константы {@link NotationRegexp#DOT_CASE} с некорректным значением.
		 */
		@Test
		public void dotCaseNotCorrect()
		{
			String value = "dot#case";
			Pattern pattern = Pattern.compile(NotationRegexp.DOT_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertFalse(actual);
		}

		/**
		 * Проверка константы {@link NotationRegexp#TRAIN_CASE}.
		 */
		@Test
		public void trainCase()
		{
			String value = "TRAIN-CASE";
			Pattern pattern = Pattern.compile(NotationRegexp.TRAIN_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertTrue(matcher.matches());

			String actualGroup = matcher.group("trainCase");

			assertEquals("TRAIN-CASE", actualGroup);
		}

		/**
		 * Проверка константы {@link NotationRegexp#TRAIN_CASE} с некорректным значением.
		 */
		@Test		public void trainCaseNotCorrect()
		{
			String value = "TRAIN#CASE";
			Pattern pattern = Pattern.compile(NotationRegexp.TRAIN_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertFalse(actual);
		}
	}
}