package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueValidEmail {
    public static void main(String[]args) {
        String[] emails= new String[]{"linqmafia@leet+code.com","linqmafia@code.com"};
        Set<String> set = new HashSet<String>();
        for(String email: emails){
            String valid = validEmail(email);
            if(valid != null)
                set.add(valid);
        }
        System.out.println(set.size());

    }

    public static String validEmail(String email){

        String[] parts= email.split("@");
        if(parts.length!=2){
            return null;
        }
        String emailPart = parts[0];
        String validEmailPart = emailPart.replaceAll("[.]|[+](.*)","");
        return validEmailPart.concat("@").concat(parts[1]);
    }
}