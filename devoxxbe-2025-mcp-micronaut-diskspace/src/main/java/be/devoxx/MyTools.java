package be.devoxx;

import io.micronaut.mcp.annotations.Tool;
import jakarta.inject.Singleton;
import java.io.File;

@Singleton
class MyTools {
    @Tool(title = "Free Disk Space",
            description = "Return the free disk space in the users computer")
    String freeDiskSpace() {
        File root = new File("/");
        long freeBytes = root.getFreeSpace();
        double freeGB = freeBytes / (1024.0 * 1024 * 1024);
        return String.format("Free disk space: %.2f GB", freeGB);
    }
}
