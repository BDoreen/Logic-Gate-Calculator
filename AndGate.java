package circuits;

//Implement an And gate.
//
//And[true,false]=false
//true&&false=false
public class AndGate extends Gate {

	// Initial an AND gate with [inGates]
	public AndGate(Gate[] inGates) {
		super(inGates);
	}

	// Return false if any [boolean.inValues] is false.
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		for (boolean b : inValues)
			if (!b)
				return false;
		return true;
	}

	// Return Gate name
	@Override
	public String getName() {
		return "AND";
	}

	// Return simplified [Gate] of obvious actions.
	//
	// AND[false,AND[true,false]]=false
	@Override
	public Gate simplify() {
		Gate[] gArr = new Gate[inGates.length];
		int next = 0;

		for (int i = 0; i < inGates.length; i++) {
			if (inGates[i].simplify() instanceof FalseGate)
				return FalseGate.instance();
			else if (!(inGates[i].simplify() instanceof TrueGate))// Ignore true, simplify others.
				gArr[next++] = inGates[i].simplify();
		}

		if (gArr[0] == null)// All gates are true
			return TrueGate.instance();
		else if (gArr.length == 1 || gArr[1] == null)// One input
			return gArr[0];
		return new AndGate(gArr);
	}
}
