import java.util.ArrayList;
import java.util.List;

class RailFenceCipher {

    private int noOfRails;

    RailFenceCipher(int noOfRails) {
        this.noOfRails = noOfRails;
    }

    String getEncryptedData(String plainText) {
        List<String> railFence = new ArrayList<>();
        for (int i = 0; i < noOfRails; i++) {
            railFence.add("");
        }

        int number = 0, increment = 1;
        for (char c : plainText.toCharArray()) {
            if (number + increment == noOfRails) {
                increment = -1;
            } else if (number + increment == -1) {
                increment = 1;
            }
            String temp = railFence.get(number);
            railFence.remove(number);
            railFence.add(number, temp + c);
            number += increment;
        }
        String buffer = "";
        for (String s : railFence) {
            buffer = buffer.concat(s);
        }
        return buffer;
    }

    String getDecryptedData(String cipherText) {
        String decrypted;
        ArrayList<ArrayList<Integer>> railFence = new ArrayList<>(noOfRails);

        for (int i = 0; i < noOfRails; ++i) {
            railFence.add(new ArrayList<>(cipherText.length()));
        }

        int rowIncrementFactor = 0, step = 1;

        for (int i = 0; i < cipherText.length(); ++i) {
            if (rowIncrementFactor + step == noOfRails) {
                step = -1;
            } else if (rowIncrementFactor + step == -1) {
                step = 1;
            }

            railFence.get(rowIncrementFactor).add(i);
            rowIncrementFactor += step;
        }

        int counter = 0;
        ArrayList<Character> buffer = new ArrayList<>(cipherText.length());
        for (int i = 0; i < cipherText.length(); ++i) {
            buffer.add('a');
        }

        for (int i = 0; i < noOfRails; ++i) {
            for (int j = 0; j < railFence.get(i).size(); ++j) {
                buffer.set(railFence.get(i).get(j), cipherText.charAt(counter));
                counter++;
            }
        }

        decrypted = buffer.toString().replaceAll(",", "").replaceAll("\\s+", "").replace("[", "").replace("]", "");
        return decrypted;
    }
}
