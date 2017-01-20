package business.engine;

import java.io.*;

import lucene.LuceneTester;

public class API {

	 public static void main(String args[]) {

	 seperate("select * from excursion with cuisine");
	 //System.out.println(q[1]);
	 }

	public static void seperate(String q) {
		
		LuceneTester l = new LuceneTester();
		SearchExcursion s=new SearchExcursion();
		String Str = new String(q);
		
		String[] query = Str.split("with ");

		l.searchByKeyword(query[1]);
		
		for(int i=0;i<l.getRes().size();i++){
			System.out.println(s.SearchById(Integer.parseInt(l.getRes().get(i)),query[0]));
			System.out.println(l.getRes().get(i));
		}
		
	}

}
