package ca.bcit.comp2522.bookstore;

/**
 * A class to represent a person.
 * @author Kyle Cheon
 * @author Tommy Nguyen
 * @version 1.0
 */
public class Person implements Comparable<Person>, Printable, Reversible
{
    private final Date dateOfBirth;
    private Date dateOfDeath;
    private final Name name;

    /*
     * A constructor to instantiate a Person object.
     * @param dateOfBirth the date of birth of the Person instance.
     * @param dateOfDeath the date of death of the Person instance.
     * @param name the full name of the Person instance.
     */
    Person(final Date dateOfBirth,
           final Date dateOfDeath,
           final Name name)
    {
        validateBirthDate(dateOfBirth);
        validateDeathDate(dateOfBirth, dateOfDeath);
        validateName(name);
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.name = name;
    }

    /**
     * An accessor method for the birthdate of the Person object.
     *
     * @return a Date for the birthdate of the Person object.
     */
    public Date getBirthDate()
    {
        return this.dateOfBirth;
    }

    /**
     * An accessor method for the death date of the Person object.
     * A death date of Person object can be a null.
     * @return a Date for the death date of the Person object.
     */
    public Date getDeathDate()
    {
        return this.dateOfDeath;
    }

    /**
     * This method overrides display() method from Printable and
     * prints every data of the Person instance.
     */
    @Override
    public void display()
    {
        final boolean deathDateNull;

        deathDateNull = dateOfDeath == null;

        System.out.println("Date of Birth: " + dateOfBirth);

        if(deathDateNull)
        {
            System.out.println("Date of Death: " + dateOfDeath);
        }

        System.out.println("Name: " + name);
    }

    /**
     * This method overrides backward() method from Reversible and
     * prints name of the Person instance backwards.
     */
    @Override
    public void backward()
    {
        final StringBuilder reversedFirstName;
        final StringBuilder reversedLastName;

        reversedFirstName = new StringBuilder(name.getFirstName());
        reversedLastName = new StringBuilder(name.getLastName());

        reversedLastName.reverse();
        reversedFirstName.reverse();

        System.out.println("Reversed Name: " +
                           reversedLastName +
                           " " +
                           reversedFirstName);
    }

    /**
     * This method overrides compareTo() method from Comparable and
     * returns integer according to age of the Person.
     * Older people are "larger" in terms of return value.
     */
    @Override
    public int compareTo(final Person o)
    {
        final int differenceByYear;
        final int differenceByMonth;
        final int differenceByDay;

        differenceByYear = o.getBirthDate().getYear() - this.getBirthDate().getYear();
        differenceByMonth = o.getBirthDate().getMonthInInteger() - this.getBirthDate().getMonthInInteger();
        differenceByDay = o.getBirthDate().getDay() - this.getBirthDate().getDay();

        if(differenceByYear != 0)
        {
            return differenceByYear;
        }
        if(differenceByMonth != 0)
        {
            return differenceByMonth;
        }
        return differenceByDay;
    }

    /*
     * Validates date of birth Date object whether they are null.
     */
    private void validateBirthDate(final Date dateOfBirth)
    {
        final boolean dateNull;

        dateNull = dateOfBirth == null;

        if(dateNull)
        {
            throw new IllegalArgumentException("Date cannot be null.");
        }
    }

    /*
     * Validates date of death Date object whether they are null or precedes the birthdate.
     */
    private void validateDeathDate(final Date dateOfBirth,
                                   final Date dateOfDeath)
    {
        final boolean dateNull;
        final boolean deathPrecedesBirthByYear;
        final boolean deathPrecedesBirthByMonth;
        final boolean deathPrecedesBirthByDay;

        dateNull = dateOfBirth == null;

        if(dateNull)
        {
            throw new IllegalArgumentException("Date cannot be null.");
        }

        deathPrecedesBirthByYear = dateOfDeath.getYear() > dateOfBirth.getYear();
        deathPrecedesBirthByMonth = dateOfDeath.getYear() >= dateOfBirth.getYear() &&
                                   dateOfDeath.getMonthInInteger() > dateOfBirth.getMonthInInteger();
        deathPrecedesBirthByDay = dateOfDeath.getYear() >= dateOfBirth.getYear() &&
                                 dateOfDeath.getMonthInInteger() >= dateOfBirth.getMonthInInteger() &&
                                 dateOfDeath.getMonthInInteger() > dateOfBirth.getMonthInInteger();

        if(deathPrecedesBirthByYear ||
           deathPrecedesBirthByMonth ||
           deathPrecedesBirthByDay)
        {
            throw new IllegalArgumentException("Death precedes birth date.");
        }
    }

    /*
     * Validates Name object whether they are null.
     */
    private void validateName(final Name name)
    {
        final boolean nameNull;

        nameNull = name == null;

        if(nameNull)
        {
            throw new IllegalArgumentException("Name cannot be null.");
        }
    }
}
