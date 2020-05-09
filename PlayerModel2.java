import java.util.*;

public class PlayerModel2
{
    private final Random rand = new Random();
    private String userName;
    private String userGender;
    private long userAge;
    private String userRole;
    private long infectionRate;
    private final String maleNames[] = { "Micheal", "Jim", "Dwight", "David", "Toby", "Oscar", "Stanley", "Creed",
            "Roy", "Darrel", "Ryan", "Greg", "Random Warehouse Guy" };
    private final String femaleNames[] = { "Pam", "Philis", "Angela", "Kelly", "Meredith", "Holly", "Jan", "Erin",
            "Karen", "Jo", "Cece" };

    // setters
    public void setUserName(final String name) {
        this.userName = name;
    }

    public void setUserGender(final String gender) {
        this.userGender = gender;
    }

    public void setRandomName() {
        if (userGender.equalsIgnoreCase("male")) {
            this.userName = this.maleNames[rand.nextInt(this.maleNames.length)];
        } else {
            this.userName = this.femaleNames[rand.nextInt(this.femaleNames.length)];
        }
    }

    public void setUserAge(final long age) {
        this.userAge = age;
        setInfectionRate();
    }

    public void setUserRole(final String role) {
        this.userRole = role;
    }

    public void setInfectionRate() {
        int tempRate = 0;
        if (userAge >= 1 && userAge < 30) {
            tempRate = 1;
        } else if(userAge >= 30 && userAge < 40){
            tempRate = 2;
        } else if(userAge >= 40 && userAge < 50){
            tempRate = 4;
        } else if(userAge >= 50 && userAge < 60){
            tempRate = 8;
        } else if(userAge >= 60 && userAge < 70){
            tempRate = 16;
        } else {
            //99 will trigger instant death because use picked outside the defined range
            tempRate = 99;
        }

        this.infectionRate = tempRate;
    }


    //getters
    public String getUserName()
    {
        return this.userName;
    }

    public String getUserGender()
    {
        return this.userGender;
    }

    public long getUserAge()
    {
        return this.userAge;
    }

    public String getUserRole()
    {
        return this.userRole;
    }

    public long getInfectionRate()
    {
        return this.infectionRate;
    }
}