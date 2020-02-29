import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/**
 * this class implemented for outputting string that is between two substrings user inputted.
 */
public class ApicaGetSubstring extends Applet implements ActionListener {

    private TextField inputText;
    private TextField fromText;
    private TextField toText;
    private String inputString;
    private String fromString;
    private String toString;

    @Override
    public void init() {
        this.setBackground(Color.pink);
        this.setLayout(null);
        inputText = new TextField("input string", 2);
        fromText = new TextField("from string", 800);
        toText = new TextField("to string", 800);
        inputText.setBounds(20, 100,800, 40);
        fromText.setBounds(20, 150,800, 40);
        toText.setBounds(20, 200,800, 40);

        Button startMatch = new Button("GET Substring!");
        startMatch.setBounds(20, 250,200, 40);
        startMatch.addActionListener(this);

        add(inputText);
        add(fromText);
        add(toText);
        add(startMatch);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            this.inputString = inputText.getText();
            this.fromString = fromText.getText();
            this.toString = toText.getText();
        } catch (Exception exception) { }
        repaint();
    }

    @Override
    public void paint(Graphics g) {

        g.drawString("Please enter the inputs for substring matching", 20, 20);

        if (this.inputString != null) {
            String result = getSubString(inputString, fromString, toString);
            g.setColor(Color.BLACK);
            g.setFont(new Font("default", Font.BOLD, 16));
            g.drawString(result, 20, 60);
        }
    }

    /**
     * this method output the substring between "fromString" and "toString" exclusively.
     * PRE: assume there exists at most 1 pair of [from, toString] for the answer
     *
     * @param inputString string for input
     * @param fromString  left bound of the substring
     * @param toString    right bound of the substring
     * @return the substring between fromString and toString exclusively.
     */
    public String getSubString(String inputString, String fromString, String toString) {
        //corner cases
        if (inputString == null || fromString == null || toString == null) {
            return "[ERROR] Invalid Null Input.";
        } else if (inputString.length() == 0 || fromString.length() == 0 || toString.length() == 0) {
            return "[ERROR] Invalid Null Input.";
        } else if (inputString.length() < fromString.length() || inputString.length() < toString.length()) {
            return "[ERROR] Invalid Null Input.";
        }

        //assume there is at most 1 pair of [fromString, toString] can be found in input.
        int fromIndex = -1;
        int toIndex = -1;
        for (int i = 0; i < inputString.length(); i++) {
            char curr = inputString.charAt(i);
            if (curr == fromString.charAt(0) && check(inputString, fromString, i)) {
                fromIndex = i;
            } else if (curr == toString.charAt(0) && check(inputString, toString, i)) {
                toIndex = i;
                if (fromIndex != -1) {
                    break;
                }
            }
        }
        if (toIndex != -1 && fromIndex != -1) {
            //corner cases: Overlapping or wrong sequence
            if (fromIndex + fromString.length() > toIndex) {
                return "[ No Matching Found! ]";
            } else {
                return inputString.substring(fromIndex + fromString.length(), toIndex);
            }
        } else {
            return "[ No Matching Found! ]";
        }
    }

    /**
     * this method helps to checking if the matches found starting from index "begin".
     *
     * @param inputString user input string
     * @param target      string for matching
     * @param begin       index for begin checking
     * @return true for match, false for none match
     */
    private boolean check(String inputString, String target, int begin) {
        for (int i = 0; i < target.length(); i++) {
            if (inputString.charAt(i + begin) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
//}


    /**below is an implementation for cases that involved multiple [from, to] string target and multiple answers involved
     *using rolling hash method to improve the general run time complexity to O(n) avoiding duplicate checks./
     * @param: see above.
     * @return: see above.
     */
//    private List<Integer> findMatchIndex(List<Integer> fromIndex, String inputString, String toMatch) {
//        //target.length < input.length
//        int largePrime = 101;
//        int prime = 31;
//        int seed = 1; //highest digit value
//        int hash = 0;
//
//        int targetHash = moduleHash(hash, toMatch.charAt(0), prime, largePrime); //toMatch.charAt(0) % largePrime;
//        for (int i = 1; i < toMatch.length(); i++) {
//            seed = moduleHash(seed, 0, prime, largePrime);
//            targetHash = moduleHash(targetHash, toMatch.charAt(i), prime, largePrime);
//        }
//        for (int i = 0; i < toMatch.length(); i++) {
//            hash = moduleHash(hash, inputString.charAt(i), prime, largePrime);
//        }
//        //checking if match at the head
//        if (hash == targetHash && isEqual(inputString, toMatch, 0)) {
//            fromIndex.add(0);
//        }
//        for (int i = toMatch.length(); i < inputString.length(); i++){
//            hash -= seed * inputString.charAt(i - toMatch.length()) % largePrime;
//            hash = ensurePositive(hash, largePrime);
//            hash = moduleHash(hash, inputString.charAt(i), prime, largePrime);
//            if (hash == targetHash && isEqual(inputString, toMatch, i - toMatch.length() + 1)) {
//                fromIndex.add(i - toMatch.length() + 1);
//            }
//        }
//        return fromIndex;
//    }
//
//    private int moduleHash(int hash, int addition, int prime, int largePrime) {
//        return (hash * prime % largePrime + addition) % largePrime;
//    }
//
//    private boolean isEqual(String inputString, String match, int beginIndex) {
//        for (int i = beginIndex; i < match.length(); i++) {
//            if (inputString.charAt(i) != match.charAt(i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private int ensurePositive(int hash, int largePrime) {
//        return hash < 0 ? hash + largePrime : hash;
//    }

//    public static void main(String[] args) {
//        System.out.print("lai offer!!!!");
//    }
