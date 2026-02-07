package CSC400Mod8;

/*
    CSC400 Module 8
    Matthew Finney
    Option #1: Person Class
    Creates a Person object
    Carries a first name, last name, and age

    https://github.com/matt-finney/CSC400
 */

// class to represent a person with first name, last name, and age
public class Person 
{
    // instance variables
    private String first_name;
    private String last_name;
    private int age;

    // constructor
    public Person(String first_name, String last_name, int age) 
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    // getters
    public String getFirst_name() 
    {
        return first_name;
    }

    public String getLast_name() 
    {
        return last_name;
    }

    public int getAge() 
    {
        return age;
    }

    // setters
    public void setFirst_name(String first_name) 
    {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) 
    {
        this.last_name = last_name;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    // return the string representation of the person to display
    @Override
    public String toString()
    {
        return capFirst(first_name) + " " + capFirst(last_name) + ", age = " + age;
    }

    // helper method to capitalize the first letter of a string for better display
    private static String capFirst(String s)
    {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
    
}
