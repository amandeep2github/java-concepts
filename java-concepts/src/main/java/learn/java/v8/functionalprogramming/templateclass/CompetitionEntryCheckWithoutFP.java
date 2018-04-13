package learn.java.v8.functionalprogramming.templateclass;

public class CompetitionEntryCheckWithoutFP {
	public boolean canParticipate(Spicies spicies, boolean checkHop){
		if(checkHop)
			return spicies.isCanHop();
		else
			return spicies.isCanSwim();
	}
}
