import java.util.*;

public class HashMarkov implements MarkovInterface {
    private String[] myWords;
    private Random myRandom;
    private int myOrder;
    private HashMap<WordGram, List<String>> myMap;
    private static String END_OF_TEXT = "*** ERROR ***";

    public HashMarkov() {
        this(3); 
    }

    public HashMarkov(int order) {
        myOrder = order;
        myRandom = new Random();
        myMap = new HashMap<>();
    }

    @Override
    public void setTraining(String text) {
        myWords = text.split("\\s+");
        myMap.clear(); 

        for (int index = 0; index <= myWords.length - myOrder; index++) {
            WordGram wg = new WordGram(myWords, index, myOrder);

            List<String> follows = myMap.getOrDefault(wg, new ArrayList<>());
            
            if (index + myOrder < myWords.length) { 
                String nextWord = myWords[index + myOrder];
                follows.add(nextWord);
                myMap.put(wg, follows);
            }
        }
    }

    @Override
    public List<String> getFollows(WordGram kGram) {
        
        return myMap.getOrDefault(kGram, Collections.emptyList());
    }

    private String getNextWord(WordGram wgram) {
        List<String> follows = getFollows(wgram);
        if (follows.isEmpty()) {
            return END_OF_TEXT;
        } else {
            int index = myRandom.nextInt(follows.size());
            return follows.get(index);
        }
    }

    @Override
    public String getRandomText(int length) {
        StringBuilder text = new StringBuilder();
        int index = myRandom.nextInt(myWords.length - myOrder + 1);
        WordGram current = new WordGram(myWords, index, myOrder);
        text.append(current.toString()).append(" ");

        for (int i = 0; i < length - myOrder; i+=1) {
            String nextWord = getNextWord(current);
            if (nextWord.equals(END_OF_TEXT)) {
                break;
            }
            text.append(nextWord).append(" ");
            current = current.shiftAdd(nextWord);
        }

        return text.toString().trim();
    }

    @Override
    public int getOrder() {
        return myOrder;
    }

    @Override
    public void setSeed(long seed) {
        myRandom.setSeed(seed);
    }
}
