package mail.ru.enums;

public enum Emails {
    MAIL_BK_RU("selenide");

    public String value;

    Emails(String value) { this.value = value; }

    public String toString() { return this.value; }
}
