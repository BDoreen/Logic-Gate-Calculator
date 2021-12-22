package circuits;

public class And2Gate extends AndGate {

	// Create an [AndGate] with two inputs.
	public And2Gate(Gate g1, Gate g2) {
		super(new Gate[] { g1, g2 });
	}

}
