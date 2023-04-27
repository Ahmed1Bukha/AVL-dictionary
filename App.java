import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws WordAlreadyExistsException, WordNotFoundException, FileNotFoundException {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter file name: ");    
        String fileName = kb.nextLine();

        File myFile = new File(fileName);
        Dictionary dictionary = new Dictionary(myFile);

        System.out.print("Check word: ");
        String checkWord= kb.nextLine();
        boolean isFound= dictionary.findWord(checkWord);
        if(isFound){
            System.out.println("Word found.");
        }
        else{
            System.out.println("Word not found.");
        }

        System.out.print("add new word: ");
        String newWord = kb.nextLine();
        dictionary.addWord(newWord);
        System.out.println("word added successfully.");

        System.out.print("remove word: ");
        String removeWord = kb.nextLine();
        dictionary.deleteWord(removeWord);
        System.out.println("word removed successfully");
        
        System.out.print("Search for similar words: ");
        String wordSimilar = kb.nextLine();
        String []similars  = dictionary.findSimilar(wordSimilar);
        System.out.println(Arrays.toString(similars));

        System.out.print("Save Updated Dictionary (Y/N): ");
        String isSave = kb.nextLine();
        if(isSave.equalsIgnoreCase("Y")){
            System.out.print("Enter filename: ");
            String fileSaveName = kb.nextLine();
        }
     
       
    }
}
