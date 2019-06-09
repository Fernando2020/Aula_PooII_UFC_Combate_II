package Model;

import Interface.ISkills;

/**
 * Classe modelo para armazenar o tipo Skills, onde serão contidos, valores e
 * métodos para o mesmo.
 * 
 * @author Fernando G. Nogueira
 * @version 1.0
 */
public abstract class Skills implements ISkills {
	private int Id;
	private int Damage;

	public Skills(int id, int damage) {
		Id = id;
		Damage = damage;
	}

	// GetSet
	@Override
	public int GetDamage() {
		return Damage;
	}

	@Override
	public int GetId() {
		return Id;
	}
}
