public class Test {
    public static String chirpify(String toChirp) {
	char[] blub = toChirp.toCharArray();
	char[] blub2 = new char[blub.length + 6];
	blub2[blub.length + 0] = (char) 0x43;
	blub2[blub.length + 1] = (char) 0110;
	blub2[blub.length + 2] = (char) 73;
	blub2[blub.length + 3] = (char) (0123 - 1);
	blub2[blub.length + 4] = (char) (40 * 2);
	blub2[blub.length + 5] = '!';
	String boxer99 = new String(blub).concat(new String(blub2));
	return boxer99;
    }

    public static void main(String[] args) {
	System.out.println(chirpify("foo"));
    }
}
