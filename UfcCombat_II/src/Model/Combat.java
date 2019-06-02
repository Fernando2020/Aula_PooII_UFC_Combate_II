package Model;

public class Combat {
	private int Id;
	private String Name;
	private Fighter First;
	private Fighter Second;
	private Fighter Winner;
	private Fighter Loser;
	private boolean KO;

	// Constructor
	public Combat(int id, String name, Fighter first, Fighter second) {
		Id = id;
		Name = name;
		First = first;
		Second = second;
		KO = false;
	}

	// GetSet
	public int GetId() {
		return Id;
	}

	public String GetName() {
		return Name;
	}

	public Fighter GetPrimeiro() {
		return First;
	}

	public Fighter GetSegundo() {
		return Second;
	}

	// prepara o combate
	public void Play() {
		InvokeFighter();
	}

	// controle de acoes
	private void InvokeFighter() {
		for (int i = 0; i < First.GetActionsList().size(); i++) {
			if (First.GetActionsList().get(i).getPower() == 1 && !KO)
				FirstAttackPower(i);

			if (Second.GetActionsList().get(i).getPower() == 1 && !KO)
				SecondAttackPower(i);

			if (First.GetActionsList().get(i).getPunch() == 1 && Second.GetActionsList().get(i).getPunch() == 1
					&& !KO) {
				if (First.GetSkillsList().size() > Second.GetSkillsList().size())
					FirstAttackSimplePunch(i);
				else if (First.GetSkillsList().size() < Second.GetSkillsList().size())
					SecondAttackSimplePunch(i);

				continue;
			}

			if (First.GetActionsList().get(i).getPunch() == 1 && !KO)
				FirstAttackSimplePunch(i);

			if (Second.GetActionsList().get(i).getPunch() == 1 && !KO)
				SecondAttackSimplePunch(i);

			if (First.GetActionsList().get(i).getKick() == 1 && Second.GetActionsList().get(i).getKick() == 1 && !KO) {
				if (First.GetSkillsList().size() > Second.GetSkillsList().size())
					FirstAttackSimpleKick(i);
				else if (First.GetSkillsList().size() < Second.GetSkillsList().size())
					SecondAttackSimpleKick(i);

				continue;
			}

			if (First.GetActionsList().get(i).getKick() == 1 && !KO)
				FirstAttackSimpleKick(i);

			if (Second.GetActionsList().get(i).getKick() == 1 && !KO)
				SecondAttackSimpleKick(i);

			if (KO)
				break;
		}
	}

	// controle de dano
	private void FirstAttackPower(int i) {
		if (Second.GetActionsList().get(i).getDefense() == 1)
			Second.SetLifeDamage(First.GetSkills().GetDamage() / 2);
		else
			Second.SetLifeDamage(First.GetSkills().GetDamage());

		CheckOut();
	}

	private void SecondAttackPower(int i) {
		if (First.GetActionsList().get(i).getDefense() == 1)
			First.SetLifeDamage(Second.GetSkills().GetDamage() / 2);
		else
			First.SetLifeDamage(Second.GetSkills().GetDamage());

		CheckOut();
	}

	private void FirstAttackSimplePunch(int i) {
		if (Second.GetActionsList().get(i).getDefense() != 1) {
			Second.SetLifeDamage(First.GetPunch());
			CheckOut();
		}
	}

	private void SecondAttackSimplePunch(int i) {
		if (First.GetActionsList().get(i).getDefense() != 1) {
			First.SetLifeDamage(Second.GetPunch());
			CheckOut();
		}
	}

	private void FirstAttackSimpleKick(int i) {
		if (Second.GetActionsList().get(i).getDefense() != 1) {
			Second.SetLifeDamage(First.GetKick());
			CheckOut();
		}
	}

	private void SecondAttackSimpleKick(int i) {
		if (First.GetActionsList().get(i).getDefense() != 1) {
			First.SetLifeDamage(Second.GetKick());
			CheckOut();
		}
	}

	// verifica fim do jogo
	private void CheckOut() {
		if (First.GetLife() <= 0) {
			Winner = Second;
			Loser = First;
			KO = true;
		} else if (Second.GetLife() <= 0) {
			Winner = First;
			Loser = Second;
			KO = true;
		} else
			KO = false;
	}

	public Fighter GetWinner() {
		return Winner;
	}

	public Fighter GetLoser() {
		return Loser;
	}
}
