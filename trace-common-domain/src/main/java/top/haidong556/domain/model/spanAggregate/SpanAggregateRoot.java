package top.haidong556.domain.model.spanAggregate;

import lombok.Getter;
import top.haidong556.trace.domain.model.trace.vo.LogVo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class SpanAggregateRoot {
    private String spanId;                      // 当前Span唯一ID
    private String parentSpanId;                // 父级Span ID
    private String traceId;                     // TraceID，关联Trace
    private String serviceName;                 // 服务名
    private String operationName;               // 操作名
    private String protocolType;                // 协议类型 http/rpc/mq
    private String httpMethod;                  // HTTP方法（如果有）
    private String httpUrl;                     // HTTP URL（如果有）
    private String rpcMethod;                   // RPC方法（如果有）
    private String queueName;                   // MQ 队列名（如果有）
    private String messageId;                   // MQ 消息ID（如果有）
    private String host;                        // 目标主机地址
    private Instant startTime;                  // 开始时间
    private Instant endTime;                    // 结束时间
    private long durationMs;                    // 耗时（毫秒）
    private String status;                      // success / error
    private String errorMessage;                // 错误信息（如果有）
    private Map<String, String> tags;           // 自定义标签
    private List<LogVo> logs;            // 日志详情
    private List<SpanAggregateRoot> childSpans = new ArrayList<>(); // 子Span集合


}
