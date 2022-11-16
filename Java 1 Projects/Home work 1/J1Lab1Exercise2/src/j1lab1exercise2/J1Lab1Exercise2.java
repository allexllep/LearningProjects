package j1lab1exercise2;
public class J1Lab1Exercise2 {
    public static void main(String[] args) {
        int year = 2000;
        int dayNum = 309;
        int[] daysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int monthNum = 0;
        boolean isLeapYear = (year%4==0)&&(year%100!=0||year%400==0);
        
        for (int days : daysInMonths) {
            if ((days==28)&&(isLeapYear==true)) days++;
            if (dayNum <= days) break;
            dayNum-=days;
            monthNum++;
        }
        System.out.println(months[monthNum] + " " + dayNum);  
    }   
}
