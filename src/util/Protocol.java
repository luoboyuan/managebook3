package util;

import model.Book;

/**
 * 用于客户端向用户端的信息打包
 * @author Administrator
 * @Time 2016年4月
 *
 */
public class Protocol {
	public Protocol() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param 用于根据作者信息查询书籍的相关信息打包
	 */
	public String getSearchByAuthor(String message)
	{
		return "searchByBookAuthor\n"+message;
	}

	/**
	 * @param 用于根据书籍名字信息查询书籍的相关信息打包
	 */
	public String getSearchByBookName(String message)
	{
		return "searchByBookName\n"+message;
	}
	
	/**
	 * @param 用于根据书籍编号信息查询书籍的相关信息打包
	 */
	public String getSearchByBookID(String message)
	{
		return "searchByBookID\n"+message;
	}
	
	/**
	 * @param 用于删除图书的相关信息打包
	 */
	public String getDeleteBook(String message)
	{
		return "deleteBook\n"+message;
	}
	
	/**
	 * @param 用于修改图书的相关信息打包
	 */
	public String getUpdataBook(Book book,Book book1)
	{
		return "updataBook\n"+book.bookName+","+book.author+"\n"+book1.bookId+","+book1.bookName+","+book1.author+","+book1.price;
	}
	
	/**
	 * @param 用于增加图书的相关信息打包
	 */
	public String getAddBook(Book book)
	{
		return "addBook\n"+book.bookId+","+book.bookName+","+book.author+","+book.price;
	}
	
	public static void main(String[] args) {
		Protocol a=new Protocol();
        String temp=a.getDeleteBook("luoanxin");
        System.out.print(temp);
	}

}
