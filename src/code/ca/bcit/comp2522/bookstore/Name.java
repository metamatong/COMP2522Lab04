package ca.bcit.comp2522.bookstore;

/**
 * A class to represent a full name of a person.
 * @author Kyle Cheon
 * @author Tommy Nguyen
 * @version 1.0
 */
public class Name implements Printable
{
    private final String first;
    private final String last;

    /*
     * A constructor to instantiate a Name object.
     * @param first the first name of the Name instance.
     * @param last the last name of the Name instance.
     */
    Name(final String first,
         final String last)
    {
        validateName(first);
        validateName(last);
        this.first = first;
        this.last = last;
    }

    /*
     * Validates name in string whether they are blank, null, or longer than 50 characters.
     */
    private void validateName(final String name)
    {
        final boolean blank;
        final boolean longerThanFifty;

        blank = name == null || name.isEmpty();
        if(blank)
        {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        longerThanFifty = name.length() >= 50;

        if(longerThanFifty)
        {
            throw new IllegalArgumentException("Name cannot exceed 50 characters");
        }
    }

    /**
     * This method overrides display() method from Printable and
     * prints full name of the Name instance.
     */
    @Override
    public void display()
    {
        System.out.println("The Full Name: " + first + " " + last);
    }
}
