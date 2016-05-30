package util;

import java.util.Scanner;
import java.util.Vector;

import model.Book;
import model.BookList;
import model.ReturnResult;

public class Parser {

	public Parser() {
		// TODO Auto-generated constructor stub
	}
    public ReturnResult parserSearchBook(String message){
    	ReturnResult returnResult = new ReturnResult();
    	
    	String head;
    	Scanner s = new Scanner(message).useDelimiter("\\s*,\\s*");
    	head=s.nextLine();
    	System.out.println(head);
    	
    	if(head.equals("success")){
    		
    		String bookId,bookName,bookAuthor,bookPriceTemp;
    		float bookPrice;
    		BookList bookList = new BookList();
    		Book book =null;
    		
    		while(s.hasNextLine()){
    		String temp=s.nextLine();
    		System.out.println(temp);
    		Scanner changge =new Scanner(temp).useDelimiter("\\s*,\\s*");
    		
//    		System.out.println(changge);
    		bookId=changge.next();
    		bookName=changge.next();
    		bookAuthor=changge.next();
//    		bookPriceTemp=changge.next();
    		bookPrice=changge.nextFloat();
//    		System.out.println(bookPrice);
    		
    		book=new Book(bookId,bookName,bookAuthor,bookPrice);
    		bookList.add(book);
    		}
    		returnResult.isSuccess=true;
    		returnResult.returnData=bookList;
    		return returnResult;
    	}
    	else{
    		returnResult.isSuccess=false;
    		returnResult.failreason=s.next();
    		return returnResult;
    	}
    	
    } 
    public ReturnResult parserBookOfAdd_Update_Delete(String message){
    	    	ReturnResult returnResult = new ReturnResult();
    	    	
    	    	String head;
    	    	Scanner s = new Scanner(message).useDelimiter("\\s*,\\s*");
    	    	head=s.nextLine();
    	    
                if(head.equals("success")){
                	returnResult.isSuccess=true;
                	String success=s.nextLine();
                	returnResult.returnData=success;
                	return returnResult;
                }
                else{
                	returnResult.isSuccess=false;
            		returnResult.failreason=s.nextLine();
            		return returnResult;
                }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String temp="success\nluoa,luoanxin,luoanyuan,998\nsda,java,luoanxin,888";
        Parser TEMP=new Parser();
        ReturnResult res=TEMP.parserSearchBook(temp);
        System.out.println(res.isSuccess);
        if(res.isSuccess){
        	for(int i=0;i<((Vector<Book>) res.returnData).size();i++){
        	System.out.println(((Vector<Book>) res.returnData).get(i).bookId);}
        }
        else{
        	System.out.println(res.failreason);    	
        }
        
	}

}
