package top.haidong556.domain.model.logAggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.haidong556.trace.domain.common.JsonReflectiveBuilder;
import top.haidong556.trace.domain.model.logAggregate.vo.LogMessageVo;
import top.haidong556.trace.domain.model.logAggregate.vo.ProtocolDetailsVo;
import top.haidong556.trace.domain.model.logAggregate.vo.ServiceDependencyVo;

import java.time.Instant;
import java.util.List;
import java.util.Map;

//{
//  "timestamp": "2025-03-11T14:25:33.123Z",              // 日志时间戳
//  "trace_id": "abc123xyz456",                            // 全链路追踪的唯一标识符 (TraceID)
//  "span_id": "span789",                                  // 当前服务请求的唯一标识符 (SpanID)
//  "parent_span_id": "parent123",                         // 父级 SpanID（如果当前请求是子请求）
//  "service_name": "order-service",                       // 当前处理请求的服务名称
//  "operation_name": "createOrder",                       // 当前操作名称，例如 API 接口名称或 RPC 方法
//  "protocol_details": {                                  // 协议相关的详细信息
//    "protocol_type": "http",                               // 调用的协议类型（http, rpc, message_queue 等）
//    "http_method": "POST",                               // HTTP 请求方法（如果是 HTTP 调用）
//    "http_url": "/api/v1/order",                         // HTTP 请求的 URL（如果是 HTTP 调用）
//    "rpc_method": "OrderService.Create",                 // RPC 方法（如果是 RPC 调用）
//    "queue_name": "order-queue",                         // 消息队列名称（如果是 MQ 调用）
//    "message_id": "msg123456",                           // 消息 ID（如果是消息队列调用）
//    "host": "192.168.0.1"                                // 请求的目标主机或服务地址
//  },
//  "start_time": "2025-03-11T14:25:30.000Z",              // 请求开始时间
//  "end_time": "2025-03-11T14:25:33.123Z",                // 请求结束时间
//  "duration_ms": 3123,                                   // 请求处理时长，单位毫秒
//  "status": "success",                                   // 请求状态（success/error）
//  "error_message": "",                                   // 错误信息（如果有错误）
//  "service_dependencies": [                              // 服务依赖关系
//    {
//      "service_name": "auth-service",                     // 被调用服务名称
//      "span_id": "auth123",                               // 被调用服务的 SpanID
//      "operation_name": "authenticate",                   // 被调用的操作名称
//      "protocol_type": "rpc",                             // 调用协议类型
//      "duration_ms": 200                                  // 被调用服务的处理时长
//    },
//    {
//      "service_name": "payment-service",
//      "span_id": "payment456",
//      "operation_name": "processPayment",
//      "protocol_type": "http",
//      "duration_ms": 150
//    }
//  ],
//  "tags": {                                              // 自定义标签
//    "env": "production",                                  // 环境标识（生产环境、测试环境等）
//    "version": "v1.2.3",                                  // 当前服务版本
//    "region": "us-east-1"                                  // 服务所在的区域
//  },
//  "logs": [                                              // 详细日志记录，适用于调试
//    {
//      "timestamp": "2025-03-11T14:25:31.000Z",            // 日志时间戳
//      "level": "info",                                    // 日志级别
//      "message": "Order created successfully"              // 日志消息
//    },
//    {
//      "timestamp": "2025-03-11T14:25:32.000Z",
//      "level": "debug",
//      "message": "Payment processed"
//    }
//  ]
//}
@Getter
public class LogAggregateRoot {
    // 基础追踪信息
    private Instant timestamp;          // 日志时间戳
    private String trace_id;            // 全链路追踪ID
    private String span_id;             // 当前服务的SpanID
    private String parent_span_id;      // 父级SpanID

    // 服务及操作信息
    private String service_name;        // 当前服务名
    private String operation_name;      // 当前操作名（接口或RPC方法）

    // 协议详细信息
    private ProtocolDetailsVo protocol_details;

    // 时间及性能数据
    private Instant start_time;         // 请求开始时间
    private Instant end_time;           // 请求结束时间
    private long duration_ms;           // 总耗时（毫秒）

    // 状态及错误信息
    private String status;              // 请求状态 success / error
    private String error_message;       // 错误信息（如有）

    // 服务依赖列表
    private List<ServiceDependencyVo> service_dependencies;

    // 自定义标签
    private Map<String, String> tags;

    // 日志明细
    private List<LogMessageVo> logs;

    private LogAggregateRoot(){}


    public static class Builder {
        // 自定义的 JSON 反射构建器
        public static LogAggregateRoot buildByJson(String json) {
            try {
                return JsonReflectiveBuilder.build(json, LogAggregateRoot.class);
            } catch (Exception e) {
                throw new RuntimeException("Failed to parse JSON with ReflectiveBuilder", e);
            }
        }
    }
}
