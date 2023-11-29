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

package dev.kalenchukov.notation.types;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Перечисление возможных типов разделителей.
 *
 * @author Алексей Каленчуков
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
	 * Символ пробела.
	 */
	SPACE(" "),

	/**
	 * Символ точки.
	 */
	DOT(".");

	/**
	 * Символ разделителя.
	 */
	@NotNull
	private final String symbol;

	/**
	 * Конструктор для {@code SeparatorType}.
	 *
	 * @param symbol символ разделителя.
	 */
	SeparatorType(@NotNull final String symbol)
	{
		this.symbol = symbol;
	}

	/**
	 * Возвращает символ разделителя.
	 *
	 * @return символ разделителя.
	 */
	@NotNull
	public String getSymbol()
	{
		return this.symbol;
	}

	/**
	 * Возвращает все символы разделителей.
	 *
	 * @return строка из символов разделителей.
	 */
	@NotNull
	public static List<@NotNull String> getAllSymbols()
	{
		List<String> symbols = new ArrayList<>();

		for (SeparatorType symbol : SeparatorType.values()) {
			symbols.add(symbol.getSymbol());
		}

		return symbols;
	}
}
