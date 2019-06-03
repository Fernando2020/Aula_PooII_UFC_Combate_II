package Model;

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

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getIdFighter() {
		return IdFighter;
	}

	public void setIdFighter(int idFighter) {
		IdFighter = idFighter;
	}

	public int getIdChampionship() {
		return IdChampionship;
	}

	public void setIdChampionship(int idChampionship) {
		IdChampionship = idChampionship;
	}


}
