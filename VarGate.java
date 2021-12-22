package circuits;

// this can be set to a TrueGate, FalseGate
// or hold to no value
public class VarGate extends Gate {
	private String name;
	private boolean value;
	private int fSet;// if this was set to value

	// has no input entries
	public VarGate(String name) {
		super(null);
		this.name = name;
	}

	public String getName() {
		return String.format("V%s", name);
	}

	// Return value of this
	// Throws CircuitException if wasn't set.
	protected boolean func(boolean[] inValues) throws CircuitException {
		if (fSet == 0)
			throw new CircuitException();
		return value;
	}

	public void setVal(boolean value) {
		fSet = 1;
		this.value = value;
	}

	// Return boolean value of Gate, if it was set.
	@Override
	public Gate simplify() {
		if (fSet == 1)
			return value == true ? TrueGate.instance() : FalseGate.instance();
		else
			return this;
	}

}
