/*
Dan Afful
CMSC 204
This program is a Morse Code Converter Utility
*/
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter
{

    private static MorseCodeTree t = new MorseCodeTree();


    public MorseCodeConverter()
    {

    }


    /**
     * Converting Morse code into English.
     * Ex:
     * code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
     * string returned = "Hello World"
     *
     * @param code the morse code
     * @return the English translation
     */
    public static java.lang.String convertToEnglish(java.lang.String code)
    {
        String output = "";
        String[] word;
        String[] letter;


        word = code.split(" / ");


        for(int i = 0; i < word.length; i++)
        {



            letter = word[i].split(" ");

            for(int j = 0; j < letter.length; j++)
            {
                //System.out.println(letter[j]);

                output += t.fetch(letter[j]);
            }


            output += " ";
        }


        output = output.trim();

        return output;
    }



    /**
     * Converts Morse code into English.
     * Ex:
     * code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
     * string returned = "Hello World"
     *
     * @param codefile name of the File that contains Morse Code
     * @return the English translation of the file
     * @throws java.io.FileNotFoundException
     */
    public static java.lang.String convertToEnglish(java.io.File codeFile) throws java.io.FileNotFoundException
    {
        String output = "";
        ArrayList<String> line = new ArrayList<String>();
        String[] word;
        String[] letter;

        Scanner inputFile;
        inputFile = new Scanner(codeFile);


        while (inputFile.hasNext())
        {
            line.add(inputFile.nextLine());
        }

        inputFile.close();


        for(int i = 0; i < line.size(); i++)
        {



            word = line.get(i).split(" / ");


            for(int j = 0; j < word.length; j++)
            {




                letter = word[j].split(" ");

                for(int k = 0; k < letter.length; k++)
                {


                    output += t.fetch(letter[k]);
                }


                output += " ";
            }
        }

        output = output.trim();

        return output;
    }



    public static java.lang.String printTree()
    {
        ArrayList<String> treeData = new ArrayList<String>();

        treeData = t.toArrayList();

        String print = "";

        for(int i = 0; i < treeData.size(); i ++)
        {
            print += treeData.get(i) + " ";
        }

        return print;
    }
}