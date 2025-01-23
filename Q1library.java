package cpm.projectday23;
//1. Library Management SystemDescription: A simple program to manage book records, borrowers, and transactions.

//Features:Classes: Book, Member, Transaction.methods: Add, update, delete books/members, issue/return books.File handling to persist data.

import java.io.*;
import java.util.*;

// Class: BookRecord
class BookRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private int bookId;
    private String bookName;
    private boolean isBorrowed;

    public BookRecord(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.isBorrowed = false;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Name: " + bookName + ", Borrowed: " + isBorrowed;
    }
}

// Class: LibraryUser
class LibraryUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private int userId;
    private String userName;

    public LibraryUser(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + userName;
    }
}

// Class: LibraryManager
class LibraryManager {
    private List<BookRecord> bookList = new ArrayList<>();
    private List<LibraryUser> userList = new ArrayList<>();

    public void addBook(BookRecord book) {
        bookList.add(book);
        System.out.println("Book added: " + book);
    }

    public void addUser(LibraryUser user) {
        userList.add(user);
        System.out.println("User added: " + user);
    }

    public void issueBook(int bookId, int userId) {
        BookRecord book = findBook(bookId);
        if (book != null && !book.isBorrowed()) {
            book.borrowBook();
            System.out.println("Book issued to User ID: " + userId);
        } else {
            System.out.println("Book is already borrowed or not found.");
        }
    }

    public void returnBook(int bookId) {
        BookRecord book = findBook(bookId);
        if (book != null && book.isBorrowed()) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book is not borrowed or not found.");
        }
    }

    public void saveLibraryData(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(bookList);
            out.writeObject(userList);
        }
        System.out.println("Library data saved to: " + fileName);
    }

    public void loadLibraryData(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            bookList = (List<BookRecord>) in.readObject();
            userList = (List<LibraryUser>) in.readObject();
        }
        System.out.println("Library data loaded from: " + fileName);
    }

    private BookRecord findBook(int bookId) {
        for (BookRecord book : bookList) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}

// Main Class: b11
public class Q1library {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();

        try {
            // Add books and users
            libraryManager.addBook(new BookRecord(101, "Java Basics"));
            libraryManager.addBook(new BookRecord(102, "Python Fundamentals"));
            libraryManager.addUser(new LibraryUser(201, "Alice"));
            libraryManager.addUser(new LibraryUser(202, "Bob"));

            // Issue and return books
            libraryManager.issueBook(101, 201);
            libraryManager.returnBook(101);

            // Save and load library data
            libraryManager.saveLibraryData("libraryData.ser");
            libraryManager.loadLibraryData("libraryData.ser");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}