package creational;

//object cloning
//clonning: two types:
// i. shallow clonning
// ii. deep clonning

import java.util.ArrayList;
import java.util.List;

class Book {
    private int bookID;
    private String bookName;

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}


class BookShop implements Cloneable{
    private String shopName;
    private List<Book> bookList = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void loadDataFromDatabaseServer(){
        for(int i=0;i<10;i++) {
            Book b = new Book();
            b.setBookID(i);
            b.setBookName("Book"+i);

            getBookList().add(b);
        }
    }

    //shallow cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //Deep cloning
//    @Override
//    protected BookShop clone() throws CloneNotSupportedException {
//        BookShop shop = new BookShop();
//        for (Book b: this.getBookList()){
//            shop.getBookList().add(b);
//        }
//        return shop;
//    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException{
        BookShop bs  = new BookShop();
        bs.setShopName("Amazon");
        bs.loadDataFromDatabaseServer();

        System.out.println(bs);

        //create another book shop
//        BookShop bs1 = new BookShop(); //but it will take much time to load data again from database. so we clone bs
//        bs1.setShopName("StarTec");
//        System.out.println(bs1);

        bs.getBookList().remove(3);

        //shallow clone*****
        //need to implement cloneable interface in bookShop and typecast it here
        //throw a clonenotsupportexception
        BookShop bs1 = (BookShop) bs.clone();
        bs1.setShopName("StarTec");
        System.out.println(bs1);

        //Deep cloning*** better to do
        //we will create two object
//        BookShop bs2 = bs.clone();
//        bs2.setShopName("DeepClone");
//        System.out.println(bs2);
    }

}
