public class ConsoleAppender implements LogAppender{
    @Override
    public void append(LogMessage msg) {
        System.out.println(msg);
    }
}
