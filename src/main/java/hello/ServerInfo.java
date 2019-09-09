package hello;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class ServerInfo {

	public static String getServerInfo() {
		return System.lineSeparator()
		+ "Current DateTime " + getCurrentDateTime() + System.lineSeparator()
		+ "Java Version " + JavaInfo.getJavaVersion() + System.lineSeparator()
		+ "System Properties " + getSystemProperties() + System.lineSeparator()
		+ "[java-version=" + System.getProperty("java.version") + "]" + System.lineSeparator()
		+ "[java-vm-version=" + System.getProperty("java.vm.version") + "]" + System.lineSeparator()
		+ "[java-specification-version=" + System.getProperty("java.specification.version") + "]" + System.lineSeparator()
		+ "[runtime-implementation-version=" + Runtime.class.getPackage().getImplementationVersion() + "]" + System.lineSeparator()
		+ "[os=" + System.getProperty("os.name") + "]" + System.lineSeparator()
		+ "[appserver=" + org.apache.catalina.util.ServerInfo.getServerInfo() + "]" + System.lineSeparator()
		+ "[availableProcessors="+ Runtime.getRuntime().availableProcessors() + "]" + System.lineSeparator()
		+ "[maxMemory=" + Utils.humanReadableByteCount(Runtime.getRuntime().maxMemory(),true) + "]" + System.lineSeparator()
		+ "[freeMemory=" + Utils.humanReadableByteCount(Runtime.getRuntime().freeMemory(),true) + "]" + System.lineSeparator()
		+ "[totalMemory=" + Utils.humanReadableByteCount(Runtime.getRuntime().totalMemory(),true) + "]" + System.lineSeparator()
		+ System.lineSeparator();
	}

	public static String getCurrentDateTime() {

		// Class DateTimeFormatter
		// https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/time/format/DateTimeFormatter.html
		DateTimeFormatter isoInstant = DateTimeFormatter.ISO_INSTANT;

		ZoneId zoneIdOslo = ZoneId.of("Europe/Oslo");

		// Class Clock
		// https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/time/Clock.html
		Clock clockUtc = Clock.systemUTC();
		// Clock clockSystemDefaultZone = Clock.systemDefaultZone();
		Clock clockOslo = Clock.system(zoneIdOslo);

		// Class Instant
		// https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/time/Instant.html
		Instant instantUtc = Instant.now(clockUtc);
		Instant instantOslo = Instant.now(clockOslo);

		return System.lineSeparator()
			+ "Date Time (UTC)          : " + isoInstant.format(instantUtc) + System.lineSeparator()
			+ "Date Time (Europe/Oslo)  : " + isoInstant.format(instantOslo) + System.lineSeparator()
			+ System.lineSeparator();
	}

	public static String getSystemProperties() {
		// https://www.mkyong.com/java/how-to-list-all-system-properties-key-and-value-in-java/
		Properties properties = System.getProperties();

        LinkedHashMap<String, String> collect = properties.entrySet().stream()
                .collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		StringBuilder stringBuilderSystemProperties = new StringBuilder();
		stringBuilderSystemProperties.append(System.lineSeparator());
		// collect.forEach((k, v) -> System.out.println(k + ":" + v + System.lineSeparator()));
		collect.forEach((k, v) -> stringBuilderSystemProperties.append(k + ":" + v + System.lineSeparator()));
		stringBuilderSystemProperties.append(System.lineSeparator());
		return stringBuilderSystemProperties.toString();
    }
}
