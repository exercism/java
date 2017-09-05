class Leap
{

	boolean is_leap_year(int year)
	{
		return ((year%100!=0)?(year%4==0):(year%400==0));

	}

}
