public class LogMessage {
    private final LogLevel level;
    private final String msg;
    private final long timestamp;

    public LogMessage(LogLevel level, String msg) {
        this.level = level;
        this.msg = msg;
        this.timestamp = System.currentTimeMillis();
    }
    public String toString(){
        return "["+level+"]"+timestamp+" - "+msg;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMsg() {
        return msg;
    }

    public long getTime() {
        return timestamp;
    }
}
