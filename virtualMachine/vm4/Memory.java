package zMachine;

public class Memory {
	private byte[] value = new byte[1048575];
	public byte getByte(short addr) {
		return value[addr];
	}
	public short getShort(short addr) {
		return (short) ((value[addr] << 8)|value[addr + 1]);
	}
	public long get(short startAddr, short endAddr) {
		long ret = 0;
		for (int index = startAddr; index <= endAddr; index++) {
			ret |= (value[index] << (endAddr - index)*8);
		}
		return ret;
	}
	public void setByte(short addr, byte set) {
		value[addr] = set;
	}
	public void setShort(short addr, short set) {
		value[addr] = (byte) (set >>> 8);
		value[addr + 1] = (byte) ((set << 8) >>> 8);
	}
}
