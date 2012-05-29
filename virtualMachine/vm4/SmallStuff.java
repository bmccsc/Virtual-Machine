package zMachine;

public class SmallStuff {
	public static short append(byte a, byte b) {
		return (short) ((a << 8) | b);
	}
	public static int append(short a, short b) {
		return (a << 16) | b;
	}
	public static long append(int a, int b) {
		return (long) ((a << 32) | b);
	}
	public static boolean isBitSet(long a, byte i) {
		return (a & (1 << i)) != 0;
	}
	public static long bitsToNum(boolean[] bits) {
		long ret = 0;
		for (int index = 0; index < bits.length; index++) {
			if (bits[index]) {
				ret |= (1 << (bits.length - index - 1));
			}
		}
		return ret;
	}
	public static long maskForSub(byte start, byte finish) {
		long ret = 0;
		for (int index = start; index <= finish; index++) {
			ret |= (1 << (index - 1));
		}
		return ret;
	}
	public static long subBits(long template, byte start, byte finish) {
		return (template & maskForSub(start, finish)) >>> (finish - start);
	}
	public static short unpackAddr(short addr) {
		return (short) (4*addr);
	}
	public static short unwordAddr(short addr) {
		return (short) (2*addr);
	}
}
