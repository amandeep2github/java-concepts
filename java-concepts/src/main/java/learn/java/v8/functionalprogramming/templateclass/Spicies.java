package learn.java.v8.functionalprogramming.templateclass;

public class Spicies {
	private String name;
	
	private boolean canHop;
	
	private boolean canSwim;

	public Spicies(String name, boolean canHop, boolean canSwim) {
		super();
		this.name = name;
		this.canHop = canHop;
		this.canSwim = canSwim;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCanHop() {
		return canHop;
	}

	public void setCanHop(boolean canHop) {
		this.canHop = canHop;
	}

	public boolean isCanSwim() {
		return canSwim;
	}

	public void setCanSwim(boolean canSwim) {
		this.canSwim = canSwim;
	}
	
	
}
