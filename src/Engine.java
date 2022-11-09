public class Engine {
        Rotor rightRotor;
        Rotor middleRotor;
        Rotor leftRotor;
        Reflector reflector;

        Engine(int rightRotor, int middleRotor, int leftRotor, int reflector, String counterSetting){
            this.rightRotor = new Rotor(rightRotor, counterSetting.toCharArray()[2]);
            this.middleRotor = new Rotor(middleRotor, counterSetting.toCharArray()[1]);
            this.leftRotor = new Rotor(leftRotor, counterSetting.toCharArray()[0]);
            this.reflector = new Reflector(reflector);
        }



        String encode(String messageToEncode){
            String encodedMessage = "";
            for (char c: messageToEncode.toCharArray()) {
                if(Character.isAlphabetic(c)) {
                    c = Character.toUpperCase(c);
                    System.out.println("================= new char " + c + " ===========");

                    System.out.println("First shift");
                    c = rightRotor.shift(c);
                    System.out.println("second shift");
                    c = middleRotor.shift(c);
                    System.out.println("third shift");
                    c = leftRotor.shift(c);
                    System.out.println("reflector");
                    c = reflector.shift(c);
                    c = leftRotor.reverseShift(c);
                    c = middleRotor.reverseShift(c);
                    c = rightRotor.reverseShift(c);


                    rightRotor.increaseCounter();
                    if (rightRotor.checkTurnOver()){
                        System.out.println("turn over on first rotor");
                        middleRotor.increaseCounter();
                        if(middleRotor.checkTurnOver()){
                            System.out.println("turn over on second rotor");
                            leftRotor.increaseCounter();
                        }
                    }

                    encodedMessage = encodedMessage.concat(String.valueOf(c));
                    System.out.println("========== the encoded char is " + c + " and the encoded message is so far " + encodedMessage + " ================");
                }
            }
            return encodedMessage;


    }



}
