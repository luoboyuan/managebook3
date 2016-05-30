package util;

import model.Book;

/**
 * ���ڿͻ������û��˵���Ϣ���
 * @author Administrator
 * @Time 2016��4��
 *
 */
public class Protocol {
	public Protocol() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param ���ڸ���������Ϣ��ѯ�鼮�������Ϣ���
	 */
	public String getSearchByAuthor(String message)
	{
		return "searchByBookAuthor\n"+message;
	}

	/**
	 * @param ���ڸ����鼮������Ϣ��ѯ�鼮�������Ϣ���
	 */
	public String getSearchByBookName(String message)
	{
		return "searchByBookName\n"+message;
	}
	
	/**
	 * @param ���ڸ����鼮�����Ϣ��ѯ�鼮�������Ϣ���
	 */
	public String getSearchByBookID(String message)
	{
		return "searchByBookID\n"+message;
	}
	
	/**
	 * @param ����ɾ��ͼ��������Ϣ���
	 */
	public String getDeleteBook(String message)
	{
		return "deleteBook\n"+message;
	}
	
	/**
	 * @param �����޸�ͼ��������Ϣ���
	 */
	public String getUpdataBook(Book book,Book book1)
	{
		return "updataBook\n"+book.bookName+","+book.author+"\n"+book1.bookId+","+book1.bookName+","+book1.author+","+book1.price;
	}
	
	/**
	 * @param ��������ͼ��������Ϣ���
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
