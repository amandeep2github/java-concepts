package learn.java.v8.functionalprogramming.templateclass;

public class SpiciesTestMain {
	public static void main(String[] args) {
		Spicies kangaroo = new Spicies("Kangaroo", true, false);
		Spicies fish = new Spicies("fish", false, true);
		
		CompetitionEntryCheckWithoutFP entryCheckWithoutFP = new CompetitionEntryCheckWithoutFP();
		
		System.out.println(entryCheckWithoutFP.canParticipate(kangaroo, true));
		System.out.println(entryCheckWithoutFP.canParticipate(fish, true));
		
		CompetitionEntryCheckWithFP entryCheckWithFP = new CompetitionEntryCheckWithFP();
		
		CheckTrait checkTrait1 = a -> a.isCanHop();
		CheckTrait checkTrait2 = Spicies::isCanHop;
		
		System.out.println(entryCheckWithFP.canParticipate(kangaroo, checkTrait1));
		System.out.println(entryCheckWithFP.canParticipate(fish, checkTrait1));
		
		
	}
}
