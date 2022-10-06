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

import dev.kalenchukov.notation.converting.resources.SeparatorType;
import dev.kalenchukov.notation.converting.resources.NotationType;
import dev.kalenchukov.stringi.Stringi;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс содержит статические методы конвертирования нотации составных слов.
 */
public final class NotationConverter
{
	/**
	 * Конструктор для {@code NotationConverter} запрещающий создавать объект класса.
	 */
	private NotationConverter() {}

	/**
	 * Возвращает строку в нотации Upper Case.
	 *
	 * @see NotationType#UPPER_CASE
	 * @param value Строка, нотацию которой необходимо изменить.
	 * @return Строку в нотации Upper Case.
	 */
	@NotNull
	public static String toUpperCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return NotationConverter.fromAbstract(value, SeparatorType.UNDERSCORE).toUpperCase();
	}

	/**
	 * Возвращает строку в нотации Kebab Case.
	 *
	 * @see NotationType#KEBAB_CASE
	 * @param value Строка, нотацию которой необходимо изменить.
	 * @return Строку в нотации Kebab Case.
	 */
	@NotNull
	public static String toKebabCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return NotationConverter.fromAbstract(value, SeparatorType.HYPHEN);
	}

	/**
	 * Возвращает строку в нотации Snake Case.
	 *
	 * @see NotationType#SNAKE_CASE
	 * @param value Строка, нотацию которой необходимо изменить.
	 * @return Строку в нотации Snake Case.
	 */
	@NotNull
	public static String toSnakeCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return NotationConverter.fromAbstract(value, SeparatorType.UNDERSCORE);
	}

	/**
	 * Возвращает строку в нотации Camel Case.
	 *
	 * @see NotationType#CAMEL_CASE
	 * @param value Строка, нотацию которой необходимо изменить.
	 * @return Строку в нотации Camel Case.
	 */
	@NotNull
	public static String toCamelCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return NotationConverter.fromAbstract(value, SeparatorType.UPPERCASE);
	}

	/**
	 * Возвращает строку в нотации Pascal Case.
	 *
	 * @see NotationType#PASCAL_CASE
	 * @param value Строка, нотацию которой необходимо изменить.
	 * @return Строку в нотации Pascal Case.
	 */
	@NotNull
	public static String toPascalCase(@NotNull final String value)
	{
		Objects.requireNonNull(value);

		return Stringi.firstLetterToUpperCase(
			NotationConverter.fromAbstract(value, SeparatorType.UPPERCASE)
		);
	}

	/**
	 * Возвращает строку в которой абстрактная нотация преобразована в соответствии с разделителем.
	 *
	 * @param value Строка в абстрактной нотации.
	 * @param separatorType Необходимый разделитель для выбранной нотации.
	 * @return Строку в которой абстрактная нотация преобразована в соответствии с разделителем.
	 */
	@NotNull
	private static String fromAbstract(@NotNull final String value, @NotNull final SeparatorType separatorType)
	{
		Objects.requireNonNull(value);
		Objects.requireNonNull(separatorType);

		String abstractValue = NotationConverter.toAbstract(value);

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
	 * @param value Строка, которую необходимо конвертировать в абстрактную нотацию.
	 * @return Строку в абстрактной нотации.
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
