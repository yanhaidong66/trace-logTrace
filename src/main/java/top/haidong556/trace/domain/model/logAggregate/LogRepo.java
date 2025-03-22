package top.haidong556.trace.domain.model.logAggregate;

import java.io.IOException;

public interface LogRepo {
    void createLog(String indexName, String logId, LogAggregateRoot logContent) throws IOException;
    LogAggregateRoot getLog(String indexName, String logId) throws IOException;
    boolean updateLog(String indexName, String logId, LogAggregateRoot updatedLog) throws IOException;
    boolean deleteLog(String indexName, String logId) throws IOException;
}
