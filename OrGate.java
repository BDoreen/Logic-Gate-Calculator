package circuits;

//Implementation of OR [Gate]
//
//OR[true,false]=true
public class OrGate extends Gate {

	//[Gate] has some entries.
	public OrGate(Gate[] inGates) {
		super(inGates);
	}

	//Return true if any [inValues] is true
	@Override
	protected boolean func(boolean[] inValues) {
		for(boolean b : inValues)
			if(b)
				return true;
		return false;
	}

	@Override
	public String getName() {
		return "OR";
	}

	// Return simplified [Gate]
	@Override
	public Gate simplify() {
		Gate[] gArr = new Gate[inGates.length];
		int next = 0;

		for (int i = 0; i < inGates.length; i++) {
			if (inGates[i].simplify() instanceof TrueGate)// if false gate, end with false.
				return TrueGate.instance();
			else if (!(inGates[i].simplify() instanceof FalseGate))// ignore true, simplify others
				gArr[next++] = inGates[i].simplify();
		}
		
		if(gArr[0]==null)//all gates are true
			return FalseGate.instance();
		else if(gArr.length==1 || gArr[1]==null)
			return gArr[0];
		return new OrGate(gArr);

	}
	
}
