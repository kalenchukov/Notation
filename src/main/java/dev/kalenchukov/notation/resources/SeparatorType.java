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
 * Перечисление возможных типов разделителей.
 *
 * @author Aleksey Kalenchukov
 */
public enum SeparatorType
{
	/**
	 * Символ дефиса.
	 */
	HYPHEN("-"),

	/**
	 * Символ нижнего подчёркивания.
	 */
	UNDERSCORE("_"),

	/**
	 * Прописная буква.
	 */
	UPPERCASE(""),

	/**
	 * Символ точки.
	 */
	DOT(".");

	/**
	 * Символ разделителя.
	 */
	@NotNull
	private final String separatorSymbol;

	/**
	 * Конструктор для {@code SeparatorType}.
	 *
	 * @param separatorSymbol символ разделителя.
	 */
	SeparatorType(@NotNull final String separatorSymbol)
	{
		this.separatorSymbol = separatorSymbol;
	}

	/**
	 * Возвращает символ разделителя.
	 *
	 * @return символ разделителя.
	 */
	@NotNull
	public String getSeparatorSymbol()
	{
		return this.separatorSymbol;
	}

	/**
	 * Возвращает все символы разделителей.
	 *
	 * @return строка из символов разделителей.
	 */
	@NotNull
	public static String getAllSeparatorSymbols()
	{
		StringBuilder values = new StringBuilder();

		for (SeparatorType separatorType : SeparatorType.values()) {
			values.append(separatorType.getSeparatorSymbol());
		}

		return values.toString();
	}
}
