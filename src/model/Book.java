package model;

public class Book {
    public String bookName;//����
    public String author;//����
    public float price;
    public String bookId;
    
    //��ʼ����
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
