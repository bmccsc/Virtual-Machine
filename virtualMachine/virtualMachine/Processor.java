package virtualMachine;
import java.util.*;

public class Processor {
	public ZMachine owner;
	private int counter = 0;
	private int seed = 999;
	private boolean randmode = true;
	public void stop(String message, int code) {
		System.out.println(message + " Error code: " + Integer.toString(code) + ". Program counter: " + Integer.toString(counter) + ".");
		System.exit(code);
	}
	private void checkDiv(short den) {
		if (den == 0) {
			stop("Division by zero! Aaaaaah!!", 4);
		}
	}
	public short add(short s1, short s2) {
		return (short) (s1 + s2);
	}
	public short mul(short s1, short s2) {
		return (short) (s1 * s2);
	}
	public short sub(short s1, short s2) {
		return (short) (s1 - s2);
	}
	public short div(short s1, short s2) {
		checkDiv(s2);
		return (short) (s1 / s2);
	}
	public short rem(short s1, short s2) {
		checkDiv(s2);
		return (short) (s1 % s2);
	}
	public void prt(short s) {
		System.out.print(s);
	}
	public short lft(short s1, short s2) {
		return (short) (s1 << s2);
	}
	public short rgt(short s1, short s2) {
		return (short) (s1 >>> s2);
	}
	public short and(short s1, short s2) {
		return (short) (s1 & s2);
	}
	public short ior(short s1, short s2) {
		return (short) (s1 | s2);
	}
	public short not(short s) {
		return (short) (~s);
	}
	public short rnd(short n) {
		short retval = 1;
		if (n < 1) {
			stop("Invalid random number maximum: " + Short.toString(n) + ".", 5);
		}
		else if (randmode) {
			// To do: Learn how to generate a random sequence of bits from the computer clock
		}
		else {
			Random contgen = new Random();
			short curr = 1;
			boolean cont = contgen.nextBoolean();
			while (cont) {
				if (curr == seed) {
					curr = 1;
				}
				else {
					curr++;
				}
				cont = contgen.nextBoolean();
			}
			if (curr == seed) {
				curr = 1;
			}
			else {
				curr++;
			}
			retval = (short) (curr % n);
		}
		return retval;
	}
	// Text processing goes here and is currently under construction
	// To edit with automatic indentation, comment out the beginning comment block delimiter. When
	// you're finished, uncomment the delimiter.
	/*
	private String[] alphabets = {"      abcdefghijklmnopqrstuvwxyz", "      ABCDEFGHIJKLMNOPQRSTUVWXYZ", "       \n0123456789.,!?_#\'\"/\\-:()"};
	private byte lastChar = 0;
	private void prc(byte b) {
		char prtval;
		boolean prtstr = false;
		boolean zscii = false;
		if (b == 0) {
			prtval = ' ';
		}
		else if ((0 < b) && (b < 4)) {
			prtstr = true;
		}
		else if ((lastChar == 5) && (b == 6)) {
			zscii = true;
		}
		else if ((3 < lastChar) && (lastChar < 6)) {
			prtval = alphabets[lastChar - 3].charAt(b);
		}
		else {
			prtval = alphabets[0].charAt(b);
		}
		if (zscii) {
			lastChar = -1;
		}
		else if (prtstr) {
			(owner.mem.abbrMark()
		}
	}
	public void txt(short s) {
		String x = Integer.toBinaryString((int) s);
		while (x.length() < 16) {
			x = "0" + x;
		}
		
	}
	 */
	// End of text processing
	public Processor() {
		owner = ZMachine.machine;
	}
	public Processor(ZMachine mach) {
		owner = mach;
	}
	public Processor(int sd) {
		seed = sd;
		owner = ZMachine.machine;
	}
	public Processor(ZMachine mach, int sd) {
		seed = sd;
		owner = mach;
	}
}