package com.example.propertymanagement.passwordHandler;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncrypt {
    public String passwordEncrypt(String password)
    {
        BCryptPasswordEncoder bCrypt=new BCryptPasswordEncoder();
        return bCrypt.encode(password);


    }
//    public String passwordDecrypt(String hased)
    public static void main(String args[])
    {
        PasswordEncrypt pass=new PasswordEncrypt();
        String str1=pass.passwordEncrypt("dewashish");
        String str2=pass.passwordEncrypt("dewashish");
        System.out.println(str1+" "+str2);

        BCryptPasswordEncoder bCrypt=new BCryptPasswordEncoder();
        Boolean check =  bCrypt.matches("dewashish",str2);
        System.out.println(check);
    }

}
