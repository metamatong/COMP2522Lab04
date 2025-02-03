package ca.bcit.comp2522.bookstore;

/**
 * A class to accurately represent a date consisting of year, month, and day.
 * @author Kyle Cheon
 * @author Shawn Lee
 * @version 1.0
 */
public class Date implements Printable
{
    private static final int EARLIEST_YEAR = 1800;
    private static final int CURRENT_YEAR = 2025;

    private static final String STRING_JANUARY = "January";
    private static final String STRING_FEBRUARY = "February";
    private static final String STRING_MARCH = "March";
    private static final String STRING_APRIL = "April";
    private static final String STRING_MAY = "May";
    private static final String STRING_JUNE = "June";
    private static final String STRING_JULY = "July";
    private static final String STRING_AUGUST = "August";
    private static final String STRING_SEPTEMBER = "September";
    private static final String STRING_OCTOBER = "October";
    private static final String STRING_NOVEMBER = "November";
    private static final String STRING_DECEMBER = "December";

    private static final int MONTH_JANUARY = 1;
    private static final int MONTH_FEBRUARY = 2;
    private static final int MONTH_MARCH = 3;
    private static final int MONTH_APRIL = 4;
    private static final int MONTH_MAY = 5;
    private static final int MONTH_JUNE = 6;
    private static final int MONTH_JULY = 7;
    private static final int MONTH_AUGUST = 8;
    private static final int MONTH_SEPTEMBER = 9;
    private static final int MONTH_OCTOBER = 10;
    private static final int MONTH_NOVEMBER = 11;
    private static final int MONTH_DECEMBER = 12;

    private static final int CODE_JANUARY = 1;
    private static final int CODE_FEBRUARY = 4;
    private static final int CODE_MARCH = 4;
    private static final int CODE_APRIL = 0;
    private static final int CODE_MAY = 2;
    private static final int CODE_JUNE = 5;
    private static final int CODE_JULY = 0;
    private static final int CODE_AUGUST = 3;
    private static final int CODE_SEPTEMBER = 6;
    private static final int CODE_OCTOBER = 1;
    private static final int CODE_NOVEMBER = 4;
    private static final int CODE_DECEMBER = 6;

    private static final int CODE_SATURDAY = 0;
    private static final int CODE_SUNDAY = 1;
    private static final int CODE_MONDAY = 2;
    private static final int CODE_TUESDAY = 3;
    private static final int CODE_WEDNESDAY = 4;
    private static final int CODE_THURSDAY = 5;
    private static final int CODE_FRIDAY = 6;

    private static final int LEAP_YEAR_OFFSET = 6;
    private static final int MILLENNIUM_OFFSET = 6;
    private static final int NINETEENTH_CENTURY_OFFSET = 2;

    private static final int LAST_TWO_DIGIT_EXTRACTOR = 100;
    private static final int NUMBER_OF_MONTHS = 12;
    private static final int NUMBER_OF_WEEKDAYS = 7;
    private static final int DENOMINATOR_FOUR = 4;

    private static final int FIRST_DAY_OF_THE_MONTH = 1;
    private static final int LAST_DAY_OF_THE_LONG_MONTH = 31;
    private static final int LAST_DAY_OF_THE_SHORT_MONTH = 30;
    private static final int LAST_DAY_OF_THE_LEAP_YEAR_FEBRUARY = 29;
    private static final int LAST_DAY_OF_THE_FEBRUARY = 28;

    private static final int LEAP_YEAR_DENOMINATOR = 4;
    private static final int LEAP_YEAR_DENOMINATOR_COMMON_MULTIPLE = 400;
    private static final int NO_REMAINDER = 0;
    private static final int MILLENNIUM_MAX_FOR_LEAP_YEAR = 2099;
    private static final int MILLENNIUM_MIN_FOR_LEAP_YEAR = 2000;
    private static final int NINETEENTH_CENTURY_MAX_FOR_LEAP_YEAR = 1899;
    private static final int NINETEENTH_CENTURY_FOR_LEAP_YEAR = 1800;
    private static final int ZERO_OFFSET = 0;

    private final int year;
    private final int month;
    private final int day;

    /**
     * A constructor to instantiate a Date object.
     * @param year the year of the date.
     * @param month the month of the date.
     * @param day the day of the date.
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(year, month, day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * A getter to fetch day of the Date object.
     * @return the day of the Date object.
     */
    public int getDay()
    {
        return this.day;
    }

    /**
     * A getter to fetch month of the Date object.
     * @return the month of the Date object.
     */
    public String getMonth()
    {
        switch (this.month)
        {
            case MONTH_JANUARY:
                return STRING_JANUARY;
            case MONTH_FEBRUARY:
                return STRING_FEBRUARY;
            case MONTH_MARCH:
                return STRING_MARCH;
            case MONTH_APRIL:
                return STRING_APRIL;
            case MONTH_MAY:
                return STRING_MAY;
            case MONTH_JUNE:
                return STRING_JUNE;
            case MONTH_JULY:
                return STRING_JULY;
            case MONTH_AUGUST:
                return STRING_AUGUST;
            case MONTH_SEPTEMBER:
                return STRING_SEPTEMBER;
            case MONTH_OCTOBER:
                return STRING_OCTOBER;
            case MONTH_NOVEMBER:
                return STRING_NOVEMBER;
            case MONTH_DECEMBER:
                return STRING_DECEMBER;
            default:
                throw new IllegalArgumentException("Invalid month value: " + this.month);
        }
    }

    /**
     * A getter to fetch year of the Date object.
     * @return the year of the Date object.
     */
    public int getYear()
    {
        return this.year;
    }

    /**
     * Returns date of the Date object in a YYYY-MM-DD format.
     * @return formatted date string
     */
    public String getYyyyMmDd()
    {
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }

    /**
     * Returns the weekday of the Date object.
     * First, the method will obtain last two digits of the instance's year.
     * This method will first calculate the number of NUMBER_OF_MONTHSs in last two digits of the year.
     * Then, it will also calculate the remainder of the previous step.
     * Then, it will calculate the remainder of the last two digits by dividing it by DENOMINATOR_FOUR.
     * Afterward, Add the previous results with the day of the Date object.
     * Finally, add the month code derived by getMonthCode method and divide it by NUMBER_OF_WEEKDAYS.
     * This method will return the corresponding weekday by figuring out the code for the weekdays.
     * <p>
     * Extra notes:
     * a) for January/February dates in leap years, add 6 at the start
     * b) for all dates in the 2000s, add 6 at the start
     * c) for all dates in the 1800s, add 2 at the start
     *
     * @return weekday in string
     */
    public String getDayOfTheWeek()
    {
        final int lastTwoDigits;
        final int firstStep;
        final int secondStep;
        final int thirdStep;
        final int fourthStep;
        final int fifthStep;
        final int sixthStep;

        lastTwoDigits = this.year % LAST_TWO_DIGIT_EXTRACTOR;
        firstStep = ( lastTwoDigits / NUMBER_OF_MONTHS ) + getOffset(this.year, this.month);
        secondStep = lastTwoDigits % NUMBER_OF_MONTHS;
        thirdStep = lastTwoDigits / DENOMINATOR_FOUR;
        fourthStep = this.day + firstStep + secondStep + thirdStep;
        fifthStep = fourthStep + getMonthCode(this.month);
        sixthStep = fifthStep % NUMBER_OF_WEEKDAYS;

        switch (sixthStep)
        {
            case CODE_SATURDAY:
                return "Saturday";
            case CODE_SUNDAY:
                return "Sunday";
            case CODE_MONDAY:
                return "Monday";
            case CODE_TUESDAY:
                return "Tuesday";
            case CODE_WEDNESDAY:
                return "Wednesday";
            case CODE_THURSDAY:
                return "Thursday";
            case CODE_FRIDAY:
                return "Friday";
            default:
                throw new IllegalArgumentException("Invalid result for month code.");
        }
    }

    /*
     * Validates the given year by checking if the year is in between NINETEENTH_CENTURY_FOR_LEAP_YEAR and CURRENT_YEAR
     * and throw an IllegalArgumentException if not.
     */
    private static void validateYear(final int year)
    {
        final boolean yearEarly;
        final boolean yearLate;
        final boolean invalidYear;

        yearEarly = year < EARLIEST_YEAR;
        yearLate = year > CURRENT_YEAR;
        invalidYear = yearEarly || yearLate;

        if (invalidYear)
        {
            throw new IllegalArgumentException("Year must be between 1800 and + " + CURRENT_YEAR);
        }
    }

    /*
     * Validates the given month by checking if the month is in between MONTH_JANUARY and MONTH_DECEMBER
     * and throw an IllegalArgumentException if not.
     */
    private static void validateMonth(final int month)
    {
        final boolean monthAboveDecember;
        final boolean monthBelowJanuary;
        final boolean invalidMonth;

        monthAboveDecember = month > MONTH_DECEMBER;
        monthBelowJanuary = month < MONTH_JANUARY;
        invalidMonth = monthAboveDecember || monthBelowJanuary;

        if (invalidMonth)
        {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }
    }

    /*
     * Validates the given day by checking if the day is in between FIRST_DAY_OF_THE_MONTH and LAST_DAY_OF_THE_MONTH
     * and if the month holds only DAY_BEFORE_LAST_DAY_OF_THE_MONTH days, it checks if the given day is in between
     * FIRST_DAY_OF_THE_MONTH and DAY_BEFORE_LAST_DAY_OF_THE_MONTH. If the month is MONTH_FEBRUARY, it checks if the
     * given day is in between FIRST_DAY_OF_THE_MONTH and LAST_DAY_OF_THE_FEBRUARY or
     * LAST_DAY_OF_THE_LEAP_YEAR_FEBRUARY depending on whether the year is the leap year. If any of the conditions
     * are not met, it will throw an IllegalArgumentException if not.
     */
    private static void validateDay(final int year,
                                    final int month,
                                    final int day)
    {
        final boolean dayValid;
        final boolean exceedMaxDay;
        final boolean exceedFebruary;
        final boolean exceedLeapFebruary;
        final boolean exceedShortMaxDay;


        dayValid = day < FIRST_DAY_OF_THE_MONTH ||
                day > LAST_DAY_OF_THE_LONG_MONTH;
        exceedMaxDay = (day > LAST_DAY_OF_THE_SHORT_MONTH) && (
                month == MONTH_APRIL ||
                        month == MONTH_JUNE ||
                        month == MONTH_SEPTEMBER ||
                        month == MONTH_NOVEMBER);
        exceedFebruary = month == MONTH_FEBRUARY &&
                !isLeapYear(year) &&
                day > LAST_DAY_OF_THE_FEBRUARY;
        exceedLeapFebruary = month == MONTH_FEBRUARY &&
                isLeapYear(year) &&
                day > LAST_DAY_OF_THE_LEAP_YEAR_FEBRUARY;
        exceedShortMaxDay = day > LAST_DAY_OF_THE_SHORT_MONTH;

        validateMonth(month);
        if (dayValid)
        {
            throw new IllegalArgumentException("Day must be between 1 and 31.");
        } else if (exceedMaxDay)
        {
            throw new IllegalArgumentException("Day must be between 1 and 30 for April, June, September, November.");
        } else if (exceedFebruary)
        {
            throw new IllegalArgumentException("Day must be between 1 and 28 for February.");
        } else if (exceedLeapFebruary)
        {
            throw new IllegalArgumentException("Day must be between 1 and 29 for February in leap year.");
        } else if (exceedShortMaxDay)
        {
            throw new IllegalArgumentException("Day must be between 1 and 30 for January, March, May, July, August," +
                    " October, December.");
        }
    }

    /*
     * Determines if the given year is a leap year. It will divide the given year with LEAP_YEAR_DENOMINATOR_FOUR,
     * LAST_TWO_DIGIT_EXTRACTOR, and LEAP_YEAR_DENOMINATOR_FOUR_HUNDRED to check for remainder and determine whether
     * it is a leap year.
     */
    private static boolean isLeapYear(final int year)
    {
        final boolean noRemainder;
        final boolean noRemainderCentury;
        final boolean noRemainderCommonMultiple;

        noRemainder = year % LEAP_YEAR_DENOMINATOR == NO_REMAINDER;
        noRemainderCentury = year % LAST_TWO_DIGIT_EXTRACTOR == NO_REMAINDER;
        noRemainderCommonMultiple = year % LEAP_YEAR_DENOMINATOR_COMMON_MULTIPLE == NO_REMAINDER;

        if (noRemainder)
        {
            if (noRemainderCentury)
            {
                return noRemainderCommonMultiple;
            }
            return true;
        }
        return false;
    }

    /*
     * Returns the code of month required for calculating weekday in getDayOfTheWeek method.
     */
    private static int getMonthCode(final int month)
    {
        switch (month)
        {
            case MONTH_JANUARY:
                return CODE_JANUARY;
            case MONTH_FEBRUARY:
                return CODE_FEBRUARY;
            case MONTH_MARCH:
                return CODE_MARCH;
            case MONTH_APRIL:
                return CODE_APRIL;
            case MONTH_MAY:
                return CODE_MAY;
            case MONTH_JUNE:
                return CODE_JUNE;
            case MONTH_JULY:
                return CODE_JULY;
            case MONTH_AUGUST:
                return CODE_AUGUST;
            case MONTH_SEPTEMBER:
                return CODE_SEPTEMBER;
            case MONTH_OCTOBER:
                return CODE_OCTOBER;
            case MONTH_NOVEMBER:
                return CODE_NOVEMBER;
            case MONTH_DECEMBER:
                return CODE_DECEMBER;
            default:
                throw new IllegalArgumentException("Invalid month value: " + month);
        }
    }

    /*
     * Returns the offset required for calculating weekday of the given Date.
     */
    private static int getOffset(final int year,
                                 final int month)
    {
        final boolean janOrFeb;
        final boolean validYearRange;
        final boolean nineteenthCentury;



        janOrFeb = month == MONTH_JANUARY ||
                month == MONTH_FEBRUARY;
        validYearRange = year <= MILLENNIUM_MAX_FOR_LEAP_YEAR &&
                year >= MILLENNIUM_MIN_FOR_LEAP_YEAR;
        nineteenthCentury = year <= NINETEENTH_CENTURY_MAX_FOR_LEAP_YEAR &&
                year >= NINETEENTH_CENTURY_FOR_LEAP_YEAR;

        if (janOrFeb && isLeapYear(year))
        {
            return LEAP_YEAR_OFFSET;
        } else if (validYearRange)
        {
            return MILLENNIUM_OFFSET;
        } else if (nineteenthCentury)
        {
            return NINETEENTH_CENTURY_OFFSET;
        }
        return ZERO_OFFSET;
    }

    /**
     * This method overrides display() method from Printable and
     * prints every instance variable to the console.
     */
    @Override
    public void display() {
        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
    }
}
