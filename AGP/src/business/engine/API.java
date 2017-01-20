package business.engine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import business.model.Excursion;


import lucene.LuceneTester;

public class API {
	private  ArrayList<Excursion> excursionList = new ArrayList<Excursion>();
/*
	public static void main(String args[]) {

	 //seperate("select * from excursion with cuisine");
	 //System.out.println(q[1]);
		// ArrayList<Excursion> test = seperateRequest("select DISTINCT * from excursion with cuisine");
 	
		 for(Excursion ex : test){
			 System.out.println(ex);
		 }
		 */
	/*	 ArrayList<Excursion> test =new ArrayList<Excursion>();
		 String key="Cuisine";
		 String s=mixedRequest(key);
		 test=seperateRequest(s);
		 
		 for(Excursion ex : test){
			 System.out.println(ex);
		 }*/
	// }
	 
	 public  String mixedRequest(String keyword){
		 String result ="";
		 result = "select * from excursion with "+keyword;
		 return result;
		 
	 }

	public  void seperate(String q) {
		
		LuceneTester l = new LuceneTester();
		SearchExcursion s=new SearchExcursion();
		String Str = new String(q);
		
		String[] query = Str.split("with ");

		l.searchByKeyword(query[1]);
		
		for(int i=0;i<l.getRes().size();i++){
			//System.out.println(s.SearchById(Integer.parseInt(l.getRes().get(i)),query[0]));
//			System.out.println(l.getRes().get(i));
		}
		
	}
	
	public  ArrayList<Excursion> seperateRequest(String q) {
		
		LuceneTester l = new LuceneTester();
		String Str = new String(q);
		
		String[] query = Str.split("with ");

		l.searchByKeyword(query[1]);
		
		/*for(int i=0;i<l.getRes().size();i++){
			excursionList.add(s.SearchById2(Integer.parseInt(l.getRes().get(i)),query[0]));
			System.out.println(Integer.parseInt(l.getRes().get(i)));	
			System.out.println(query[0]);
		}*/
		for(int j = 0;j<l.getRes().size();j++ ){
			SearchExcursion s= new SearchExcursion();
		
			excursionList.add(s.SearchById2(Integer.parseInt(l.getRes().get(j)), query[0]));
		}
		
		return excursionList;
		
	}

	public  ArrayList<Excursion> getExcursionList() {
		return excursionList;
	}

	public  void setExcursionList(ArrayList<Excursion> excursionList) {
		this.excursionList = excursionList;
	}
	

}
