public class Reflector {
    char[] reflector;

    char shift(char c) {
        return reflector[c - 'A'];
    }

    Reflector(int i) {
        this.reflector = reflectorSetting(i);
    }

    char[] reflectorSetting(int i) {
        final char[][] reflectors = {
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(),
                "EJMZALYXVBWFCRQUONTSPIKHGD".toCharArray()
        };
        return reflectors[i];
    }
}
