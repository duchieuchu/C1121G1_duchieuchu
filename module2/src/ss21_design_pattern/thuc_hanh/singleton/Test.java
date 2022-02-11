package ss21_design_pattern.thuc_hanh.singleton;

public class Test {
    public static void main(String[] args) {
        System.out.println("BEGIN TESTING SINGLETON PATTERN");
        BookBorrower bookBorrower1 = new BookBorrower();
        BookBorrower bookBorrower2= new BookBorrower();

        bookBorrower1.borrowBook();
        System.out.println("BookBorrower1 asked to borrow the book");
        System.out.println("BookBorrower1 author and title");
        System.out.println(bookBorrower1.getAuthorAndTitle());

        bookBorrower2.borrowBook();
        System.out.println("BookBorrower2 asked to borrow the book");
        System.out.println("BookBorrower2 author and title");
        System.out.println(bookBorrower2.getAuthorAndTitle());

        bookBorrower1.returnBook();
        System.out.println("BookBorrower1 returned the book");

        bookBorrower2.borrowBook();
        System.out.println("BookBorrower2 author and title");
        System.out.println(bookBorrower2.getAuthorAndTitle());

        System.out.println("END TESTING SINGLETON PATTERN");

    }
}
