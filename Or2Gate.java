package circuits;

//Implementation of an Or Gate with 2 inputs
public class Or2Gate extends OrGate{

	public Or2Gate(Gate g1, Gate g2) {
		super(new Gate[] {g1,g2});
	}
}
