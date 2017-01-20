package lucene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneTester {
	
   String indexDir = "./index";
   String dataDir = "./data";
   Indexer indexer;
   Searcher searcher;
   
   private List<String> res=new ArrayList<String>();
   
   public  void searchByKeyword(String keyword) {
      try {
         this.createIndex();
         this.search(keyword);
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }

   private void createIndex() throws IOException{
      indexer = new Indexer(indexDir);
      int numIndexed;
      long startTime = System.currentTimeMillis();	
      numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
      long endTime = System.currentTimeMillis();
      indexer.close();
      //System.out.println(numIndexed+" File indexed, time taken: "
      //   +(endTime-startTime)+" ms");		
   }



private void search(String searchQuery) throws IOException, ParseException{
      searcher = new Searcher(indexDir);
      long startTime = System.currentTimeMillis();
      TopDocs hits = searcher.search(searchQuery);
      long endTime = System.currentTimeMillis();
   
      //System.out.println(hits.totalHits +
      //   " documents found. Time :" + (endTime - startTime));
      for(ScoreDoc scoreDoc : hits.scoreDocs) {
         Document doc = searcher.getDocument(scoreDoc);
          //  System.out.println("File: "
          //  + doc.get(LuceneConstants.FILE_NAME).substring(0,doc.get(LuceneConstants.FILE_NAME).indexOf('.')));
     this.res.add(doc.get(LuceneConstants.FILE_NAME).substring(0,doc.get(LuceneConstants.FILE_NAME).indexOf('.')));
      
      }
      
		for(int i=0;i<res.size();i++){
		System.out.println(res.get(i));
	}
    	searcher.close();
  	
  	
      
   }

public List<String> getRes() {
	return res;
}

public void setRes(List<String> res) {
	this.res = res;
}
}
