public class SmallStuff {
	public static short appendBytes(byte a, byte b) {
		return (((short) a) << 8) | (short) b;
	}
	public static boolean getBit(long b, byte i) {
		return b & (~(1 << i));
	}
	public static long append(int a, int b) {
		if ((byte) b == b) {
			return (((long) a) << 8) | (byte) b;
		}
		else if ((short) b == b) {
			return (((long) a) << 16) | (short) b;
		}
		else {
			return (((long) a) << 32) | (int) b;
		}
	}
}