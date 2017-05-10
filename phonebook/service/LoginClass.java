package phonebook.service;

import phonebook.presentation.console.ConsolePresentation;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sasha on 16.03.2017.
 */
public class LoginClass {

    private final static HashMap<String,String> secretLoginPassword= new HashMap();

    private final static String enterLoginMesssage          = "Enter correct login: ";
    private final static String enterMessage                = " -> Enjoy your work with PhoneBook)))";
    private final static String enterPasswordMesssage       = "Enter your password: ";
    private final static String checkPasswordErrorMesssage  = "Try again.  ";
    private final static String checkLoginErrorMesssage     = "Try again.  ";

    public HashMap<String, String> getSecretLoginPassword() {
        return secretLoginPassword;
    }

    public HashMap<String, String> setSecretLoginPassword() {
        secretLoginPassword.put("ADMIN","ADMIN");
        secretLoginPassword.put("USER","USER");
        return secretLoginPassword;
    }

    public static String getEnterLoginMesssage() {
        System.out.print(enterLoginMesssage);
        return "";
    }

    public static String getEnterMessage() {
        System.out.print(enterMessage);
        return "";
    }

    public static String getEnterPasswordMesssage() {
        System.out.print(enterPasswordMesssage);
        return "";
    }

    public static String getCheckPasswordErrorMesssage() {
        System.out.print(checkPasswordErrorMesssage);
        return "";
    }

    public static String getCheckLoginErrorMesssage() {
         System.out.print(checkLoginErrorMesssage);
        return "";
    }

    Scanner scanner = new Scanner(System.in);
    Scanner scannerPassword = new Scanner(System.in);

    public Scanner getScannerPassword() {
        return scannerPassword;
    }

    public void setScannerPassword(Scanner scannerPassword) {
        this.scannerPassword = scannerPassword;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public LoginClass() {
    }


    public boolean logIn(String login) {

        setSecretLoginPassword();
        boolean coincidence=false;
        for (String i:getSecretLoginPassword().keySet())
        {
            if (i.matches(login.toUpperCase())) coincidence=true;
        }

        if (!coincidence)
        {
            getCheckLoginErrorMesssage();
            return false;
        } else return true;
    }

    public boolean checkPassword(String password) {
        setSecretLoginPassword();
        boolean coincidence=false;
        for (String i:getSecretLoginPassword().values())
        {
            if (i.matches(password.toUpperCase())) coincidence=true;
        }

        if (!coincidence)
        {
            getCheckPasswordErrorMesssage();
            return false;
        } else return true;
    }

    /**
     * @param text check enter symbols
     * @param type managing blocks login or password
     */
    public boolean checkRegex(String text,int type) {
        String pattern = "[A-Za-z_0-9]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        boolean matches = m.matches();

        if (!matches&&type == 1) {//login view
                return false;
            }
        else if (!matches&&type == 2) {//password view
                return false;
            }
        return matches;
    }


    public boolean basicInterfaceLogin() {
        getEnterLoginMesssage();

        Scanner scannerNewLogin = new Scanner(System.in);
        String login = scannerNewLogin.nextLine();

        //check symbols
        if (checkRegex(login, 1)) {
            scannerNewLogin=null;
            login=null;
            basicInterfaceLogin();
        }
        else {
            //check corrrect login
            if (logIn(login)) {
                scannerNewLogin=null;
                login=null;
                basicInterfacePassword();
                return true;
            } else
            {   scannerNewLogin=null;
                login=null;
                basicInterfaceLogin();}
        }

        return false;
    }

    public boolean basicInterfacePassword()
    {
        getEnterPasswordMesssage();

        Scanner scannerPass = new Scanner(System.in);
        String password=scannerPass.nextLine();

        //check symbols
        if (checkRegex(password, 2)) {
            scannerPass=null;
            password=null;
            basicInterfacePassword();
        }
        else {
            //check corrrect login
            if (checkPassword(password)) {
                scannerPass=null;
                password=null;
                ConsolePresentation presentation = new ConsolePresentation(new PhoneBook());
                presentation.getConsolePresentation();
                return true;
            } else
            {   scannerPass=null;
                password=null;
                basicInterfacePassword();
                return false;
            }
        }
        return true;
    }


}