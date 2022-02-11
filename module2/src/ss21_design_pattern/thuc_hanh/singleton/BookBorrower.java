package ss21_design_pattern.thuc_hanh.singleton;

public class BookBorrower {
    private BookSingleton borrowedBook;
    private boolean haveBook = false;

    public void borrowBook() {
        borrowedBook = BookSingleton.borrowBook();

        if (borrowedBook!=null){
            haveBook= false;
        }else {
            haveBook= false;
        }
    }

    public String getAuthorAndTitle() {
        if (haveBook) {
            return borrowedBook.getAuthorAndTitle();
        }
        return "i don'have a book";
    }
    public void returnBook(){
        borrowedBook.returnBook(borrowedBook);
    }
}
