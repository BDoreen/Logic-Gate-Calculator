package circuits;

import java.util.Arrays;

//Implement general logical gate
public abstract class Gate {
	protected Gate[] inGates; // Input for [Gate].

	// Give [Gate] its' input.
	public Gate(Gate[] inGates) {
		if (inGates == null)
			return;
		this.inGates = new Gate[inGates.length];
		this.inGates = Arrays.copyOf(inGates, inGates.length);
	}

	// Calculate boolean value [Gate].
	// Throws CircuitException if any input [inGates] is empty.
	public boolean calc() throws CircuitException {
		if (inGates == null) // FalseGate || TrueGate || VarGate
			return func(null);
		boolean[] inValues = new boolean[inGates.length];
		for (int i = 0; i < inGates.length; i++) {
			if (inGates[i] == null)
				throw new CircuitException();
			else
				inValues[i] = inGates[i].calc();// Initial boolean array.
		}
		return func(inValues);// Calculate boolean array
	}

	// Return [Gate] value.
	protected abstract boolean func(boolean[] inValues) throws CircuitException;

	// Return [Gate] name
	public abstract String getName();

	// return simplified [Gate]
	public abstract Gate simplify();

	// Return [Gate] as a String.
	//
	// From outer [Gate] to inner Gate.
	// AND[OR[TRUE,FALSE]]
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append(getName());
		if (inGates == null)// FalseGate || TrueGate || VarGate
			return ret.toString();
		ret.append("[");
		for (Gate inGate : inGates) {
			if (inGate != null)// not last entry
				ret.append(inGate).append(", ");
		}
		ret.delete(ret.length() - 2, ret.length());// remove last ", "
		return ret.append("]").toString();
	}
}
