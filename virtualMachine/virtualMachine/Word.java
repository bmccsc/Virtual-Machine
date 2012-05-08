package virtualMachine;

public class Word { // Used to represent words for intermediary calculations that require use of
	// both bytes in a word individually.
	public static Word toWord(short x) { // Converts a short to a word.
		String s = Integer.toHexString(x);
		String l, r = "";
		while (s.length() < 4) {
			s = "0" + s;
		}
		l = s.substring(0,2);
		r = s.substring(2,4);
		return new Word(Byte.parseByte(l), Byte.parseByte(r));
	}
	private byte left, right; // Stores the two bytes individually.
	public byte getLeft() { // Returns the bottom byte. I call it left because it's easier for me to
		// visualize.
		return left;
	}
	public byte getRight() { // Returns the top byte. Second verse same as first verse.
		return right;
	}
	public void setLeft(byte b) { // Changes the bottom byte.
		left = b;
	}
	public void setRight(byte b) { // Changes the top byte.
		right = b;
	}
	public short numeric() { // Returns the numeric value of the word.
		return Short.parseShort(Integer.toHexString(left) + Integer.toHexString(right), 16);
	}
	public Word(byte l, byte r) { // Instantiates the word and changes both bytes.
		left = l;
		right = r;
	}
}