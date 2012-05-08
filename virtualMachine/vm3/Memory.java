package vm3;

public interface Memory {
	public byte loadByte(short addr);
	public void storeByte(byte value, short addr);
	public short loadWord(short addr);
	public void storeWord(byte[] value, short addr);
}
