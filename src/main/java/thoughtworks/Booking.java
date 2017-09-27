package thoughtworks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ruidli on 2017/9/11.
 */
public class Booking {
    public static HashMap<String, List<Book>> map = new HashMap<>();
    static List<String> placeList = new ArrayList<>();
    static String reg = "^U[0-9](.*?) ([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))) ([01][0-9]|2[0-3]):00~([01][0-9]|2[0-3]):00 [ABCD]?[ ]?[C]?";
    static Pattern p = Pattern.compile(reg);

    public static void main(String args[]) {
        placeList.add("A");
        placeList.add("B");
        placeList.add("C");
        placeList.add("D");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.length() == 0) {
                printAll();
            }
            Matcher matcher = p.matcher(s);
            if (!matcher.find()) {
                System.out.println("Error: the booking is invalid!");
            }
            String[] str = s.split(" ");
            if (str.length == 4) {// means  booking
                book(str);
            } else {
                cancel(str);
            }
        }
    }

    static void printAll() {
        System.out.println("收入汇总");
        System.out.println("---");
        int all = 0;
        for (int index = 0; index < placeList.size(); index++) {
            if (map.get(placeList.get(index)) != null && map.get(placeList.get(index)).size() != 0) {
                int sum = print(map.get(placeList.get(index)), placeList.get(index));
                all += sum;
            }
        }
        System.out.println("---");
        System.out.println("总计：" + all + "元");
    }

    static int print(List<Book> list, String place) {
        System.out.println("场地:" + place);
        String status;
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            status = list.get(i).status == 1 ? "" : "违约金";
            System.out.println(list.get(i).printDate + " " + list.get(i).printStart + "~" + list.get(i).printEnd +
                    status + " " + list.get(i).fee + "元");
            sum += list.get(i).fee;
        }
        System.out.println("小计:" + sum + "元");
        return sum;
    }

    static void book(String[] str) {
        String uId = str[0];
        String date = str[1];
        String startTime = str[2].split("~")[0];
        String endTime = str[2].split("~")[1];
        Calendar startCalendar = getTime(date + " " + startTime);
        Calendar endCalendar = getTime(date + " " + endTime);
        if (!startCalendar.before(endCalendar)) {
            System.out.println("Error: the booking is invalid!");
            return;
        }
        String place = str[3];
        List<Book> values = map.get(place);
        if (values != null && values.size() != 0) {
            for (Book book : map.get(place)) {
                if (startCalendar.after(book.startTime) && startCalendar.before(book.endTime)
                        || (endCalendar.after(book.startTime) && endCalendar.before(book.endTime))) {
                    System.out.println("Error: the booking conflicts with existing bookings!");
                    return;
                }
            }
        }
        if (values == null) {
            values = new ArrayList<>();
        }
        double fee = calculateFee(startCalendar, endCalendar);
        values.add(new Book(uId, startCalendar, endCalendar, date, startTime, endTime, 1, place, fee));
        System.out.println("Success: the booking is accepted!");
    }

    static double calculateFee(Calendar start, Calendar end) {
        boolean isFirstSunday = (end.getFirstDayOfWeek() == Calendar.SUNDAY);
        int weekDay = end.get(Calendar.DAY_OF_WEEK);
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }
        double fee = 0;
        int startHour = start.get(Calendar.HOUR);
        int endHour = start.get(Calendar.HOUR);
        if (weekDay <= 5) {
            if (endHour >= 9 && endHour <= 12) {
                fee = (endHour - startHour) * 30;
                return fee;
            }
            if (endHour >= 12 && endHour <= 18) {
                fee = (endHour - startHour) * 50;
                return fee;
            }
            if (endHour >= 18 && endHour <= 20) {
                fee = (endHour - startHour) * 80;
                return fee;
            }
            if (endHour >= 20 && endHour <= 22) {
                fee = (endHour - startHour) * 60;
                return fee;
            }
            return -1;
        } else {
            if (endHour >= 9 && endHour <= 12) {
                fee = (endHour - startHour) * 40;
                return fee;
            }
            if (endHour >= 12 && endHour <= 18) {
                fee = (endHour - startHour) * 50;
                return fee;
            }
            if (endHour >= 18 && endHour <= 22) {
                fee = (endHour - startHour) * 60;
                return fee;
            }
        }
        return -1;
    }

    static void cancel(String[] str) {
        String uId = str[0];
        String date = str[1];
        String startTime = str[2].split("~")[0];
        String endTime = str[2].split("~")[1];
        Calendar startCalendar = getTime(date + " " + startTime);
        Calendar endCalendar = getTime(date + " " + endTime);
        String place = str[3];
        boolean isFirstSunday = (startCalendar.getFirstDayOfWeek() == Calendar.SUNDAY);
        int weekDay = startCalendar.get(Calendar.DAY_OF_WEEK);
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }
        List<Book> values = map.get(place);
        if (values != null && values.size() != 0) {
            for (Book book : map.get(place)) {
                if (book.uid == uId && book.startTime.equals(startCalendar) && book.endTime.equals(endCalendar)) {
                    if (weekDay <= 5) {
                        book.setFee(book.fee * 0.5);
                    } else {
                        book.setFee(book.fee * 0.3);
                    }
                    book.setStatus(0);
                    System.out.println("Success: the booking is accepted!");
                    return;
                }
            }
        }
        System.out.println("Error: the booking being cancelled does not exist!");
    }

    static Calendar getTime(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = sdf.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Book {
    String uid;
    Calendar startTime;
    Calendar endTime;
    String printDate;//为了输出的作用
    String printStart;
    String printEnd;
    int status; // 标志是否是取消的预定
    String place;
    double fee;

    public Book(String uid, Calendar startTime, Calendar endTime, String printDate, String printStart, String printEnd, int status, String place, double fee) {
        this.uid = uid;
        this.startTime = startTime;
        this.endTime = endTime;
        this.printDate = printDate;
        this.printStart = printStart;
        this.printEnd = printEnd;
        this.status = status;
        this.place = place;
        this.fee = fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
