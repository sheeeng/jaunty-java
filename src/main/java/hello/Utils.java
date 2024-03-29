package hello;

public class Utils {
    // https://stackoverflow.com/a/3758880
	public static String humanReadableByteCount(long bytes, boolean si) {
		// Math.abs(), Math.signum()
		int unit = si ? 1000 : 1024;
		if (bytes < unit) return bytes + " B";
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
		return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }
}
