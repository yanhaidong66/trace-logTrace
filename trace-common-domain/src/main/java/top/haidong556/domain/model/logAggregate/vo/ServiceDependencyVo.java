package top.haidong556.domain.model.logAggregate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
//"service_dependencies": [                              // 服务依赖关系
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
//  ]
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDependencyVo {
    private String service_name;// 被调用服务名称
    private String span_id;// 被调用服务的 SpanID
    private String operation_name;// 被调用的操作名称
    private String protocol_type;// 调用协议类型
    private long duration_ms;// 被调用服务的处理时长
}
