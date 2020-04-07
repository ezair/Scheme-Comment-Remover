/**
 * @Author Eric Zair
 * @File WordCounter.java
 * @version 0.1
 *
 * @Description  This Program finds every "word" that is contained in a file(s) that the user passes as a cmd argument.
 *               We then add each word to the map as a <Key> and then add the count of the word ton the map as a
 *               <Value>.
 */

package p003;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordCounter {


    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            usage();

        for (String filename : args) {
            File fileGivenAsArgument = new File(filename);
            if (fileGivenAsArgument.exists()) {
                System.out.println("Output for \"" + filename + "\":");
                Map<String, Integer> wordCountMap = getMapFilledWithWordsInFile(new TreeMap<>(), fileGivenAsArgument);
                System.out.println(mapToString(wordCountMap));
            }
            else
                System.out.println("The file \"" + filename + "\" was not found...Skiping....");

        }
    }


    /**
     * Returns a Scanner object containing the content of a given File object but with all scheme comments
     * parsed out of it.
     *
     * @param  file  The file that we will give to the scanner that we return.
     * @return  Scanner that contains content of passed if file. This scanner has 0 scheme comments in it.
     *
     *
     * @throws  FileNotFoundException  Required to throw, but will not cause any issues.
     *
     */
    public static Scanner getScannerFilledWithFileContentNoComments(File file) throws FileNotFoundException {
        Reader commentRemovalReader = new SansLittleUFilterReader(new FileReader(file));
        return new Scanner(commentRemovalReader);
    }


    /**
     * Return a toString() version of our map in the form: <map_key> : <map_value> '\n'
     *
     * @param  map  The map that you want to return the string representation of.
     *              Abstracted so that the user can choose the type of map to pass in.
     *
     * @return  A string version of the map that is passed in.
     *
     */
    public static String mapToString(Map<String, Integer> map) {
        String mapAsString = "";
        Iterator<String> mapIterator = map.keySet().iterator();

        // Fence-post here because we don't want a '\n' at at the end of the returned string.
        if (mapIterator.hasNext()) {
            String keyInMap = mapIterator.next();
            mapAsString += keyInMap + " : " + map.get(keyInMap);
        }

        while (mapIterator.hasNext()) {
            String keyInMap = mapIterator.next();
            mapAsString += "\n" + keyInMap + " : " + map.get(keyInMap);
        }
        return mapAsString;
    }


    /**
     * Returns a Map containing a "word" as a <key> and the count of each word as a <value>.
     *
     * @param  wordCountMap  The map that we want to put all of our word and word counts in.
     *
     * @param  file  The file that we will grab words out of.
     *
     * @return  Map containing words and the count of each word.
     *
     * @throws  FileNotFoundException  Required to throw, but no error will occur here.
     *
     */
    public static Map<String, Integer> getMapFilledWithWordsInFile(Map<String, Integer> wordCountMap, File file)
        throws FileNotFoundException {

        Scanner fileScanner = getScannerFilledWithFileContentNoComments(file);
        while (fileScanner.hasNext())
            putWordsFromStringInMapAndUpdateValue(wordCountMap, fileScanner.next());
        fileScanner.close();
        return wordCountMap;
    }


    /**
     * Given a Map and a String, we populate the map with every "word" that is contained in the string.
     * The "word" will be the <Key> and the number of times the word appears will be the <value>.
     *
     * @param  map  The map that we want to populate.
     *
     * @param  str  The string that contains the "words" that we are going to put in map.
     *
     */
    public static void putWordsFromStringInMapAndUpdateValue(Map<String, Integer> map, String str) {
        String regexForFindingWords = "([A-Za-z])+(\\d)*|\\W{1}|(\\d)+";
        Matcher regexExpressionFinder = Pattern.compile(regexForFindingWords).matcher(str);

        while (regexExpressionFinder.find()) {
            String regexFoundInString = regexExpressionFinder.group();
            if (map.containsKey(regexFoundInString))
                map.put(regexFoundInString, map.get(regexFoundInString) + 1);
            else
                map.put(regexFoundInString, 1);
        }
    }


    /**
     * Print out the instructions on how to correctly run this program.
     * Called when user does not give a filename.
     *
     */
    public static void usage() {
        System.out.println("Program must take a file as an argument.");
        System.out.println("Run without gradle: java WordCounter <path_to_file>");
        System.out.println("Run with gradle: gradle run --args <path_to_file>");
    }
}
