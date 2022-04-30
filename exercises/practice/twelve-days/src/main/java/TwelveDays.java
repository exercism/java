import java.util.Scanner;
public class TwelveDays
{
public static void main(String[] args)
{
   int christmas;
   Scanner xmasDay = new Scanner(System.in);
   System.out.println("Enter a day of Christmas (1-12), and I will sing you a song.");
   christmas = xmasDay.nextInt();
   
   if(christmas == 1)
   {
   System.out.println("On the " + christmas + "st day of Christmas, my true love sent to me,"); 
   }
   if(christmas == 2)
   {
   System.out.println("On the " + christmas + "nd day of Christmas, my true love sent to me,"); 
   }
   if(christmas == 3)
   {
   System.out.println("On the " + christmas + "rd day of Christmas, my true love sent to me,"); 
   }
   if(christmas != 1 && christmas !=2 && christmas !=3 && christmas <= 12)
   {
   System.out.println("On the " + christmas + "th day of Christmas, my true love sent to me,"); 
   }
   if(christmas > 12)
   {
   System.out.println("Bad news!"); 
   }
   
   switch (christmas) {
        case 12:
            System.out.println("12 drummers drumming,");
        case 11:
            System.out.println("11 pipers piping,");
        case 10:
            System.out.println("10 lords-a-leaping,");
        case 9:
            System.out.println("9 ladies dancing,");
        case 8:
            System.out.println("8 maids-a-milking,");
        case 7:
            System.out.println("7 swans-a-swimming,");
        case 6:
            System.out.println("6 geese-a-laying,");
        case 5:
            System.out.println("5 golden rings,");
        case 4:
            System.out.println("4 calling birds,");
        case 3:
            System.out.println("3 french hens,");
        case 2:
            System.out.println("2 turtle doves,");
        case 1:
            System.out.println("And a partridge in a pear tree!");
            break;
        default:
            System.out.println("There are only 12 days of Christmas!");
            break;
    }
}
}
