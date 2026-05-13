package org.example.scan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class NetworkScanner {

    private static final Set<Integer> suspiciousPorts = Set.of(
            1337,
            4444,
            5555,
            6666,
            7777,
            9001
    );

    public static void scanConnections() {

        System.out.println("[+] Checking Active Connections...");

        try {

            Process process = Runtime.getRuntime().exec("netstat -ano");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(process.getInputStream())
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                if (!line.startsWith("TCP"))
                    continue;

                String[] parts = line.split("\\s+");

                if (parts.length < 5)
                    continue;

                String remote = parts[2];

                int port = extractPort(remote);

                if (suspiciousPorts.contains(port)) {

                    System.out.println("[!] Suspicious Port Connection:");
                    System.out.println("    " + line);
                }
            }

        } catch (Exception e) {
            System.out.println("[-] Network scan failed: " + e.getMessage());
        }

        System.out.println();
    }

    private static int extractPort(String address) {

        try {

            int idx = address.lastIndexOf(':');

            if (idx == -1)
                return -1;

            return Integer.parseInt(address.substring(idx + 1));

        } catch (Exception e) {
            return -1;
        }
    }
}