package Model;

public class Combat {
	private int Id;
	private String Name;
	private String Category;
	private Fighter First;
	private Fighter Second;
	private Fighter Winner;
	private Fighter Loser;
	private boolean KO;

	// Constructor
	public Combat(String name, String category, Fighter first, Fighter second) {
		Name = name;
		Category = category;
		First = first;
		Second = second;
		KO = false;
	}

	// GetSet
	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

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
		CheckOut();
	}

	// controle de acoes
	private void InvokeFighter() {

		for (int i = 0; i < First.GetActionsList().size(); i++) {

			if (First.GetActionsList().get(i).getPower() == 1 && Second.GetActionsList().get(i).getPower() == 0
					&& !KO) {
				FirstAttackPower(i);
				continue;
			}

			if (Second.GetActionsList().get(i).getPower() == 1 && First.GetActionsList().get(i).getPower() == 0
					&& !KO) {
				SecondAttackPower(i);
				continue;
			}

			if (First.GetActionsList().get(i).getPower() == 1 && Second.GetActionsList().get(i).getPower() == 1
					&& !KO) {
				if (First.GetActionsList().get(i).getModalidade() > Second.GetActionsList().get(i).getModalidade())
					FirstAttackPower(i);
				else if (First.GetActionsList().get(i).getModalidade() < Second.GetActionsList().get(i).getModalidade())
					SecondAttackPower(i);

				continue;
			}

			if (First.GetActionsList().get(i).getPunch() == 1 && Second.GetActionsList().get(i).getPunch() == 1
					&& !KO) {
				if (First.GetActionsList().get(i).getModalidade() > Second.GetActionsList().get(i).getModalidade())
					FirstAttackSimplePunch(i);
				else if (First.GetActionsList().get(i).getModalidade() < Second.GetActionsList().get(i).getModalidade())
					SecondAttackSimplePunch(i);

				continue;
			}

			if (First.GetActionsList().get(i).getPunch() == 1 && !KO)
				FirstAttackSimplePunch(i);

			if (Second.GetActionsList().get(i).getPunch() == 1 && !KO)
				SecondAttackSimplePunch(i);

			if (First.GetActionsList().get(i).getKick() == 1 && Second.GetActionsList().get(i).getKick() == 1 && !KO) {
				if (First.GetActionsList().get(i).getModalidade() > Second.GetActionsList().get(i).getModalidade())
					FirstAttackSimpleKick(i);
				else if (First.GetActionsList().get(i).getModalidade() < Second.GetActionsList().get(i).getModalidade())
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
		if (Second.GetActionsList().get(i).getDefense() == 1) {
			Second.SetLifeDamage(First.GetSkills(First.GetActionsList().get(i).getModalidade()).GetDamage() / 2);
			First.SetPoint(1);
		} else {
			Second.SetLifeDamage(First.GetSkills(First.GetActionsList().get(i).getModalidade()).GetDamage());
			First.SetPoint(2);
		}
	}

	private void SecondAttackPower(int i) {
		if (First.GetActionsList().get(i).getDefense() == 1) {
			First.SetLifeDamage(Second.GetSkills(Second.GetActionsList().get(i).getModalidade()).GetDamage() / 2);
			Second.SetPoint(1);
		} else {
			First.SetLifeDamage(Second.GetSkills(Second.GetActionsList().get(i).getModalidade()).GetDamage());
			Second.SetPoint(2);
		}
	}

	private void FirstAttackSimplePunch(int i) {
		if (Second.GetActionsList().get(i).getKick() == 1) {
			if (Second.GetActionsList().get(i).getModalidade() <= First.GetActionsList().get(i).getModalidade()) {
				Second.SetLifeDamage(First.GetPunch());
				First.SetPoint(1);
			} else if (Second.GetActionsList().get(i).getDefense() != 1) {
				Second.SetLifeDamage(First.GetPunch());
				First.SetPoint(1);
			}
		}
	}

	private void SecondAttackSimplePunch(int i) {
		if (First.GetActionsList().get(i).getKick() == 1) {
			if (First.GetActionsList().get(i).getModalidade() <= Second.GetActionsList().get(i).getModalidade()) {
				First.SetLifeDamage(Second.GetPunch());
				Second.SetPoint(1);
			}
		} else if (First.GetActionsList().get(i).getDefense() != 1) {
			First.SetLifeDamage(Second.GetPunch());
			Second.SetPoint(1);
		}
	}

	private void FirstAttackSimpleKick(int i) {
		if (Second.GetActionsList().get(i).getPunch() == 1) {
			if (Second.GetActionsList().get(i).getModalidade() <= First.GetActionsList().get(i).getModalidade()) {
				Second.SetLifeDamage(First.GetKick());
				First.SetPoint(1);
			}
		} else if (Second.GetActionsList().get(i).getDefense() != 1) {
			Second.SetLifeDamage(First.GetKick());
			First.SetPoint(1);
		}
	}

	private void SecondAttackSimpleKick(int i) {
		if (First.GetActionsList().get(i).getPunch() == 1) {
			if (First.GetActionsList().get(i).getModalidade() <= Second.GetActionsList().get(i).getModalidade()) {
				First.SetLifeDamage(Second.GetKick());
				Second.SetPoint(1);
			}
		} else if (First.GetActionsList().get(i).getDefense() != 1) {
			First.SetLifeDamage(Second.GetKick());
			Second.SetPoint(1);
		}
	}

	// verifica fim do jogo
	private void CheckOut() {

		System.out.println(First.GetPoint() + " = " + Second.GetPoint());

		if (First.GetPoint() < Second.GetPoint()) {
			Winner = Second;
			Loser = First;
			KO = true;
			System.out.println("Ganhador: " + Winner.GetName() + " - " + Winner.GetPoint() + " X " + "Perdador: "
					+ Loser.GetName() + " - " + Loser.GetPoint());
		} else if (Second.GetPoint() < First.GetPoint()) {
			Winner = First;
			Loser = Second;
			KO = true;
			System.out.println("Ganhador: " + Winner.GetName() + " - " + Winner.GetPoint() + " X " + "Perdador: "
					+ Loser.GetName() + " - " + Loser.GetPoint());
		} else if(First.GetLife() < Second.GetLife()) {
			Winner = Second;
			Loser = First;
			KO = true;
			System.out.println("Ganhador: " + Winner.GetName() + " - " + Winner.GetPoint() + " X " + "Perdador: "
					+ Loser.GetName() + " - " + Loser.GetPoint());
		}else if(First.GetLife() > Second.GetLife()) {
			Winner = First;
			Loser = Second;
			KO = true;
			System.out.println("Ganhador: " + Winner.GetName() + " - " + Winner.GetPoint() + " X " + "Perdador: "
					+ Loser.GetName() + " - " + Loser.GetPoint());
			
		 }else {
				Winner = First;
				Loser = Second;
				KO = true;
				System.out.println("Ganhador: " + Winner.GetName() + " - " + Winner.GetPoint() + " X " + "Perdador: "
						+ Loser.GetName() + " - " + Loser.GetPoint());
		 }
	}

	public Fighter GetWinner() {
		return Winner;
	}

	public Fighter GetLoser() {
		return Loser;
	}
}
