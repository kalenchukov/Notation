/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.notationconverter.tests;

import dev.kalenchukov.notationconverter.NotationConverter;

public final class Test2
{
	public static void main(String[] args)
	{
		System.out.println("toCamelCase:  hello-world -> " + NotationConverter.toCamelCase("hello-world"));
		System.out.println("toKebabCase:  helloWorld  -> " + NotationConverter.toKebabCase("helloWorld"));
		System.out.println("toUpperCase:  HelloWorld  -> " + NotationConverter.toUpperCase("HelloWorld"));
		System.out.println("toSnakeCase:  hello_world -> " + NotationConverter.toSnakeCase("hello_world"));
		System.out.println("toPascalCase: HelloWorld  -> " + NotationConverter.toPascalCase("HelloWorld"));
	}
}
