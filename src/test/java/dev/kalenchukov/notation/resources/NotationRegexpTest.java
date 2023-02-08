package dev.kalenchukov.notation.resources;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки констант и методов перечисления {@link NotationRegexp}.
 */
class NotationRegexpTest
{
	/**
	 * Проверка метода {@link NotationRegexp#getGroup()}.
	 */
	@Test
	public void getGroup()
	{
		assertEquals("pascalCase", NotationRegexp.PASCAL_CASE.getGroup());
	}

	/**
	 * Проверка метода {@link NotationRegexp#getPattern()}.
	 */
	@Test
	public void getPattern()
	{
		assertTrue( NotationRegexp.KEBAB_CASE.getPattern().length() > 0);
	}

	/**
	 * Проверка групп константы {@link NotationRegexp#UPPER_CASE}.
	 */
	@Test
	public void testGroupUpperCase()
	{
		String value = "CAMEL_CASE";

		Pattern pattern = Pattern.compile(NotationRegexp.UPPER_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.find());

		assertEquals("CAMEL_CASE", matcher.group(NotationRegexp.UPPER_CASE.getGroup()));
	}

	/**
	 * Проверка групп константы {@link NotationRegexp#KEBAB_CASE}.
	 */
	@Test
	public void testGroupKebabCase()
	{
		String value = "kebab-case";

		Pattern pattern = Pattern.compile(NotationRegexp.KEBAB_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.find());

		assertEquals("kebab-case", matcher.group(NotationRegexp.KEBAB_CASE.getGroup()));
	}

	/**
	 * Проверка групп константы {@link NotationRegexp#SNAKE_CASE}.
	 */
	@Test
	public void testGroupSnakeCase()
	{
		String value = "snake_case";

		Pattern pattern = Pattern.compile(NotationRegexp.SNAKE_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.find());

		assertEquals("snake_case", matcher.group(NotationRegexp.SNAKE_CASE.getGroup()));
	}

	/**
	 * Проверка групп константы {@link NotationRegexp#CAMEL_CASE}.
	 */
	@Test
	public void testGroupCamelCase()
	{
		String value = "camelCase";

		Pattern pattern = Pattern.compile(NotationRegexp.CAMEL_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.find());

		assertEquals("camelCase", matcher.group(NotationRegexp.CAMEL_CASE.getGroup()));
	}

	/**
	 * Проверка групп константы {@link NotationRegexp#PASCAL_CASE}.
	 */
	@Test
	public void testGroupPascalCase()
	{
		String value = "PascalCase";

		Pattern pattern = Pattern.compile(NotationRegexp.PASCAL_CASE.getPattern());
		Matcher matcher = pattern.matcher(value);

		assertTrue(matcher.find());

		assertEquals("PascalCase", matcher.group(NotationRegexp.PASCAL_CASE.getGroup()));
	}
}