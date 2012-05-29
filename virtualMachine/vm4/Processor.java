package zMachine;

public class Processor {
	private short pc;
	private Machine owner;
	public short getPC() {
		return pc;
	}
	public void setPC(short value) {
		pc = value;
	}
	public void incPC(short value) {
		pc += value;
	}
	public void incPC() {
		pc++;
	}
	public void run() {
		pc = owner.getMem().getShort((short) 6);
		while (true) {
			
		}
	}
}
