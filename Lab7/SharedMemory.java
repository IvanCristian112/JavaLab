package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedMemory {
    private List<Token> listOfTokens = new ArrayList<>();

    public SharedMemory(int n) {
        for (int i = 0; i < Math.pow(n, 3); i++) {
            listOfTokens.add(new Token(i));
        }
        Collections.shuffle(listOfTokens);

    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (listOfTokens.isEmpty()) {
                break;
            }
            extracted.add(listOfTokens.get(0));
        }
        return extracted;
    }
}
