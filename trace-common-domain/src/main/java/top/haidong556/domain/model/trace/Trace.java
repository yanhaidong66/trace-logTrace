package top.haidong556.domain.model.trace;

import lombok.Getter;
import top.haidong556.trace.domain.model.spanAggregate.SpanAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Trace {
    private String traceId;                     // 全局唯一Trace ID
    private List<SpanAggregateRoot> spans = new ArrayList<>(); // 包含的Span集合

    public void addSpan(SpanAggregateRoot span) {
        spans.add(span);
    }
}
