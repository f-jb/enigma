public class Rotor {
    private char[] rotor;

    private char turnover;
    private char counter = 'A';

    boolean checkTurnOver() {
        return Character.valueOf(turnover) == Character.valueOf(counter);
    }

    void increaseCounter() {
        System.out.println("before incremeant counter is " + counter);
        counter++;
        System.out.println("After increment it is " + counter);
        if (counter > ('Z')) {
            System.out.println("counter exceeded Z");
            counter = 'A';
        }
    }
    char reverseShift(char c){
        return (char)(new String(rotor).indexOf(c) + 'A');
    }

    char shift(char c) {
        if (26 < (c - 'A' + (counter - 'A'))) {
            return rotor[c - 'A' + (counter - 'A') - 26];
        }

        System.out.println("counter is " + counter);
        return rotor[c + counter - 'A' *2];

    }

    Rotor(int rotorNumber, char counter) {
        this.rotor = rotorSettings.getSettings(rotorNumber);
        this.turnover = turnoverSettings.getSettings(rotorNumber);
        this.counter = counter;
    }

}

class turnoverSettings {
    final static char[] settings = {' ','R', 'F', 'W', 'K', 'A'};

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