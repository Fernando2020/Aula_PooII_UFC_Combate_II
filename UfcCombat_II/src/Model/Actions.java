package Model;

public class Actions {
	private int Attack;
	private int Punch;
	private int Kick;
	private int Power;
	private int Defense;
	private int Modalidade;

	public Actions(int defense, int attack, int punch, int kick, int power, int modalidade) {
		this.Defense = defense;
		this.Attack = attack;
		this.Punch = punch;
		this.Kick = kick;
		this.Power = power;
		this.Modalidade = modalidade;
	}

	public int GetAttack() {
		return Attack;
	}

	public void SetAttack(int attack) {
		Attack = attack;
	}

	public int GetPunch() {
		return Punch;
	}

	public void SetPunch(int punch) {
		Punch = punch;
	}

	public int GetKick() {
		return Kick;
	}

	public void SetKick(int kick) {
		Kick = kick;
	}

	public int GetPower() {
		return Power;
	}

	public void SetPower(int power) {
		Power = power;
	}

	public int GetDefense() {
		return Defense;
	}

	public void SetDefense(int defense) {
		Defense = defense;
	}

	public int GetModalidade() {
		return Modalidade;
	}

	public void SetModalidade(int modalidade) {
		Defense = modalidade;
	}

}
