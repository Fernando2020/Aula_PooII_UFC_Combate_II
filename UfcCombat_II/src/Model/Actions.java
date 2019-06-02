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

	public int getAttack() {
		return Attack;
	}

	public void setAttack(int attack) {
		Attack = attack;
	}

	public int getPunch() {
		return Punch;
	}

	public void setPunch(int punch) {
		Punch = punch;
	}

	public int getKick() {
		return Kick;
	}

	public void setKick(int kick) {
		Kick = kick;
	}

	public int getPower() {
		return Power;
	}

	public void setPower(int power) {
		Power = power;
	}

	public int getDefense() {
		return Defense;
	}

	public void setDefense(int defense) {
		Defense = defense;
	}

	public int getModalidade() {
		return Modalidade;
	}

	public void setModalidade(int modalidade) {
		Defense = modalidade;
	}

}
