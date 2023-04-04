package com.example.szs.infrastructure.encrypt;

import com.example.szs.infrastructure.annotations.Provider;
import org.mindrot.jbcrypt.BCrypt;

@Provider("bcryptPasswordProvider")
public class BCryptPasswordProvider implements PasswordEncryptor {

    @Override
    public String hash(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }

    @Override
    public boolean isMatch(String rawPassword, String hashedPassword) {
        return BCrypt.checkpw(rawPassword, hashedPassword);
    }
}
