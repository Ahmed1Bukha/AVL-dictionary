import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Dictionary {
    private File wordsFile;
    AVLTree<String> bigTree = new AVLTree<String>();
   
    public Dictionary(){
    
    }

    public Dictionary(String firsrWord){

        addWord(firsrWord);
         
    }

    public Dictionary(File wordsFile) throws WordAlreadyExistsException, FileNotFoundException{
        this.wordsFile = wordsFile;
       
     
        try {
            addWord(this.wordsFile);
        } catch (WordAlreadyExistsException e) {
        
            e.printStackTrace();
        }
            System.out.println("dictionary loaded successfully.");
    }


    

    public void addWord(File myFile) throws WordAlreadyExistsException, FileNotFoundException{

        Scanner kb = new Scanner(myFile);
        String word="";
        while(kb.hasNextLine()){
             word = kb.nextLine();
    
            addWord(word);
            System.out.println("Adding: "+word);
        }
      
           
            
        
       
      
    }
    public void addWord(String word) { // O(log n).
       
        
        boolean isExsits= bigTree.search(word);
         
      if(isExsits){
        try {
            throw new WordAlreadyExistsException("Word is already added to the dictionary!");
        } catch (WordAlreadyExistsException e) {
            System.out.println(e);
        }
      }
      else{
     System.out.println("word added successfully.");
      bigTree.insertAVL(word);
      
      }


    }



    public boolean findWord(String word){ // O(log n).
       
        boolean isFound =bigTree.search(word);
        return isFound;
    }



	public void deleteWord(String word) throws WordNotFoundException{ // O(log n).
       
        bigTree.deleteAVL(word);
    }




    public String [] findSimilar (String word) { //O( n * m)
        String [] similars= {};
        String tempoSimilar="";
      

            String temp=bigTree.findSimilarPreOrder(word);
            if(!temp.isEmpty()){
                
                if(tempoSimilar.isEmpty()){
                    tempoSimilar = temp;
                }
                else{
                    tempoSimilar = tempoSimilar+","+temp;
                }
            }
        
        similars = tempoSimilar.split(",");
        return similars;
    }


    public void saveFile(String fileName){ // O(n)
    
          bigTree.writeToFileLevelOrderTraversal(fileName);
           
      
    }








}
