package circuits;

//Implement FALSE logic gate.
//
//Singleton strategy.
//Insure only one [instance] of this class
public class FalseGate extends Gate {
	private static FalseGate instance;

	//No input
	private FalseGate() {
		super(null);
	}

	//Return boolean value of FALSE
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return false;
	}

	//Return name of False gate
	@Override
	public String getName() {
		return "F";
	}

	//No simpler version for this 
	@Override
	public Gate simplify() {
		return this;
	}

	//Create an instance, if one doesn't exist.
	public static Gate instance() {
		return instance = instance == null ? new FalseGate() : instance;
	}
}
