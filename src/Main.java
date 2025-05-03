//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Logger sys= Logger.getInstance();

        LoggerConfig config= new LoggerConfig(LogLevel.DEBUG, new FileAppender("app.log"));
        sys.setConfig(config);
        sys.info("Information For You");
        sys.debug("Debugginggg");

    }
}