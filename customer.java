import java.util.ArrayList;
import java.util.HashMap;

public class customer {
    String email_id;
    String name;
    long mobile_number;
    String password;

    ArrayList<String> emailid_list = new ArrayList<>();

    //HashMap<customer,String> hash = new HashMap<>();



    public customer(String name,String email_id,long mobile_number,String password){
        this.name = name;
        this.email_id = email_id;
        this.mobile_number = mobile_number;
        this.password = password;
    }
}
