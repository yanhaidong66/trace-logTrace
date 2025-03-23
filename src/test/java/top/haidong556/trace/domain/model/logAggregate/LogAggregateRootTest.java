package top.haidong556.trace.domain.model.logAggregate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LogAggregateRootTest {

    private LogAggregateRoot logAggregateRoot;

    // 示例 JSON 字符串
    private static final String json = "{\n" +
            "  \"timestamp\": \"2025-03-11T14:25:33.123Z\",\n" +
            "  \"trace_id\": \"abc123xyz456\",\n" +
            "  \"span_id\": \"span789\",\n" +
            "  \"parent_span_id\": \"parent123\",\n" +
            "  \"service_name\": \"order-service\",\n" +
            "  \"operation_name\": \"createOrder\",\n" +
            "  \"protocol_details\": {\n" +
            "    \"protocol_type\": \"http\",\n" +
            "    \"http_method\": \"POST\",\n" +
            "    \"http_url\": \"/api/v1/order\",\n" +
            "    \"rpc_method\": \"OrderService.Create\",\n" +
            "    \"queue_name\": \"order-queue\",\n" +
            "    \"message_id\": \"msg123456\",\n" +
            "    \"host\": \"192.168.0.1\"\n" +
            "  },\n" +
            "  \"start_time\": \"2025-03-11T14:25:30.111Z\",\n" +
            "  \"end_time\": \"2025-03-11T14:25:33.123Z\",\n" +
            "  \"duration_ms\": 3123,\n" +
            "  \"status\": \"success\",\n" +
            "  \"error_message\": \"\",\n" +
            "  \"service_dependencies\": [\n" +
            "    {\n" +
            "      \"service_name\": \"auth-service\",\n" +
            "      \"span_id\": \"auth123\",\n" +
            "      \"operation_name\": \"authenticate\",\n" +
            "      \"protocol_type\": \"rpc\",\n" +
            "      \"duration_ms\": 200\n" +
            "    },\n" +
            "    {\n" +
            "      \"service_name\": \"payment-service\",\n" +
            "      \"span_id\": \"payment456\",\n" +
            "      \"operation_name\": \"processPayment\",\n" +
            "      \"protocol_type\": \"http\",\n" +
            "      \"duration_ms\": 150\n" +
            "    }\n" +
            "  ],\n" +
            "  \"tags\": {\n" +
            "    \"env\": \"production\",\n" +
            "    \"version\": \"v1.2.3\",\n" +
            "    \"region\": \"us-east-1\"\n" +
            "  },\n" +
            "  \"logs\": [\n" +
            "    {\n" +
            "      \"timestamp\": \"2025-03-11T14:25:31.000Z\",\n" +
            "      \"level\": \"info\",\n" +
            "      \"message\": \"Order created successfully\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"timestamp\": \"2025-03-11T14:25:32.000Z\",\n" +
            "      \"level\": \"debug\",\n" +
            "      \"message\": \"Payment processed\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @BeforeEach
    void setUp() {
        logAggregateRoot = LogAggregateRoot.Builder.buildByJson(json);
    }

    @Test
    void getTimestamp() {
        assertNotNull(logAggregateRoot.getTimestamp());
        assertEquals("2025-03-11T14:25:33.123Z", logAggregateRoot.getTimestamp().toString());
    }

    @Test
    void getTrace_id() {
        assertEquals("abc123xyz456", logAggregateRoot.getTrace_id());
    }

    @Test
    void getSpan_id() {
        assertEquals("span789", logAggregateRoot.getSpan_id());
    }

    @Test
    void getParent_span_id() {
        assertEquals("parent123", logAggregateRoot.getParent_span_id());
    }

    @Test
    void getService_name() {
        assertEquals("order-service", logAggregateRoot.getService_name());
    }

    @Test
    void getOperation_name() {
        assertEquals("createOrder", logAggregateRoot.getOperation_name());
    }

    @Test
    void getProtocol_details() {
        assertNotNull(logAggregateRoot.getProtocol_details());
        assertEquals("http", logAggregateRoot.getProtocol_details().getProtocol_type());
    }

    @Test
    void getStart_time() {
        assertNotNull(logAggregateRoot.getStart_time());
        assertEquals("2025-03-11T14:25:30.111Z", logAggregateRoot.getStart_time().toString());
    }

    @Test
    void getEnd_time() {
        assertNotNull(logAggregateRoot.getEnd_time());
        assertEquals("2025-03-11T14:25:33.123Z", logAggregateRoot.getEnd_time().toString());
    }

    @Test
    void getDuration_ms() {
        assertEquals(3123, logAggregateRoot.getDuration_ms());
    }

    @Test
    void getStatus() {
        assertEquals("success", logAggregateRoot.getStatus());
    }

    @Test
    void getError_message() {
        assertEquals("", logAggregateRoot.getError_message());
    }

    @Test
    void getService_dependencies() {
        assertNotNull(logAggregateRoot.getService_dependencies());
        assertEquals(2, logAggregateRoot.getService_dependencies().size());
        assertEquals("auth-service", logAggregateRoot.getService_dependencies().get(0).getService_name());
    }

    @Test
    void getTags() {
        assertNotNull(logAggregateRoot.getTags());
        assertEquals("production", logAggregateRoot.getTags().get("env"));
        assertEquals("v1.2.3", logAggregateRoot.getTags().get("version"));
    }

    @Test
    void getLogs() {
        assertNotNull(logAggregateRoot.getLogs());
        assertEquals(2, logAggregateRoot.getLogs().size());
        assertEquals("info", logAggregateRoot.getLogs().get(0).getLevel());
        assertEquals("Order created successfully", logAggregateRoot.getLogs().get(0).getMessage());
    }
}
