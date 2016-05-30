package model;

public class Book {
    public String bookName;//书名
    public String author;//作者
    public float price;
    public String bookId;
    
    //初始化类
  public  Book(String Id,String bookName,String author,float price){
	    this.bookId=Id;
    	this.bookName=bookName;
    	this.author=author;
    	this.price=price;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
