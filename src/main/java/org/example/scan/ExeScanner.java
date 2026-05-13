package org.example.scan;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.*;

import static org.apache.commons.codec.digest.DigestUtils.sha256;

public class ExeScanner {

    private static final List<String> suspiciousStrings = List.of(
            "powershell",
            "cmd.exe",
            "wget",
            "curl",
            "invoke-webrequest",
            "downloadstring",
            "http://",
            "https://",
            "pastebin",
            "discord.com/api/webhooks",
            "startup",
            "appdata",
            "temp",
            "reg add",
            "schtasks",
            "javaw.exe",
            ".jar"
    );

    public static void scanExecutable(Path exe) {

        int score = 0;

        try {

            byte[] data = Files.readAllBytes(exe);

            String content = new String(data);

            System.out.println("[+] File Size: " + data.length + " bytes");

            String hash = sha256(data);

            System.out.println("[+] SHA256: " + hash);
            System.out.println();

            for (String indicator : suspiciousStrings) {

                if (content.toLowerCase().contains(indicator.toLowerCase())) {

                    System.out.println("[!] Suspicious String Found: " + indicator);
                    score += 10;
                }
            }

            if (content.contains("MZ")) {
                System.out.println("[+] Valid PE Header Detected");
            }

            if (containsIPAddress(content)) {
                System.out.println("[!] Embedded IP Address Detected");
                score += 20;
            }

            if (containsLongBase64(content)) {
                System.out.println("[!] Possible Encoded Payload Detected");
                score += 25;
            }

            if (score >= 50) {
                System.out.println(" [!!!] HIGH RISK EXECUTABLE");
            } else if (score >= 20) {
                System.out.println(" [!] SUSPICIOUS EXECUTABLE");
            } else {
                System.out.println(" [+] No major indicators found");
            }

            System.out.println("[+] Risk Score: " + score + "/100");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static boolean containsIPAddress(String content) {

        return content.matches(
                "(?s).*\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b.*"
        );
    }

    private static boolean containsLongBase64(String content) {

        return content.matches(
                "(?s).*[A-Za-z0-9+/]{200,}={0,2}.*"
        );
    }
    private static String sha256(byte[] data) throws Exception {

        MessageDigest digest =
                MessageDigest.getInstance("SHA-256");

        byte[] hash = digest.digest(data);

        StringBuilder hex = new StringBuilder();

        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }

        return hex.toString();
    }
}