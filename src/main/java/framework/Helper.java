
package framework;


public class Helper {
    
    public static String getRandomText() {
        return "Filip-" + getRandomInteger();
    }

    private static int getRandomInteger() {
        return (int) ( Math.random() * 1000);
    }
    
    public static String getRandomEmail() {
        return "Filip" + getRandomInteger() + "@gmail.com";
    }
    
    
}


