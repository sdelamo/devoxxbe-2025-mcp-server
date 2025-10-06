package com.example;

import com.example.httpserver.HttpServerMcpStatelessServerTransport;
import com.example.httpserver.McpSimpleHttpServer;
import com.sun.net.httpserver.HttpExchange;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static com.example.httpserver.McpSimpleHttpServer.DEFAULT_ENDPOINT;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws IOException {
        McpJsonMapper jsonMapper = McpJsonMapper.getDefault();
        HttpServerMcpStatelessServerTransport<HttpExchange> transport = new HttpServerMcpStatelessServerTransport<>(
                (serverRequest) -> McpTransportContext.EMPTY);
        McpSchema.JsonSchema inputJsonSchema = new McpSchema.JsonSchema("object",
                Collections.emptyMap(), Collections.emptyList(), null, null, null);
        McpSchema.Tool tool = McpSchema.Tool.builder()
                .name("freeDiskSpace")
                .title("Free Disk Space")
                .inputSchema(inputJsonSchema)
                .description("Return the free disk space in the users computer")
                .build();
        McpServer.sync(transport)
                .jsonSchemaValidator(JsonSchemaValidator.getDefault())
                .jsonMapper(jsonMapper)
                .tools(List.of(
                        new McpStatelessServerFeatures.SyncToolSpecification(tool,
                        (mcpSyncServerExchange, stringObjectMap)
                                -> new McpSchema.CallToolResult(DiskUtils.freeDiskSpace(), false))))
                .capabilities(McpSchema.ServerCapabilities.builder().tools(false).build())
                .build();

        McpSimpleHttpServer server = new McpSimpleHttpServer(transport);
        server.start();
        out.println("Server started in http://localhost:" + server.getPort() + DEFAULT_ENDPOINT);

    }
}