package top.haidong556.trace.domain.model.logAggregate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
//"logs": [                                              // 详细日志记录，适用于调试
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
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LogMessageVo {
    private Instant timestamp;
    private String level;
    private String message;
}
