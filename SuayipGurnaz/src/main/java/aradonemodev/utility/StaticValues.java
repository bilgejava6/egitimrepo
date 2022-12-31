package aradonemodev.utility;

public class StaticValues {
    public static Long personelId=0L;
    public static Long departmanId=0L;

    public static long personlerIdOlustur() {
        personelId++;
        return personelId;
    }
    public static long departmanIdOlustur() {
        departmanId++;
        return departmanId;
    }
}
