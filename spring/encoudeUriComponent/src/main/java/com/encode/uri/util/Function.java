package com.encode.uri.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Function {

    public static void main(String[] args) {
        System.out.println(new Function().encodeUriComponent("`~!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?"));

        System.out.println(URLEncoder.encode("`~!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?", StandardCharsets.UTF_8));
        System.out.println(URLDecoder.decode("%60~!%40%23%24%25%5E%26*()-_%3D%2B%5B%7B%5D%7D%5C%7C%3B%3A'%22%2C%3C.%3E%2F%3F", StandardCharsets.UTF_8));
    }

    public String encodeUriComponent(String text) {
        return text.replaceAll("\\%", "\\%25")
                   .replaceAll(";", "\\%3B")
                   .replaceAll(",", "\\%2C")
                   .replaceAll("/", "\\%2F")
                   .replaceAll("\\?", "\\%3F")
                   .replaceAll(":", "\\%3A")
                   .replaceAll("@", "\\%40")
                   .replaceAll("&", "\\%26")
                   .replaceAll("=", "\\%3D")
                   .replaceAll("\\+", "\\%2B")
                   .replaceAll("\\$", "\\%24")
                   .replaceAll("#", "\\%23")
                   .replaceAll("`", "\\%60")
                   .replaceAll("\\^", "\\%5E")
                   .replaceAll("\\[", "\\%5B")
                   .replaceAll("\\]", "\\%5D")
                   .replaceAll("\\{", "\\%7B")
                   .replaceAll("\\}", "\\%7D")
                   .replaceAll("\"", "\\%22")
                   .replaceAll("<", "\\%3C")
                   .replaceAll(">", "\\%3E")
                   .replaceAll("\\\\", "\\%5C")
                   .replaceAll("\\|", "\\%7C");
    }
}
