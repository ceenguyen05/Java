public class checkCharacterCases
{
    public static void main (String [] args)
    {
        System.out.println("Hello World") ;
        String stringWord = "HelloThereBoy";
        int isUpper = 0 ;
        int isLower = 0 ;
        for (int count = 0 ; count < stringWord.length() ; count++)
    {
        char characterCheck = stringWord.charAt(count) ;
        boolean check = Character.isUpperCase (characterCheck) ;
        if (check == true)
        {
            isUpper++ ;
        }
        else 
        {
            isLower++ ;
        }
    }
    System.out.println(isUpper) ;
    System.out.println(isLower) ;
    }
}