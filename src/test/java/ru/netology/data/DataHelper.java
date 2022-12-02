package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

public class DataHelper {
  private DataHelper() {
  }

  private static Faker faker = new Faker(new Locale("en"));

  @Value
  public static class AuthInfo {
    String login;
    String password;
  }

  public static AuthInfo getAuthInfoWithTestData() {
    return new AuthInfo("vasya", "qwerty123");
  }

  public static String generateRandomLogin() {
    return faker.name().username();
  }

  public static String generateRandomPassword() {
    return faker.internet().password();
  }

  public static AuthInfo generateRandomUser() {
    return new AuthInfo(generateRandomLogin(), generateRandomPassword());
  }

  @Value
  public static class VerificationCode {
    String code;
  }

  public static VerificationCode generateRandomVerificationCode() {
    return new VerificationCode(faker.numerify("######"));
  }

  public static VerificationCode getVerificationCode() {
    return new VerificationCode("12345");
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class AuthCode {
    private String id;
    private String user_id;
    private String code;
    private String created;
  }
}