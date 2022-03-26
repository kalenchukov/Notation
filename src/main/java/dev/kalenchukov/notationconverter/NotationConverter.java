/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.notationconverter;

import dev.kalenchukov.notationconverter.resources.Separator;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс содержит статические методы конвертирования нотации составных слов.
 */
public final class NotationConverter
{
	private NotationConverter() {}

	/**
	 * Возвращает строку в нотации Upper Case.
	 * Upper Case - все слова пишутся прописными буквами, а в качестве разделителя слов символ нижнего подчёркивания.
	 *
	 * @param value Строка, нотацию которой необходимо изменить.
	 * @return Строку в нотации Upper Case.
	 */
	@NotNull
	public static String toUpperCase(@NotNull final String value)
	{
		return NotationConverter.fromAbstract(value, Separator.UNDERSCORE).toUpperCase();
	}

	/**
	 * Возвращает строку в нотации Kebab Case.
	 * Kebab Case - все слова пишутся строчными буквами, а в качестве разделителя слов символ дефиса.
	 *
	 * @param value Строка, нотацию которой необходимо изменить.
	 * @return Строку в нотации Kebab Case.
	 */
	@NotNull
	public static String toKebabCase(@NotNull final String value)
	{
		return NotationConverter.fromAbstract(value, Separator.HYPHEN);
	}

	/**
	 * Возвращает строку в нотации Snake Case.
	 * Snake Case - все слова пишутся строчными буквами, а в качестве разделителя слов символ нижнего подчёркивания.
	 *
	 * @param value Строка, нотацию которой необходимо изменить.
	 * @return Строку в нотации Snake Case.
	 */
	@NotNull
	public static String toSnakeCase(@NotNull final String value)
	{
		return NotationConverter.fromAbstract(value, Separator.UNDERSCORE);
	}

	/**
	 * Возвращает строку в нотации Camel Case.
	 * Camel Case - должен начинаться со строчной буквы, а первая буква каждого последующего слова
	 * должна быть прописной. Все слова при этом пишутся слитно между собой.
	 *
	 * @param value Строка, нотацию которой необходимо изменить.
	 * @return Строку в нотации Camel Case.
	 */
	@NotNull
	public static String toCamelCase(@NotNull final String value)
	{
		return NotationConverter.fromAbstract(value, Separator.UPPERCASE);
	}

	/**
	 * Возвращает строку в нотации Pascal Case.
	 * Pascal Case - первая буква каждого слова должна быть прописной. Все слова при этом пишутся слитно между собой.
	 *
	 * @param value Строка, нотацию которой необходимо изменить.
	 * @return Строку в нотации Pascal Case.
	 */
	@NotNull
	public static String toPascalCase(@NotNull final String value)
	{
		return NotationConverter.firstCharToUpperCase(
			NotationConverter.fromAbstract(value, Separator.UPPERCASE)
		);
	}

	/**
	 * Возвращает строку в которой абстрактная нотация преобразована в соответствии с разделителем.
	 *
	 * @param value Строка в абстрактной нотации.
	 * @param separator Необходимый разделитель для выбранной нотации.
	 * @return Строку в которой абстрактная нотация преобразована в соответствии с разделителем.
	 */
	@NotNull
	private static String fromAbstract(@NotNull final String value, @NotNull final Separator separator)
	{
		String abstractValue = NotationConverter.toAbstract(value);

		Matcher matcher = Pattern.compile("\\+(?<target>[a-z0-9])", Pattern.UNICODE_CASE)
								 .matcher(abstractValue);

		while (matcher.find())
		{
			String replacement = switch (separator)
				{
					case HYPHEN -> "-" + matcher.group("target");
					case UNDERSCORE -> "_" + matcher.group("target");
					case UPPERCASE -> matcher.group("target").toUpperCase();
					case NONE -> matcher.group("target");
				};

			abstractValue = abstractValue.replaceAll("\\+" + matcher.group("target"), replacement);
		}

		return abstractValue;
	}

	/**
	 * Возвращает строку в абстрактной нотации.
	 * Абстрактная нотация - это стиль в котором разделение слов обозначается символом "*", а все буквы прописные.
	 *
	 * @param value Строка, которую необходимо конвертировать в абстрактную нотацию.
	 * @return Строку в абстрактной нотации.
	 */
	@NotNull
	private static String toAbstract(@NotNull final String value)
	{
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

	/**
	 * Делает первую найденную букву прописной.
	 * Внимание! Преобразовывается не первый символ строки, а именно первая буква латинского алфавита.
	 *
	 * @param value Строка в которой необходимо сделать первую букву прописной.
	 * @return Возвращает строку в которой первая буква будет прописной.
	 */
	@NotNull
	private static String firstCharToUpperCase(@NotNull String value)
	{
		Matcher matcher = Pattern.compile("[a-z]", Pattern.UNICODE_CASE + Pattern.CASE_INSENSITIVE)
								 .matcher(value);

		if (matcher.find()) {
			value = value.substring(0, matcher.start()) +
					value.substring(matcher.start(), matcher.end()).toUpperCase() +
					value.substring(matcher.end());
		}

		return value;
	}
}
