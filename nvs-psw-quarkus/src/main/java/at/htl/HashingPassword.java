package at.htl;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class HashingPassword {
    private String salt2;

    public String hash(String input) {
        try {
            // Generate a random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // Append the pepper to the input

            // Append the salt to the input
            input = input + new String(salt);
            this.salt2 = String.valueOf(salt);

            // Create the SHA-256 digest
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Hash the input
            byte[] hash = digest.digest(input.getBytes("UTF-8"));

            // Convert the hash to a hex string
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Append the salt to the hex string
            hexString.append(new String(salt));
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public String getSalt2() {
        return salt2;
    }

}
