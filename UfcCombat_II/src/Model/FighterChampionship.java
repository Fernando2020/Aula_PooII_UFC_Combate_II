package Model;

/**
 * Classe modelo para armazenar o tipo FighterChampionship, onde serão contidos,
 * valores e métodos para o mesmo.
 * 
 * @author Fernando G. Nogueira
 * @version 1.0
 */
public class FighterChampionship {
	private int Id;
	private int IdFighter;
	private int IdChampionship;

	public FighterChampionship(int id, int idFighter, int idChampionship) {
		Id = id;
		IdFighter = idFighter;
		IdChampionship = idChampionship;
	}

	public FighterChampionship() {

	}

	public int GetId() {
		return Id;
	}

	public void SetId(int id) {
		Id = id;
	}

	public int GetIdFighter() {
		return IdFighter;
	}

	public void SetIdFighter(int idFighter) {
		IdFighter = idFighter;
	}

	public int GetIdChampionship() {
		return IdChampionship;
	}

	public void SetIdChampionship(int idChampionship) {
		IdChampionship = idChampionship;
	}
}
