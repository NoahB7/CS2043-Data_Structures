import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/********************************
Name: Noah Buchanan
Username: ua203
Problem Set: PS5
Due Date: July 7, 2020
********************************/


public class RunTesterUALinkedList {
	
	public static void main(String[] args) throws IOException {
		
		UALinkedList list = new UALinkedList();
		
		BufferedReader br = new BufferedReader(new FileReader("records.txt"));
		
		String line = "";
		
		while((line = br.readLine()) != null) {
			
			String [] x = line.split(",");
			
			UACourse y = new UACourse(Integer.parseInt(x[2]),x[0],x[1]);
			
			list.insert(y);
			
		}
		
		list.printList();//a
		
		list.printListReversed();//b
		
		System.out.println(list.find(12345));//c
		
		System.out.println(list.find(45678));//d
		
	
		UACourse gpu = new UACourse(44332,"GPU Programming", "A fun course");//e
		list.insert(gpu);//e
		
		System.out.println(list.find(12345));//f
		
		list.remove(45678);//g
		
		System.out.println(list.find(55555));//h
		
		UACourse nlp = new UACourse(44332, "Natural Language Processing" , "NLP class");//i
		list.insert(nlp);//i
		
		System.out.println(list.find(44332));//j
		
		list.printList();//k
	}

}
