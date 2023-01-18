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

import dev.kalenchukov.word.notation.resources.WordNotationRegexp;
import dev.kalenchukov.word.notation.resources.SeparatorType;
import dev.kalenchukov.word.notation.resources.WordNotationType;
import dev.kalenchukov.stringi.Stringi;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс содержит статические методы для нотации составных слов.
 */
public final class WordNotation
{
	/**
	 * Конструктор для {@code WordNotation}.
	 */
	private WordNotation() {}

	/**
	 * Проверяет соответствие строки нотации Upper Case.
	 *
	 * @param value строка.
	 * @return {@code true}, если строка соответствует нотации Upper Case, иначе {@code false}.
	 */
	public static boolean isUpperCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return WordNotation.is(value, WordNotationRegexp.UPPER_CASE);
	}

	/**
	 * Проверяет соответствие строки нотации Kebab Case.
	 *
	 * @param value строка.
	 * @return {@code true}, если строка соответствует нотации Kebab Case, иначе {@code false}.
	 */
	public static boolean isKebabCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return WordNotation.is(value, WordNotationRegexp.KEBAB_CASE);
	}

	/**
	 * Проверяет соответствие строки нотации Snake Case.
	 *
	 * @param value строка.
	 * @return {@code true}, если строка соответствует нотации Snake Case, иначе {@code false}.
	 */
	public static boolean isSnakeCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return WordNotation.is(value, WordNotationRegexp.SNAKE_CASE);
	}

	/**
	 * Проверяет соответствие строки нотации Camel Case.
	 *
	 * @param value строка.
	 * @return {@code true}, если строка соответствует нотации Camel Case, иначе {@code false}.
	 */
	public static boolean isCamelCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return WordNotation.is(value, WordNotationRegexp.CAMEL_CASE);
	}

	/**
	 * Проверяет соответствие строки указанной нотации.
	 *
	 * @param value строка.
	 * @param wordNotationRegexp регулярное выражение нотации.
	 * @return {@code true}, если строка соответствует указанной нотации, иначе {@code false}.
	 */
	private static boolean is(@NotNull final String value, @NotNull final WordNotationRegexp wordNotationRegexp)
	{
		Objects.requireNonNull(value);
		Objects.requireNonNull(wordNotationRegexp);

		final Pattern pattern = Pattern.compile(wordNotationRegexp.getPattern(), Pattern.UNICODE_CASE);
		final Matcher matcher = pattern.matcher(value);

		return matcher.matches();
	}

	/**
	 * Возвращает строку в указанной нотации.
	 *
	 * @param value строка, нотацию которой необходимо изменить.
	 * @param wordNotationType тип нотации.
	 * @return строку в указанной нотации.
	 *
	 */
	@NotNull
	public static String to(@NotNull final String value, @NotNull final WordNotationType wordNotationType)
	{
		Objects.requireNonNull(value);
		Objects.requireNonNull(wordNotationType);

		return switch (wordNotationType)
			{
				case CAMEL_CASE -> WordNotation.toCamelCase(value);
				case KEBAB_CASE -> WordNotation.toKebabCase(value);
				case UPPER_CASE -> WordNotation.toUpperCase(value);
				case SNAKE_CASE -> WordNotation.toSnakeCase(value);
				case PASCAL_CASE -> WordNotation.toPascalCase(value);
			};
	}

	/**
	 * Возвращает строку в нотации Upper Case.
	 *
	 * @see WordNotationType#UPPER_CASE
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Upper Case.
	 */
	@NotNull
	public static String toUpperCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return WordNotation.fromAbstract(value, SeparatorType.UNDERSCORE).toUpperCase();
	}

	/**
	 * Возвращает строку в нотации Kebab Case.
	 *
	 * @see WordNotationType#KEBAB_CASE
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Kebab Case.
	 */
	@NotNull
	public static String toKebabCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return WordNotation.fromAbstract(value, SeparatorType.HYPHEN);
	}

	/**
	 * Возвращает строку в нотации Snake Case.
	 *
	 * @see WordNotationType#SNAKE_CASE
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Snake Case.
	 */
	@NotNull
	public static String toSnakeCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return WordNotation.fromAbstract(value, SeparatorType.UNDERSCORE);
	}

	/**
	 * Возвращает строку в нотации Camel Case.
	 *
	 * @see WordNotationType#CAMEL_CASE
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Camel Case.
	 */
	@NotNull
	public static String toCamelCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return WordNotation.fromAbstract(value, SeparatorType.UPPERCASE);
	}

	/**
	 * Возвращает строку в нотации Pascal Case.
	 *
	 * @see WordNotationType#PASCAL_CASE
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Pascal Case.
	 */
	@NotNull
	public static String toPascalCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Stringi.firstLetterToUpperCase(
			WordNotation.fromAbstract(value, SeparatorType.UPPERCASE)
		);
	}

	/**
	 * Возвращает строку, в которой абстрактная нотация преобразована в соответствии с разделителем.
	 *
	 * @param value строка в абстрактной нотации.
	 * @param separatorType необходимый разделитель для выбранной нотации.
	 * @return строку, в которой абстрактная нотация преобразована в соответствии с разделителем.
	 */
	@NotNull
	private static String fromAbstract(@NotNull final String value, @NotNull final SeparatorType separatorType)
	{
		Objects.requireNonNull(value);
		Objects.requireNonNull(separatorType);

		String abstractValue = WordNotation.toAbstract(value);

		Matcher matcher = Pattern.compile("\\+(?<target>[a-z0-9])", Pattern.UNICODE_CASE)
								 .matcher(abstractValue);

		while (matcher.find())
		{
			String replacement = switch (separatorType)
				{
					case HYPHEN -> "-" + matcher.group("target");
					case UNDERSCORE -> "_" + matcher.group("target");
					case UPPERCASE -> matcher.group("target").toUpperCase();
				};

			abstractValue = abstractValue.replaceAll("\\+" + matcher.group("target"), replacement);
		}

		return abstractValue;
	}

	/**
	 * Возвращает строку в абстрактной нотации.
	 * Абстрактная нотация - это стиль в котором разделение слов обозначается символом "+", а все буквы прописные.
	 *
	 * @param value строка, которую необходимо конвертировать в абстрактную нотацию.
	 * @return строку в абстрактной нотации.
	 */
	@NotNull
	private static String toAbstract(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		String separator = "+";
		String abstractValue = value.replaceAll("(?<=[a-zA-Z])[_-](?=[a-z0-9A-Z])", separator);

		Matcher matcher = Pattern.compile("(?<=[a-z])(?<joint>[A-Z])(?=[a-z0-9A-Z])", Pattern.UNICODE_CASE)
								 .matcher(abstractValue);

		while (matcher.find())
		{
			abstractValue = abstractValue.replaceAll(
				"(?<=[a-z])" + matcher.group("joint"),
				separator + matcher.group("joint")
			);
		}

		return abstractValue.toLowerCase();
	}
}
