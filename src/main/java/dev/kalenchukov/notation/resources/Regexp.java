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

package dev.kalenchukov.notation.resources;

import org.jetbrains.annotations.NotNull;

/**
 * Перечисление шаблонов регулярных выражений.
 *
 * @author Алексей Каленчуков
 */
public enum Regexp
{
	/**
	 * Нотация Upper Case.
	 *
	 * <p>Требования:</p>
	 * <ul>
	 * 		<li>Может состоять из прописных букв, цифр и символа {@literal «_»};</li>
	 * 		<li>Не может начинаться с символа {@literal «_»};</li>
	 * 		<li>Не может заканчиваться символом {@literal «_»};</li>
	 * 		<li>Не может содержать двух и более символов {@literal «_»} подряд;</li>
	 * 		<li>Не может содержать только цифры;</li>
	 * 		<li>Не может содержать только символ {@literal «_»};</li>
	 * 		<li>Не может быть меньше 1 символа;</li>
	 * </ul>
	 */
	UPPER_CASE("upperCase", """
		(?<upperCase>
			(?=.{1,})
			(?![0-9_]+)
			(?!_{2,})
			([A-Z0-9]+)*
			(_[A-Z0-9]+)*
		)
		"""),

	/**
	 * Нотация Kebab Case.
	 *
	 * <p>Требования:</p>
	 * <ul>
	 * 		<li>Может состоять из строчных букв, цифр и символа {@literal «-»};</li>
	 * 		<li>Не может начинаться с символа {@literal «-»};</li>
	 * 		<li>Не может заканчиваться символом {@literal «-»};</li>
	 * 		<li>Не может содержать двух и более символов {@literal «-»} подряд;</li>
	 * 		<li>Не может содержать только цифры;</li>
	 * 		<li>Не может содержать только символ {@literal «-»};</li>
	 * 		<li>Не может быть меньше 1 символа;</li>
	 * </ul>
	 */
	KEBAB_CASE("kebabCase", """
		(?<kebabCase>
			(?=.{1,})
			(?![0-9-]+)
			(?!-{2,})
			([a-z0-9]+)*
			(-[a-z0-9]+)*
		)
		"""),

	/**
	 * Нотация Snake Case.
	 *
	 * <p>Требования:</p>
	 * <ul>
	 * 		<li>Может состоять из строчных букв, цифр и символа {@literal «_»};</li>
	 * 		<li>Не может начинаться с символа {@literal «_»};</li>
	 * 		<li>Не может заканчиваться символом {@literal «_»};</li>
	 * 		<li>Не может содержать двух и более символов {@literal «_»} подряд;</li>
	 * 		<li>Не может содержать только цифры;</li>
	 * 		<li>Не может содержать только символ {@literal «_»};</li>
	 * 		<li>Не может быть меньше 1 символа;</li>
	 * </ul>
	 */
	SNAKE_CASE("snakeCase", """
		(?<snakeCase>
			(?=.{1,})
			(?![0-9_]+)
			(?!_{2,})
			([a-z0-9]+)*
			(_[a-z0-9]+)*
		)
		"""),

	/**
	 * Нотация Camel Case.
	 *
	 * <p>Требования:</p>
	 * <ul>
	 * 		<li>Может состоять из букв и цифр;</li>
	 * 		<li>Не может начинаться с прописной буквы;</li>
	 * 		<li>Не может содержать только цифры;</li>
	 * 		<li>Не может содержать только прописные буквы;</li>
	 * 		<li>Не может быть меньше 1 символа;</li>
	 * </ul>
	 */
	CAMEL_CASE("camelCase", """
		(?<camelCase>
			(?=.{1,})
			(?![0-9]+)
			(?![A-Z])
			([a-z0-9]+)+
			([A-Z]+[a-z0-9]+)*
			([A-Z]+[0-9]*)*
		)
		"""),

	/**
	 * Нотация Pascal Case.
	 *
	 * <p>Требования:</p>
	 * <ul>
	 * 		<li>Может состоять из букв и цифр;</li>
	 * 		<li>Не может начинаться со строчной буквы;</li>
	 * 		<li>Не может содержать только цифры;</li>
	 * 		<li>Не может содержать только строчные буквы;</li>
	 * 		<li>Не может быть меньше 1 символа;</li>
	 * </ul>
	 */
	PASCAL_CASE("pascalCase", """
		(?<pascalCase>
			(?=.{1,})
			(?![0-9]+)
			(?![a-z])
			([A-Z]+[a-z0-9]+)*
			([A-Z]+[0-9]*)*
		)
		"""),

	/**
	 * Нотация Dot Case.
	 *
	 * <p>Требования:</p>
	 * <ul>
	 * 		<li>Может состоять из строчных букв, цифр и символа {@literal «.»};</li>
	 * 		<li>Не может начинаться с символа {@literal «.»};</li>
	 * 		<li>Не может заканчиваться символом {@literal «.»};</li>
	 * 		<li>Не может содержать двух и более символов {@literal «.»} подряд;</li>
	 * 		<li>Не может содержать только цифры;</li>
	 * 		<li>Не может содержать только символ {@literal «.»};</li>
	 * 		<li>Не может быть меньше 1 символа;</li>
	 * </ul>
	 */
	DOT_CASE("dotCase", """
		(?<dotCase>
			(?=.{1,})
			(?![0-9.]+)
			(?!\\.{2,})
			([a-z0-9]+)*
			(\\.[a-z0-9]+)*
		)
		"""),

	/**
	 * Нотация Train Case.
	 *
	 * <p>Требования:</p>
	 * <ul>
	 * 		<li>Может состоять из прописных букв, цифр и символа {@literal «-»};</li>
	 * 		<li>Не может начинаться с символа {@literal «-»};</li>
	 * 		<li>Не может заканчиваться символом {@literal «-»};</li>
	 * 		<li>Не может содержать двух и более символов {@literal «-»} подряд;</li>
	 * 		<li>Не может содержать только цифры;</li>
	 * 		<li>Не может содержать только символ {@literal «-»};</li>
	 * 		<li>Не может быть меньше 1 символа;</li>
	 * </ul>
	 */
	TRAIN_CASE("trainCase", """
		(?<trainCase>
			(?=.{1,})
			(?![0-9-]+)
			(?!-{2,})
			([A-Z0-9]+)*
			(-[A-Z0-9]+)*
		)
		""");

	/**
	 * Основная группа регулярного выражения.
	 */
	@NotNull
	private final String group;

	/**
	 * Шаблон регулярного выражения.
	 */
	@NotNull
	private final String pattern;

	/**
	 * Конструктор для {@code Regexp}.
	 *
	 * @param pattern шаблон регулярного выражения.
	 */
	Regexp(@NotNull final String group, @NotNull final String pattern)
	{
		this.group = group;
		this.pattern = pattern;
	}

	/**
	 * Возвращает основную группу регулярного выражения.
	 *
	 * @return основную группу регулярного выражения.
	 */
	@NotNull
	public String getGroup()
	{
		return this.group;
	}

	/**
	 * Возвращает шаблон регулярного выражения.
	 *
	 * @return шаблон регулярного выражения.
	 */
	@NotNull
	public String getPattern()
	{
		return this.pattern.replaceAll("[\n\t\s]*", "");
	}
}
