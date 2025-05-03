import java.util.logging.Level;

public class Logger {
    private static final Logger instance= new Logger();
    private LoggerConfig config;


    public Logger() {
        this.config = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());
    }
    public static Logger getInstance(){
        return instance;
    }
    public void setConfig(LoggerConfig config){
        this.config=config;
    }
    public void log(LogLevel level, String msg){
        if (level.ordinal() >=config.getLevel().ordinal()){
            LogMessage logMsg= new LogMessage(level,msg);
            config.getLogAppender().append(logMsg);
        }
    }
    public void debug(String msg){log(LogLevel.DEBUG,msg);}
    public void info(String msg){log(LogLevel.INFO,msg);}
    public void warning(String msg){log(LogLevel.WARNING,msg);}
    public void error(String msg){log(LogLevel.ERROR,msg);}
    public void fatal(String msg){log(LogLevel.FATAL,msg);}
}
