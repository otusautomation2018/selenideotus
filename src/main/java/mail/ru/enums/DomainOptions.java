package mail.ru.enums;

public enum DomainOptions {
    BK_RU("bk.ru");

    public String value;

    DomainOptions(String value) { this.value = value; }

    public String toString() { return this.value; }
}
