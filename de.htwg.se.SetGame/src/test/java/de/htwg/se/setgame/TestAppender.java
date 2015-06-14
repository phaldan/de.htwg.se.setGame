package de.htwg.se.setgame;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Philipp Daniels
 */
@Ignore
public class TestAppender extends AppenderSkeleton {

    private final List<LoggingEvent> log = new ArrayList<>();

    @Override
    public void close() {
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    @Override
    protected void append(LoggingEvent loggingEvent) {
        log.add(loggingEvent);
    }

    public String getLog() {
        StringBuilder sb = new StringBuilder();
        for (LoggingEvent e : log) {
            sb.append(e.getMessage());
        }
        return sb.toString();
    }
}
