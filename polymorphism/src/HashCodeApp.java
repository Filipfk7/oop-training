public class HashCodeApp {

    public static void main(String[] args) {
        String s1 = "D";
        String s2 = "D";
        String s3 = "siema";
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(s1.hashCode() == s3.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
    }
}
