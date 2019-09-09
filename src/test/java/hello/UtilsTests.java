package hello;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import junit.framework.TestCase;

public class UtilsTests extends TestCase {

	private String returnString = "";

	@Test
	public void testHumanReadableByteCountEmptyString() {
		assertThat(returnString).isNotEqualTo(null);
		assertThat(returnString).isEqualTo("");
	}

	public void testHumanReadableByteCountNegativeRange() {
		testHumanReadableByteCountEmptyString();

		returnString = Utils.humanReadableByteCount(Long.MIN_VALUE, true);
		assertThat(returnString).isNotEqualTo("-9223372036854775808");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("-9223372036854775808 B");

		returnString = Utils.humanReadableByteCount(Long.MIN_VALUE, false);
		assertThat(returnString).isNotEqualTo("-9223372036854775808");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("-9223372036854775808 B");

		returnString = Utils.humanReadableByteCount(-1000, true);
		assertThat(returnString).isNotEqualTo("-1000");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("-1000 B");

		returnString = Utils.humanReadableByteCount(-1000, false);
		assertThat(returnString).isNotEqualTo("-1000");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("-1000 B");
	}

	@Test
	public void testHumanReadableByteCountZeroValue() {
		testHumanReadableByteCountEmptyString();

		returnString = Utils.humanReadableByteCount(0, true);
		assertThat(returnString).isNotEqualTo("0");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("0 B");

		returnString = Utils.humanReadableByteCount(0, false);
		assertThat(returnString).isNotEqualTo("0");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("0 B");
	}

	@Test
	public void testHumanReadableByteCountPositiveRange() {
		testHumanReadableByteCountEmptyString();

		returnString = Utils.humanReadableByteCount(27, true);
		assertThat(returnString).isNotEqualTo("27");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("27 B");

		returnString = Utils.humanReadableByteCount(27, false);
		assertThat(returnString).isNotEqualTo("27");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("27 B");

		returnString = Utils.humanReadableByteCount(999, true);
		assertThat(returnString).isNotEqualTo("999");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("999 B");

		returnString = Utils.humanReadableByteCount(999, false);
		assertThat(returnString).isNotEqualTo("999");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("999 B");

		returnString = Utils.humanReadableByteCount(1000, true);
		assertThat(returnString).isNotEqualTo("1000");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("1.0 kB");

		returnString = Utils.humanReadableByteCount(1000, false);
		assertThat(returnString).isNotEqualTo("1000");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("1000 B");

		returnString = Utils.humanReadableByteCount(1023, true);
		assertThat(returnString).isNotEqualTo("1023");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("1.0 kB");

		returnString = Utils.humanReadableByteCount(1023, false);
		assertThat(returnString).isNotEqualTo("1023");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("1023 B");

		returnString = Utils.humanReadableByteCount(1024, true);
		assertThat(returnString).isNotEqualTo("1024");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("1.0 kB");

		returnString = Utils.humanReadableByteCount(1024, false);
		assertThat(returnString).isNotEqualTo("1024");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("1.0 KiB");

		returnString = Utils.humanReadableByteCount(1728, true);
		assertThat(returnString).isNotEqualTo("1728");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("1.7 kB");

		returnString = Utils.humanReadableByteCount(1728, false);
		assertThat(returnString).isNotEqualTo("1728");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("1.7 KiB");

		returnString = Utils.humanReadableByteCount(110592, true);
		assertThat(returnString).isNotEqualTo("110592");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("110.6 kB");

		returnString = Utils.humanReadableByteCount(110592, false);
		assertThat(returnString).isNotEqualTo("110592");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("108.0 KiB");

		returnString = Utils.humanReadableByteCount(7077888, true);
		assertThat(returnString).isNotEqualTo("7077888");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("7.1 MB");

		returnString = Utils.humanReadableByteCount(7077888, false);
		assertThat(returnString).isNotEqualTo("7077888");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("6.8 MiB");

		returnString = Utils.humanReadableByteCount(452984832, true);
		assertThat(returnString).isNotEqualTo("452984832");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("453.0 MB");

		returnString = Utils.humanReadableByteCount(452984832, false);
		assertThat(returnString).isNotEqualTo("452984832");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("432.0 MiB");

		returnString = Utils.humanReadableByteCount(28991029248L, true);
		assertThat(returnString).isNotEqualTo("28991029248");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("29.0 GB");

		returnString = Utils.humanReadableByteCount(28991029248L, false);
		assertThat(returnString).isNotEqualTo("28991029248");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("27.0 GiB");

		returnString = Utils.humanReadableByteCount(1855425871872L, true);
		assertThat(returnString).isNotEqualTo("1855425871872");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("1.9 TB");

		returnString = Utils.humanReadableByteCount(1855425871872L, false);
		assertThat(returnString).isNotEqualTo("1855425871872");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("1.7 TiB");

		returnString = Utils.humanReadableByteCount(Long.MAX_VALUE, true);
		assertThat(returnString).isNotEqualTo("1855425871872");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("9.2 EB");

		returnString = Utils.humanReadableByteCount(Long.MAX_VALUE, false);
		assertThat(returnString).isNotEqualTo("1855425871872");
		assertThat(returnString).isNotEqualTo("");
		assertThat(returnString).isEqualTo("8.0 EiB");
	}

}
