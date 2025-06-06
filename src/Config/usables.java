/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Timer;

/**
 *
 * @author DANIEL FAILADONA
 */
public class usables {
    

//===================================================
//        PLACE ABOVE VOID W initComponents();
//===================================================
    
//    public static final usables use = new usables();


    
    
    
    
    
    
    
    
    
    
    
   
//===================================================
//                  DELAY BY SECONDS
//===================================================

public void delay(int seconds, Runnable afterDelay) {
        int delayInMillis = seconds * 1000;
//        System.out.println("[delay()] Scheduling delay for " + seconds + " seconds (" + delayInMillis + " ms)");

        Timer timer = new Timer(delayInMillis, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Timer) e.getSource()).stop(); // stop the timer after it's triggered once
//                System.out.println("[delay()] Delay finished after " + seconds + " seconds");
                afterDelay.run(); // run the code passed as argument
            }
        });

        timer.setRepeats(false); // one-time delay
        timer.start();
        
        
        //==========================================
        // How to use:
        
        
//        usables use = new usables();
//        use.delay(desiredSecond, () -> {
//           // Functions_here
//        });


        //==========================================
    }












    public static final Scanner sc = new Scanner(System.in);
    public String checkFor = "";

    //========================================================
    //                SHOW MENU FUNCTION
    //========================================================
    public void showMenu() {
        String show_decrypt
                = "if (v == 2) {"
                + "\nSystem.out.print(\"Enter shift value: \");"
                + "\nint shift = (int) use.numValid();"
                + "\nvalue1(shift, use);"
                + "\n}"
                + "\n\n\npublic void value2(int shift, processors process) {"
                + "\n\nString v1 = \"dssoh\"; // Encrypted version of \"apple\""
                + "\n\nSystem.out.println(\"v1: \" + process.decrypt(v1, shift)); "
                + "\n}";
        String show_encrypt
                = "System.out.print(\"Enter Message: \");" + "String e_message = (String) use."
                + "encrypt(); // Encrypt without shift for" + "simplicity"
                + "\nuse.clearScreen();"
                + "\nSystem.out.print(\"Encrypted"
                + "Message: \" + e_message);";
        String show_value_retrieval
                = "//Main"
                + "\npublic static final showables show = new showables();"
                + "\npublic static final Scanner sc = new Scanner(System.in);"
                + "\n\n//main args"
                + "\n boolean spill = false;"
                + "\n boolean specific = false;"
                + "\n String test[];"
                + "\n show.set1 = test;"
                + "\n\n if (spill == true){"
                + "\n for (String all : show.set1) {"
                + "\n System.out.println(\"\\t\"+all);}}"
                + "\n\n//====================="
                + "\n else if(specific == true){"
                + "\n System.out.print(\"Enter array: \");"
                + "\n int get = sc.nextInt();"
                + "\n while(get > show.set1.length/*class.void.lenght*/){"
                + "\n System.out.print(\"Out of bounds\nTry again: \");"
                + "\n get = sc.nextInt();"
                + "\n}"
                + "\n System.out.print(\"\\t\"+show.set1[get-1]);"
                + "\n}"
                + "\n\n\n//class values"
                + "\nclass showables {"
                + "\n public String[] set1 = {\"a \", \"b \", \"c \", \"d \"};"
                + "\n public String[] set2 = {\"1 \", \"2 \", \"3 \", \"4 \"};"
                + "\n\n}";
        String wChecker
                = "System.out.print(\"Enter num: \");"
                + "\nuse.checkFor = \"0\";"
                + "\nString num1 = (String) use.wordChecker();"
                + "\n\nSystem.out.println(\"\\t\" + num1);";
        boolean loop = true;
        while (loop) {
            clearMini();
            separator();
            System.out.println("Select Option");
            String[] menu
                    = {
                        "1. Stop",
                        "2. Syntax Encrypt",
                        "3. Setting up Value Class",
                        "4. Syntax Decrypt",
                        "5. Deploy Word Checker"
                    };

            for (String all : menu) {
                System.out.println("\t" + all);
            }
            separator();
            System.out.print(": ");
            int option = (int) allPositive();
            while (option > menu.length) {
                System.out.println("\nOut of bounds, try again");
                System.out.print(": ");
                option = (int) allPositive();
            }
            clearScreen();
            separator();
            clearMini();
            switch (option) {
                case 1:
                    clearScreen();
                    loop = false;
                    break;
                case 2:
                    System.out.print(show_encrypt);
                    break;
                case 3:
                    String svr = show_value_retrieval;
                    System.out.print(svr);
                    break;
                case 4:
                    System.out.print(show_decrypt);
                    break;
                case 5:
                    System.out.print(wChecker);
                    break;
            }
            clearMini();
            if (option == 1) {
                separator();
                System.out.print("\t\t\t PROGRAM ENDED");
                separator();
            } else {
                option = 0;
                separator();
                System.out.print("\n\nEnter any key: ");
                sc.nextLine();
            }
        }
        //==========================================================
        //          How to use
        //          showMenu();
        //==========================================================
    }

    
    
    
    
    
    
    
    
    //========================================================
    //                NUM VALID FUNCTION
    //========================================================
    public double numValid() {
        Scanner sc = new Scanner(System.in);
        double value;
        while (true) {
            String input = sc.nextLine();
            if (input.matches("-?\\d+(\\.\\d+)?") && input.trim().equals(input)) {
                value = Double.parseDouble(input);
                break;
            } else {
                System.out.print("\nError, Enter a valid number: ");
            }
        }
        return value;
        //==========================================================
        //          How to use
        //          int variable = (int) use.numValid();
        //==========================================================
    }

    
    
    
    
    
    
    
    
    //========================================================
    //                CRUD VALID FUNCTION
    //========================================================
    public int crudValid() {
        Scanner sc = new Scanner(System.in);
        int value;
        while (true) {
            String input = sc.nextLine();
            if (input.matches("\\d+") && input.trim().equals(input)) {
                value = Integer.parseInt(input);
                if (value >= 1 && value <= 5) {
                    break;
                } else {
                    System.out.print("Invalid input. Please enter a number between 1 and 5: ");
                }
            } else {
                System.out.print("\nInvalid input. Please enter a valid integer: ");
            }
        }
        return value;
    //==========================================================
    //          How to use
    //          int variable = (int) use.crudValid();
    //==========================================================

    }

    
    
    
    
    
    
    
    
    
    //========================================================
    //                ALL POSITIVE FUNCTION
    //========================================================
    public int allPositive() {
        Scanner sc = new Scanner(System.in);
        int value;
        while (true) {
            String input = sc.nextLine();
            if (input.matches("\\d+") && input.trim().equals(input)) {
                value = Integer.parseInt(input);
                if (value > 0) {
                    break;
                } else {
                    System.out.print("\nPlease enter a positive number: ");
                }
            } else {
                System.out.print("\nPlease enter a valid number: ");
            }
        }
        return value;
    }
    
    
    
    
    

    //========================================================
    //                CLEAR SCREEN FUNCTION
    //========================================================
    public void clearScreen() {
        int x;
        for (x = 0; x <= 60; x++) {
            System.out.print("\n");
        }
        //==========================================================
        //          How to use
        //          use.clearScreen();
        //==========================================================
    }
    
    
    
    
    
    
    

    //========================================================
    //                CLEAR MINI FUNCTION
    //========================================================
    public void clearMini() {
        int x;
        for (x = 0; x <= 10; x++) {
            System.out.print("\n");
        }
    }

    //========================================================
    //                SEPARATOR FUNCTION
    //========================================================
    public void separator() {
        int length = 60;
        String value1 = "="; // Initialize value1
        String[] test = new String[length];
        int x = 0;
        System.out.print("\n\n");
        while (x < length) {
            test[x] = value1; // Assign value1 directly
            x++;
        }
        for (String s : test) { // Print array contents
            if (s != null) {
                System.out.print(s);
            }
        }
        System.out.print("\n\n");
    }

    //========================================================
    //                ENCRYPTION FUNCTION
    //========================================================
    public String encrypt(String message, int shift) {
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            // Encrypt uppercase letters
            if (ch >= 'A' && ch <= 'Z') {
                charArray[i] = (char) (((ch - 'A' + shift) % 26) + 'A');
            } // Encrypt lowercase letters
            else if (ch >= 'a' && ch <= 'z') {
                charArray[i] = (char) (((ch - 'a' + shift) % 26) + 'a');
            }
        }
        return new String(charArray);
    }

    //========================================================
    //                DECRYPTION FUNCTION
    //========================================================
    public String decrypt(String message, int shift) {
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch >= 'A' && ch <= 'Z') {
                charArray[i] = (char) (((ch - 'A' - shift + 26) % 26) + 'A');
            } else if (ch >= 'a' && ch <= 'z') {
                charArray[i] = (char) (((ch - 'a' - shift + 26) % 26) + 'a');
            }
        }
        return new String(charArray);
    }

    // Encrypt method with input validation
    public String encrypt() {
        Scanner sc = new Scanner(System.in);
        String message;
        while (true) {
            System.out.print("Enter a message to encrypt: ");
            message = sc.nextLine().trim();
            if (message.isEmpty()) {
                System.out.println("\nInvalid input. Please enter a non-empty message.");
            } else {
                break;
            }
        }
        System.out.print("Enter shift value: ");
        int shift = (int) numValid(); // Get the shift value
        return encrypt(message, shift); // Perform the encryption
    }

    //========================================================
    //                DRAW DNA FUNCTION
    //========================================================
    public void DNA() {
        int delay = 100; //milliseconds
        String v1 = "❤️";
        String v2 = "🔺";
        String v3 = "💙";
        String v4 = "📘";
        String v5 = "😡";
        String v6 = "👖";
        String v7 = "?";
        String v8 = "✈";
        String origin = "Origin:\n\nv1 = ❤️ \nv2 = 🔺 \nv3 = 💙 \nv4 = 📘 \nv5 = 😡 \nv6 = 👖 \nv7 = 👠\nv8 = ✈ ";
        System.out.printf("\t\t %s%s%s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t%s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s %s%s\n", v1, v1, v3, v3);
        System.out.printf("\t\t %s%s%s%s\n", v1, v1, v3, v3);
        //System.out.printf("\t\t %s%s%s%s%s%s\n",v1,v1,v7,v4,v3,v3);
        //System.out.printf("\t\t %s%s%s\n",v8,v1,v7);
        //System.out.printf("\t\t %s%s %s%s\n",v8,v3,v1,v7);
        //System.out.printf("\t\t %s%s %s%s\n",v8,v6,v1,v7);
        //System.out.printf("\t\t %s%s %s%s\n",v8,v6,v1,v2);
        //System.out.printf("\t\t %s%s %s%s\n",v8,v6,v1,v2);
        //System.out.printf("\t\t %s%s %s%s\n",v3,v4,v1,v1);
        //System.out.printf("\t\t %s%s%s%s\n",v3,v3,v4,v2);
        // Add delays after other lines as well
        // ...
        /* } catch (InterruptedException e) {
        System.err.println("Animation interrupted.");
        }*/
    }

    //========================================================
    //                DRAW CIRCLE FUNCTION
    //========================================================
    public void Circle() {
        int radius = 10;
        for (int y = -radius; y <= radius; y++) {
            for (int x = -radius; x <= radius; x++) {
                if (x * x + y * y <= radius * radius) {
                    System.out.print("☢️");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //========================================================
    //                WORD CHECKER FUNCTION
    //========================================================
    public String wordChecker() {
        // Get input word
        String input = sc.nextLine().toLowerCase();
        // Check if the input contains the `checkFor` value
        boolean hasH = input.contains(checkFor);
        // Return "True" or "False" as a string
        return hasH ? "True" : "False";
    }

    //========================================================
    //                CONTAINS WHAT FUNCTION
    //========================================================
    public String containsWhat() {
        String input = sc.nextLine(); // Get input from the user
        int length = input.length();
        boolean containsA = input.contains("a");
        boolean containsDigit = input.matches(".*\\d.*");
        // Create the result string
        StringBuilder result = new StringBuilder();
        result.append("Length: ").append(length).append("\n");
        result.append("Contains 'a': ").append(containsA ? "Yes" : "No").append("\n");
        result.append("Contains digit: ").append(containsDigit ? "Yes" : "No");
        return result.toString(); // Return the result
    }

    // Method to check if the input contains a digit
    public boolean containsDigit(String input) {
        return input.matches(".*\\d.*"); // Return true if input contains a digit
    }
    
    

    
    
    
    
    
    
    
    //========================================================
    //                   Experimentals
    //========================================================
    public boolean isValidEmail(String text) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
        //==========================================================
        //          How to use
        //          String variable = ""; // Place above if-else
        //
        //          if(use.isValidEmail(variable))
        //==========================================================
    }

    public boolean isNumeric(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
        //==========================================================
        //          How to use
        //          String variable = ""; // Place above if-else
        //
        //          if(use.isNumeric(variable))
        //==========================================================
    }








}
