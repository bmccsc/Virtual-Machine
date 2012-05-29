package zMachine;

import java.util.Arrays;

public class Instruction {
	private byte[] opCount;
	private boolean store;
	private boolean jump;
	private boolean print;
	public void run(short[] ops, byte svar, short branch, byte[] text) {
		if (Arrays.asList(opCount).contains(ops.length) && ((svar == 0) != store) && ((branch == 0) != jump) && ((text == null) != print) {
			svar = run(ops, SmallStuff.decodeText(text));
		}
	}
}
