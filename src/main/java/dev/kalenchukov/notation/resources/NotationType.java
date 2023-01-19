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

/**
 * Перечисление типов нотаций.
 */
public enum NotationType
{
	/**
	 * Нотация Upper Case.
	 * <p>Все слова пишутся прописными буквами,
	 * а в качестве разделителя слов символ нижнего подчёркивания.</p>
	 */
	UPPER_CASE,

	/**
	 * Нотация Kebab Case.
	 * <p>Все слова пишутся строчными буквами,
	 * а в качестве разделителя слов символ дефиса.</p>
	 */
	KEBAB_CASE,

	/**
	 * Нотация Snake Case.
	 * <p>Все слова пишутся строчными буквами,
	 * а в качестве разделителя слов символ нижнего подчёркивания.</p>
	 */
	SNAKE_CASE,

	/**
	 * Нотация Camel Case.
	 * <p>Первая буква строчная, а первая буква каждого последующего слова должна быть прописной.
	 * Все слова при этом пишутся слитно между собой.</p>
	 */
	CAMEL_CASE,

	/**
	 * Нотация Pascal Case.
	 * <p>Первая буква каждого слова должна быть прописной.
	 * Все слова при этом пишутся слитно между собой.</p>
	 */
	PASCAL_CASE;
}
