import java.util.*;
public class Main {

    static HashMap<customer, String> new_cust =  new HashMap<>();

    static Scanner obj = new Scanner(System.in);
    static String name;static String email_id; static long mobile_number;static String password;
    static String login_username; static String login_password;

    static String encryted_string;static String retype_password;static String password_new;static String password_nu;
//case 2
    static boolean store_validateresult;
    static String encriptedstr;

    public static void main(String[] args) {

        boolean loop = true;
        boolean result;
        customer obj1 = new customer("Rahul","abc@gmail.com",9842166271l,"rahul");
        customer obj2 = new customer("divya","123@zoho.com",7200066271l,"divya");
        customer obj3 = new customer("kbwb22","user@zoho.com",7904567725l,"div66");

        //Inventory

        inventory inv1 = new inventory("Mobile","Apple","6s",60000,10);
        inventory inv2 = new inventory("Mobile","Motorola","G",12000,5);
        inventory inv3 = new inventory("Laptop","Hp","Ellite",56000,20);
        inventory inv4 = new inventory("Tablet","Google","ChromeBook",8000,12);



        while (loop){
            System.out.println("1.New user\t  2.Login ");
            int n = obj.nextInt();
            switch (n){
                case 1:
                {
                    System.out.println("Enter the details for new user name, email id, mobile number, password");
                    name = obj.next();
                    email_id = obj.next();
                    mobile_number = obj.nextLong();
                    password = obj.next();
                    System.out.println("Retype the password");
                    password_new = obj.next();

                    //checking password
                    result = password_valid(password,password_new);
                    funt_for_valid_password(result);


                }
                break;
                case 2:
                {
                    System.out.println("Hey welcome there");
                    System.out.println("Enter username and password");
                    login_username = obj.next();
                    login_password = obj.next();
                    store_validateresult = validuser(login_username);
                    if(store_validateresult){
                        encriptedstr = encrypt(login_password);
                        if(new_cust.containsKey(encriptedstr)){
                            System.out.println("Welcome to Z-kart again!! Happy Shopping");
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        }


    }

    private static boolean validuser(String login_username) {
        if(!new_cust.containsKey(login_username)){
            System.out.println("You are not registered SignUp");
            return false;
        }
        return true;
    }

    private static void funt_for_valid_password(boolean result) {
        if(result){
            customer cust = new customer(name,email_id,mobile_number,password_new);
            addcustmoer(cust);
        }
        else{
            System.out.println("Password mismatch retype the password");
            retype_password = obj.next();
            result = password_valid(password,retype_password);
            funt_for_valid_password(result);
        }

    }

    private static boolean password_valid(String password, String password_new) {
        if(password.equals(password_new)){
            return true;
        }
        return false;

    }


    private static void addcustmoer(customer cust) {

        if(new_cust.containsKey(cust.email_id )){
            System.out.println("You are already a user please login");
        }
        else{
            System.out.println("Welcome to Zkart enter the password");
            password_nu = obj.next();

            //encrypting the password
            encryted_string = encrypt(password_nu);
            new_cust.put(cust, encryted_string);
            System.out.println("Explore our products");
        }
    }

    private static String encrypt(String password_nu) {

        char[] str = password_nu.toCharArray();
        for(int i=0;i<str.length;i++){
            char c = str[i];
            //int c1 = str[i];
            if(c == 'Z' || c == 'z' || c == '9') {
                switch (c) {
                    case 'Z':
                        c = 'A';
                        break;

                    case 'z':
                        c = 'a';
                        break;

                    case '9':
                        c = '0';
                        break;
                }
            }
            else if(c >= 65 && c< 90){
                c = (char) (c+1);
            }

            else if(c >= 'a' && c < 'z' ){
                c = (char) (c+1);
            }

        }
        return str.toString();
    }


}