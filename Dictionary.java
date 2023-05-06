import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Dictionary {
    private File wordsFile;
    AVLTree<String> bigTree = new AVLTree<String>();
    // private AVLTree<String>[] trees = new AVLTree[26]; //Number of letters in English.
    // private String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y" , "z"};
    public Dictionary(){
        // instantiateTrees();
    }

    public Dictionary(String firsrWord){
        // instantiateTrees();
        addWord(firsrWord);
         
    }

    public Dictionary(File wordsFile) throws WordAlreadyExistsException, FileNotFoundException{
        this.wordsFile = wordsFile;
        // instantiateTrees();
     
        try {
            addWord(wordsFile);
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
            System.out.println(word);
        }
      
           
            
        
       
      
    }
    public void addWord(String word) {
        // int treeNumber =getTreeNumber(word);
        boolean isExsits= bigTree.search(word);
            System.out.println(word);
      if(isExsits){
        try {
            throw new WordAlreadyExistsException("Word is already added to the dictionary!");
        } catch (WordAlreadyExistsException e) {
            e.printStackTrace();
        }
      }
      else{
       bigTree.insertAVL(word);
      }
    }



    public boolean findWord(String word){ // O(1)+ O(log n).
        // int treeNumber = getTreeNumber(word); 
        boolean isFound =bigTree.search(word);
        return isFound;
    }

    // private int getTreeNumber(String word){ //O(1)
    //     String charaString = word.split("")[0];
    //     int treeNumber=0;

    //     for(int i=0; i<this.letters.length; i++){
    //         if(charaString.equals(letters[i])){
    //             treeNumber = i;
    //             break;
    //         }
    //     }
    //     return treeNumber;




    // }

	public void deleteWord(String word) throws WordNotFoundException{
        // int treeNumber = getTreeNumber(word);
        bigTree.deleteAVL(word);
    }



    // private void  instantiateTrees(){
    //     for(int i=0; i< this.trees.length; i++ ){
    //         trees[i] = new AVLTree<String>();
    //     }
    // }

    public String [] findSimilar (String word) { //Complete stuff
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


    public void saveFile(String fileName){
    
          bigTree.writeToFileLevelOrderTraversal(fileName);
           
      
    }








}
