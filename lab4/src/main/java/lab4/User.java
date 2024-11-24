package lab4;


public class User {
    private int id;
    private String name;
    private String company;
    private String username;
    private String email;
    private String address;
    private String zip;
    private String state;
    private String country;
    private String phone;
    private String photo;


    @Override
    public String toString() {
        return "User ID: " + id +
                "\nName: " + name +
                "\nCompany: " + company +
                "\nUsername: " + username +
                "\nEmail: " + email +
                "\nAddress: " + address +
                "\nZIP: " + zip +
                "\nState: " + state +
                "\nCountry: " + country +
                "\nPhone: " + phone +
                "\nPhoto: " + photo + "\n";
    }
}
