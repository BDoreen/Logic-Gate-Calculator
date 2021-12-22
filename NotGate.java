package circuits;

//Implementation of NOT gate
//
//NOT[TRUE]=FALSE
public class NotGate extends Gate {

	// Only one [Gate] input
	public NotGate(Gate in) {
		super(new Gate[] { in });
	}

	// Return opposite value of [inValues[0]]
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return (!inValues[0]);
	}

	@Override
	public String getName() {
		return "NOT";
	}

	// Return opposite value of simplified [Gate]
	//
	// if NOT[NOT[...], return [...]
	@Override
	public Gate simplify() {
		Gate g = inGates[0];
		if (g instanceof TrueGate)
			return FalseGate.instance();
		else if (g instanceof FalseGate)
			return TrueGate.instance();
		else if (g instanceof NotGate)
			return g.inGates[0].simplify();
		return new NotGate(g);
	}
}
