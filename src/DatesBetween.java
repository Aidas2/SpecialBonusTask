public class DatesBetween {

    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        for (int year = fromYear; year <= toYear; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= 31; day++) {
                    String monthAppended = month < 10 ? "0" + month : "" + month;
                    String dayAppended = day < 10 ? "0" + day : "" + day;
                    String date = year + monthAppended + dayAppended;

                    String reversedDay = new StringBuilder(dayAppended).reverse().toString();
                    String reversedMonth = new StringBuilder(monthAppended).reverse().toString();
                    String reversedYear = new StringBuilder("" + year).reverse().toString();
                    String reversedDate = reversedDay + reversedMonth + reversedYear;

                    if (isValidRange(reversedDate, fromYear, toYear) && isMirrored(date)) {
                        System.out.println(year + "-" + monthAppended + "-" + dayAppended);
                    }
                }
            }
        }
    }

    public static boolean isValidRange(String reversedDate, int startYear, int endYear) {
        String reversedYear = reversedDate.substring(0,4);
        String reversedMonth = reversedDate.substring(4,6);
        String reversedDay = reversedDate.substring(6);

        if (Integer.valueOf(reversedYear) >= startYear && Integer.valueOf(reversedYear) <= endYear &&
            Integer.valueOf(reversedMonth) >= 1 && Integer.valueOf(reversedMonth) <= 12 &&
            Integer.valueOf(reversedDay) >= 1 && Integer.valueOf(reversedDay) <= 31
        ) {
            return true;
        }
        return false;
    }

    public static boolean isMirrored(String date) {
        if (date.substring(0,4).equals(new StringBuilder(date.substring(4)).reverse().toString()) &&
            date.substring(4,6).equals(new StringBuilder(date.substring(2,4)).reverse().toString()) &&
            date.substring(6).equals(new StringBuilder(date.substring(0,2)).reverse().toString())
        ) {
            return true;
        }
        return false;
    }

}
