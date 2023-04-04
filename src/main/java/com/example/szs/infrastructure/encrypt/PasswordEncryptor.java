package com.example.szs.infrastructure.encrypt;

public interface PasswordEncryptor {

    String hash(String rawPassword);
    boolean isMatch(String rawPassword, String hashedPassword);
}
