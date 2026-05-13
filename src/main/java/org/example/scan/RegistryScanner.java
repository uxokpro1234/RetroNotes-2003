package org.example.scan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegistryScanner {

    public static void scanRunKeys() {

        System.out.println("[+] Checking Registry Persistence...");

        try {

            Process process = Runtime.getRuntime().exec(
                    "reg query HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Run"
            );

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(process.getInputStream())
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String lower = line.toLowerCase();

                if (lower.contains("javaw.exe") ||
                        lower.contains(".jar") ||
                        lower.contains("appdata") ||
                        lower.contains("temp")) {

                    System.out.println("[!] Suspicious Run Key:");
                    System.out.println("    " + line.trim());
                }
            }

        } catch (Exception e) {
            System.out.println("[-] Registry scan failed: " + e.getMessage());
        }

        System.out.println();
    }
}