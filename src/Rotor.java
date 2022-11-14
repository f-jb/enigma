public class Rotor {
    private final char[] rotor;
    private final char turnover;
    private char counter;

    boolean checkTurnOver() {
        return Character.valueOf(turnover) == Character.valueOf(counter);
    }

    void increaseCounter() {
        counter++;
        if (counter > ('Z')) {
            counter = 'A';
        }
    }


    char reverseShift(char c){
        char revChar = (char) ((new String(rotor).indexOf(c) + 'A') - (counter - 'A'));
        if (revChar < 'A') {
            return (char) (revChar + 25);
        }

        return revChar;
    }


    char shift(char c) {
        int charIndex = (c - 'A' + counter - 'A');
        if (charIndex > 25) {
            charIndex -= 25;
        }
        return rotor[charIndex];

    }

    Rotor(int rotorNumber, char counter) {
        this.rotor = rotorSettings.getSettings(rotorNumber);
        this.turnover = turnoverSettings.getSettings(rotorNumber);
        this.counter = Character.toUpperCase(counter);
    }

}

class turnoverSettings {
    final static char[] settings = {' ', 'R', 'F', 'W', 'K', 'A'};

    public static char getSettings(int rotorNumber) {
        return settings[rotorNumber];
    }
}

class rotorSettings {
    final static char[][] settings = {
            // Rotors I to V
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(),
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray(),
            "AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray(),
            "BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray(),
            "ESOVPZJAYQUIRHXLNFTGKDCMWB".toCharArray(),
            "VZBRGITYUPSDNHLXAWMJQOFECK".toCharArray()
    };

    public static char[] getSettings(int rotorNumber) {
        return settings[rotorNumber];
    }
}