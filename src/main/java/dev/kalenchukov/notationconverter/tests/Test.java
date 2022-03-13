/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.notationconverter.tests;

import dev.kalenchukov.notationconverter.NotationConverter;

public final class Test
{
	public static void main(String[] args)
	{
		String[] words = {
			"hello",
			"HELLO",

			"hello1",
			"HELLO1",

			"_hello",
			"_HELLO",

			"__hello",
			"__HELLO",

			"__hello__",
			"__HELLO__",

			"___hello1",
			"___HELLO1",

			"hello_",
			"HELLO_",

			"hello__",
			"HELLO__",

			"_hello_",
			"_HELLO_",

			"__hello__",
			"__HELLO__",

			"hello1___",
			"HELLO1___",

			"helloWorld",
			"HelloWorld",
			"hello_world",
			"hello-world",
			"HELLO_WORLD",

			"helloWorld1",
			"HelloWorld1",
			"hello_world1",
			"hello-world1",
			"HELLO_WORLD1",
			"hello_world_1",
			"hello-world-1",
			"HELLO_WORLD_1",

			"helloJavaWorld",
			"HelloJavaWorld",
			"hello_java_world",
			"hello-java-world",
			"HELLO_JAVA_WORLD",

			"helloJavaWorld1",
			"HelloJavaWorld1",
			"hello_java_world1",
			"hello-java-world1",
			"HELLO_JAVA_WORLD1",
			"hello_java_world_1",
			"hello-java-world-1",
			"HELLO_JAVA_WORLD_1"
		};

		System.out.println();
		System.out.println("Camel Case:");
		for (String word : words) {
			System.out.println("\t" + NotationConverter.toCamelCase(word));
		}

		System.out.println();
		System.out.println("Pascal Case:");
		for (String word : words) {
			System.out.println("\t" + NotationConverter.toPascalCase(word));
		}

		System.out.println();
		System.out.println("Snake Case:");
		for (String word : words) {
			System.out.println("\t" + NotationConverter.toSnakeCase(word));
		}

		System.out.println();
		System.out.println("Kebab Case:");
		for (String word : words) {
			System.out.println("\t" + NotationConverter.toKebabCase(word));
		}

		System.out.println();
		System.out.println("Upper Case:");
		for (String word : words) {
			System.out.println("\t" + NotationConverter.toUpperCase(word));
		}
	}
}
