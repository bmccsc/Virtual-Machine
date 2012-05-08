package vm2;

public class Memory {
	private byte[] map = new byte[1048575];
	private void init() {
		for (int i = 0; i < 1048575; i++) {
			map[i] = 0;
		}
	}
	public byte version() {
		return map[0];
	}
	private static String makeLengthEight(String s) {
		while (s.length() < 8) {
			s = "0" + s;
		}
		return s;
	}
	private static boolean[] toBits(byte b) {
		char[] cs = makeLengthEight(Integer.toBinaryString(b)).toCharArray();
		boolean[] result = new boolean[cs.length];
		byte i = 0;
		for (char c : cs) {
			result[i] = (c == 0);
			i++;
		}
		return result;
	}
	public byte rawFlagsOne() {
		return map[1];
	}
	public boolean[] flagsOne() {
		return toBits(rawFlagsOne());
	}
}
