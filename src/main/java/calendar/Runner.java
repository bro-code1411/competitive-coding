package calendar;

public class Runner {
    private static Object CalendarManagementService;

    public static void main(String args[]){
        CalendarManagementService = new CalendarManagementServiceImpl();
    }
}
