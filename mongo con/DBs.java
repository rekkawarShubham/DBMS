package new1;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;


public class DBs {

	public static void main(String[] args) {
		Logger monLogger = Logger.getLogger("org.mongodb.driver");
		monLogger.setLevel(Level.SEVERE);
		Mongo mongo = new Mongo("localhost",27017);
		DB db = mongo.getDB("test");
		DBCollection collection = db.getCollection("NewMe");
	
		Scanner sc = new Scanner(System.in);
	    String key ,value,upvalue;
		int choice;
	     do
	     {
	    	 System.out.println("1.insert 2.update 3.delete 4 .display");
	    	 System.out.println("enter you choice");
	    	 choice = sc.nextInt();
	    	 
	    	 switch (choice) {
			case 1:
				    System.out.println("enter key and value");
				    System.out.println("enter key");
				    key = sc.next();
				    System.out.println("enter value");
				    value = sc.next();
				    
				    BasicDBObject db1 = new BasicDBObject();
				    db1.put(key, value);
				    collection.insert(db1);
				   System.out.println("inserted");
				    break;
				
			case 2:
				System.out.println("enter key and value to be updated");
			    System.out.println("enter key");
			    key = sc.next();
			    System.out.println("enter value");
			    value = sc.next();
			    System.out.println("enter the value to be updated");
			    upvalue = sc.next();
			    
			    
	            BasicDBObject db2 = new BasicDBObject();
	            db2.put(key, value);
	            DBCursor cur1 = collection.find(db2);
	            if(cur1.hasNext())
	            {
	                DBObject ob1 = cur1.next();
	                ob1.put(key, upvalue);
	                collection.save(ob1);  
	            }
	            System.out.println("updated document");
				break;
			case 3:
				System.out.println("enter key and value to be updated");
			    System.out.println("enter key");
			    key = sc.next();
			    System.out.println("enter value");
			    value = sc.next();
			    BasicDBObject db3 = new BasicDBObject();
	            db3.put(key, value);
	            DBCursor cur2 = collection.find(db3);
	            if(cur2.hasNext())
	            {
	                DBObject ob1 = cur2.next();
	                collection.remove(ob1);  
	            }
	        	System.out.println("deleted document");
				break;
			case 4: 
				BasicDBObject db4 =  new BasicDBObject();
				DBCursor cur3 =  collection.find(db4);
				  while(cur3.hasNext())
				  {
					System.out.println(cur3.next());  
				  }
				break;

			default:
				break;
			}    	 
	     }while(choice!=0);
	}
}