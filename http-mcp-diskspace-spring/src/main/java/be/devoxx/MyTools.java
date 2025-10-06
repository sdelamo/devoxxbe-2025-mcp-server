package be.devoxx;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
class MyTools {

    @Tool(description = "Return the free disk space in the users computer")
    String freeDiskSpace() {
        return DiskUtils.freeDiskSpace() + " from spring MCP HTTP";
    }
}
