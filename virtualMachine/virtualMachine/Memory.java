package virtualMachine;

public class Memory { // Emulates the Z-machine's main memory.
	public ZMachine owner;
	private byte[] map = new byte[0xfffff]; // Contains the bytes. The index represents byte address.
	private void init() { // Initializes memory so that all bytes are 0.
		int pointer = 0;
		while (pointer < 0x100000) {
			map[pointer] = 0;
			pointer += 1;
		}
	}
	private void checkWrite(int ba) { // Halts the program if the given byte address cannot be
		// written to at this time.
		if (ba < staticMark()) {
			owner.proc.stop("Cannot write to " + Integer.toString(ba) + " because it is in static or high memory.", 1);
		}
	}
	private void checkRead(int ba) { // Halts the program if the given byte address cannot be read
		// at this time.
		// To do:
		// - Figure out how to determine the top of static memory
		// - Use to allow access to high memory that overlaps static memory
	}
	private void checkWordOp(int wa) { // Halts the program if the given word address is higher
		// than 128KB.
		if (wa > 0x10000) { // A word is two bytes; thus, word addresses must be doubled to find
			// corresponding bottom byte addresses (hence 0x10000 instead of 0x20000).
			owner.proc.stop("Word address above 128KB: " + Integer.toString(wa) + ".", 3);
		}
	}
	public int staticMark() { // Uses the header to determine the static mark.
		return (new Word(map[0x0e], map[0x0f])).numeric();
	}
	public int highMark() { // Uses the header to determine the high mark.
		return (new Word(map[0x04], map[0x05])).numeric();
	}
	public int abbrMark() {
		return (new Word(map[0x18], map[0x19])).numeric();
	}
	public short loadw(int wa) { // Loads a word from the given word address.
		checkWordOp(wa);
		checkRead(2*wa);
		checkRead(2*wa + 1);
		return (new Word(map[2*wa], map[2*wa + 1])).numeric();
	}
	public int loadb(int ba) { // Loads a byte from the given byte address.
		checkRead(ba);
		return map[ba];
	}
	public void storew(int wa, short w) { // Stores the given word at the given word address.
		checkWordOp(wa);
		checkWrite(2*wa);
		checkWrite(2*wa + 1);
		map[2*wa] = Word.toWord(w).getLeft();
		map[2*wa + 1] = Word.toWord(w).getRight();
	}
	public void storeb(int ba, byte b) { // Stores the given byte at the given byte address.
		checkWrite(ba);
		map[ba] = b;
	}
	public void loadGame(byte[] game) { // Sets the memory map.
		map = game;
	}
	public Memory() { // Instantiates the Memory class.
		init();
		owner = ZMachine.machine;
	}
	public Memory(ZMachine mach) {
		init();
		owner = mach;
	}
	public Memory(byte[] game) { // Instantiates the Memory class and sets the memory map.
		loadGame(game);
		owner = ZMachine.machine;
	}
	public Memory(ZMachine mach, byte[] game) { // Instantiates the Memory class and sets the memory map.
		loadGame(game);
		owner = mach;
	}
}