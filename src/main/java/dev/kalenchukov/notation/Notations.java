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

import dev.kalenchukov.notation.resources.SeparatorType;
import dev.kalenchukov.notation.resources.Regexp;
import dev.kalenchukov.notation.resources.NotationType;
import dev.kalenchukov.stringi.Stringi;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс содержит статические методы для нотации составных слов.
 *
 * @author Алексей Каленчуков
 */
public final class Notations
{
	/**
	 * Абстрактный разделитель слов.
	 */
	private static final String ABSTRACT_SEPARATOR = "+";

	/**
	 * Конструктор для {@code Notations}.
	 */
	private Notations() {}

	/**
	 * Проверяет соответствие строки указанной нотации.
	 *
	 * @param value строка, нотацию которой необходимо проверить.
	 * @param notationType тип нотации.
	 * @return {@code true}, если строка соответствует указанной нотации, иначе {@code false}.
	 *
	 */
	public static boolean is(@NotNull final String value, @NotNull final NotationType notationType)
	{
		Objects.requireNonNull(value);
		Objects.requireNonNull(notationType);

		return switch (notationType)
		{
			case CAMEL_CASE -> Notations.isCamelCase(value);
			case KEBAB_CASE -> Notations.isKebabCase(value);
			case UPPER_CASE -> Notations.isUpperCase(value);
			case SNAKE_CASE -> Notations.isSnakeCase(value);
			case PASCAL_CASE -> Notations.isPascalCase(value);
			case DOT_CASE -> Notations.isDotCase(value);
			case TRAIN_CASE -> Notations.isTrainCase(value);
		};
	}

	/**
	 * Проверяет соответствие строки нотации Upper Case.
	 *
	 * @param value строка.
	 * @return {@code true}, если строка соответствует нотации Upper Case, иначе {@code false}.
	 */
	public static boolean isUpperCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Notations.is(value, Regexp.UPPER_CASE);
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

		return Notations.is(value, Regexp.KEBAB_CASE);
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

		return Notations.is(value, Regexp.SNAKE_CASE);
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

		return Notations.is(value, Regexp.CAMEL_CASE);
	}

	/**
	 * Проверяет соответствие строки нотации Pascal Case.
	 *
	 * @param value строка.
	 * @return {@code true}, если строка соответствует нотации Pascal Case, иначе {@code false}.
	 */
	public static boolean isPascalCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Notations.is(value, Regexp.PASCAL_CASE);
	}

	/**
	 * Проверяет соответствие строки нотации Dot Case.
	 *
	 * @param value строка.
	 * @return {@code true}, если строка соответствует нотации Dot Case, иначе {@code false}.
	 */
	public static boolean isDotCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Notations.is(value, Regexp.DOT_CASE);
	}

	/**
	 * Проверяет соответствие строки нотации Train Case.
	 *
	 * @param value строка.
	 * @return {@code true}, если строка соответствует нотации Train Case, иначе {@code false}.
	 */
	public static boolean isTrainCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Notations.is(value, Regexp.TRAIN_CASE);
	}

	/**
	 * Возвращает строку в указанной нотации.
	 *
	 * @param value строка, нотацию которой необходимо изменить.
	 * @param notationType тип нотации.
	 * @return строку в указанной нотации.
	 *
	 */
	@NotNull
	public static String to(@NotNull final String value, @NotNull final NotationType notationType)
	{
		Objects.requireNonNull(value);
		Objects.requireNonNull(notationType);

		return switch (notationType)
			{
				case CAMEL_CASE -> Notations.toCamelCase(value);
				case KEBAB_CASE -> Notations.toKebabCase(value);
				case UPPER_CASE -> Notations.toUpperCase(value);
				case SNAKE_CASE -> Notations.toSnakeCase(value);
				case PASCAL_CASE -> Notations.toPascalCase(value);
				case DOT_CASE -> Notations.toDotCase(value);
				case TRAIN_CASE -> Notations.toTrainCase(value);
			};
	}

	/**
	 * Возвращает строку в нотации Upper Case.
	 *
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Upper Case.
	 */
	@NotNull
	public static String toUpperCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Notations.fromAbstract(value, SeparatorType.UNDERSCORE).toUpperCase();
	}

	/**
	 * Возвращает строку в нотации Kebab Case.
	 *
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Kebab Case.
	 */
	@NotNull
	public static String toKebabCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Notations.fromAbstract(value, SeparatorType.HYPHEN);
	}

	/**
	 * Возвращает строку в нотации Snake Case.
	 *
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Snake Case.
	 */
	@NotNull
	public static String toSnakeCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Notations.fromAbstract(value, SeparatorType.UNDERSCORE);
	}

	/**
	 * Возвращает строку в нотации Camel Case.
	 *
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Camel Case.
	 */
	@NotNull
	public static String toCamelCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Notations.fromAbstract(value, SeparatorType.UPPERCASE);
	}

	/**
	 * Возвращает строку в нотации Pascal Case.
	 *
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Pascal Case.
	 */
	@NotNull
	public static String toPascalCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Stringi.firstLetterToUpperCase(
			Notations.fromAbstract(value, SeparatorType.UPPERCASE)
		);
	}

	/**
	 * Возвращает строку в нотации Dot Case.
	 *
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Dot Case.
	 */
	@NotNull
	public static String toDotCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Notations.fromAbstract(value, SeparatorType.DOT);
	}

	/**
	 * Возвращает строку в нотации Train Case.
	 *
	 * @param value строка, нотацию которой необходимо изменить.
	 * @return строку в нотации Train Case.
	 */
	@NotNull
	public static String toTrainCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Notations.fromAbstract(value, SeparatorType.HYPHEN).toUpperCase();
	}

	/**
	 * Проверяет соответствие строки указанной нотации.
	 *
	 * @param value строка.
	 * @param regexp регулярное выражение нотации.
	 * @return {@code true}, если строка соответствует указанной нотации, иначе {@code false}.
	 */
	private static boolean is(@NotNull final String value, @NotNull final Regexp regexp)
	{
		Objects.requireNonNull(value);
		Objects.requireNonNull(regexp);

		final Pattern pattern = Pattern.compile(regexp.getPattern(), Pattern.UNICODE_CASE);
		final Matcher matcher = pattern.matcher(value);

		return matcher.matches();
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

		String abstractValue = Notations.toAbstract(value);
		Matcher matcher = Pattern.compile(
				Pattern.quote(Notations.ABSTRACT_SEPARATOR) + "(?<target>[a-z0-9])",
				Pattern.UNICODE_CASE
		).matcher(abstractValue);

		while (matcher.find())
		{
			String target = matcher.group("target");
			String replacement = separatorType.getSeparatorSymbol() + target;

			if (separatorType == SeparatorType.UPPERCASE) {
				replacement = replacement.toUpperCase();
			}

			abstractValue = abstractValue.replaceAll(
					Pattern.quote(Notations.ABSTRACT_SEPARATOR) + target,
					replacement
			);
		}

		return abstractValue;
	}

	/**
	 * Возвращает строку в абстрактной нотации.
	 * Абстрактная нотация - это стиль в котором разделение слов обозначается
	 * символом {@value Notations#ABSTRACT_SEPARATOR}, а все буквы строчные.
	 *
	 * @param value строка, которую необходимо конвертировать в абстрактную нотацию.
	 * @return строку в абстрактной нотации.
	 */
	@NotNull
	private static String toAbstract(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		String separators = SeparatorType.getAllSeparatorSymbols();
		String regexp = "(?<=[a-zA-Z])[" + separators + "](?=[a-z0-9A-Z])";
		String abstractValue = value.replaceAll(regexp, Notations.ABSTRACT_SEPARATOR);

		Matcher matcher = Pattern.compile("(?<=[a-z])(?<word>[A-Z])(?=[a-z0-9A-Z])", Pattern.UNICODE_CASE)
								 .matcher(abstractValue);

		while (matcher.find())
		{
			String target = matcher.group("word");
			String replacement = Notations.ABSTRACT_SEPARATOR + target;

			abstractValue = abstractValue.replaceAll("(?<=[a-z])" + target, replacement);
		}

		return abstractValue.toLowerCase();
	}
}
