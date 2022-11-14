public class Engine {
    Rotor rightRotor;
    Rotor middleRotor;
    Rotor leftRotor;
    Reflector reflector;

    Engine(int rightRotor, int middleRotor, int leftRotor, int reflector, String counterSetting) {
        this.rightRotor = new Rotor(rightRotor, counterSetting.toCharArray()[2]);
        this.middleRotor = new Rotor(middleRotor, counterSetting.toCharArray()[1]);
        this.leftRotor = new Rotor(leftRotor, counterSetting.toCharArray()[0]);
        this.reflector = new Reflector(reflector);
    }


    String encode(String messageToEncode) {
        String encodedMessage = "";
        for (char c : messageToEncode.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                c = Character.toUpperCase(c);

                c = rightRotor.shift(c);
                c = middleRotor.shift(c);
                c = leftRotor.shift(c);
                c = reflector.shift(c);
                c = leftRotor.reverseShift(c);
                c = middleRotor.reverseShift(c);
                c = rightRotor.reverseShift(c);


                rightRotor.increaseCounter();
                if (rightRotor.checkTurnOver()) {
                    middleRotor.increaseCounter();
                    if (middleRotor.checkTurnOver()) {
                        leftRotor.increaseCounter();
                    }
                }

                encodedMessage = encodedMessage.concat(String.valueOf(c));
            }
        }
        return encodedMessage;
    }
}
