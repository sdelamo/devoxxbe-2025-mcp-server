package be.devoxx;

import io.quarkiverse.mcp.server.Tool;

class MyTools {

    @Tool(title = "Free Disk Space",
            description = "Return the free disk space in the users computer")
    String freeDiskSpace() {
        return DiskUtils.freeDiskSpace() + " from Quarkus";
    }
}
