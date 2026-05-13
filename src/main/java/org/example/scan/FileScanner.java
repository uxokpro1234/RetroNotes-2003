package org.example.scan;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FileScanner {

    private static final List<String> suspiciousNames = List.of(
            "jre.exe",
            "javaw.exe",
            "svchost.exe",
            "runtime.exe",
            "update.exe",
            "system.exe"
    );

    public static void scanSuspiciousDirectories() {

        System.out.println("[+] Scanning Suspicious Directories...");

        List<Path> targets = new ArrayList<>();

        String appData = System.getenv("APPDATA");
        String temp = System.getenv("TEMP");
        String local = System.getenv("LOCALAPPDATA");

        if (appData != null)
            targets.add(Paths.get(appData));

        if (temp != null)
            targets.add(Paths.get(temp));

        if (local != null)
            targets.add(Paths.get(local));

        for (Path path : targets) {
            recursiveScan(path);
        }

        System.out.println();
    }

    private static void recursiveScan(Path root) {

        try {

            Files.walk(root)
                    .filter(Files::isRegularFile)
                    .forEach(FileScanner::analyzeFile);

        } catch (IOException ignored) {
        }
    }

    private static void analyzeFile(Path file) {

        String name = file.getFileName().toString().toLowerCase();

        for (String suspicious : suspiciousNames) {

            if (name.equals(suspicious)) {

                System.out.println("[!] Suspicious File Found:");
                System.out.println("    " + file);

                try {

                    long size = Files.size(file);

                    System.out.println("    Size: " + size + " bytes");

                } catch (IOException ignored) {
                }
            }
        }

        if (name.endsWith(".jar")) {

            System.out.println("[?] JAR File Found:");
            System.out.println("    " + file);
        }
    }
}