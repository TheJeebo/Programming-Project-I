import javax.swing.*;
import java.util.*;


public class ProgrammingProject
{
    public static PlayerModel2 mainPlayer = new PlayerModel2();
    public static Random rand = new Random();
    public static int familyCount = rand.nextInt(3) + 2; /*3 2*/
    public static PlayerModel2 playerFamily[] = new PlayerModel2[familyCount];
    
    
    public static void main(String args[])
    {
        playerSetup();

        familySetup();

        projectEnding();
    }

    public static void projectEnding()
    {
        String endMessage1 = "The brave " + mainPlayer.getUserName() + ", unknowignly already had the virus and dies before the journey begins!";
        String endMessage2 = mainPlayer.getUserName() + "'s family";

        for(int i = 0; i < playerFamily.length; i++)
        {
            endMessage2 += "\n" + playerFamily[i].getUserName() + ", age " + playerFamily[i].getUserAge();
        }

        endMessage2 += "\nWere all very sad, but they'll be ok.";

        messageBox(endMessage1);
        messageBox(endMessage2);
    }

    public static void familySetup()
    {
        myDebug("Family size: " + familyCount);

        int spouseAgeLow = (int)mainPlayer.getUserAge() - 10;
        int spouseAgeHigh = (int)mainPlayer.getUserAge() + 10;
        int childAgeHigh = (int)mainPlayer.getUserAge() / 2;
        int spouseGender = rand.nextInt(2);
        int childGender = 0;
        long tempAge = 0;

        if(spouseAgeLow < 18 || spouseAgeHigh < 18){
            spouseAgeLow = 20;
            spouseAgeHigh = 30;
        }

        for(int i = 0; i < familyCount; i++)
        {
            playerFamily[i] = new PlayerModel2();

            if(i == 0){
                //first family member is the spouse, else are the kids
                tempAge = (long)rand.nextInt((spouseAgeHigh - spouseAgeLow) + 1) + spouseAgeLow;
                playerFamily[i].setUserAge(tempAge);
                
                playerFamily[i].setUserRole("Spouse");

                if(spouseGender == 0){
                    playerFamily[i].setUserGender("male");
                    playerFamily[i].setRandomName();
                } else{
                    playerFamily[i].setUserGender("female");
                    playerFamily[i].setRandomName();
                }
            } else{
                tempAge = (long)rand.nextInt(childAgeHigh) + 1;
                playerFamily[i].setUserAge(tempAge);
                playerFamily[i].setUserRole("Child");

                childGender = rand.nextInt(2);

                if(childGender == 0){
                    playerFamily[i].setUserGender("male");
                    playerFamily[i].setRandomName();
                } else{
                    playerFamily[i].setUserGender("female");
                    playerFamily[i].setRandomName();
                }
            }

            myDebug("Name: " + playerFamily[i].getUserName() + " Gender: " + playerFamily[i].getUserGender() 
                    + " Age: " + playerFamily[i].getUserAge() + " Role: " + playerFamily[i].getUserRole()
                    + " Infection Rate: " + playerFamily[i].getInfectionRate());
        }
    }

    public static void messageBox(String whatToPrint)
    {
        JOptionPane.showMessageDialog(null, whatToPrint);
    }

    public static void myDebug(String whatToPrint)
    {
        System.out.println(whatToPrint);
    }

    public static boolean isInt(String numTest)
    {
        if(numTest == null){
            return false;
        }
        try{
            long i = Long.parseLong(numTest);
        } catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }

    public static void playerSetup()
    {
        String tempAge = "";
        String tempGender;
        boolean ageCheck;
        int i;
        messageBox("Programming Fundamentals I - Project");
        
        mainPlayer.setUserName(userInfo("name"));

        messageBox("Hello, " + mainPlayer.getUserName());
        messageBox("We'll need some information to get started...");
        ageCheck = false;

        while(!ageCheck){
            tempAge = userInfo("age");

            if(isInt(tempAge)){
                i = Integer.parseInt(tempAge);
                if(i >= 20){
                    ageCheck = true;
                } else {
                    messageBox("Please enter an age between 20 and 70");
                }
            } else {
                messageBox("Please enter a whole number.");
            }
        }

        mainPlayer.setUserAge(Long.parseLong(tempAge));

        myDebug("Player infection rate: " + mainPlayer.getInfectionRate());

        mainPlayer.setUserGender(userInfo("gender"));
        mainPlayer.setUserRole("Main");
        
        if(mainPlayer.getUserGender().equalsIgnoreCase("male")){
            tempGender = "Sir";
        } else if(mainPlayer.getUserGender().equalsIgnoreCase("female")){
            tempGender = "Madam";
        } else {
            tempGender = "Person";
        }

        messageBox("Welcome to COVID-19 Trail, " + tempGender 
            + "!\nBefore you begin on this perilous journey, we will find out about your family.\nYou can't leave home without them!");
    }

    public static String userInfo(String infoToGet)
    {
        String result = "";
        switch(infoToGet)
        {
            case "name":
                result = JOptionPane.showInputDialog("What is your name?");
                break;
            case "gender":
                result = JOptionPane.showInputDialog("What is your gender?");
                break;
            case "age":
                result = JOptionPane.showInputDialog("What is your age? (Between 20 and 70)");
                break;
            default:
                result = "a";
                break;
        }
        return result;
    }
}