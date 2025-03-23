package top.haidong556.trace.application.logEventApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.haidong556.trace.application.common.filterChainTemplate.FilterChain;
import top.haidong556.trace.domain.model.errorReportAggregate.AlarmPublisher;
import top.haidong556.trace.domain.model.logAggregate.LogAggregateRoot;
import top.haidong556.trace.domain.model.logAggregate.LogRepo;

@Service
public class LogEventApplicationService {

    private FilterChain<String> preCreationFilterChain = new FilterChain<String>();
    private AlarmPublisher alarmPublisherService;
    private FilterChain<LogAggregateRoot> postCreationFilterChain = new FilterChain<LogAggregateRoot>();

    @Autowired
    public LogEventApplicationService(AlarmPublisher alarmPublisherService, LogRepo logRepo) {
        this.alarmPublisherService = alarmPublisherService;
    }

    public void processLogEvent(String metricJson) throws Exception {
        preCreationFilterChain.executeFilters(metricJson);
        LogAggregateRoot metricAggregateRoot = LogAggregateRoot.Builder.buildByJson(metricJson);
        postCreationFilterChain.executeFilters(metricAggregateRoot);
    }


}

