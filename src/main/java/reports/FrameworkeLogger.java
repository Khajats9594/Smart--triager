package reports;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

import enums.LogType;

public class FrameworkeLogger {
	private FrameworkeLogger() {
	}

	private static final Consumer<String> PASS = (message) -> ExtendReport.test.pass(message);
	private static final Consumer<String> FAIL = (message) -> ExtendReport.test.fail(message);
	private static final Consumer<String> SKIP = (message) -> ExtendManager.getExtentTest().skip(message);
	private static final Consumer<String> INFO = (message) -> ExtendManager.getExtentTest().info(message);
	private static final Consumer<String> CONSOLE = (message) -> System.out.println("INFO---->" + message);
	private static final Consumer<String> EXTENTANDCONSOLE = PASS.andThen(CONSOLE);

	private static final Map<LogType, Consumer<String>> MAP = new EnumMap<>(LogType.class);


	static {
		MAP.put(LogType.PASS, PASS);
		MAP.put(LogType.FAIL, FAIL);
		MAP.put(LogType.SKIP, SKIP);
		MAP.put(LogType.INFO, INFO);
		MAP.put(LogType.CONSOLE, CONSOLE);
		MAP.put(LogType.EXTENTANDCONSOLE, EXTENTANDCONSOLE);

	}

	public static void log(LogType status, String message) {

		MAP.getOrDefault(status, EXTENTANDCONSOLE).accept(message);

	}

}
