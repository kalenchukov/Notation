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

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс проверки констант и методов перечисления {@link Regexp}.
 *
 * @author Алексей Каленчуков
 */
public class RegexpTest
{
	/**
	 * Проверка метода {@link Regexp#getGroup()}.
	 */
	@Test
	public void getGroup()
	{
		Regexp regexp = Regexp.CAMEL_CASE;

		String actualGroup = regexp.getGroup();

		assertThat(actualGroup).isEqualTo("camelCase");
	}

	/**
	 * Проверка метода {@link Regexp#getPattern()}.
	 */
	@Test
	public void getPattern()
	{
		Regexp regexp = Regexp.CAMEL_CASE;

		String actualPattern = regexp.getPattern();

		assertThat(actualPattern).isNotEmpty();
	}

	/**
	 * Класс проверки регулярного выражения констант перечисления {@link Regexp}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class PatternRegexp
	{
		/**
		 * Проверка константы {@link Regexp#UPPER_CASE}.
		 */
		@Test
		public void upperCase()
		{
			String value = "CAMEL_CASE";
			Pattern pattern = Pattern.compile(Regexp.UPPER_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertThat(matcher.matches()).isTrue();

			String actualGroup = matcher.group("upperCase");

			assertThat(actualGroup).isEqualTo("CAMEL_CASE");
		}

		/**
		 * Проверка константы {@link Regexp#UPPER_CASE} с некорректным значением.
		 */
		@Test
		public void upperCaseNotCorrect()
		{
			String value = "CAMEL#CASE";
			Pattern pattern = Pattern.compile(Regexp.UPPER_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка константы {@link Regexp#KEBAB_CASE}.
		 */
		@Test
		public void kebabCase()
		{
			String value = "kebab-case";
			Pattern pattern = Pattern.compile(Regexp.KEBAB_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertThat(matcher.matches()).isTrue();

			String actualGroup = matcher.group("kebabCase");

			assertThat(actualGroup).isEqualTo("kebab-case");
		}

		/**
		 * Проверка константы {@link Regexp#KEBAB_CASE} с некорректным значением.
		 */
		@Test
		public void kebabCaseNotCorrect()
		{
			String value = "kebab#case";
			Pattern pattern = Pattern.compile(Regexp.KEBAB_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка константы {@link Regexp#SNAKE_CASE}.
		 */
		@Test
		public void snakeCase()
		{
			String value = "snake_case";
			Pattern pattern = Pattern.compile(Regexp.SNAKE_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertThat(matcher.matches()).isTrue();

			String actualGroup = matcher.group("snakeCase");

			assertThat(actualGroup).isEqualTo("snake_case");
		}

		/**
		 * Проверка константы {@link Regexp#SNAKE_CASE} с некорректным значением.
		 */
		@Test
		public void snakeCaseNotCorrect()
		{
			String value = "snake#case";
			Pattern pattern = Pattern.compile(Regexp.SNAKE_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка константы {@link Regexp#CAMEL_CASE}.
		 */
		@Test
		public void camelCase()
		{
			String value = "camelCase";
			Pattern pattern = Pattern.compile(Regexp.CAMEL_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertThat(matcher.matches()).isTrue();

			String actualGroup = matcher.group("camelCase");

			assertThat(actualGroup).isEqualTo("camelCase");
		}

		/**
		 * Проверка константы {@link Regexp#CAMEL_CASE} с некорректным значением.
		 */
		@Test
		public void camelCaseNotCorrect()
		{
			String value = "camel#case";
			Pattern pattern = Pattern.compile(Regexp.CAMEL_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка константы {@link Regexp#PASCAL_CASE}.
		 */
		@Test
		public void pascalCase()
		{
			String value = "PascalCase";
			Pattern pattern = Pattern.compile(Regexp.PASCAL_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertThat(matcher.matches()).isTrue();

			String actualGroup = matcher.group("pascalCase");

			assertThat(actualGroup).isEqualTo("PascalCase");
		}

		/**
		 * Проверка константы {@link Regexp#PASCAL_CASE} с некорректным значением.
		 */
		@Test
		public void pascalCaseNotCorrect()
		{
			String value = "Pascal#case";
			Pattern pattern = Pattern.compile(Regexp.PASCAL_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка константы {@link Regexp#DOT_CASE}.
		 */
		@Test
		public void dotCase()
		{
			String value = "dot.case";
			Pattern pattern = Pattern.compile(Regexp.DOT_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertThat(matcher.matches()).isTrue();

			String actualGroup = matcher.group("dotCase");

			assertThat(actualGroup).isEqualTo("dot.case");
		}

		/**
		 * Проверка константы {@link Regexp#DOT_CASE} с некорректным значением.
		 */
		@Test
		public void dotCaseNotCorrect()
		{
			String value = "dot#case";
			Pattern pattern = Pattern.compile(Regexp.DOT_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка константы {@link Regexp#TRAIN_CASE}.
		 */
		@Test
		public void trainCase()
		{
			String value = "TRAIN-CASE";
			Pattern pattern = Pattern.compile(Regexp.TRAIN_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);
			assertThat(matcher.matches()).isTrue();

			String actualGroup = matcher.group("trainCase");

			assertThat(actualGroup).isEqualTo("TRAIN-CASE");
		}

		/**
		 * Проверка константы {@link Regexp#TRAIN_CASE} с некорректным значением.
		 */
		@Test
		public void trainCaseNotCorrect()
		{
			String value = "TRAIN#CASE";
			Pattern pattern = Pattern.compile(Regexp.TRAIN_CASE.getPattern(), Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(value);

			boolean actual = matcher.matches();

			assertThat(actual).isFalse();
		}
	}
}