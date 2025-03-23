package top.haidong556.trace.domain.model.logAggregate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
//  "protocol_details": {                                  // 协议相关的详细信息
//   "protocol_type": "http",                               // 调用的协议类型（http, rpc, message_queue 等）
//    "http_method": "POST",                               // HTTP 请求方法（如果是 HTTP 调用）
//    "http_url": "/api/v1/order",                         // HTTP 请求的 URL（如果是 HTTP 调用）
//    "rpc_method": "OrderService.Create",                 // RPC 方法（如果是 RPC 调用）
//    "queue_name": "order-queue",                         // 消息队列名称（如果是 MQ 调用）
//    "message_id": "msg123456",                           // 消息 ID（如果是消息队列调用）
//    "host": "192.168.0.1"                                // 请求的目标主机或服务地址
//  }
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProtocolDetailsVo {
    private String protocol_type;
    private String http_method;
    private String http_url;
    private String rpc_method;
    private String queue_name;
    private String message_id;
    private String host;
}
