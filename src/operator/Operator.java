package operator;

import model.Book;
import model.BookList;
import model.ReturnResult;
import net.Client;
import util.Parser;
import util.Protocol;
/**
 * �鼮����ϵͳ�пͻ������ܴ���Ĳ���
 * @author Administrator
 * @Time 2016��4��
 *
 */
public class Operator {

	public Operator() {
		// TODO Auto-generated constructor stub
	}
	
//	/**
//	 * @param arg ���ڲ�ѯ���е��鼮�ǵ���Ϣ
//	 */
//	public BookList searchAll()
//	{
//	    Protocol protocol = new Protocol();
//		String message = protocol.getSearchOfMessage("all");
//		String returnMessage = Client.sendMessageToServer(message);
//		Parser parser = new Parser();
//		ReturnResult returnResult = parser.parserSearchBook(returnMessage);
//		BookList bookList=null;
//		if(returnResult.isSuccess){
//	    bookList=(BookList) returnResult.returnData;
//	    }
//	    return bookList;
//	}
	
	
	/**
	 * @param args ��������ѹ����Ϣ�Լ���ѹ�ӷ������˷��͹�����ѹ��
	 */
	public ReturnResult searchByAthor(String authorName)
	{
		Protocol protocol = new Protocol();
		String message = protocol.getSearchByAuthor(authorName);
		String returnMessage = new Client().sendMessageToServer(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearchBook(returnMessage);
		return returnResult;
	}
	
	/**
	 * @param args ���������˷���ѹ����Ϣ�Լ���ѹ�ӷ������˷��͹�����ѹ��
	 */
	public ReturnResult searchByBookName(String bookName)
	{
		Protocol protocol = new Protocol();
		String message = protocol.getSearchByBookName(bookName);
		String returnMessage = new Client().sendMessageToServer(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearchBook(returnMessage);
		return returnResult;
	}
	
	/**
	 * @param args ���������˷���ѹ����Ϣ�Լ���ѹ�ӷ������˷��͹�����ѹ��
	 */
	public ReturnResult deleteBook(String bookID)
	{
		Protocol protocol = new Protocol();
		String message = protocol.getDeleteBook(bookID);
		
		String returnMessage = new Client().sendMessageToServer(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserBookOfAdd_Update_Delete(returnMessage);
		return returnResult;
	}
	
	/**
	 * @param args ���������˷���ѹ����Ϣ�Լ���ѹ�ӷ������˷��͹�����ѹ��
	 */
	public ReturnResult updateBook(Book book,Book book1)
	{
		Protocol protocol = new Protocol();
		String message = protocol.getUpdataBook(book,book1);
		String returnMessage =new Client().sendMessageToServer(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserBookOfAdd_Update_Delete(returnMessage);
		return returnResult;
	}
	
	/**
	 * @param args ���������˷���ѹ����Ϣ�Լ���ѹ�ӷ������˷��͹�����ѹ��
	 */
	public ReturnResult addBook(Book book)
	{
		Protocol protocol = new Protocol();
		String message = protocol.getAddBook(book);
		String returnMessage = new Client().sendMessageToServer(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserBookOfAdd_Update_Delete(returnMessage);
		return returnResult;
	}
	
	/**
	 * @param args ���������˷���ѹ����Ϣ�Լ���ѹ�ӷ������˷��͹�����ѹ��
	 */
	public ReturnResult searchByBookID(String bookID)
	{
		Protocol protocol = new Protocol();
		String message = protocol.getSearchByBookID(bookID);
		String returnMessage = new Client().sendMessageToServer(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearchBook(returnMessage);
		return returnResult;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}