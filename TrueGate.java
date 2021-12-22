package circuits;

//Implementation of TRUE gate
//
//Singleton strategy ensures one instance of this
public class TrueGate extends Gate{
	private static TrueGate instance;
	
	private TrueGate() { super(null); }
	
	//Return TRUE boolean value
	@Override
	protected boolean func(boolean[] inValues) { return true; }

	@Override
	public String getName() { return "T"; }

	//No simpler version of this
	@Override
	public Gate simplify() {
		return this;
	}
	
	//force only one instance
	public static Gate instance() {
		return instance = instance==null?new TrueGate():instance;
	}


}
