package learn.java.v8.functional;

public class CompetitionEntryCheckWithFP {
	public boolean canParticipate(Spicies spicies, CheckTrait checkTrait){
		return checkTrait.check(spicies);
	}
}
