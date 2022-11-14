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

    char reverseShift(char c) {
        if ((char) (new String(rotor).indexOf(c) + 'A' - (counter - 'A')) < 'A') {
            return (char) (((new String(rotor).indexOf(c) + 'A') - (counter - 'A')) + 25);
        }

        return (char) ((new String(rotor).indexOf(c) + 'A') - (counter - 'A'));
    }

    char shift(char c) {
        if ((c - 'A' + (counter - 'A')) > 25) {
            return rotor[c - 'A' + (counter - 'A') - 25];
        }

        return rotor[c + counter - 'A' * 2];

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