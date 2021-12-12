package effective_search;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Search {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			BufferedReader file=new BufferedReader(
					new FileReader("C:\\Users\\prije\\source\\repos\\effective_search\\src\\words_alpha.txt"));
			Scanner sc=new Scanner(System.in);
			
			System.out.println("==ENTER THE SEARCH KEYword==");
			String str=sc.nextLine().toLowerCase();
			HashMap<Character,Integer> CurrentLettersmap= FindWord(str);
//			System.out.println(CurrentLetters);
			for(String CalWord=file.readLine();CalWord!=null;CalWord=file.readLine()){
				HashMap<Character,Integer> find_word_map= FindWord(CalWord);
				boolean flag=true;
			for(Character c:find_word_map.keySet()) {
				int CurrentWordCount=find_word_map.get(c);
				int LetterCount=CurrentLettersmap.containsKey(c)?CurrentLettersmap.get(c):0;
				if(CurrentWordCount>LetterCount) {
					flag=false;
					break;
					
				}
						
			}
//			&& (str.length())==(CalWord.length() )
				if(flag )
				System.out.println(CalWord);
			}
	
			
			sc.close();
			
			
			
	}

	private static HashMap<Character,Integer> FindWord(String str) {
		HashMap<Character,Integer> CurrentWordList =new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			int count=CurrentWordList.containsKey(c)?CurrentWordList.get(c):0;
			CurrentWordList.put(c, count+1);
		}
		return CurrentWordList;
	}

}
