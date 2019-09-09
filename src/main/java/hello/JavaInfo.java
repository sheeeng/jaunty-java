package hello;

public class JavaInfo {

    public static String getJavaVersion() {
        // Class Runtime.Version
        // https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Runtime.Version.html
        Runtime.Version version = Runtime.version();

        StringBuilder stringBuilderJavaVersion = new StringBuilder();

        stringBuilderJavaVersion.append(System.lineSeparator());
        stringBuilderJavaVersion.append("java-version = " + version + System.lineSeparator());
        stringBuilderJavaVersion.append("java-version-feature = " + version.feature() + System.lineSeparator());
        stringBuilderJavaVersion.append("java-version-interim = " + version.interim() + System.lineSeparator());
        stringBuilderJavaVersion.append("java-version-patch = " + version.patch() + System.lineSeparator());
        stringBuilderJavaVersion.append("java-version-update = " + version.update() + System.lineSeparator());
        stringBuilderJavaVersion.append("java-version-build = " + version.build().get() + System.lineSeparator());
        stringBuilderJavaVersion.append("java-version-pre = " + version.pre().orElse("N/A") + System.lineSeparator());
        stringBuilderJavaVersion.append(System.lineSeparator());

        return stringBuilderJavaVersion.toString();
    }
}
