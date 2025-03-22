package top.haidong556.trace.domain.model.logAggregate.entity;

import java.time.Instant;

public class LogEntity {
    private Instant timestamp;
    private String traceId;
    private String spanId;
    private String parentSpanId;
    private String serviceName;
    private String operationName;
    private Instant startTime;
    private Instant endTime;
    private long durationMs;
    private String status;
    private String errorMessage;
}
