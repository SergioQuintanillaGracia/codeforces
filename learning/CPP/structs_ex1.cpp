#include <iostream>
#include <vector>

struct Book {
    std::string title;
    std::string author;
    bool isCheckedOut;

    Book(const std::string& t, const std::string& a) : title(t), author(a), isCheckedOut(false) {}

    void showInfo() const {
        std::cout << "Title: " << title << " | Author: " << author << " | Is checked out: " << isCheckedOut << std::endl;
    }
};

struct Patron {
    std::string name;
    std::vector<Book> checkedBooks;

    Patron(const std::string& n) : name(n) {}

    virtual void addBook(Book& b) {
        b.isCheckedOut = true;
        checkedBooks.push_back(b);
    }

    void returnBook(Book& b) {
        for (size_t i = 0; i < checkedBooks.size(); i++) {
            Book& book = checkedBooks.at(i);

            if (book.title == b.title) {
                // The book has been found
                checkedBooks.at(i).isCheckedOut = false;
                checkedBooks.erase(checkedBooks.begin() + i);
                break;
            }
        }
    }

    void showInfo() const {
        std::cout << "Checked books for patron " << name << std::endl;

        for (const Book& b : checkedBooks) {
            b.showInfo();
        }
    }
};

struct SpecialPatron : Patron {
private:
    int checkOutLimit;

public:
    SpecialPatron(const std::string& n, int col) : Patron(n), checkOutLimit(col) {}

    void addBook(Book& b) override {
        if  (checkedBooks.size() < checkOutLimit) {
            Patron::addBook(b);
        
        } else {
            std::cout << "ERROR: Couldn't add book to SpecialPatron (check out limit reached)\n";
        }
    }
};