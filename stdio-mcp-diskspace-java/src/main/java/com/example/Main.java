package com.example;

import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        McpJsonMapper jsonMapper = McpJsonMapper.getDefault();
        var transportProvider = new StdioServerTransportProvider(jsonMapper);

        McpSchema.JsonSchema inputJsonSchema = new McpSchema.JsonSchema("object",
                Collections.emptyMap(), Collections.emptyList(), null, null, null);
        McpSchema.Tool tool = McpSchema.Tool.builder()
                .name("freeDiskSpace")
                .title("Free Disk Space")
                .inputSchema(inputJsonSchema)
                .description("Return the free disk space in the users computer")
                .build();
        McpServer.sync(transportProvider)
                .jsonMapper(jsonMapper)
                .tools(List.of(
                        new McpServerFeatures.SyncToolSpecification(tool,
                        (mcpSyncServerExchange, stringObjectMap)
                                -> new McpSchema.CallToolResult(DiskUtils.freeDiskSpace(), false))))
                .capabilities(McpSchema.ServerCapabilities.builder().tools(false).build())
                .build();
    }
}